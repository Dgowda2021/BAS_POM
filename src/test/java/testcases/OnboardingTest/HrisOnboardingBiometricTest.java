package testcases.OnboardingTest;
import Pages.Hris;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import static utilities.ConfigReader.*;

public class HrisOnboardingBiometricTest extends BaseClass {

    @Test(priority = 1)
    public void HRISNewOnboaringTest() throws InterruptedException, IOException {
        test = extent.createTest("HRIS New Onboarding Biometric Test");

        // Step 1: Initialize the Hris page object
        Hris newonbord = new Hris(driver);

        // Step 2: Navigate to the Onboarding module
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        newonbord.clickOnboardingModule();

        // Step 3: Search for the associate using their ID
        newonbord.clickSearchAssociates();
        newonbord.setSearchAssociates(getNewOnboardingAssociateId());
//        Thread.sleep(2000);
        newonbord.pressEnterSearch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Step 4: Mark the associate as ready to onboard
        newonbord.clickReadyToOnboard();
        Thread.sleep(2000);
        // Step 5: Agree to the onboarding terms
        newonbord.clickIAgree();
        Thread.sleep(3000);
        // Step 6: Start the onboarding process
        newonbord.clickStartOnboarding();
        Thread.sleep(3000);
        // Step 7: Select the registration type
        newonbord.clickRegistrationType();
        Thread.sleep(3000);
        newonbord.clickBiometric();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


//         Step 8: Continue with the biometric registration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        newonbord.clickContinue();
//        Thread.sleep(3000);
//        // Step 9: Add a new associate
     //   newonbord.ClickAddNewAssociate();
        String status = Hris.scanFinegerprintHandle(driver);
        switch (status){
            case "New Associate Added Successfully":
                test.pass("New Associate Added Successfully");
                Assert.assertEquals(status, "New Associate Added Successfully");
                System.out.println("New Associate Added Successfully");
                break;

            case "Enroll Failed":
                test.fail("Enroll Failed");
                Assert.assertEquals(status, "Enroll Failed");
                System.out.println("Enroll Failed due to Fingerprint Already Registered with Flex id :"+getNewOnboardingAssociateId()+".");
                break;

            case "Fingerprint Matched - Continue and Update":
                test.pass("Fingerprint Matched - Continue and Update");
                Assert.assertEquals(status, "Fingerprint Matched - Continue and Update");
                System.out.println("Fingerprint Matched - Continue and Update");
                break;

            case "GOVT ID Mismatched":
                test.pass("GOVT ID Mismatched");
                Assert.assertEquals(status, "GOVT ID Mismatched");
                System.out.println("GOVT ID Mismatched");
                break;

            case "Cannot Onboard Due to Red Flag":
                test.pass("Cannot Onboard Due to Red Flag");
                Assert.assertEquals(status, "Cannot Onboard Due to Red Flag");
                System.out.println("Cannot Onboard Due to Red Flag");
                break;

            default:
                test.fail("Unexpected status: " + status);
                Assert.fail("Unexpected status: " + status);
                break;
        }
        newonbord.refreshPage();
        Thread.sleep(3000);
    }
}