package testcases.VendorsTest;

import Pages.Vendors;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class SitePage extends VendorBaseClass {

    @Test(priority = 1)
    public void AddSiteTest() throws InterruptedException, IOException {
        test = extent.createTest("Add Site Test", "Test to add a new site");
        // Initialize the ManageVendors page object
        Vendors manageAddSite = new Vendors(driver);

        // Navigate to the Vendors section
        manageAddSite.ClickVendors();
        // Navigate to Sites section
        manageAddSite.clickSites();
        // Click the "Add Site" button
        manageAddSite.clickAddSite();

        manageAddSite.setSiteCode("TEST"); // Fill in the Site Name
        Thread.sleep(500);
        manageAddSite.selectState("Karnataka"); // Select State
        Thread.sleep(500);
        manageAddSite.selectCity("Bengaluru"); // Select City
        Thread.sleep(500);
        manageAddSite.selectRegion("West"); // Select Region
        Thread.sleep(500);
        manageAddSite.selectType("AMZL"); // Select Type
        Thread.sleep(500);
        manageAddSite.clickSaveSite(); // Submit the form
//
            // Verify if the site was added successfully
            if (manageAddSite.isConfirmationSiteDisplayed()) {
                System.out.println("Site Details Created Successfully");
                test.log(Status.PASS, "Site Details Created Successfully");
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Site Details Creation Screenshot");
            } else {
                System.out.println("Site creation failed or already exists");
                test.log(Status.FAIL, "Site creation failed or already exists");
                test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Site Details Creation Failed Screenshot");
            }
//
    }

    @Test(priority = 2)
    public void SiteReportTest() throws IOException, InterruptedException {
        test = extent.createTest("Site Report Test", "Test to generate and verify the Site Report");
        // Initialize the ManageVendors page object
        Vendors manageSiteReport = new Vendors(driver);
        Thread.sleep(500);
        // Navigate to the Vendors section
        manageSiteReport.ClickVendors();
        // Navigate to Sites section
        manageSiteReport.clickSites();
        // Click on the Site Report button
        manageSiteReport.clickSiteReport();
        Thread.sleep(2000); // Wait for the download to complete

//       Verify if the report was downloaded successfully

        if (manageSiteReport.isFileDownloaded("D:\\Downloads\\")) {
            System.out.println("Report downloaded successfully.");
            test.log(Status.PASS, "Report downloaded successfully.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Site Report Download Screenshot");
        } else {
            System.out.println("Report download failed.");
            test.log(Status.FAIL, "Report download failed.");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Site Report Download Failed Screenshot");
        }


}

    @Test(priority = 3)
    public void DeleteSiteTest() throws InterruptedException, IOException {
        test = extent.createTest("Delete Site Test", "Test to delete an existing site");
        // Initialize the ManageVendors page object
        Vendors manageDeleteSite = new Vendors(driver);
        Thread.sleep(500);
        // Navigate to the Vendors section
        manageDeleteSite.ClickVendors();
        // Navigate to Sites section
        manageDeleteSite.clickSites();
        // Search for the site using its name
        manageDeleteSite.setSearch("TEST"); // Enter the site name in the search field
        Thread.sleep(2000); // Wait for search results to load
            // Click the Delete button for the site
           if (manageDeleteSite.isSitePresentInSearchResults("TEST")) {

            manageDeleteSite.clickDeleteSite();
            Thread.sleep(2000);
            // Confirm the site deletion
            manageDeleteSite.clickConfirmDeleteSite();
            Thread.sleep(2000);
            // Verify if the site was deleted successfully
            if (manageDeleteSite.isDeleteSiteConfirmationDisplayed()) {
                System.out.println("Site Details Deleted Successfully");
                test.log(Status.PASS, "Site Details Deleted Successfully");
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Site Details Deleted Screenshot");
            } else {
                System.out.println("Site deletion failed or does not exist");
                test.log(Status.FAIL, "Site deletion failed or does not exist");
                test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Site Details Deleted Failed Screenshot");
            }
           }
           else{
               Thread.sleep(2000); // Wait for search results to load
                   manageDeleteSite.getNoSitesFoundMessage();
                   System.out.println("No Sites Found");
                   test.log(Status.PASS, "No Sites Found");
                   test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Site Not Found Screenshot");
               }
    }

    }