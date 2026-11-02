package base;

import Pages.Login;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUrl;
import static utilities.ConfigReader.getUsernumber;

public class BaseClass {
    public WebDriver driver;
    static ExtentReports reports;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();


    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the application URL
        driver.get(getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // Initialize Extent Reports
        ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
        extent.attachReporter(spark);

        // Step 3: Perform login actions
        Login login = new Login(driver);
        Thread.sleep(4000); // Wait for the page to load
        login.setClickCloseAlert(); // Close any alert if present
        login.setTxtUsernumber(getUsernumber()); // Enter username
        login.setTxtUserPassword(getPassword()); // Enter password
        login.ClickCheckbox(); // Click the checkbox
        login.ClickBtnLogin(); // Click the login button

        // Step 4: Enter OTP for authentication
        if (getOtpDisplayText()) {
            System.out.println("OTP page is displayed.");
        } else {
            System.out.println("OTP page was not displayed.");
        }
        login.setEnterOtp1("2");
        login.setEnterOtp2("5");
        login.setEnterOtp3("3");
        login.setEnterOtp4("1");
        login.setEnterOtp5("9");
        login.setEnterOtp6("3");


        // Step 5: Submit OTP and close any post-login alerts
        login.clickSubmitbutton();

        login.ClickClosebutton();

    }
    public boolean getOtpDisplayText() {
        Login login = new Login(driver);
        String otpText = login.getOtpDisplayText();
        return otpText.contains("digit");
    }

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\Amazon Project\\My Staffs\\Selenium with Java\\BAS Test screenshots\\" + System.currentTimeMillis() + ".png");
        String errFilePath = dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, dest);
        return errFilePath;
    }

    @AfterClass
    public void teardown() {
        extent.flush();
        // Step 6: Quit the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}