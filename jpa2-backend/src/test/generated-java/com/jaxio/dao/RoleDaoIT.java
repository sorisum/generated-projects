/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/dao/DaoIT.e.vm.java
 */
package com.jaxio.dao;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaxio.domain.Role;
import com.jaxio.repository.RoleGenerator;
import com.jaxio.dao.RoleDao;

/**
 * Integration test on RoleDao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class RoleDaoIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(RoleDaoIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private RoleDao roleDao;

    @Inject
    private RoleGenerator roleGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Role role = roleGenerator.getRole();

        // add it to a Set before saving (force equals/hashcode)
        Set<Role> set = newHashSet(role, role);
        assertThat(set).hasSize(1);

        roleDao.save(role);
        entityManager.flush();

        // reload it from cache and check equality
        Role model = new Role();
        model.setId(role.getId());
        assertThat(role).isEqualTo(roleDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(role).isEqualTo(roleDao.get(model));
    }
}