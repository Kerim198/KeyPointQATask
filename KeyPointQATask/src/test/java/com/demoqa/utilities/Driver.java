package com.demoqa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){
            String browser = ConfigurationReader.get("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                   // System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
                   // ChromeOptions options = new ChromeOptions();
                   // options.addArguments("--no-sandbox");
                   // driver = new ChromeDriver(options);
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

            }

        }

        return driver;
    }
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }


    }

}
