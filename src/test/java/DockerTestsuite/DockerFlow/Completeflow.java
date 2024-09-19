package DockerTestsuite.DockerFlow;

import com.aventstack.extentreports.ExtentTest;
import com.common.utilities.ExtentListener;
import com.common.utilities.VideoManger;
import com.waf.context.TestContext;
import com.waf.pages.e_commerce.place_orderpage;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;
@Listeners(ExtentListener.class)
public class Completeflow {
    private TestContext context;
    public place_orderpage orderPage;

    @BeforeMethod
//    @Parameters({"browser"}) // Accept the browser parameter from testng.xml
    public void setUp() throws IOException, AWTException, IOException {
        context = new TestContext();  // Pass browser parameter to TestContext
        VideoManger.startVideoRecording();
        orderPage = context.orderPage;
    }

    @Test
    public void placeOrderTest() {
        ExtentTest test = ExtentListener.getTest();

        try {
            test.info("Starting the test for placing an order.");

            String username = context.cloader.getProperty("username");
            String password = context.cloader.getProperty("password");
            String firstName = context.cloader.getProperty("first_name");
            String lastName = context.cloader.getProperty("last_name");
            String postalCode = context.cloader.getProperty("postal_code");

            orderPage.enter_logindetails(username, password);
            orderPage.click_loginbtn();
            orderPage.clickAddToCartButtonForProduct(1);
            orderPage.click_cart();
            orderPage.click_checkout();
            orderPage.enter_checkout_details(firstName, lastName, postalCode);
            orderPage.click_continue();
            orderPage.click_finishbtn();

            test.pass("Order placed successfully.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            //System.out.println("Not executing.");
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            if (context.driver != null) {
                VideoManger.stopVideoRecording("VID_" + System.currentTimeMillis());
                context.driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Exception during teardown: " + e.getMessage());
        }
    }

}
