package testcases.Settings;

import Pages.SettingsPage;
import base.BaseClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OtpSettingsTest extends BaseClass {

    @Test(priority = 1)
    public void OtpSettingsVerificationTest() throws InterruptedException {
        test = extent.createTest("OTP Settings Verification Test");
        // Add test steps for OTP Settings verification here
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickCloseNotification();
        // Add test steps for Email Notification Settings here
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        settingsPage.clickSettingsMenu();
        settingsPage.clickOtpSettingsOption();
        settingsPage.clickOtpToggle();
        settingsPage.clickConfirmButton();
        Thread.sleep(2000);
        settingsPage.clickOtpToggle();
        settingsPage.clickConfirmButton();


        Thread.sleep(3000);

    }
}
