/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/SeleniumTest.p.vm.java
 */
package com.jaxio.web.selenium.support;

import org.junit.Before;
import org.junit.Rule;

import com.jaxio.web.selenium.page.AnonymousHomePage;
import com.jaxio.web.selenium.page.LoggedHomePage;
import com.jaxio.web.selenium.page.LoginPage;

public abstract class SeleniumTest {
    @Rule
    public WebClientRule webClientRule = new WebClientRule(this);
    protected WebClient webClient;
    protected LoginPage loginPage;
    protected AnonymousHomePage anonymousHomePage;
    protected LoggedHomePage loggedHomePage;

    @Before
    public void setup() {
        webClient = webClientRule.getWebClient();
    }

    protected void englishHomePage() {
        webClient.page("/home.faces?locale=en");
        webClient.hasText("Please login first in order to access the application content.");
    }

    protected void loginAsAnAdmin() {
        webClient.step("Login as admin");
        anonymousHomePage.connexion();
        loginPage.login("admin", "admin");
        webClient.hasText("Congratulations admin, you are logged");
    }

    protected void logout() {
        webClient.step("Logout");
        loggedHomePage.logout();
        webClient.hasText("Please login first in order to access the application content.");
    }
}
