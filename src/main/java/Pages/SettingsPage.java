package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[normalize-space()='Settings']")
    WebElement settingsMenu;
    public void clickSettingsMenu() {
       // System.out.println("Clicking on Settings Menu");
        settingsMenu.click();
    }
    @FindBy(xpath = "//h5[normalize-space()='Email Notification']") WebElement emailNotificationOption;
    public void clickEmailNotificationOption() {
       // System.out.println("Clicking on Email Notification Option");
        emailNotificationOption.click();
    }
    @FindBy(xpath = "//span[normalize-space()='Add']") WebElement addButton;
    public void clickAddButton() {
        //System.out.println("Clicking on Add Button");
        addButton.click();
    }
    @FindBy(xpath = "//input[@placeholder='Name']") WebElement nameField;
    public void enterName(String name) {
        //System.out.println("Entering Name: " + name);
        nameField.clear();
        nameField.sendKeys(name);
    }
    @FindBy(xpath = "//input[@placeholder='Email']") WebElement emailField;
    public void enterEmail(String email) {
        //System.out.println("Entering Email: " + email);
        emailField.clear();
        emailField.sendKeys(email);
    }
    @FindBy(xpath = "//span[normalize-space()='Save']") WebElement saveButton;
    public void clickSaveButton() {
        //System.out.println("Clicking on Save Button");
        saveButton.click();
    }
    @FindBy (xpath = "//span[normalize-space()='No']") WebElement noButton;
    public void clickNoButton() {
        //System.out.println("Clicking on No Button");
        noButton.click();
    }
    @FindBy (xpath = "//span[normalize-space()='Yes']") WebElement yesButton;
    public void clickYesButton() {
        //System.out.println("Clicking on Yes Button");
        yesButton.click();
    }
    @FindBy (xpath = "//tbody/tr[3]/td[4]/a[2]/i[1]") WebElement EditButton;
    public void clickEditButton() {
        //System.out.println("Clicking on Edit Button");
        EditButton.click();
    }

    @FindBy(xpath = "//tbody/tr[3]/td[4]/a[1]/i[1]") WebElement DeleteButton;
    public void clickDeleteButton() {
        //System.out.println("Clicking on Delete Button");
        DeleteButton.click();
    }
    @FindBy(xpath = "//span[normalize-space()='Delete']") WebElement confirmDeleteButton;
    public void clickConfirmDeleteButton() {
       // System.out.println("Clicking on Confirm Delete Button");
        confirmDeleteButton.click();
    }
    @FindBy (xpath = "//img[@class='cursor-pointer close']") WebElement closeNotification;
    public void clickCloseNotification() {
       // System.out.println("Clicking on Close Notification");
        closeNotification.click();
    }
    @FindBy (xpath = "//h5[normalize-space()='OTP Settings']") WebElement otpSettingsOption;
    public void clickOtpSettingsOption() {
       // System.out.println("Clicking on OTP Settings Option");
        otpSettingsOption.click();
    }
    @FindBy (xpath = "//div[@class='mdc-switch__handle']") WebElement otpToggle;

    public void clickOtpToggle() throws InterruptedException {
       // System.out.println("Clicking on OTP Toggle");
        otpToggle.click();
        Thread.sleep(500);
    }
    @FindBy (xpath = "//span[normalize-space()='Confirm']") WebElement confirmButton;
    public void clickConfirmButton() {
       // System.out.println("Clicking on Confirm Button");
        confirmButton.click();
    }

}
