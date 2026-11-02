package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class Vendors {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public Vendors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to the Vendors section
    @FindBy(xpath = "//p[normalize-space()='Vendors']")
    WebElement vendors; // Locates the Vendors menu item

    public void ClickVendors() {
        vendors.click(); // Click on the Vendors menu
    }

    // Click the Add Vendor button
    @FindBy(xpath = "//button[@class='create-action ng-star-inserted']")
    WebElement addVendor; // Locates the Add Vendor button

    public void clickAddVendor() {
        addVendor.click(); // Click on the Add Vendor button
    }

    // Search for a vendor
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search; // Locates the Search input field
    public void setSearch(String siteName) throws InterruptedException {
        search.sendKeys(siteName); // Enter the vendor name in the search field
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER); // Press Enter to search
    }

    // Enter Organisation Name
    @FindBy(xpath = "//input[@placeholder='Organisation Name']")
    WebElement organisationName; // Locates the Organisation Name input field

    public void setOrganisationName(String orgName) {
        organisationName.sendKeys(orgName); // Enter the organisation name
    }

    // Enter Domain Name
    @FindBy(xpath = "//input[@placeholder='Domain Name']")
    WebElement domainName; // Locates the Domain Name input field

    public void setDomainName(String domain) {
        domainName.sendKeys(domain); // Enter the domain name
    }

    // Enter Contact Person Name
    @FindBy(xpath = "//input[@placeholder='Contact Person']")
    WebElement contactPerson; // Locates the Contact Person input field

    public void setContactPerson(String contact) {
        contactPerson.sendKeys(contact); // Enter the contact person name
    }
    @FindBy(xpath = "//input[@placeholder='Search Sites']") WebElement searchSites; // Locates the Search Sites input field
    public void setSearchSites(String siteName) throws InterruptedException {
        searchSites.sendKeys(siteName); // Enter the site name in the search field
        Thread.sleep(1000);
        searchSites.sendKeys(Keys.ENTER); // Press Enter to search
    }

    // Select BLRH location
    @FindBy(xpath = "//label[@for='DELH-input']")
    WebElement dELH; // Locates the DELH location selection

    public void clickDELH() {
        dELH.click(); // Select the DELH location
    }

    // Click the Save button
    @FindBy(xpath = "//button[@type='submit']//span")
    WebElement save; // Locates the Save button

    public void clickSave() {
        save.click(); // Click on the Save button
    }

    // Confirm Vendor creation
    @FindBy(xpath = "//button[@class='create-action text-capitalize']//span")
    WebElement confirm; // Locates the Confirm Vendor button

    public void clickConfirmVendor() {
        confirm.click(); // Click on the Confirm Vendor button
    }

    // Verify Vendor creation confirmation
    public boolean isConfirmationDisplayed() {
        if (driver.findElements(By.xpath("//div[contains(text(),'Vendor Details Created Successfully')]")).size() > 0) {
            return driver.findElement(By.xpath("//div[contains(text(),'Vendor Details Created Successfully')]")).isDisplayed();
        } else {
            return driver.findElement(By.xpath("//div[@class='cdk-overlay-container']")).isDisplayed();
        }
    }

    public boolean isNoVendorsMessageDisplayed() {
        return driver.findElements(By.xpath("//div[normalize-space()='No Vendors Available']")).size() > 0;
    }
    @FindBy(xpath="//p[normalize-space()='No Vendors Available']") WebElement noVendorsAvailable;
    public String getNoVendorsMessage() {
        return noVendorsAvailable.getText();
    }

    // Click the Delete Vendor button
    @FindBy(xpath = "//span[normalize-space()='Delete']")
    WebElement delete; // Locates the Delete button

    public void clickDeleteVendor() {
        delete.click(); // Click on the Delete Vendor button
    }

    // Verify Vendor deletion confirmation
    public boolean isDeleteConfirmationDisplayed() {
        if (driver.findElements(By.xpath("//div[@class='message']")).size() > 0) {
            return driver.findElement(By.xpath("//div[@class='message']")).isDisplayed();
        } else {
            return driver.findElement(By.xpath("//div[@class='cdk-overlay-container']")).isDisplayed();
        }
    }

    // Navigate to the Sites section
    @FindBy(xpath = "//span[contains(text(),'Sites')]")
    WebElement sites; // Locates the Sites menu item

    public void clickSites() {
        sites.click(); // Click on the Sites menu
    }

    // Click the Add Site button
    @FindBy(xpath = "//span[normalize-space()='Add Site']")
    WebElement addSite; // Locates the Add Site button

    public void clickAddSite() {
        addSite.click(); // Click on the Add Site button
    }

    @FindBy(xpath="//input[@formcontrolname='sitecode']") WebElement siteCode; // Locates the Site Code input field
    public void setSiteCode(String code) {
        siteCode.sendKeys(code); // Enter the site code
    }

    @FindBy(xpath="//span[normalize-space()='State']") WebElement stateDropdown; // Locates the State dropdown
    public void selectState(String state) throws InterruptedException {
        stateDropdown.click(); // Open the State dropdown
        Thread.sleep(2000); // Wait for the dropdown options to appear
        WebElement stateOption = driver.findElement(By.xpath("//span[contains(text(),'"+state+"')]")); // Select the specified state
        stateOption.click(); // Click on the state option
        Thread.sleep(2000); // Wait for the selection to be processed
    }
    @FindBy(xpath="//span[normalize-space()='City']") WebElement cityDropdown; // Locates the City dropdown
    public void selectCity(String city) throws InterruptedException {
        cityDropdown.click(); // Open the City dropdown
        Thread.sleep(2000); // Wait for the dropdown options to appear
        WebElement cityOption = driver.findElement(By.xpath("//span[contains(text(),'"+city+"')]")); // Select the specified city
        cityOption.click(); // Click on the city option
        Thread.sleep(2000); // Wait for the selection to be processed
    }

    @FindBy(xpath="//span[normalize-space()='Region']") WebElement regionDropdown; // Locates the Region dropdown
    public void selectRegion(String region) throws InterruptedException {
        regionDropdown.click(); // Open the Region dropdown
        Thread.sleep(2000); // Wait for the dropdown options to appear
        WebElement regionOption = driver.findElement(By.xpath("//span[contains(text(),'"+region+"')]")); // Select the specified region
        regionOption.click(); // Click on the region option
        Thread.sleep(2000); // Wait for the selection to be processed
    }
    @FindBy(xpath="//span[normalize-space()='Type']") WebElement typeDropdown; // Locates the Type dropdown
    public void selectType(String type) throws InterruptedException {
        typeDropdown.click(); // Open the Type dropdown
        Thread.sleep(2000); // Wait for the dropdown options to appear
        WebElement typeOption = driver.findElement(By.xpath("//span[contains(text(),'"+type+"')]")); // Select the specified type
        typeOption.click(); // Click on the type option
        Thread.sleep(2000); // Wait for the selection to be processed
    }
    @FindBy(xpath="//span[normalize-space()='Submit']") WebElement saveSite; // Locates the Save button
    public void clickSaveSite() {
        saveSite.click(); // Click on the Save button
    }

    // Verify Site creation confirmation
    public boolean isConfirmationSiteDisplayed() {
        if (driver.findElements(By.xpath("//div[contains(text(),'Site Details Created Successfully')]")).size() > 0) {
            return driver.findElement(By.xpath("//div[contains(text(),'Site Details Created Successfully')]")).isDisplayed();
        } else if (driver.findElements(By.xpath("//div[contains(text(),'Sitecode Already Exists')]")).size() > 0) {
            return driver.findElement(By.xpath("//div[contains(text(),'Sitecode Already Exists')]")).isDisplayed();
        } else {
            return false;
        }
    }
    @FindBy(xpath="//p[normalize-space()='Report']") WebElement VendorReport;
    public void clickVendorReport() {
        VendorReport.click(); // Click on the Site Report button
    }
    @FindBy(xpath="//p[normalize-space()='Report']") WebElement SiteReport;
    public void clickSiteReport() {
        SiteReport.click(); // Click on the Site Report button
    }
    public boolean isFileDownloaded(String dir) {
        File file = new File( "D:\\Downloads\\");
        return file.exists();
    }

    // Click the Delete Site button
    @FindBy(xpath = "//i[@class='far fa-trash-can']")
    WebElement deleteSite; // Locates the Delete Site button

    public void clickDeleteSite() {
        deleteSite.click(); // Click on the Delete Site button
    }

    // Confirm Site deletion
    @FindBy(xpath = "//span[normalize-space()='Delete']")
    WebElement deleteSiteConfirmation; // Locates the Confirm Delete Site button

    public void clickConfirmDeleteSite() {
        deleteSiteConfirmation.click(); // Click on the Confirm Delete Site button
    }

    // Verify Site deletion confirmation
    public boolean isDeleteSiteConfirmationDisplayed() {
        if (driver.findElements(By.xpath("//div[contains(text(),'Site has been deleted successfully.')]")).size() > 0) {
            return driver.findElement(By.xpath("//div[contains(text(),'Site has been deleted successfully.')]")).isDisplayed();
        } else {
            return driver.findElement(By.xpath("//div[@class='cdk-overlay-container']")).isDisplayed();
        }
    }
    public boolean isNoSitesFoundMessageDisplayed() {
       if (driver.findElements(By.xpath("//p[normalize-space()='No Sites Found']")).size() > 0);{
          return driver.findElement(By.xpath("//p[normalize-space()='No Sites Found']")).isDisplayed();
        }

    }
    public boolean isSitePresentInSearchResults(String siteName) {
        return driver.findElements(By.xpath("//h5[normalize-space()='"+siteName+"']")).size() > 0;
    }
    @FindBy(xpath="//p[normalize-space()='No Sites Found']") WebElement noSitesFound;
    public String getNoSitesFoundMessage() {
        return noSitesFound.getText();
    }
}