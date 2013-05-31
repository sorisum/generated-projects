/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.LegacyPk;
import com.jaxio.repository.LegacyRepository;
import com.jaxio.web.domain.LegacyController;
import com.jaxio.web.domain.support.GenericEditForm;
import com.jaxio.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Legacy}.
 */
@Named
@ConversationContextScoped
public class LegacyEditForm extends GenericEditForm<Legacy, LegacyPk> {
    @Inject
    protected LegacyController legacyController;

    @Inject
    public LegacyEditForm(LegacyRepository legacyRepository) {
        super(legacyRepository);
    }

    /**
     * The entity to edit/view.
     */
    public Legacy getLegacy() {
        return getEntity();
    }

    public String print() {
        return legacyController.print(getLegacy());
    }
}
