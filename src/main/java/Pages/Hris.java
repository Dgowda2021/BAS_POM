package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Alert;

import java.io.IOException;
import java.time.Duration;

public class Hris {

    WebDriver driver;

    public Hris(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    @FindBy(xpath = "//span[contains(text(),'Onboarding')]")
    WebElement onboarding;

    public static String scanFinegerprintHandle(WebDriver driver) throws IOException, InterruptedException {
        Hris hris = new Hris(driver);
      //  hris.waitForAnyStatus();
        return hris.scanFinegerprintHandle();
    }

    public void clickOnboardingModule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement onboarding = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/onboarding-icon.svg']")));
        onboarding.click();
    }

    @FindBy(xpath = "//input[@placeholder='Search Associates']")
    WebElement searchAssociates;

    public void clickSearchAssociates() {
        searchAssociates.click();
    }

    public void setSearchAssociates(String enterAsscoaiteName) {
        searchAssociates.sendKeys(enterAsscoaiteName);
    }

    public void pressEnterSearch() {
        searchAssociates.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//span[normalize-space()='Ready to Onboard']")
    WebElement readyToOnboard;

    public void clickReadyToOnboard() {
        readyToOnboard.click();
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement iAgreeToThePrivacyPolicy;

    public void clickIAgree() {
        iAgreeToThePrivacyPolicy.click();
    }

    @FindBy(xpath = "//span[normalize-space()='START ONBOARDING']")
    WebElement startOnboarding;

    public void clickStartOnboarding() {
        startOnboarding.click();
    }

    @FindBy(xpath = "//mat-select[@placeholder='Select Registration Type']")
    WebElement selectRegistrationType;

    public void clickRegistrationType() {
        selectRegistrationType.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Manual Registration']")
    WebElement manualRegistration;

    public void clickManualRegistration() {
        manualRegistration.click();
    }

    @FindBy(xpath = "//mat-select[@placeholder='Select Vendor']")
    WebElement selectVendor;

    public void clickSelectVendor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectVendor));
        selectVendor.click();
    }

    @FindBy(xpath = "//span[contains(text(),'MSF')]")
    WebElement SelectorVendorName;

