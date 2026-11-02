package testcases.AssociatesTest;

import Pages.Associates;
import Pages.DatePickerAssociates;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RedFlagAssociateReportTest extends BaseClass {

    // Test method to verify the Associate Report functionality
    @Test(priority = 1)
    public void verifyAssociateCreatedDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify All Associate Red flag History Report", "Test to verify All Associate Red flag History Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);

        Thread.sleep(3000);
        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickRedFlagHistory(); // Click on the Red Flag History optio

        // Navigate to the Associates section
        associateReport.clickReports();

        DatePickerAssociates datePicker = new DatePickerAssociates(driver);
        Thread.sleep(2000);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();

        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        associateReport.clickSelectVendor(); // Click on the Select Vendor dropdown
        associateReport.clickAll(); // Click on the All option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---All Associates Red Flag History Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "All Associates Red Flag History Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "All Associates Red Flag History Report Screenshot");
        } else {
            test.log(Status.FAIL, "All Associates Red Flag History Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "All Associates Red Flag History Report Screenshot");
        }
        extent.flush();

    }

    @Test(priority = 2)
    public void verifyAssociateUpdatedDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify G4S Associate Red flag History Report", "Test to verify G4S Associate Red flag History Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);

        Thread.sleep(2000);
        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickRedFlagHistory(); // Click on the Red Flag History option

        // Navigate to the Associates section
        associateReport.clickReports();

        DatePickerAssociates datePicker = new DatePickerAssociates(driver);
        Thread.sleep(2000);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();

        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        associateReport.clickSelectVendor(); // Click on the Select Vendor dropdown
        associateReport.clickG4S(); // Click on the All option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---G4S Associates Red Flag History Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "G4S Associates Red Flag History Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "G4S Associates Red Flag History Report Screenshot");
        } else {
            test.log(Status.FAIL, "G4S Associates Red Flag History Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "G4S Associates Red Flag History Report Screenshot");
        }
        extent.flush();

    }
    @Test(priority = 3)
    public void verifyAssociateOnboardingDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify SIS Associate Red flag History Report", "Test to verify SIS Associate Red flag History Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickRedFlagHistory(); // Click on the Red Flag History option

        // Navigate to the Associates section
        associateReport.clickReports();

        DatePickerAssociates datePicker = new DatePickerAssociates(driver);
        Thread.sleep(2000);
        datePicker.ClickCalenderReport();
        datePicker.clickStartMonthYear25();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();

        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();

        associateReport.clickSelectVendor(); // Click on the Select Vendor dropdown
        associateReport.clickSIS(); // Click on the Aziro option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---SIS Associates Red Flag History Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "SIS Associates Red Flag History Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "SIS Associates Red Flag History Report Screenshot");
        } else {
            test.log(Status.FAIL, "SIS Associates Red Flag History Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "SIS Associates Red Flag History Report Screenshot");
        }
        extent.flush();

    }


}
