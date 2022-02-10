package com.demoqa.stepDefinitions;

import com.demoqa.pages.AlertsWindowsPage;
import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class AlertWindowsStepDef {

    AlertsWindowsPage alertPage = new AlertsWindowsPage();

    @Given("the user should be on the {string} page")
    public void theUserShouldBeOnThePage(String arg0) {
        Driver.getDriver().get(ConfigurationReader.get("demoQAUrl"));
    }

    @When("the user navigates to {string}, {string}")
    public void theUserNavigatesTo(String alertModule, String alertSubModule) {
        alertPage.clickModule(alertModule, alertPage.alertModule);
        BrowserUtils.waitFor(2);
        alertPage.clickSubModule(alertSubModule, alertPage.alertSubModule);

    }

    @And("the user clicks {string} buttons and accept, dismiss or send input to alert")
    public void theUserClicksButtonsAndAcceptDismissOrSendInputToAlert(String arg0) {
        alertPage.clickClickMeButtonsAndHandleAlerts();

    }

}
