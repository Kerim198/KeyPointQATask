package com.demoqa.pages;

import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertsWindowsPage extends BasePage{


    @FindBy(xpath = "//h5[. = 'Alerts, Frame & Windows']")
    public WebElement alertModule;

    @FindBy(xpath = "//span[.= 'Alerts']")
    public WebElement alertSubModule;

    @FindBy(xpath = "(//button[. = 'Click me'])[1]")
    public WebElement clickMeFirst;

    @FindBy(xpath = "//button[. = 'Click me']")
    public List<WebElement> listOfAlertButton;

    @FindBy(id = "promptResult")
    public WebElement promtResutl;


    public void clickModule(String module, WebElement element){

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        String xpath = "//h5[. = '" +module+ "']";
        Driver.getDriver().findElement(By.xpath(xpath)).click();

    }

    public void clickSubModule(String subModule, WebElement element){

        String xpath = "//span[.= '" +subModule+ "']";
        element = Driver.getDriver().findElement(By.xpath("//span[.= '" +subModule+ "']"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Driver.getDriver().findElement(By.xpath(xpath)).click();

    }

    public void clickClickMeButtonsAndHandleAlerts(){

        for (WebElement element : listOfAlertButton) {

            if (element.getAttribute("id").equals("alertButton")) {
                element.click();
                BrowserUtils.alertAccept();
            } else if (element.getAttribute("id").equals("timerAlertButton")) {
                element.click();
                BrowserUtils.waitFor(8);
                BrowserUtils.alertAccept();
            } else if (element.getAttribute("id").equals("confirmButton")) {
                element.click();
                BrowserUtils.alertDismiss();
            } else if (element.getAttribute("id").equals("promtButton")) {
                element.click();
                Driver.getDriver().switchTo().alert().sendKeys("Hello Alert");
                BrowserUtils.alertAccept();
                System.out.println("promtResutl.getText() = " + promtResutl.getText());
                BrowserUtils.waitFor(3);
            }

        }
    }

}
