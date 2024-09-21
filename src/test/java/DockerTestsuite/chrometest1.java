package DockerTestsuite;

import com.aventstack.extentreports.ExtentTest;
import com.common.utilities.ExtentListener;
import com.common.utilities.VideoManger;
import com.waf.context.TestContext;
import com.waf.pages.e_commerce.place_orderpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class chrometest1 {

    @Test
    public void test2() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserName", "chrome");
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, options);
        System.out.println("chrome is executing");

    }

}
