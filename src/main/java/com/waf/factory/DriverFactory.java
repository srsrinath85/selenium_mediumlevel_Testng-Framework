package com.waf.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initialization(String browserType)  {
        if (browserType.equalsIgnoreCase("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser");
        }
        return driver;
    }

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }



}
