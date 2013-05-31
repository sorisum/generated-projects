/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/conversation/ConversationBreadCrumb.p.vm.java
 */
package com.jaxio.web.conversation;

import static com.jaxio.web.conversation.ConversationHolder.getCurrentConversation;
import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.Iterator;
import java.util.Stack;

import javax.inject.Named;
import javax.inject.Singleton;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@Named
@Singleton
public class ConversationBreadCrumb {

    public boolean getRender() {
        Conversation currentConversation = getCurrentConversation();
        return currentConversation == null ? false : !currentConversation.getConversationContextes().isEmpty();
    }

    public MenuModel getModel() {
        MenuModel model = new DefaultMenuModel();
        Stack<ConversationContext<?>> ctxStack = getCurrentConversation().getConversationContextes();
        int beforeLastIndex = ctxStack.size() - 2;
        Iterator<ConversationContext<?>> iterator = ctxStack.iterator();

        // first item is rendered as ui-icon-home => we don't want it so we disable it.
        MenuItem menuItem = new MenuItem();
        menuItem.setRendered(false);
        model.addMenuItem(menuItem);

        int i = 0;
        while (iterator.hasNext()) {
            ConversationContext<?> ctx = iterator.next();
            if (isNotBlank(ctx.getLabel())) {
                menuItem = new MenuItem();
                menuItem.setValue(ctx.getLabel());
                if (i == beforeLastIndex && beforeLastIndex > 0) {
                    // calls back button action
                    menuItem.setOnclick("APP.menu.back()");
                } else {
                    menuItem.setDisabled(true);
                }

                model.addMenuItem(menuItem);
            }
            i++;
        }
        return model;
    }
}
