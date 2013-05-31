/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/project/repository/Repository.e.vm.java
 */
package com.jaxio.repository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import com.jaxio.dao.LegacyDao;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.LegacyPk;
import com.jaxio.repository.support.GenericRepository;

/**
 * Note: you may use multiple DAO from this layer.
 */
@Named
@Singleton
public class LegacyRepository extends GenericRepository<Legacy, LegacyPk> {

    // required by cglib to create a proxy around the object as we are using the @Transactional annotation
    protected LegacyRepository() {
        super();
    }

    @Inject
    public LegacyRepository(LegacyDao legacyDao) {
        super(legacyDao);
    }

    @Override
    public Legacy getNew() {
        return new Legacy();
    }

    @Override
    public Legacy getNewWithDefaults() {
        Legacy result = getNew();
        result.initDefaultValues();
        return result;
    }
}