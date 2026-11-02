package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePicker {

    WebDriver driver;

    public DatePicker(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath="//span[@class='mat-mdc-button-touch-target']")
//    WebElement openCalendar;
    //@FindBy(xpath="//body//div//div[@dir='ltr']//mat-datepicker-toggle[@ng-reflect-datepicker='[object Object]']//span[1]") WebElement openCalendar;
   // @FindBy(xpath="(//span)[82]") WebElement openCalendar;
    //@FindBy(xpath="(//span[@class='mat-mdc-button-touch-target'])[2]") WebElement openCalendar;
   // @FindBy(xpath="//div[@dir='ltr']//span[3]") WebElement openCalendar;
    @FindBy(xpath="//body//app-root//mat-form-field//span[3]") WebElement openCalendar;
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
    @FindBy(xpath="//*[name()='polygon' and contains(@points,'0,0 5,5 10')]") WebElement startMonthYear25;
    public void clickStartMonthYear25()
    {
        startMonthYear25.click();
    }
    @FindBy(xpath="//span[normalize-space()='2025']")
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
    @FindBy(xpath="//*[name()='polygon' and contains(@points,'0,0 5,5 10')]")
    WebElement endMonthYear;
    public void clickEndMonthYear()
    {
        endMonthYear.click();
    }
    @FindBy(xpath="//span[normalize-space()='2025']")
    WebElement endYearSelection;
    public void clickEndYear()
    {
        endYearSelection.click();
    }
    @FindBy(xpath="//span[normalize-space()='DEC']")
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
