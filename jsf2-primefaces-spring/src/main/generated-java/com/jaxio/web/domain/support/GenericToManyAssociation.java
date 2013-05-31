/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/support/GenericToManyAssociation.p.vm.java
 */
package com.jaxio.web.domain.support;

import java.io.Serializable;
import java.util.List;

import org.omnifaces.util.Faces;
import org.primefaces.event.SelectEvent;

import com.jaxio.domain.Identifiable;
import com.jaxio.repository.support.GenericRepository;
import com.jaxio.web.conversation.ConversationCallBack;
import com.jaxio.web.permission.support.GenericPermission;
import com.jaxio.web.util.MessageUtil;

/**
 * Controller that allows you to manage an entity's x-to-many association.
 */
public abstract class GenericToManyAssociation<E extends Identifiable<PK>, PK extends Serializable> {
    protected String labelKey;
    protected MessageUtil messageUtil;
    protected GenericController<E, PK> controller;
    protected GenericPermission<E> permission;
    protected GenericRepository<E, PK> repository;
    protected SelectableListDataModel<E> dataModel;

    public GenericToManyAssociation(List<E> elements, String labelKey, GenericController<E, PK> controller) {
        this.dataModel = new SelectableListDataModel<E>(elements);
        this.labelKey = labelKey;
        this.controller = controller;
        this.messageUtil = controller.getMessageUtil();
        this.permission = controller.getPermission();
        this.repository = controller.getRepository();
    }

    /**
     * Return the dataModel used in the datatable component. 
     */
    public SelectableListDataModel<E> getModel() {
        return dataModel;
    }

    /**
     * Set the dataModel used in the datatable component. 
     */
    public void setModel(SelectableListDataModel<E> dataModel) {
        this.dataModel = dataModel;
    }

    /**
     * Remove the passed entity from the x-to-many association.
     */
    protected abstract void remove(E e);

    /**
     * Add the passed entity to the x-to-many association.
     */
    protected abstract void add(E e);

    /**
     * Instantiate a new entity with a view to adding it to the x-to-many assocation.
     */
    protected E create() {
        E e = repository.getNewWithDefaults();
        onCreate(e);
        return e;
    }

    /**
     * Override this method if you need to perform additional initialization such as setting
     * the entity that owns the passed x-t-many association element.
     * This method is invoked by the create method.
     * Does nothing by default.
     */
    protected void onCreate(E e) {
    }

    /**
     * Action to edit the entity corresponding to the selected row.
     * @return the implicit jsf view.
     */
    public String edit() {
        return controller.editSubView(labelKey, dataModel.getSelectedRow(), editCallBack);
    }

    protected ConversationCallBack<E> editCallBack = new ConversationCallBack<E>() {
        private static final long serialVersionUID = 1L;

        @Override
        protected void onOk(E e) {
            E previous = dataModel.getSelectedRow();
            // 'previous' is not necessarily the same instance as 'e', as 'e' may come form a merge... 
            // so we replace the old instance with the new one.
            remove(previous);
            add(e);
            messageUtil.infoEntity("status_edited_ok", e);
        }
    };

    /**
     * Action to view the entity corresponding to the selected row.
     * @return the implicit jsf view.
     */
    public String view() {
        return controller.editSubReadOnlyView(labelKey, dataModel.getSelectedRow());
    }

    /**
     * This datatable row selection listener invokes the {@link #view()} action and force the navigation to the returned implicit view.
     * Use it from a p:ajax event="rowSelect".
     */
    public void onRowSelectView(SelectEvent event) {
        Faces.navigate(view());
    }

    /**
     * This datatable row selection listener invokes the {@link #edit()} action and force the navigation to the returned implicit view.
     * Use it from a p:ajax event="rowSelect".
     */
    public void onRowSelectEdit(SelectEvent event) {
        Faces.navigate(edit());
    }

    /**
     * Remove the entity corresponding to the selected row from the x-to-many association.
     */
    public void remove() {
        checkPermission(permission.canDelete(dataModel.getSelectedRow()));
        remove(dataModel.getSelectedRow());
        messageUtil.infoEntity("status_removed_ok", dataModel.getSelectedRow());
    }

    /**
     * Action to create a new entity. The entity is not added a priori to the x-to-many association. It is added
     * if the 'ok' callback is invoked. 
     * @return the implicit jsf view.
     */
    public String add() {
        return controller.createSubView(labelKey, create(), addCallBack);
    }

    protected ConversationCallBack<E> addCallBack = new ConversationCallBack<E>() {
        private static final long serialVersionUID = 1L;

        @Override
        protected void onOk(E e) {
            add(e);
            messageUtil.infoEntity("status_added_new_ok", e);
        }
    };

    public String search() {
        return select();
    }

    public String select() {
        return controller.multiSelectSubView(labelKey, selectCallBack);
    }

    protected ConversationCallBack<E> selectCallBack = new ConversationCallBack<E>() {
        private static final long serialVersionUID = 1L;

        @Override
        protected void onSelected(E e) {
            checkPermission(permission.canSelect(e));
            remove(e); // in case it was already selected.
            add(e);
            messageUtil.infoEntity("status_added_existing_ok", e);
        }
    };

    protected void checkPermission(boolean check) {
        if (!check) {
            throw new IllegalStateException();
        }
    }
}
