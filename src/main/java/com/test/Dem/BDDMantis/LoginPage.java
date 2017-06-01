package com.test.Dem.BDDMantis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Максим on 29.05.2017.
 */
public class LoginPage {
    @FindBy(id = "username")
    WebElement username;
    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/input[2]")
    WebElement loginButton;

    public void Login(User user) {
        this.username.sendKeys(user.getLogin());
        this.loginButton.click();
    }
}
