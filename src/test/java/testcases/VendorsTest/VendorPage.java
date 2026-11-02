package testcases.VendorsTest;

import Actions.VendorActions;
import Pages.Vendors;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class VendorPage extends BaseClass {

    @Test(priority = 1)
    public void AddVendorTest() throws InterruptedException, IOException {
        test = extent.createTest("Add Vendor Test", "Test to add a new vendor");
        // Initialize the ManageVendors page object
        Vendors manageAddVendor = new Vendors(driver);
        Thread.sleep(2000);
        // Navigate to the Vendors section
        manageAddVendor.ClickVendors();


        // Click the "Add Vendor" button
        manageAddVendor.clickAddVendor();
        // Fill in the vendor details
        manageAddVendor.setOrganisationName("Test Vendor");
        manageAddVendor.setDomainName("testvendor.com");
        manageAddVendor.setContactPerson("TestName");
        manageAddVendor.setSearchSites("DELH");

        // Select the location
        manageAddVendor.clickDELH();
        // Save the vendor details
        manageAddVendor.clickSave();
        // Confirm the vendor creation
        manageAddVendor.clickConfirmVendor();

        if (manageAddVendor.isConfirmationDisplayed()) {
            System.out.println("Vendor Details Created Successfully");
            test.log(Status.PASS, "Vendor Details Created Successfully");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Vendor Creation Screenshot");
        } else {
            System.out.println("Vendor already exists");
            test.log(Status.FAIL, "Vendor already exists");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Vendor Creation Failed Screenshot");
        }

    }

    @Test(priority = 2)
    public void VendorReportTest() throws IOException, InterruptedException {
        test = extent.createTest("Vendor Report Test", "Test to generate and verify the Vendor Report");
        // Initialize the ManageVendors page object
        Vendors manageVendorReport = new Vendors(driver);
        // Navigate to the Vendors section
        manageVendorReport.ClickVendors();
        Thread.sleep(2000);
        // Click on the Vendor Report button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        manageVendorReport.clickVendorReport();
        Thread.sleep(2000); // Wait for the download to complete

        if (manageVendorReport.isFileDownloaded("D:\\Downloads\\")) {
            System.out.println("Vendor Report Generated Successfully");
            test.log(Status.PASS, "Vendor Report Generated Successfully");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Vendor Report Screenshot");
        } else {
            System.out.println("Vendor Report generation failed");
            test.log(Status.FAIL, "Vendor Report generation failed");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Vendor Report Failed Screenshot");
        }
    }

    @Test(priority = 3)
    public void DeleteVendorTest() throws InterruptedException, IOException {
        test = extent.createTest("Delete Vendor Test", "Test to delete an existing vendor");
        // Initialize the ManageVendors and VendorActions page objects
        Vendors manageDeleteVendors = new Vendors(driver);
        VendorActions vendorActions = new VendorActions(driver);

        // Navigate to the Vendors section
        manageDeleteVendors.ClickVendors();
        // Search for the vendor using its name
        manageDeleteVendors.setSearch("Test Vendor");

        if (manageDeleteVendors.isNoVendorsMessageDisplayed()) {
            String expected = "No Vendors Available";
            String actual = manageDeleteVendors.getNoVendorsMessage(); // Method to retrieve the message
            Assert.assertEquals(actual, expected, "No Vendors message mismatch.");
            System.out.println("No Vendors Available");
            test.log(Status.INFO, "No Vendors Available");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "No Vendors Available Screenshot");
        } else {

            // Hover over the vendor card to make the delete button visible
            vendorActions.hoverOverVendorCard("Test Vendor");
            // Click the delete button for the vendor
            vendorActions.clickDeleteButton("Test Vendor");
            // Confirm the vendor deletion
            vendorActions.confirmVendorDeletion();

            if (manageDeleteVendors.isDeleteConfirmationDisplayed()) {
                System.out.println("Vendor Details Deleted Successfully");
                test.log(Status.PASS, "Vendor Details Deleted Successfully");
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Vendor Creation Screenshot");
            } else {
                System.out.println("Vendor deletion confirmation not displayed");
                test.log(Status.FAIL, "Vendor deletion confirmation not displayed");
                test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Vendor Creation Failed Screenshot");
            }
        }

    }
}