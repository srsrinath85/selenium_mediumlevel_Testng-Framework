package com.waf.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver driver;
//
//    public static WebDriver initialization(String browserType)  {
//        if (browserType.equalsIgnoreCase("EDGE")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        } else if (browserType.equalsIgnoreCase("FIREFOX")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else {
//            System.out.println("Invalid browser");
//        }
//        return driver;
//    }

    public static WebDriver initialization1(String gridUrl, String browserType) {
        try {
            if (browserType.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else if (browserType.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else {
                System.out.println("Invalid browser type");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

//    public void openUrl(WebDriver driver, String url) {
//        driver.get(url);
//        driver.manage().window().maximize();
//    }

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

}
