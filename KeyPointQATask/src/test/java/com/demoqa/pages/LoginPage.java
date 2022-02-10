package com.demoqa.pages;

import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement userNameInputBox;

    @FindBy(css = "#password")
    public WebElement passwordInputBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3")
    public WebElement errorMessage;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement openMenuButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutButton;

    @FindBy(xpath = "//span[@class = 'title']")
    public WebElement title;

    public void logOut(){
        openMenuButton.click();
        BrowserUtils.waitFor(2);
        logOutButton.click();
    }

    public void validLogin(String username, String password){
        userNameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password, Keys.ENTER);
    }


    public void loginAsStandarUser(){
       String username = ConfigurationReader.get("standart_user_username");
       String password = ConfigurationReader.get("password");
        userNameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password, Keys.ENTER);
    }

    public void loginAsLockedOutUser(){
        String username = ConfigurationReader.get("locked_out_user_username");
        String password = ConfigurationReader.get("password");
        userNameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password, Keys.ENTER);
    }

    public void loginAsProblemUser(){
        String username = ConfigurationReader.get("problem_user_username");
        String password = ConfigurationReader.get("password");
        userNameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password, Keys.ENTER);
    }

    public void loginAsPerformanceGlitchUser(){
        String username = ConfigurationReader.get("performance_glitch_user_username");
        String password = ConfigurationReader.get("password");
        userNameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password, Keys.ENTER);
    }



}
