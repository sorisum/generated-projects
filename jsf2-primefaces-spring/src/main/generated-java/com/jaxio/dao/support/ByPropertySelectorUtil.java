/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/project/dao/support/ByPropertySelectorUtil.p.vm.java
 */
package com.jaxio.dao.support;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.jaxio.dao.support.JpaUtil;
import com.jaxio.dao.support.PropertySelector;
import com.jaxio.dao.support.SearchParameters;

/**
 * Helper to create a predicate out of {@link PropertySelector}s.
 */
public class ByPropertySelectorUtil {
    @SuppressWarnings("unchecked")
    public static <E> Predicate byPropertySelectors(Root<E> root, CriteriaBuilder builder, final SearchParameters sp,
            final List<PropertySelector<?, ?>> selectors) {
        List<Predicate> predicates = newArrayList();

        for (PropertySelector<?, ?> selector : selectors) {
            if (selector.isBoolean()) {
                byBooleanSelector(root, builder, predicates, (PropertySelector<E, Boolean>) selector);
            } else {
                byObjectSelector(root, builder, predicates, sp, (PropertySelector<E, ?>) selector);
            }
        }
        return JpaUtil.andPredicate(builder, predicates);
    }

    private static <E> void byBooleanSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates, PropertySelector<E, Boolean> selector) {
        if (selector.isNotEmpty()) {
            List<Predicate> selectorPredicates = newArrayList();

            for (Boolean selection : selector.getSelected()) {
                Path<Boolean> path = root.get(selector.getField());
                if (selection == null) {
                    selectorPredicates.add(builder.isNull(path));
                } else {
                    selectorPredicates.add(selection ? builder.isTrue(path) : builder.isFalse(path));
                }
            }
            predicates.add(JpaUtil.orPredicate(builder, selectorPredicates));
        }
    }

    private static <E> void byObjectSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates, SearchParameters sp,
            PropertySelector<E, ?> selector) {
        if (selector.isNotEmpty()) {
            List<Predicate> selectorPredicates = newArrayList();

            for (Object selection : selector.getSelected()) {
                if (selection instanceof String) {
                    @SuppressWarnings("unchecked")
                    Path<String> path = (Path<String>) root.get(selector.getField());
                    selectorPredicates.add(JpaUtil.stringPredicate(path, selection, selector.getSearchMode(), sp, builder));
                } else {
                    Path<?> path = root.get(selector.getField());
                    selectorPredicates.add(selection == null ? builder.isNull(path) : builder.equal(path, selection));
                }
            }
            predicates.add(JpaUtil.orPredicate(builder, selectorPredicates));
        }
    }
}