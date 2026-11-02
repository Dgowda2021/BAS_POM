package testcases.OnboardingTest;

import Pages.Hris;
import base.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class HrisEditAssociateTest extends BaseClass {
    @Test
    public void HrisOnboardingtest() throws InterruptedException, IOException {
        Hris hris = new Hris(driver);
        hris.clickOnboardingModule();
        hris.clickSearchAssociates();
        hris.setSearchAssociates(getRedFlagAssociateId());
        hris.pressEnterSearch();
        hris.clickActionButton();
        hris.clickEditAssociate();
        hris.clickFlagSelection();
        hris.clickFlag();
        hris.setRemark("testing auto");
        //hris.clickSaveFlag();
        Thread.sleep(3000);
//        hris.clickConfirm();

    }
}
