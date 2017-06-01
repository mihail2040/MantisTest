package com.test.Dem.BDDMantis.StepDefs;

import com.test.Dem.BDDMantis.MantisSite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Максим on 29.05.2017.
 */
public class Hook {

    public static WebDriver driver;



    @Before
    public void before(Scenario scenario){

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); //doesn't build without this property. Though maven is configured well.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        MantisSite.init(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void after(Scenario scenario){
        driver.close();
    }
}
