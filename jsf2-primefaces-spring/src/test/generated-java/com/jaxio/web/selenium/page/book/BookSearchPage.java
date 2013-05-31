/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/SearchPage.e.vm.java
 */
package com.jaxio.web.selenium.page.book;

import static org.openqa.selenium.By.name;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jaxio.web.selenium.support.Page;
import com.jaxio.web.selenium.page.AbstractSearchPage;

@Page
public class BookSearchPage extends AbstractSearchPage {
    // search box
    @FindBy(id = "form:bookTitle_input")
    public WebElement bookTitle;
    @FindBy(id = "form:numberOfPagesFrom_input")
    public WebElement numberOfPagesFrom;
    @FindBy(id = "form:numberOfPagesTo_input")
    public WebElement numberOfPagesTo;
    @FindBy(id = "form:ownerSelector_input")
    public WebElement owner;

    public void edit(String book) {
        clickEdit(book);
    }

    public void add(String book) {
        clickAdd(book);
    }

    public void delete(String book) {
        clickDelete(book);
        webClient.click(name("form:askForDeleteItemDialogYes"));
    }

    public void select(String book) {
        clickSelect(book);
    }
}