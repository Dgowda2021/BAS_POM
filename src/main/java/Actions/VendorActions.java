package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VendorActions {
    WebDriver driver;

    public VendorActions(WebDriver driver) {
        this.driver = driver;
    }

    // Hover over the vendor card
    public void hoverOverVendorCard(String vendorName) {
        Actions actions = new Actions(driver);
        WebElement vendorCard = driver.findElement(By.xpath("//div[@class='card-body vendor-card-desc']"));
        actions.moveToElement(vendorCard).perform();
    }

    // Click the delete button for the vendor
    public void clickDeleteButton(String vendorName) {
        WebElement deleteButton = driver.findElement(By.xpath("//i[@class='far fa-trash-can']"));
        deleteButton.click();
    }

    // Confirm the vendor deletion
    public void confirmVendorDeletion() {
        WebElement confirmDeleteVendor = driver.findElement(By.xpath("//span[normalize-space()='Delete']"));
        confirmDeleteVendor.click();
    }
}