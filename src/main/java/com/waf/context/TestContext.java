package com.waf.context;

import com.common.utilities.ConfigLoader;
import com.common.utilities.PropertyFileLoader;
//import com.waf.dbhelper.dbexecutor;
import com.waf.factory.DriverFactory;
import com.waf.pages.e_commerce.place_orderpage;
import com.waf.pages.register;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContext {
    public WebDriver driver;
    public PropertyFileLoader pfloader;
    public ConfigLoader cloader;
    public register register;
    //public dbexecutor dbexecutor;
    public DriverFactory driverFactory;
    public place_orderpage orderPage;

    public TestContext() throws IOException {
        cloader = new ConfigLoader();
        driverFactory = new DriverFactory(); // Initialize DriverFactory with ConfigLoader
        driver = DriverFactory.initialization(cloader.getProperty("browser"));
        driverFactory.openUrl(driver, cloader.getProperty("url1"));
        orderPage=new place_orderpage(driver);
    }
}

