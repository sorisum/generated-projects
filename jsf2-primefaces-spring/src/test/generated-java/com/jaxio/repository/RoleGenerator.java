/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.jaxio.repository;

import javax.inject.Named;
import javax.inject.Singleton;
import com.jaxio.domain.Role;
import com.jaxio.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class RoleGenerator {

    /**
     * Returns a new Role instance filled with random values.
     */
    public Role getRole() {
        Role role = new Role();

        // simple attributes follows
        role.setRoleName(ValueGenerator.getUniqueString(100));
        return role;
    }

}