/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Controller.e.vm.java
 */
package com.jaxio.web.domain;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Legacy;
import com.jaxio.repository.LegacyRepository;
import com.jaxio.web.conversation.Conversation;
import com.jaxio.web.conversation.ConversationContext;
import com.jaxio.web.conversation.ConversationFactory;

/**
 * Stateless controller for Legacy conversation start. Provides also auto-complete support. 
 */
@Named
@Singleton
public class LegacyController implements ConversationFactory {
    public final static String editUri = "/domain/legacyEdit.faces";
    public final static String selectUri = "/domain/legacySelect.faces";
    private LegacyRepository legacyRepository;

    @Inject
    public void setLegacyRepository(LegacyRepository legacyRepository) {
        this.legacyRepository = legacyRepository;
    }

    // --------------------------------
    // ConversationFactoryImpl
    // --------------------------------

    @Override
    public boolean canCreateConversation(HttpServletRequest request) {
        return selectUri.equals(request.getServletPath());
    }

    @Override
    public Conversation createConversation(HttpServletRequest request) {
        String uri = request.getServletPath();
        if (selectUri.equals(uri)) {
            Conversation conversation = Conversation.newInstance(request);
            ConversationContext<Legacy> ctx = newSearchContext();
            ctx.setLabelWithKey("legacy");
            conversation.push(ctx);
            return conversation;
        }

        throw new IllegalStateException("Unexpected conversation creation demand");
    }

    // --------------------------------
    // Autocomplete support
    // --------------------------------

    /**
     * This method is used from primefaces autocomplete components.
     */
    public List<Legacy> complete(String value) {
        SearchParameters sp = new SearchParameters().anywhere().searchPattern(value);
        return legacyRepository.find(sp);
    }

    // --------------------------------
    // Helper 
    // --------------------------------    

    /**
     * Helper to construct a new ConversationContext for edition.
     */
    public static ConversationContext<Legacy> newEditContext(Legacy legacy) {
        ConversationContext<Legacy> ctx = new ConversationContext<Legacy>();
        LegacyEditForm legacyEditForm = new LegacyEditForm();
        legacyEditForm.setLegacy(legacy);
        ctx.addBean("legacyEditForm", legacyEditForm); // will be autowired by our ConversationScope...
        ctx.setViewUri(editUri);
        return ctx;
    }

    /**
     * Helper to construct a new ConversationContext for search/selection.
     */
    public static ConversationContext<Legacy> newSearchContext() {
        ConversationContext<Legacy> ctx = new ConversationContext<Legacy>();
        ctx.setViewUri(selectUri);
        return ctx;
    }
}