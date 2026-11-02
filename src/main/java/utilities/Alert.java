package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert {
    WebDriver driver;
    public Alert(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptJsAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("No JS alert present");
        }
    }




    public void handleSecurityAlert(WebDriver driver) {
        try {
            // Wait up to 10 seconds for the alert to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert and accept it (i.e., click "Allow" or "OK")
            driver.switchTo().alert().accept();
//            System.out.println("Handled the web-based alert successfully.");

        } catch (Exception e) {
            System.out.println("No web-based alert appeared or could not be handled.");
            // Log the exception if necessary
        }
    }
    
}
