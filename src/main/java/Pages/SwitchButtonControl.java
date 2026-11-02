package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//

public class SwitchButtonControl {
    WebDriver driver;

    public SwitchButtonControl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[normalize-space()='Enable']")
    WebElement enableButton;

    @FindBy(xpath="//span[normalize-space()='Disable']")
    WebElement disableButton;

    /**
     * Controls the toggle based on the desired state.
     * @param shouldBeEnabled pass true to ensure it's ON, false for OFF.
     */
    public void setToggleState(boolean shouldBeEnabled) {
        if (shouldBeEnabled) {
            // We want it ON. If the Enable button is visible, click it.
            if (isElementDisplayed(enableButton)) {
                enableButton.click();
                System.out.println("Toggle was OFF. Clicked Enable.");
            } else {
                System.out.println("Toggle is already ON (Disable button is showing).");
            }
        } else {
            // We want it OFF. If the Disable button is visible, click it.
            if (isElementDisplayed(disableButton)) {
                disableButton.click();
                System.out.println("Toggle was ON. Clicked Disable.");
            } else {
                System.out.println("Toggle is already OFF (Enable button is showing).");
            }
        }
    }

    // Helper method to prevent NoSuchElementException if one button is hidden
    private boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
