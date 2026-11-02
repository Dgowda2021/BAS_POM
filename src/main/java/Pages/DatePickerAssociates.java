package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerAssociates {

    WebDriver driver;

    public DatePickerAssociates(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[@class='mat-mdc-button-touch-target']") WebElement openCalendar;
    public void ClickCalender()
    {
        openCalendar.click();
    }
    @FindBy(xpath="//div[@dir='ltr']//span[3]") WebElement openCalendarReport;
    public void ClickCalenderReport()
    {
        openCalendarReport.click();
    }
    @FindBy(xpath="//span[contains(text(),'JAN 2019')]") WebElement startMonthYear;
    public void clickStartMonthYear()
    {
        startMonthYear.click();
    }
    //@FindBy(xpath="//span[contains(text(),'JUN 2025')]") WebElement startMonthYear25;
    @FindBy(xpath="//button[@aria-label='Choose month and year']//span[@class='mdc-button__label']") WebElement MonthYear;
    public void clickStartMonthYear25()
    {
        MonthYear.click();
    }
    @FindBy(xpath="//span[normalize-space()='2022']")
    WebElement startYearselection;
    public void clickStartYear()
    {
        startYearselection.click();
    }
    @FindBy(xpath="//span[normalize-space()='MAR']")
    WebElement startMonth;
    public void clickStartMonth()
    {
        startMonth.click();
    }
    @FindBy(xpath="//span[normalize-space()='18']")
    WebElement startDate;
    public void clickStartDate()
    {
        startDate.click();
    }
    @FindBy(xpath="//span[contains(text(),'MAR 2022')]")
    WebElement endMonthYear;
    public void clickEndMonthYear()
    {
        endMonthYear.click();
    }
    @FindBy(xpath="//span[normalize-space()='2024']")
    WebElement endYearSelection;
    public void clickEndYear()
    {
        endYearSelection.click();
    }
    @FindBy(xpath="//span[normalize-space()='FEB']")
    WebElement endMonth;
    public void clickEndMonth()
    {
        endMonth.click();
    }
    @FindBy(xpath="//span[normalize-space()='28']")
    WebElement endDate;
    public void clickEndDate()
    {
        endDate.click();
    }
    @FindBy(xpath="//div[@dir='ltr']//span[3]")
    WebElement startDateSelect;
    public void clickstartDateSelect()
    {
        startDateSelect.click();
    }

}
