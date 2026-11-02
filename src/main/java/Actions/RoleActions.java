package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RoleActions {
    WebDriver driver;

    public RoleActions(WebDriver driver) {
        this.driver = driver;
    }

    // Hover over the role card
    public void hoverOverRoleCard(String roleName) {
        Actions actions = new Actions(driver);
        WebElement roleCard = driver.findElement(By.xpath("//div[@class='card-body vendor-card-desc']"));
        actions.moveToElement(roleCard).perform();
    }

    // Click the delete button for the role
    public void clickDeleteButton(String roleName) {
        WebElement deleteButton = driver.findElement(By.xpath("//i[@class='far fa-trash-can']"));
        deleteButton.click();
    }

    // Confirm the role deletion
    public void confirmRoleDeletion() {
        WebElement confirmDeleteRole = driver.findElement(By.xpath("//span[normalize-space()='Yes']"));
        confirmDeleteRole.click();
    }
}