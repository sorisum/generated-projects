/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/conversation/ConversationMenu.p.vm.java
 */
package com.jaxio.web.conversation;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@Named
@Singleton
public class ConversationMenu {
    @Inject
    private ConversationManager conversationManager;

    public boolean getRender() {
        return !conversationManager.conversationMap().isEmpty();
    }

    public MenuModel getModel() {
        MenuModel model = new DefaultMenuModel();
        Conversation currentConversation = conversationManager.getCurrentConversation();
        for (Conversation conversation : conversationManager.conversationMap().values()) {
            MenuItem htmlMenuItem = new MenuItem();
            htmlMenuItem.setValue(conversation.getLabel());
            htmlMenuItem.setUrl(conversation.getUrl());
            if (currentConversation != null && currentConversation.getId().equals(conversation.getId())) {
                htmlMenuItem.setDisabled(true);
            }
            if (isNotBlank(conversation.getLabel())) {
                model.addMenuItem(htmlMenuItem);
            }
        }
        return model;
    }
}
