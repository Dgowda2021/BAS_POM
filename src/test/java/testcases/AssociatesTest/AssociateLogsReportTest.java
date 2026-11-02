package testcases.AssociatesTest;

import Pages.Associates;
import Pages.DatePickerAssociates;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AssociateLogsReportTest extends BaseClass {

    // Test method to verify the Associate Report functionality
    @Test(priority = 1)
    public void verifyAssociateAllLogsReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate All Logs Report", "Test to verify Associate All Logs Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
        associateReport.clickAssociates(); // Click on the Associates menu

        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickAssociateLogs(); // Click on the Red Flag History option

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

        associateReport.clickSelectLogType(); // Click on the Select Vendor dropdown
        associateReport.clickAll(); // Click on the All option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Associates All Logs Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associates All Logs Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Associates All Logs Report Screenshot");
        } else {
            test.log(Status.FAIL, "Associates All Logs Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Associates All Logs Report Screenshot");
        }
        extent.flush();
        
    }

    @Test(priority = 2)
    public void verifyAssociateFlagChangeReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate Flag Changes Report", "Test to verify Associate Flag Changes Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickAssociateLogs(); // Click on the Red Flag History option
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

        associateReport.clickSelectLogType(); // Click on the Select Vendor dropdown
        associateReport.clickFlagChange(); // Click on the All option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Associates Flag Changes Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associates Flag Changes Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Associates Flag Changes Report Screenshot");
        } else {
            test.log(Status.FAIL, "Associates Flag Changes Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Associates Flag Changes Report Screenshot");
        }
        extent.flush();

    }
    @Test(priority = 3)
    public void verifyAssociateManualRegistrationReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate Manual Registration Report", "Test to verify Associate Manual Registration Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickAssociateLogs(); // Click on the Red Flag History option
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

        associateReport.clickSelectLogType(); // Click on the Select Vendor dropdown
        associateReport.clickManualRegistration(); // Click on the Aziro option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Associates Manual Registration Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associates Manual Registration Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Associates Manual Registration Report Screenshot");
        } else {
            test.log(Status.FAIL, "Associates Manual Registration Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Associates Manual Registration Report Screenshot");
        }
        extent.flush();

    }

    @Test(priority = 4)
    public void verifyAssociateAssociateFingerprintsDeletionReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate Fingerprints Deletion Report", "Test to verify Associate Manual Fingerprints Deletion Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(2000);
        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button
        associateReport.clickAssociateLogs(); // Click on the Red Flag History option
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

        associateReport.clickSelectLogType(); // Click on the Select Vendor dropdown
        associateReport.clickAssociateFingerprintsDeletion(); // Click on the Aziro option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Associates Fingerprints Deletion Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associates Fingerprints Deletion Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Associates Fingerprints Deletion Report Screenshot");
        } else {
            test.log(Status.FAIL, "Associates Fingerprints Deletion Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Associates Fingerprints Deletion Report Screenshot");
        }
        extent.flush();

    }


}
