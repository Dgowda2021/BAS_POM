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
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static utilities.ConfigReader.getUrl;

public class loginBaseClass {
    public WebDriver driver;
    static ExtentReports reports;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the application URL
        driver.get(getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // Initialize Extent Reports
        ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
        extent.attachReporter(spark);

        Login login = new Login(driver);
        Thread.sleep(4000); // Wait for the page to load
        login.setClickCloseAlert();
    }
    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\Amazon Project\\My Staffs\\Selenium with Java\\BAS Test screenshots\\" + System.currentTimeMillis() + ".png");
        String errFilePath = dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, dest);
        return errFilePath;
    }

    @AfterMethod
    public void teardown() {
        extent.flush();
        // Step 6: Quit the WebDriver instance
        if (driver != null) {
            driver.close();
        }
    }
}
