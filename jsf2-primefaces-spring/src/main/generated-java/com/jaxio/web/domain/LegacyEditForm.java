/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.LegacyPk;
import com.jaxio.repository.LegacyRepository;
import com.jaxio.web.domain.support.GenericEditForm;
import com.jaxio.web.faces.Conversation;

/**
 * View Helper/Controller to edit {@link Legacy}.
 */
@Named
@Conversation
public class LegacyEditForm extends GenericEditForm<Legacy, LegacyPk> {
    @Inject
    public void setLegacyRepository(LegacyRepository legacyRepository) {
        setRepository(legacyRepository);
    }

    public Legacy getLegacy() {
        return getEntity();
    }
}
