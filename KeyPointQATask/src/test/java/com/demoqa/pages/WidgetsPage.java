package com.demoqa.pages;

import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WidgetsPage extends BasePage{

    @FindBy(id = "toolTipButton")
    public WebElement hoverMeToSeeButton;

   @FindBy(id = "toolTipTextField")
    public WebElement hoverMeToSeeTextField;

    @FindBy(css = "#buttonToolTip")
    public WebElement messageButton;

    @FindBy(css = ".fade.show.tooltip.bs-tooltip-bottom")
    public WebElement messageTextField;

   public void hoverOverTest(String hoverTarget){

       if (hoverTarget.contains("button")){
           BrowserUtils.hoverOver(hoverMeToSeeButton);
           BrowserUtils.waitFor(3);
       }
       else if (hoverTarget.contains("text field")){
           BrowserUtils.hoverOver(hoverMeToSeeTextField);
           BrowserUtils.waitFor(3);
       }
   }

}
