package testcases.OnboardingTest;

import Pages.Hris;
import base.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class HrisDeleteFingerprintTest extends BaseClass {
    @Test
    public void HrisOnboardingtest() throws InterruptedException, IOException {
        Hris hris = new Hris(driver);
        hris.clickOnboardingModule();
        hris.clickSearchAssociates();
        hris.setSearchAssociates(getDeleteFingerprintAssociateId());
        hris.pressEnterSearch();
        hris.clickActionButton();
        hris.clickDeleteFingerprint();
        hris.clickDeleteFingerprint1();
        Thread.sleep(3000);
//        hris.clickYes();
//        Thread.sleep(5000);
//        hris.clickCloseIcon1();
//        Thread.sleep(5000);
//        hris.clickCloseIcon();

    }
}
