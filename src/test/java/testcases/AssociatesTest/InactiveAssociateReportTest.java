package testcases.AssociatesTest;

import Pages.Associates;
import Pages.DatePickerAssociates;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class InactiveAssociateReportTest extends BaseClass {

    @Test(priority = 1)
    public void verifyInactiveAssociateCreatedDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Inactive Associate Created Date Report", "Test to verify Inactive Associate Created Date Report generation");
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
// Explicit wait before clicking "Associates"
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Associates']")));
        associateReport.clickAssociates();
        associateReport.clickViewMore();
        associateReport.clickInActiveAssociates();
        associateReport.clickReports();
        associateReport.clickSelectDateType();
        associateReport.clickCreatedDate();

        DatePickerAssociates datePicker = new DatePickerAssociates(driver);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();
        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        associateReport.clickSelectVendor();
        associateReport.clickAll();
        associateReport.clickGenerate();

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Inactive Associates Created Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Inactive Associate Created Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Inactive Associate Created Date Report Screenshot");
        } else {
            test.log(Status.FAIL, "Inactive Associate Created Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Inactive Associate Created Date Report Screenshot");
        }
        extent.flush();
    }

    @Test(priority = 2)
    public void verifyInactiveAssociateUpdatedDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Inactive Associate Updated Date Report", "Test to verify Inactive Associate Updated Date Report generation");
        Associates associateReport = new Associates(driver);

        Thread.sleep(3000);
        associateReport.clickAssociates();
        associateReport.clickViewMore();
        associateReport.clickInActiveAssociates();
        associateReport.clickReports();
        associateReport.clickSelectDateType();
        associateReport.clickUpdatedDate();

        DatePickerAssociates datePicker = new DatePickerAssociates(driver);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();
        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        associateReport.clickSelectVendor();
        associateReport.clickAll();
        associateReport.clickGenerate();

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Inactive Associates Updated Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Inactive Associate Updated Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Inactive  Associate Updated Date Report Screenshot");
        } else {
            test.log(Status.FAIL, "Inactive Associate Updated Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Inactive Associate Updated Date Report Screenshot");
        }
        extent.flush();
    }

    @Test(priority = 3)
    public void verifyInactiveAssociateOnboardingDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Inactive Associate Onboarding Date Report", "Test to verify Inactive Associate Onboarding Date Report generation");
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
        associateReport.clickAssociates();
        associateReport.clickViewMore();
        associateReport.clickInActiveAssociates();
        associateReport.clickReports();
        associateReport.clickSelectDateType();
        associateReport.clickOnboardingDate();

        DatePickerAssociates datePicker = new DatePickerAssociates(driver);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();
        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        associateReport.clickSelectVendor();
        associateReport.clickAll();
        associateReport.clickGenerate();

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Inactive Associates Onboarded Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Inactive Associate Onboarding Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Inactive Associate Onboarding Date Report Screenshot");
        } else {
            test.log(Status.FAIL, "Inactive Associate Onboarding Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Inactive Associate Onboarding Date Report Screenshot");
        }
        extent.flush();
    }
}