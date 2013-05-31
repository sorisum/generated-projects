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
import com.jaxio.domain.Book;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class BookGenerator {

    /**
     * Returns a new Book instance filled with random values.
     */
    public Book getBook() {
        Book book = new Book();

        // simple attributes follows
        book.setBookTitle("a");
        book.setNumberOfPages(1);
        return book;
    }

}