package com.demoqa.stepDefinitions;

import com.demoqa.pages.InteractionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class InteractionsStepDef {

    InteractionsPage interactionsPage = new InteractionsPage();
    @And("the user drags the “drag me” box to the “drop me” box")
    public void theUserDragsTheDragMeBoxToTheDropMeBox() {
        interactionsPage.dragAndDrop();

    }

    @Then("the user verifies that {string}")
    public void theUserVerifiesThat(String expectedText) {
        System.out.println("interactionsPage.target.getText() = " + interactionsPage.targetText.getText());
        System.out.println("expectedText = " + expectedText);
        Assert.assertEquals(expectedText, interactionsPage.targetText.getText());
    }

}
