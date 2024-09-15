package com.wamf.testsuite.E_commerce;

import com.aventstack.extentreports.ExtentTest;
import com.common.utilities.ExtentListener;
import com.waf.context.TestContext;
import com.waf.factory.DriverFactory;
import com.waf.pages.e_commerce.place_orderpage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(ExtentListener.class)
public class End_to_End_flow {

    private TestContext context;
    public place_orderpage orderPage;



    @BeforeMethod
    public void bt() throws IOException {
        context = new TestContext();
        orderPage=context.orderPage;
    }

    @Test
    public void test2(){
        System.out.println("it is executing");
        ExtentTest test = ExtentListener.getTest(); // Retrieve the current ExtentTest instance

        try {
            test.info("Starting the test for placing an order.");

            String username = context.cloader.getProperty("username");
            String password = context.cloader.getProperty("password");
            String firstName = context.cloader.getProperty("first_name");
            String lastName = context.cloader.getProperty("last_name");
            String postalCode = context.cloader.getProperty("postal_code");

            test.info("Entering login details.");
            orderPage.enter_logindetails(username, password);
            test.info("Clicking login button.");
            orderPage.click_loginbtn();

            test.info("Adding the first product to the cart.");
            orderPage.clickAddToCartButtonForProduct(1);

            test.info("Proceeding to checkout.");
            orderPage.click_cart();
            orderPage.click_checkout();
            test.info("Entering checkout details.");
            orderPage.enter_checkout_details(firstName, lastName, postalCode);
            orderPage.click_continue();
            orderPage.click_finishbtn();

            test.pass("Order placed successfully.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        }
    }

@AfterMethod
public void at(){
        context.driver.quit();
}


}
