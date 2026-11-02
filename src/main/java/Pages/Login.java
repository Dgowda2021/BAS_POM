package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "//img[@type='button']")
//    WebElement clickCloseAlert;
//       public void setClickCloseAlert()
//    {
//        clickCloseAlert.click();
//    }
    @FindBy(xpath="//img[@type='button']")
    WebElement closeIcon;
    public void setClickCloseAlert()
    {
        closeIcon.click();
    }

    @FindBy (xpath = "//input[@placeholder='Mobile Number']")
    WebElement txtUsernumber;
    public void setTxtUsernumber(String usernumber)
    {
        txtUsernumber.sendKeys(usernumber);
    }
    @FindBy (xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;
    public void setTxtUserPassword(String userPassword)
    {
        txtPassword.sendKeys(userPassword);
    }
    @FindBy (xpath = "//input[@type='checkbox']")
    WebElement clickCheckbox;
    public void ClickCheckbox()
    {
        clickCheckbox.click();
    }

    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;
    public void ClickBtnLogin()
    {
        btnLogin.click();
    }
    @FindBy (xpath="//input[@ng-reflect-name='otp1']")
    WebElement EnterOtp1;
    public void setEnterOtp1(String opt1)
    {
        EnterOtp1.sendKeys(opt1);
    }
    @FindBy (xpath="//input[@ng-reflect-name='otp2']")
    WebElement EnterOtp2;
    public void setEnterOtp2(String opt2)
    {
        EnterOtp2.sendKeys(opt2);
    }
    @FindBy (xpath="//input[@ng-reflect-name='otp3']")
    WebElement EnterOtp3;
    public void setEnterOtp3(String opt3)
    {
        EnterOtp3.sendKeys(opt3);
    }
    @FindBy (xpath="//input[@ng-reflect-name='otp4']")
    WebElement EnterOtp4;
    public void setEnterOtp4(String opt4)
    {
        EnterOtp4.sendKeys(opt4);
    }
    @FindBy (xpath="//input[@ng-reflect-name='otp5']")
    WebElement EnterOtp5;
    public void setEnterOtp5(String opt5)
    {
        EnterOtp5.sendKeys(opt5);
    }
    @FindBy (xpath="//input[@ng-reflect-name='otp6']")
    WebElement EnterOtp6;
    public void setEnterOtp6(String opt6)
    {
        EnterOtp6.sendKeys(opt6);
    }

    @FindBy(xpath ="//p[contains(text(),'Your OTP is')]") WebElement otpDisplay;
    public String getOtpDisplayText() {
        return otpDisplay.getText();
    }
    @FindBy (xpath = "//button[normalize-space()='Submit']")
    WebElement EnterSubmit;
    public void clickSubmitbutton()
    {
        EnterSubmit.click();
    }
    @FindBy(xpath = "//img[@type='button']")
    WebElement closeIconhome;
    public void ClickClosebutton()
    {
        closeIconhome.click();
    }


}
