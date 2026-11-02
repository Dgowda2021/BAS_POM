package testcases.OnboardingTest;

import Pages.DatePicker;
import Pages.Hris;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HrisReportTest extends BaseClass {
    @Test
    public void HrisOnboardingtest() throws InterruptedException, IOException {
        test = extent.createTest("verify Hris Onboarding Associate Updated Date Report", "Test to verify Hris Onboarding Associate Updated Date Report generation");
        Hris hris = new Hris(driver);
        hris.clickOnboardingModule();
        hris.clickOnboardingReport();
        hris.ClickSelectDateType();
        hris.ClickSelectCreatedDateType();

        DatePicker datePicker = new DatePicker(driver);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();

        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        Thread.sleep(2000);
        hris.ClickGenerate();

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();;
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Onboarding Associates Created Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Onboarding Associates Created Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+ "Onboarding Associates Created Date Report Screenshot");
        } else if (false){
            test.log(Status.FAIL, "Onboarding Associates Created Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver))+ "Onboarding Associates Created Date Report Screenshot");
        }
        extent.flush();



    }
}
