package com.test.Dem.BDDMantis;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Максим on 30.05.2017.
 */
public class IssuePage {
    @FindBy(id = "category_id")
    WebElement category;

    @FindBy(id = "reproducibility")
    WebElement reproducibility;

    @FindBy(id = "severity")
    WebElement severity;

    @FindBy(id = "priority")
    WebElement priority;

    @FindBy(id = "handler_id")
    WebElement handler;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "steps_to_reproduce")
    WebElement steps_to_reproduce;

    @FindBy(id = "additional_info")
    WebElement additional_info;

    @FindBy(xpath = "//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"profile_open_link\"]/i")
    WebElement open_platform_button;

    @FindBy (xpath = "//*[@id=\"profile_closed_link\"]/i")
    WebElement close_platform_button;

    @FindBy(id = "platform")
    WebElement platform;

    @FindBy(id = "os")
    WebElement os_field;

    @FindBy(id = "os_build")
    WebElement os_version_field;

    @FindBy(css = "#profile_open > table")
    WebElement platformTable;

    public void Form_Filling(Issue issue) {
        new Select(category).selectByVisibleText(issue.getCategory());
        new Select(reproducibility).selectByVisibleText(issue.getReproducibility());
        new Select(severity).selectByVisibleText(issue.getSeverity());
        new Select(priority).selectByVisibleText(issue.getPriority());

        if (!platformTable.isDisplayed()){
            close_platform_button.click();
    }


        platform.sendKeys(issue.getPlatform());
        os_field.sendKeys(issue.getOs());
        os_version_field.sendKeys(issue.getOsVersion());
        new Select(handler).selectByVisibleText(issue.getHandler());

        summary.sendKeys(issue.getSummary());
        description.sendKeys(issue.getDescription());
        steps_to_reproduce.sendKeys(issue.getSteps_to_reproduce());
        additional_info.sendKeys(issue.getAdditional_info());
    }

    public void submitIssue() {
        submitButton.click();
    }
}