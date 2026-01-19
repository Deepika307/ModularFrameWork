package com.deepika.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementControl;

public class BasePage {

    protected WebDriver driver;
    protected ElementControl elementControl;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl(driver);
    }
}
