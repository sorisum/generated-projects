/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/SearchPage.e.vm.java
 */
package com.jaxio.web.selenium.page.account;

import static org.openqa.selenium.By.name;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jaxio.web.selenium.support.Page;
import com.jaxio.web.selenium.page.AbstractSearchPage;

@Page
public class AccountSearchPage extends AbstractSearchPage {
    // search box
    @FindBy(id = "form:username_input")
    public WebElement username;
    @FindBy(id = "form:password_input")
    public WebElement password;
    @FindBy(id = "form:email_input")
    public WebElement email;
    @FindBy(id = "form:civility_input")
    public WebElement civility;
    @FindBy(id = "form:firstName_input")
    public WebElement firstName;
    @FindBy(id = "form:lastName_input")
    public WebElement lastName;
    @FindBy(id = "form:birthDateFrom_input")
    public WebElement birthDateFrom;
    @FindBy(id = "form:birthDateTo_input")
    public WebElement birthDateTo;
    @FindBy(id = "form:description_input")
    public WebElement description;
    @FindBy(id = "form:homeAddressSelector_input")
    public WebElement homeAddress;
    @FindBy(id = "form:coolBooksSelector_input")
    public WebElement coolBooks;
    @FindBy(id = "form:edocsSelector_input")
    public WebElement edocs;
    @FindBy(id = "form:securityRolesSelector_input")
    public WebElement securityRoles;

    public void edit(String account) {
        clickEdit(account);
    }

    public void add(String account) {
        clickAdd(account);
    }

    public void delete(String account) {
        clickDelete(account);
        webClient.click(name("form:askForDeleteItemDialogYes"));
    }

    public void select(String account) {
        clickSelect(account);
    }

    public void searchByUsername(String username) {
        webClient.clear(this.email, this.username);
        webClient.autocomplete(this.username, username);
        webClient.click(searchButton);
    }

    public void searchByEmail(String email) {
        webClient.clear(this.username);
        webClient.autocomplete(this.email, email);
        webClient.click(searchButton);
    }
}