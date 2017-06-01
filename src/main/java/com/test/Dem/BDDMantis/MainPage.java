package com.test.Dem.BDDMantis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.xml.ws.FaultAction;
import java.util.stream.Collectors;

/**
 * Created by Максим on 30.05.2017.
 */
public class MainPage {


    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a[1]")
    WebElement reportIssue;

    @FindBy(id = "buglist")
    WebElement buglist;

    @FindBy(id = "hide_status_filter")
    WebElement hideStatusFilter;

    @FindBy(xpath = "//select[@name=\"hide_status[]\"]")
    WebElement hideStatusSelector;

    @FindBy(xpath = "//input[@name=\"filter\"]")
    WebElement applyFilterBtn;


    @FindBy (xpath = "//*[@id=\"buglist\"]/tbody/tr[1]/td[4]/a")
    WebElement openTask;



    public void openReportForm() {

        reportIssue.click();
    }


    public void findIssue(Issue issue, String assigned) {
        Assert.assertTrue(MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr"))
                .stream().anyMatch(row ->
                        (row.getText().contains(issue.getSummary()))
                                && (row.getText().contains("block"))
                                && (row.getText().contains(assigned))
                                && (row.getText().contains("General"))));
    }


    public void openTask() {
       openTask.click();
    }


    public void offFilter() {
        hideStatusFilter.click();
        new Select(hideStatusSelector).selectByVisibleText("[none]");
        applyFilterBtn.click();
    }
}
