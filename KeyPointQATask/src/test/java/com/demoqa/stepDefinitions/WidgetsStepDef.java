package com.demoqa.stepDefinitions;

import com.demoqa.pages.WidgetsPage;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.And;

import org.junit.Assert;


public class WidgetsStepDef {

    WidgetsPage widgetsPage = new WidgetsPage();

    @And("the user hover over the {string} and verifies the {string} is displayed")
    public void theUserHoverOverTheAndVerifiesTheIsDisplayed(String hoverTarget, String expectedMessage) {
        widgetsPage.hoverOverTest(hoverTarget);

        if (expectedMessage.contains("button")){
            Assert.assertEquals(expectedMessage,widgetsPage.messageButton.getText() );
        }if (expectedMessage.contains("text field")){
            Assert.assertEquals(expectedMessage, widgetsPage.messageTextField.getText());
        }
    }


}
