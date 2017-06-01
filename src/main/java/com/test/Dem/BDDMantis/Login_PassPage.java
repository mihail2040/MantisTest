package com.test.Dem.BDDMantis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Максим on 30.05.2017.
 */
public class Login_PassPage {
    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/input[3]")
    WebElement loginButton;
    public void Pass (User user) {
        this.password.sendKeys(user.getPassword());
        this.loginButton.click();
    }
}
