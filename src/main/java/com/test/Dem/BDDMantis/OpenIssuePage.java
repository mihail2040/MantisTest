package com.test.Dem.BDDMantis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by Максим on 31.05.2017.
 */
public class OpenIssuePage {
    @FindBy(xpath = "//select[@name=\"new_status\"]")
    WebElement changeStatus;

    @FindBy(xpath = "//input[@value=\"Change Status To:\"]")
    WebElement changeStatusButton;

    @FindBy(xpath = "//input[@value=\"Resolve Issue\"]")
    WebElement resolveButton;

    @FindBy(xpath = "//input[@value=\"Close Issue\"]")
    WebElement CloseButton;

    @FindBy(xpath = "//td[@class=\"bug-assigned-to\"]")
    WebElement bugAssigned;

    @FindBy(xpath = "//td[@class=\"bug-category\"]")

    WebElement bugCategory;

    @FindBy(xpath = "//td[@class=\"bug-severity\"]")

    WebElement bugSeverity;

    @FindBy(xpath = "//td[@class=\"bug-priority\"]")
    WebElement bugPriority;

    @FindBy(xpath = "//td[@class=\"bug-status\"]")
    WebElement bugStatus;

    @FindBy(xpath = "//td[@class=\"bug-platform\"]")
    WebElement bugPlatform;

    @FindBy(xpath = "//td[@class=\"bug-os\"]")
    WebElement bugOs;

    @FindBy(xpath = "//td[@class=\"bug-os-version\"]")
    WebElement bugOsVersion;

    @FindBy(xpath = "//td[@class=\"bug-summary\"]")
    WebElement bugSummary;

    @FindBy(xpath = "//td[@class=\"bug-description\"]")
    WebElement bugDescription;

    @FindBy(xpath = "//td[@class=\"bug-steps-to-reproduce\"]")
    WebElement bugStepsToReproduce;

    @FindBy(xpath = "//td[@class=\"bug-additional-information\"]")
    WebElement bugAdditionalInformation;

    @FindBy(xpath = "//select[@name=\"handler_id\"]")
    WebElement handlerSelector;

    @FindBy(xpath = "//input[@value=\"Assign To:\"]")
    WebElement handlerButton;


    public  void checkSection(Issue issue, String status){
        Assert.assertTrue(
                bugAssigned.getText().contains(issue.getHandler())
                        && bugCategory.getText().contains(issue.getCategory())
                        && bugSeverity.getText().contains(issue.getSeverity())
                        && bugPriority.getText().contains(issue.getPriority())
                        && bugStatus.getText().contains(status)
                        && bugPlatform.getText().contains(issue.getPlatform())
                        && bugOs.getText().contains(issue.getOs())
                        && bugOsVersion.getText().contains(issue.getOsVersion())
                        && bugSummary.getText().contains(issue.getSummary())
                        && bugDescription.getText().contains(issue.getDescription())
                        && bugStepsToReproduce.getText().contains(issue.getSteps_to_reproduce())
                        && bugAdditionalInformation.getText().contains(issue.getAdditional_info())
        );
    }

    public  void statusIssue(String status, String responsible) {
        new Select(handlerSelector).selectByVisibleText(responsible);
        handlerButton.click();
        Select selector = new Select(changeStatus);
        selector.selectByVisibleText(status);
        changeStatusButton.click();

    }
    public void ResolveButton() {
        resolveButton.click();
    }

    public void closeButton() {
        CloseButton.click();
    }
}
