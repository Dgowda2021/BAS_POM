package testcases.Settings;

import Pages.SettingsPage;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class EmailNotificationTest extends BaseClass {

    @Test(priority = 1)
    public void EmailNotificationSettingsTest() throws InterruptedException, IOException {

        Thread.sleep(3000);
        test = extent.createTest("Email Notification Settings Test");
        SettingsPage settingsPage = new SettingsPage(driver);
        // Add test steps for Email Notification Settings here
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        settingsPage.clickSettingsMenu();
        settingsPage.clickEmailNotificationOption();
        settingsPage.clickAddButton();
        settingsPage.enterName("Test Email Notification");
        settingsPage.enterEmail("Test@aziro.com");
        settingsPage.clickSaveButton();
        settingsPage.clickNoButton();
        settingsPage.clickSaveButton();
        settingsPage.clickYesButton();

        String expected = "Email has been added successfully.";
        String actual = driver.findElement(By.xpath("//div[@class='message']")).getText();
        Assert.assertEquals(expected, actual, "Email Notification addition failed or message mismatch.");
        System.out.println("---Email Notification Add Email testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Email Notification Settings test passed.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Email Notification Settings Screenshot");
        } else {
            test.log(Status.FAIL, "Email Notification Settings test failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Email Notification Settings Screenshot");
        }
        settingsPage.clickCloseNotification();
        Thread.sleep(3000);
        settingsPage.clickEditButton();
        settingsPage.enterName("Test Email Notification edited");
        settingsPage.enterEmail("TestEdit@aziro.com");
        settingsPage.clickSaveButton();
        settingsPage.clickYesButton();
        String expectedEdit = "Email has been updated successfully.";
        String actualEdit = driver.findElement(By.xpath("//div[@class='message']")).getText();
        Assert.assertEquals(expectedEdit, actualEdit, "Email Notification edit failed or message mismatch.");
        System.out.println("---Email Notification Settings Edit testing results---");
        System.out.println("Expected: " + expectedEdit);
        System.out.println("Actual: " + actualEdit);
        if (expectedEdit.equals(actualEdit)) {
            test.log(Status.PASS, "Email Notification Settings Edit test passed.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Email Notification Settings Edit Screenshot");
        } else {
            test.log(Status.FAIL, "Email Notification Settings Edit test failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Email Notification Settings Edit Screenshot");
        }

        settingsPage.clickCloseNotification();
        Thread.sleep(3000);
        settingsPage.clickDeleteButton();
        settingsPage.clickConfirmDeleteButton();
        String expectedDelete = "Email has been deleted successfully.";
        String actualDelete = driver.findElement(By.xpath("//div[@class='message']")).getText();
        Assert.assertEquals(expectedDelete, actualDelete, "Email Notification deletion failed or message mismatch.");
        System.out.println("---Email Notification Settings Delete testing results---");
        System.out.println("Expected: " + expectedDelete);
        System.out.println("Actual: " + actualDelete);
        if (expectedDelete.equals(actualDelete)) {
            test.log(Status.PASS, "Email Notification Settings Delete test passed.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Email Notification Settings Delete Screenshot");
        } else {
            test.log(Status.FAIL, "Email Notification Settings Delete test failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Email Notification Settings Delete Screenshot");
        }
        extent.flush();



    }


}
