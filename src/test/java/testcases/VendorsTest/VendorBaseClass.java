package testcases.VendorsTest;

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
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static utilities.ConfigReader.*;

public class VendorBaseClass {
    WebDriver driver;
//    static ExtentReports reports;
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        // Step 1: Initialize WebDriver and maximize the browser window
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the application URL
        driver.get(getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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
        Thread.sleep(4000);
        login.setEnterOtp1("2");
        login.setEnterOtp2("5");
        login.setEnterOtp3("3");
        login.setEnterOtp4("1");
        login.setEnterOtp5("9");
        login.setEnterOtp6("3");
        Thread.sleep(4000);

        // Step 5: Submit OTP and close any post-login alerts
        login.clickSubmitbutton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        login.ClickClosebutton();
        Thread.sleep(4000);
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