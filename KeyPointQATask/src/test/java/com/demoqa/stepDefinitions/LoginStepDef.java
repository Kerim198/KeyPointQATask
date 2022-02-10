package com.demoqa.stepDefinitions;

import com.demoqa.pages.LoginPage;
import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.get("sauceDemoUrl"));

    }

    @When("the user enters standart user credentials")
    public void theUserEntersStandartUserCredentials() {
        loginPage.loginAsStandarUser();

    }

    @Then("the user should be login successfully")
    public void theUserShouldBeLoginSuccessfully() {
        String expectedTitle = "Products";
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(loginPage.title.getText()));

    }

    @When("the user enters locked out user credentials")
    public void theUserEntersLockedOutUserCredentials() {
        loginPage.loginAsLockedOutUser();

    }

    @Then("the user shouldn't be login and verify error message")
    public void theUserShouldnTBeLoginAndVerifyErrorMessage() {
        Assert.assertTrue(loginPage.errorMessage.getText().contains("this user has been locked out."));

    }

    @When("the user enters problem user credentials")
    public void theUserEntersProblemUserCredentials() {
        loginPage.loginAsProblemUser();

    }

    @When("the user enters performance glitch user credentials")
    public void theUserEntersPerformanceGlitchUserCredentials() {
        loginPage.loginAsPerformanceGlitchUser();

    }

    @Then("the user should be login successfully {int} second later")
    public void theUserShouldBeLoginSuccessfullySecondLater(int waitTime) {
        //after wait
        BrowserUtils.waitFor(waitTime);
        Assert.assertTrue(loginPage.title.getText().equalsIgnoreCase("Products"));

    }


    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String arg0, String arg1) {

    }

    @Then("the user shouldn't be login and verify {string}")
    public void theUserShouldnTBeLoginAndVerify(String arg0) {

    }
}