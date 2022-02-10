package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InteractionsPage extends BasePage{

    @FindBy(xpath = "(//div[@id = 'droppable']/p[. = 'Drop here'])[1]")
    public WebElement target;

    @FindBy(xpath = "(//div[@id = 'droppable']/p)[1]")
    public WebElement targetText;

    @FindBy(css = "#draggable")
    public WebElement source;


    public void dragAndDrop(){
        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(source,target).perform();

    }




}
