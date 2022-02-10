package com.demoqa.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickSafely(WebElement element, int time){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForClickablility(element,10);
        element.click();
    }

    public static void alertAccept(){
        waitFor(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

    public static void alertDismiss(){
        waitFor(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();

    }

    public static String alertGetText(){
        waitFor(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        return alert.getText();

    }

    public static void hoverOver(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();

    }

}