    public void clickSelectVendorName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SelectorVendorName));
        SelectorVendorName.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Select Remark']")
    WebElement selectRemark;

    public void clickSelectRemark() {
        selectRemark.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Flat Finger Registration')]")
    WebElement flatFingerRegistration;
    public void clickFlatFingerRegistration() {
        flatFingerRegistration.click();
    }
    @FindBy(xpath = "//mat-option[@value='Biometric Registration']")
    WebElement biometricRegistration;
    public void clickBiometric() throws InterruptedException {
        while (true) {
            try{
                biometricRegistration.click();
                break;
            } catch (Exception e) {
                Alert alert = new Alert(driver);
                alert.handleSecurityAlert(driver);
//                System.out.println("Retrying to click Biometric Registration due to alert...");
                System.out.println("Please ensure the biometric device is connected and Re-Test the onboarding process from beginning.");
                WebDriver driver1 = this.driver;
                driver1.quit();
                break;
            }
        }
    }
//----------------------Match found----------------------------------
    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement save;
    public void clickSave() {
        save.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Close']")
    WebElement close;
    public void clickClose() {
        close.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Continue']")
    WebElement Continue;
    @FindBy(xpath = "//span[normalize-space()='Try Again']") WebElement tryAgain;
    @FindBy(xpath = "//p[normalize-space()='Place your Right index finger']") WebElement RightHand;
//    public void clickContinue() {
//        while (true) {
//            if (isDisplayed(Continue)) {
//                Continue.click();
//                break; // Left hand successful, moving to Right hand
//            } else {
//                // Scan failed or not yet finished
//                tryAgain.click();
//            }
//        }
//
//        // --- PHASE 2: Right Hand (Single Action) ---
//        // After clicking Continue above, the UI moves to Right Hand.
//        // There is no 'Continue' button here.
//
//        // We wait/check for the Right Hand scan result
//         {
//            if (isSuccessful(RightHand)) {
//                // Right hand successful, exit the loop
//            } else {
//                tryAgain.click();
//            }
//        }
//
//    }

    public void clickContinue() {
        // --- PHASE 1: Left Hand ---
        while (true) {
            // Use findElements (plural) to check without crashing
            if (!driver.findElements(By.xpath("//span[text()='Continue']")).isEmpty()) {
                Continue.click();
                break; // Move to Right hand
            }
            else if (!driver.findElements(By.xpath("//span[normalize-space()='Try Again']")).isEmpty()) {
                tryAgain.click();
            }

            // Small pause to prevent the script from "spamming" the CPU
            try { Thread.sleep(2000); } catch (Exception e) {}
        }

        // --- PHASE 2: Right Hand ---
        // Wait a moment for the UI to switch to Right Hand
        try { Thread.sleep(2000); } catch (Exception e) {}

        if (!isSuccessful(RightHand)) {
            if (!driver.findElements(By.xpath("//span[normalize-space()='Try Again']")).isEmpty()) {
                tryAgain.click();
            }
        }
    }

    @FindBy(xpath = "//span[normalize-space()='ADD NEW ASSOCIATE']")
    WebElement AddNewAssociate;
    public void ClickAddNewAssociate() {
        AddNewAssociate.click();
    }

    @FindBy(xpath = "//p[normalize-space()='GOVT_ID_MISMATCHED']")
    WebElement gOVTIDMISMATCHED;
    public void clickGOVTIDMISMATCHED() {
        gOVTIDMISMATCHED.click();
    }

    @FindBy(xpath = "//p[normalize-space()='You cannot onboard this associate due to red flag.']")
    WebElement youCannotOnboardThisAssoci;
    public void clickYouCannotOnboardThisAssoci() {
        youCannotOnboardThisAssoci.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Contact Support']")
    WebElement contactSupport;
    public void clickContactSupport() {
        contactSupport.click();
    }
    @FindBy(xpath = "//p[normalize-space()='Enroll Failed']")
    WebElement EnrollFailed;
    public void ClickCloseEnroll(){
        EnrollFailed.click();
    }

    @FindBy(xpath = "//span[normalize-space()='UPDATE & CONTINUE']")
    WebElement UpdateAssociate;
    public void ClickUpdateAssociate(){
        UpdateAssociate.click();
    }

    @FindBy(xpath = "//img[@src='assets/images/close-circle.svg']")
    WebElement closebio;
    //span[normalize-space()='Close']
    public void clickCloseBio() {
        closebio.click();
    }


    public String scanFinegerprintHandle() throws IOException, InterruptedException {
        if(isDisplayed(AddNewAssociate)) {
            // Step 1: Attempt to save/close first
            handleSaveandClose();
            Thread.sleep(2000);
            clickClose();
            // Step 2: Check if the enrollment failed immediately after the action
            if (isDisplayed(EnrollFailed)) {
                handleEnrollFailedAndClose();
                return "Enroll Failed";
            }
            Thread.sleep(2000);
            clickClose();
            return "New Associate Added Successfully";
        }else if (isDisplayed(UpdateAssociate)) {
            handleUpdateAndContinueClose();
            return "Fingerprint Matched - Continue and Update";
        } else if(isDisplayed(gOVTIDMISMATCHED)){
            handleClose();
            return "GOVT ID Mismatched";
        } else if(isDisplayed(youCannotOnboardThisAssoci)) {
            handleContactSupportAndClose();
            return "Cannot Onboard Due to Red Flag";
        } else {
            return "Unknown Status";
        }
    }

    private void handleSaveandClose() throws InterruptedException {
           Assert.assertTrue(isDisplayed(AddNewAssociate), "Add New Associate option is not displayed");
           ClickAddNewAssociate();
           clickSave();
       Thread.sleep(2000);
    }
    private void handleUpdateAndContinueClose() throws InterruptedException {
        Assert.assertTrue(isDisplayed(UpdateAssociate), "Update and Continue option is not displayed");
        ClickUpdateAssociate();
        clickSave();
        Thread.sleep(2000);
        clickClose();
    }
    private void handleClose() throws InterruptedException {
        Assert.assertTrue(isDisplayed(gOVTIDMISMATCHED), "GOVT ID Mismatched message is not displayed");
        clickClose();
    }
    private void handleContactSupportAndClose() {
        Assert.assertTrue(isDisplayed(youCannotOnboardThisAssoci), "Cannot Onboard message is not displayed");
        clickContactSupport();
        clickClose();
    }
    private void handleEnrollFailedAndClose() throws IOException, InterruptedException {
        Assert.assertTrue(isDisplayed(EnrollFailed), "Enroll Failed due to Fingerprint Already Registered with Flex id ");
        Thread.sleep(2000);
    }


    private boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
    private boolean isSuccessful(WebElement element) {
        try {
            return element.getText().contains("Scan Successful");
        } catch (Exception e) {
            return false;
        }

    }

    @FindBy(xpath="//tbody/tr[1]/td[6]/div[1]/div[1]/img[1]") WebElement actionbutton;
    public void clickActionButton() {
        actionbutton.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Delete Fingerprint']")
    WebElement deleteFingerprint;
    public void clickDeleteFingerprint() {
        deleteFingerprint.click();
    }

    @FindBy(xpath = "//span[normalize-space()='DELETE FINGERPRINT']")
    WebElement deleteFingerprint1;
    public void clickDeleteFingerprint1() {
        deleteFingerprint1.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Yes']")
    WebElement yes;
    public void clickYes() {
        yes.click();
    }

    @FindBy(xpath = "//img[@class='close']")
    WebElement closeIcon;
    public void clickCloseIcon() {
        closeIcon.click();
    }

    @FindBy(xpath = "//img[@class='cursor-pointer close']")
    WebElement closeIcon1;
    public void clickCloseIcon1() {
        closeIcon1.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Edit Associate']")
    WebElement editAssociate;
    public void clickEditAssociate() {
        editAssociate.click();
    }

    @FindBy(xpath = "//*[@class='form-control ng-touched ng-pristine ng-valid ng-star-inserted']")
    WebElement flagSelection;
    public void clickFlagSelection() {
        flagSelection.click();
    }

    @FindBy(xpath = "//option[@value='ORANGE']")
    WebElement flag;
    public void clickFlag() {
        flag.click();
    }

    @FindBy(xpath = "//input[@placeholder='Remark']")
    WebElement remark;
    public void setRemark(String enterremark) {
        remark.sendKeys(enterremark);
    }

    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement saveFlagChange;
    public void clickSaveFlag() {
        saveFlagChange.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement confirm;
    public void clickConfirm() {
        confirm.click();
    }
    @FindBy(xpath="//p[normalize-space()='Report']") WebElement report;
    public void clickOnboardingReport() {
        report.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Select Date Type']")
    WebElement selectDateType;
    public void ClickSelectDateType() {
        selectDateType.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Created Date']")
    WebElement selectCreatedDateType;
    public void ClickSelectCreatedDateType() {
        selectCreatedDateType.click();
    }

    @FindBy(xpath="//span[normalize-space()='Generate']")
    WebElement generate;
    public void ClickGenerate(){
        generate.click();
    }

}


