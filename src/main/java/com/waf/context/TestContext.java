package com.waf.context;

import com.common.utilities.ConfigLoader;
import com.common.utilities.PropertyFileLoader;
//import com.waf.dbhelper.dbexecutor;
import com.waf.factory.DriverFactory;
import com.waf.pages.e_commerce.place_orderpage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContext {
    public WebDriver driver;
    //public PropertyFileLoader pfloader;
    public ConfigLoader cloader;
    // public dbexecutor dbexecutor;
    public DriverFactory driverFactory;
    public place_orderpage orderPage;

//    public TestContext() throws IOException {
//        cloader = new ConfigLoader();
//        driverFactory = new DriverFactory(); // Initialize DriverFactory with ConfigLoader
////        //driver = DriverFactory.initialization(cloader.getProperty("browser"));
////        driver = DriverFactory.initialization(cloader.getProperty("browser"));
////        driverFactory.openUrl(driver, cloader.getProperty("url1"));
////        orderPage = new place_orderpage(driver);
//        String gridUrl = cloader.getProperty("grid_url");  // Fetch the Grid URL from config
//        String browserType = cloader.getProperty("browser");  // Fetch browser type from config
//        driver = DriverFactory.initialization1(gridUrl, browserType);
//
//        // Open the test URL
//        driverFactory.openUrl(driver, cloader.getProperty("url1"));
//
//        // Initialize page objects
//        orderPage = new place_orderpage(driver);
//    }

    public TestContext() throws IOException {
        cloader = new ConfigLoader();
        driverFactory = new DriverFactory(); // Initialize DriverFactory with ConfigLoader
//        //driver = DriverFactory.initialization(cloader.getProperty("browser"));
//        driver = DriverFactory.initialization(cloader.getProperty("browser"));
//        driverFactory.openUrl(driver, cloader.getProperty("url1"));
//        orderPage = new place_orderpage(driver);
        String gridUrl = cloader.getProperty("grid_url");  // Fetch the Grid URL from config
        String browserType = cloader.getProperty("browser");  // Fetch browser type from config
        driver = DriverFactory.initialization1(gridUrl, browserType);

        // Open the test URL
        driverFactory.openUrl(driver, cloader.getProperty("url1"));

        // Initialize page objects
        orderPage = new place_orderpage(driver);
    }


}
