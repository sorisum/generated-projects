/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.jaxio.domain;

import java.io.*;
import java.util.*;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

import com.jaxio.util.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic tests for Role
 */
@SuppressWarnings("unused")
public class RoleTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Role model = new Role();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        Role model = new Role();
        model.setId(ValueGenerator.getUniqueInteger());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    @Test
    public void equalsUsingBusinessKey() {
        Role model1 = new Role();
        Role model2 = new Role();
        String roleName = ValueGenerator.getUniqueString(100);
        model1.setRoleName(roleName);
        model2.setRoleName(roleName);
        assertThat(model1).isEqualTo(model2);
        assertThat(model2).isEqualTo(model1);
        assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
    }
}