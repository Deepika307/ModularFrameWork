package com.deepika.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "uid")
    private WebElement userId;

    @FindBy(name = "password")
    private WebElement userPassword;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Business flow method
    public void loginToApp(String username, String password) {

        // Temporary wait (we'll replace with WebDriverWait later)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elementControl.setText(userId, username);
        elementControl.setText(userPassword, password);
        elementControl.clickElement(loginButton);
    }
}
