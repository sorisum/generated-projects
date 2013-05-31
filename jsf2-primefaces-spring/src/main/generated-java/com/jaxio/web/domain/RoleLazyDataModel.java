/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import com.jaxio.domain.Role;
import com.jaxio.repository.RoleRepository;
import com.jaxio.web.converter.RoleJsfConverter;
import com.jaxio.web.domain.support.GenericLazyDataModel;
import com.jaxio.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link Role}
 */
@Named
@ConversationContextScoped
public class RoleLazyDataModel extends GenericLazyDataModel<Role, Integer, RoleSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public RoleLazyDataModel(RoleRepository roleRepository, RoleJsfConverter roleConverter, RoleController roleController, RoleSearchForm roleSearchForm) {
        super(roleRepository, roleConverter, roleController, roleSearchForm);
    }
}