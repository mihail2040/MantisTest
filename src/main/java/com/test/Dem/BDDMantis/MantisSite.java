package com.test.Dem.BDDMantis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

/**
 * Created by Максим on 29.05.2017.
 */
public class MantisSite {


    public static LoginPage loginPage;

    public static Login_PassPage login_PassPage;
    public static IssuePage issuePage;
    public static MainPage mainPage;
    public static OpenIssuePage OpenIssuePage;


    public static WebDriver driver;
    public static void init(WebDriver driver) {
        MantisSite.loginPage     = PageFactory.initElements(driver, LoginPage.class);
        MantisSite.login_PassPage     = PageFactory.initElements(driver, Login_PassPage.class);
        MantisSite.issuePage = PageFactory.initElements(driver, IssuePage.class);
        MantisSite.mainPage = PageFactory.initElements(driver, MainPage.class);
        MantisSite.OpenIssuePage = PageFactory.initElements(driver, OpenIssuePage.class);
        MantisSite.driver        = driver;
    }
    public static void gotoBugTable() {
        driver.navigate().to("http://127.0.0.1/mantisbt-2.4.1/view_all_bug_page.php"); }

    public static void open() {
        driver.navigate().to("http://127.0.0.1/mantisbt-2.4.1");}

    public static void logout() {

        driver.navigate().to("http://127.0.0.1/mantisbt-2.4.1/logout_page.php");
    }

    public static void  openMainPage() {

        driver.navigate().to("http://localhost/mantisbt-2.4.1/my_view_page.php");
    }

}
