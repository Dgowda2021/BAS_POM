package testcases.OnboardingTest;

import Pages.Hris;
import base.BaseClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import static utilities.ConfigReader.*;

public class HrisOnboardingManualTest extends BaseClass {

    @Test
    public void HrisOnboardingtest() throws InterruptedException, IOException {
        Hris hris = new Hris(driver);
        hris.clickOnboardingModule();
        hris.clickSearchAssociates();
        hris.setSearchAssociates(getmanualFingerprintAssociateId());
        hris.pressEnterSearch();
        hris.clickReadyToOnboard();
        hris.clickIAgree();
        hris.clickStartOnboarding();
        hris.clickRegistrationType();
        hris.clickManualRegistration();
        hris.clickSelectVendor();
        Thread.sleep(500);
        hris.clickSelectVendorName();
        Thread.sleep(500);
        hris.clickSelectRemark();
        Thread.sleep(500);
        hris.clickFlatFingerRegistration();
        Thread.sleep(500);
       // hris.clickSave();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //hris.clickClose();
    }

}
