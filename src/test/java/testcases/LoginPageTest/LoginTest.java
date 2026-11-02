package testcases.LoginPageTest;

import Pages.Login;
import base.loginBaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static utilities.ConfigReader.*;

public class LoginTest extends loginBaseClass {
    @Test(priority = 4)
    public void loginTest() throws IOException, InterruptedException {
        test = extent.createTest("Login Test", "Verify that a user can log in successfully with valid credentials.");
        Login login = new Login(driver);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //login.setClickCloseAlert();
        login.setTxtUsernumber(getUsernumber());
        login.setTxtUserPassword(getPassword());
        login.ClickCheckbox();
        login.ClickBtnLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);
        login.setEnterOtp1("2");
        login.setEnterOtp2("5");
        login.setEnterOtp3("3");
        login.setEnterOtp4("1");
        login.setEnterOtp5("9");
        login.setEnterOtp6("3");
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login.clickSubmitbutton();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login.ClickClosebutton();
        Thread.sleep(3000);

        String expected = "Biometric Authentication System";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Biometric Authentication System']")).getText();
        Assert.assertEquals(expected, actual, "Login failed or landing page title mismatch.");
            System.out.println("---Login testing results---");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
                if (expected.equals(actual)) {
                    test.log(Status.PASS, "Login test passed successfully.");
                    test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Login test passed.");
                } else {
                    test.log(Status.FAIL, "Login test failed.");
                    test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Login test failed.");
                }
                extent.flush();

    }

    @Test(priority = 1)
    public void otpPageDisplayTest() throws IOException, InterruptedException {
        test = extent.createTest("OTP Page Display Test", "Verify that the OTP page is displayed after entering valid login credentials.");
        Login login = new Login(driver);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //login.setClickCloseAlert();
        login.setTxtUsernumber(getUsernumber());
        login.setTxtUserPassword(getPassword());
        login.ClickCheckbox();
        login.ClickBtnLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);

        String expectedOtpPage = "OTP Verification Page"; // Change this to the actual heading text if available
        String actualOtpPage = "";

        try {
            // Check if the OTP input field is visible
            boolean isOtpFieldPresent = driver.findElement(By.xpath("//input[@ng-reflect-name='otp1']")).isDisplayed();

            if (isOtpFieldPresent) {
                actualOtpPage = "OTP Verification Page";
            }
        } catch (Exception e) {
            actualOtpPage = "Page Not Found / Element Missing";
        }

// Assertions and Reporting
        Assert.assertEquals(actualOtpPage, expectedOtpPage, "OTP page validation failed.");

        System.out.println("---OTP Page Visibility Results---");
        System.out.println("Expected: " + expectedOtpPage);
        System.out.println("Actual: " + actualOtpPage);

        if (expectedOtpPage.equals(actualOtpPage)) {
            test.log(Status.PASS, "OTP Page displayed successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "OTP Page Passed.");
        } else {
            test.log(Status.FAIL, "OTP Page was not displayed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "OTP Page Failed.");
        }

        extent.flush();
    }

    @Test(priority = 2)
    public void invalidLoginTest() throws IOException, InterruptedException {
        test = extent.createTest("Invalid Login Test", "Verify that an appropriate error message is displayed when logging in with invalid credentials.");
        Login login = new Login(driver);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //login.setClickCloseAlert();
        login.setTxtUsernumber("9008639449");
        login.setTxtUserPassword("Stage@222222");
        login.ClickCheckbox();
        login.ClickBtnLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);

        String expectedErrorMessage = "Invalid credentials";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match for invalid login.");
        System.out.println("Expected Error Message: " + expectedErrorMessage);
        System.out.println("Actual Error Message: " + actualErrorMessage);
        System.out.println("---Invalid Login testing results---");
            if (expectedErrorMessage.equals(actualErrorMessage)) {
                test.log(Status.PASS, "Invalid login error message displayed successfully.");
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Invalid Login Test Passed.");
            } else {
                test.log(Status.FAIL, "Invalid login error message was not displayed.");
                test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Invalid Login Test Failed.");
            }
        extent.flush();
    }

    @Test(priority = 3)
    public void emptyCredentialsLoginTest() throws IOException, InterruptedException {
        test = extent.createTest("Empty Credentials Login Test", "Verify that appropriate error messages are displayed when attempting to log in with empty credentials.");
        Login login = new Login(driver);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //login.setClickCloseAlert();
        login.setTxtUsernumber("");
        login.setTxtUserPassword("");
        login.ClickCheckbox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);

        // Define expected messages
        String expectedMobileError = "Mobile Number is required";
        String expectedPasswordError = "Password is required";

// Capture actual messages from the UI
        String actualMobileError = driver.findElement(By.xpath("//p[normalize-space()='Mobile Number is required']")).getText();
        String actualPasswordError = driver.findElement(By.xpath("//p[normalize-space()='Password is required']")).getText();

// Console Output
        System.out.println("---Validation Results---");
        System.out.println("Mobile Number Error - Expected: " + expectedMobileError + " | Actual: " + actualMobileError);
        System.out.println("Password Error - Expected: " + expectedPasswordError + " | Actual: " + actualPasswordError);

// Logical Check for Reporting
        boolean isMobileValid = expectedMobileError.equals(actualMobileError);
        boolean isPasswordValid = expectedPasswordError.equals(actualPasswordError);

        if (isMobileValid && isPasswordValid) {
            test.log(Status.PASS, "Validation Passed: Both 'Mobile Number' and 'Password' required messages are displayed correctly.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Field Validation Passed.");
        } else {
            test.log(Status.FAIL, "Validation Failed: Error messages missing or incorrect.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Field Validation Failed.");
        }

// Hard Assertion to stop the test if validation fails
        Assert.assertTrue(isMobileValid && isPasswordValid, "Error message mismatch for required fields.");

        extent.flush();

    }

}
