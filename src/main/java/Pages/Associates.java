package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Associates {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public Associates(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//p[normalize-space()='Associates']")WebElement associates;
    public void clickAssociates() {
        associates.click(); // Click on the Associates menu
    }

    // XPath for VIEW MORE button
    @FindBy(xpath = "//button[normalize-space()='VIEW MORE']")
    WebElement viewMore;

    public void clickViewMore() {
        viewMore.click(); // Click on the VIEW MORE button
    }

    @FindBy(xpath="//span[contains(text(),'InActive Associates')]") WebElement inActiveAssociates;
    public void clickInActiveAssociates() {
        inActiveAssociates.click(); // Click on the InActive Associates option
    }
    @FindBy(xpath="//span[contains(text(),'Red Flag History')]") WebElement redFlagHistory;
    public void clickRedFlagHistory() {
        redFlagHistory.click(); // Click on the Red Flag History option
    }
    @FindBy(xpath="//span[contains(text(),'Associate Logs')]") WebElement associateLogs;
    public void clickAssociateLogs() {
        associateLogs.click(); // Click on the Associate Logs option
    }
    // XPath for Report menu
    @FindBy(xpath = "//p[normalize-space()='Report']")
    WebElement report;

    public void clickReports() {
        report.click(); // Click on the Report menu
    }
    @FindBy(xpath="//span[normalize-space()='Select Date Type']")WebElement selectDateType;
    public void clickSelectDateType() {
        selectDateType.click(); // Click on the Select Date Type dropdown
    }
    @FindBy(xpath="//span[normalize-space()='Created Date']")WebElement createdDate;
    public void clickCreatedDate() {
        createdDate.click(); // Click on the Created Date option
    }
    @FindBy(xpath="//span[normalize-space()='Updated Date']")WebElement updatedDate;
    public void clickUpdatedDate() {
        updatedDate.click(); // Click on the Created Date option
    }
    @FindBy(xpath="//span[normalize-space()='Onboarding Date']")WebElement onboardingDate;
    public void clickOnboardingDate() {
        onboardingDate.click(); // Click on the Created Date option
    }
    @FindBy(xpath="//mat-datepicker-toggle[@class='mat-datepicker-toggle ng-tns-c3736059725-81']//span[@class='mat-mdc-button-touch-target']") WebElement openCalendar;
    public void clickCalenderSelect() {
        openCalendar.click(); // Click on the calendar select button
    }
    @FindBy(xpath="//span[normalize-space()='Select Vendor']") WebElement selectVendor;
    public void clickSelectVendor() {
        selectVendor.click();
    }
    @FindBy(xpath="//span[normalize-space()='All']") WebElement all;
    public void clickAll() {
        all.click(); // Click on the All option
    }
    @FindBy(xpath="//span[normalize-space()='G4S']") WebElement g4S;
    public void clickG4S() {
        g4S.click(); // Click on the G4S option
    }
    @FindBy(xpath="//mat-option[@ng-reflect-value='SIS']") WebElement sIS;
    public void clickSIS() {
        sIS.click(); // Click on the SIS option
    }
    @FindBy(xpath="//span[normalize-space()='Select Log Type']") WebElement selectLogType;
    public void clickSelectLogType() {
        selectLogType.click(); // Click on the Select Log Type dropdown
    }
    @FindBy(xpath="//span[normalize-space()='FlagChange']") WebElement flagChange;
    public void clickFlagChange() {
        flagChange.click(); // Click on the FlagChange option
    }
    @FindBy(xpath="//span[normalize-space()='Associate Fingerprints Deletion']") WebElement associateFingerprintsDeletio;
    public void clickAssociateFingerprintsDeletion() {
        associateFingerprintsDeletio.click(); // Click on the Associate Fingerprints Deletion option
    }
    @FindBy(xpath="//span[normalize-space()='Manual Registration']") WebElement manualRegistration;
    public void clickManualRegistration() {
        manualRegistration.click(); // Click on the Manual Registration option
    }
    @FindBy(xpath="//span[normalize-space()='Select Flag']") WebElement selectFlag;
    public void clickSelectFlag() {
        selectFlag.click(); // Click on the Select Flag dropdown
    }
    @FindBy(xpath="//mat-option[@ng-reflect-value='All']") WebElement All;
    public void clickAllFlag() {
        All.click(); // Click on the option in the flag dropdown
    }
    @FindBy(xpath="//span[normalize-space()='Generate']") WebElement generate;
    public void clickGenerate() {
        generate.click(); // Click on the Generate button
    }


    public boolean isReportGenerated() {
        return driver.findElement(By.xpath("//div[contains(@class, 'download-header')]/h3")).isDisplayed();
    }
}