/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/test/java/repository/RepositoryWithRealSessionTest.e.vm.java
 */
package com.jaxio.demo.repository;

import static org.fest.assertions.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;

import com.jaxio.demo.domain.Role;
import com.jaxio.demo.repository.RoleGenerator;
import com.jaxio.demo.repository.RoleRepository;

/**
 * Integration test on {@link RoleRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class RoleRepositoryWithRealSessionTest {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RoleRepositoryWithRealSessionTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleGenerator roleGenerator;

    @Test
    public void identityShouldBePreserved() {
        Role role = roleGenerator.getRole();

        // add it to a Set before saving (force equals/hashcode)
        Sets.newHashSet(role);

        roleRepository.save(role);
        entityManager.flush();

        // reload it from cache and check equality
        Integer id = role.getId();
        assertThat(role).isEqualTo(roleRepository.findOne(id));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(role).isEqualTo(roleRepository.findOne(id));
    }
}