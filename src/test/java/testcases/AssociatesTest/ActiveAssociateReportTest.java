package testcases.AssociatesTest;

import Pages.Associates;
import Pages.DatePickerAssociates;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class ActiveAssociateReportTest extends BaseClass {

//WebDriver driver;

    // Test method to verify the Associate Report functionality
    @Test(priority = 1)
    public void verifyAssociateCreatedDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate Created Date Report", "Test to verify Associate Created Date Report generation");
        Associates associateReport = new Associates(driver);
        Thread.sleep(3000);
// Explicit wait before clicking "Associates"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Associates']")));

        associateReport.clickAssociates();
        associateReport.clickViewMore();
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
        associateReport.clickAll(); // Click on the All option
        associateReport.clickSelectFlag(); // Click on the Select Flag dropdown
        associateReport.clickAllFlag(); // Click on the All option
        associateReport.clickGenerate();

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Active Associates Created Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associate Created Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Associate Created Date Report Screenshot");
        } else {
            test.log(Status.FAIL, "Associate Created Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Associate Created Date Report Screenshot");
        }
        extent.flush();
    }

    @Test(priority = 2)
    public void verifyAssociateUpdatedDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate Updated Date Report", "Test to verify Associate Updated Date Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(3000);
// Explicit wait before clicking "Associates"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Associates']")));

        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button

        // Navigate to the Associates section
        associateReport.clickReports();
        associateReport.clickSelectDateType(); // Click on the Select Date Type dropdown

        // Select the "Updated Date" option
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
        associateReport.clickSelectVendor(); // Click on the Select Vendor dropdown
        associateReport.clickAll(); // Click on the All option
        associateReport.clickSelectFlag(); // Click on the Select Flag dropdown
        associateReport.clickAllFlag(); // Click on the All option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();;
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Active Associates Updated Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associate Updated Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+ "Associate Updated Date Report Screenshot");
        } else if (false){
            test.log(Status.FAIL, "Associate Updated Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver))+ "Associate Updated Date Report Screenshot");
        }
        extent.flush();


    }
    @Test(priority = 3)
    public void verifyAssociateOnboardingDateReport() throws InterruptedException, IOException {
        test = extent.createTest("verify Associate Onboarding Date Report", "Test to verify Associate Onboarding Date Report generation");
        // Initialize the AssociateReport page object
        Associates associateReport = new Associates(driver);
        Thread.sleep(3000);
// Explicit wait before clicking "Associates"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Associates']")));

        associateReport.clickAssociates(); // Click on the Associates menu
        associateReport.clickViewMore(); // Click on the VIEW MORE button

        // Navigate to the Associates section
        associateReport.clickReports();
        associateReport.clickSelectDateType(); // Click on the Select Date Type dropdown
        // Select the "Onboarding Date" option
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

        associateReport.clickSelectVendor(); // Click on the Select Vendor dropdown
        associateReport.clickAll(); // Click on the All option
        associateReport.clickSelectFlag(); // Click on the Select Flag dropdown
        associateReport.clickAllFlag(); // Click on the All option
        associateReport.clickGenerate(); // Click on the Generate button

        String expected = "Download";
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='Download']")).getText();;
        Assert.assertEquals(expected, actual, "Report generation failed or message mismatch.");
        System.out.println("---Active Associates Onboarding Date Report testing results---");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Associate Onboarding Date Report generated successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+ "Associate Onboarding Date Report Screenshot");
        } else if (false){
            test.log(Status.FAIL, "Associate Onboarding Date Report generation failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver))+ "Associate Onboarding Date Report Screenshot");
        }
        extent.flush();

    }


}
