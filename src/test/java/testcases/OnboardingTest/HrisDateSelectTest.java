package testcases.OnboardingTest;

import Pages.DatePicker;
import Pages.Hris;
import base.BaseClass;
import org.testng.annotations.Test;

public class HrisDateSelectTest extends BaseClass {
    @Test
    public void HrisOnboardingDateSelectTest() throws InterruptedException {
        Hris hris = new Hris(driver);
        hris.clickOnboardingModule();
        DatePicker datePicker = new DatePicker(driver);
        datePicker.ClickCalender();
        datePicker.clickStartMonthYear();
        datePicker.clickStartYear();
        datePicker.clickStartMonth();
        datePicker.clickStartDate();

        datePicker.clickEndMonthYear();
        datePicker.clickEndYear();
        datePicker.clickEndMonth();
        datePicker.clickEndDate();


    }
}
