/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.LegacyPk;
import com.jaxio.repository.LegacyRepository;
import com.jaxio.web.domain.support.GenericController;
import com.jaxio.web.permission.LegacyPermission;

/**
 * Stateless controller for {@link Legacy} conversation start. 
 */
@Named
@Singleton
public class LegacyController extends GenericController<Legacy, LegacyPk> {
    public static final String LEGACY_EDIT_URI = "/domain/legacyEdit.faces";
    public static final String LEGACY_SELECT_URI = "/domain/legacySelect.faces";

    @Inject
    public LegacyController(LegacyRepository legacyRepository, LegacyPermission legacyPermission) {
        super(legacyRepository, legacyPermission, LEGACY_SELECT_URI, LEGACY_EDIT_URI);
    }
}