package com.test.Dem.BDDMantis.StepDefs;

import com.test.Dem.BDDMantis.*;
import com.test.Dem.BDDMantis.Helper.ResourceLoader;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Random;

import static com.test.Dem.BDDMantis.MantisSite.mainPage;
import static com.test.Dem.BDDMantis.MantisSite.OpenIssuePage;


/**
 * Created by Максим on 29.05.2017.
 */
public class MyStepdefs {

    private static Issue issue;

    private static User user;

    private void setupIssue(String issue_name){
        Random random = new Random();
        issue = ResourceLoader.issues.get(issue_name);
        issue.setOs(System.getProperty("os.name"));
        issue.setOsVersion(System.getProperty("os.version"));
        issue.setPlatform(System.getProperty("os.arch"));

        issue.setDescription(issue.getDescription() + random.nextInt());
        issue.setSummary(issue.getSummary() + random.nextInt());
        issue.setAdditional_info(issue.getAdditional_info() + random.nextInt());
        issue.setSteps_to_reproduce(issue.getSteps_to_reproduce() + random.nextInt());
    }
    @Given("^User log in as \"([^\"]*)\"$")
    public void userLogsInAs(String arg0) throws Throwable {
        MantisSite.open();
        user = ResourceLoader.users.get(arg0);
        MantisSite.loginPage.Login(user);
        MantisSite.login_PassPage.Pass(user);

    }

    @And("^report issue$")
    public void reportIssue() throws Throwable {
       mainPage.openReportForm();
    }

    @When("^user fills the form \"([^\"]*)\"$")
    public void userFillsTheForm(String issue_name) throws Throwable {
        setupIssue(issue_name);
        MantisSite.issuePage.Form_Filling(issue);
    }

    @And("^submit issue$")
    public void submitIssue() throws Throwable {
        MantisSite.issuePage.submitIssue();
    }
    @Then("^user open bug table$")
    public void userOpenBugTable() throws Throwable {
        MantisSite.gotoBugTable();
    }

    @And("^user find \"([^\"]*)\"$")
    public void userFind(String status) throws Throwable {
        mainPage.findIssue(issue, status);
    }


    @And("^logout$")
    public void logout() throws Throwable {
        MantisSite.logout();
    }


    @And("^user open task$")
    public void userOpenTask() throws Throwable {
       mainPage.openTask();
    }

    @And("^check the \"([^\"]*)\" section$")
    public void checkTheSection(String arg0) throws Throwable {
        OpenIssuePage.checkSection(issue, "assigned");
    }



    @Then("^user changes the status issue to \"([^\"]*)\" \"([^\"]*)\"$")
    public void userChangesTheStatusIssueToAndClickButton(String status, String responsible) throws Throwable {
        OpenIssuePage.statusIssue(status, responsible);
    }

    @And("^click button resolve$")
    public void clickButton() throws Throwable {
        OpenIssuePage.ResolveButton();
    }

    @And("^click button close$")
    public void clickButtonClosed() throws Throwable {
    OpenIssuePage.closeButton();
    }


    @And("^user change filter off$")
    public void userChangeFilterOff() throws Throwable {
    mainPage.offFilter();
    }
}
