package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HRISNewOnboarding {

    WebDriver driver;

    public HRISNewOnboarding(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
