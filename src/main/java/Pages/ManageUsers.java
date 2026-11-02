package Pages;

import org.openqa.selenium.By; // Importing By for locating elements
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsers {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public ManageUsers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to Manage Users section
    @FindBy(xpath = "//p[normalize-space()='Manage Users']")
    WebElement ManageUsers;
    public void ClickManageUsers() {
        ManageUsers.click();
    }

    // Open Add User form
    @FindBy(xpath = "//span[normalize-space()='Add User']")
    WebElement addUser;
    public void btnAddUser() {
        addUser.click();
    }

//    // Check if Add User form is displayed
//    public boolean isAddUserFormDisplayed() {
//        return driver.findElement(By.id("addUserForm")).isDisplayed();
//    }

    // Enter First Name
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    public void txtFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    // Enter Last Name
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    public void txtLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    // Select Role dropdown
    @FindBy(xpath = "//span[normalize-space()='Select Role']")
    WebElement selectRole;
    public void selctRole() {
        selectRole.click();
    }

    // Select specific role
    @FindBy(xpath = "//span[normalize-space()='fielduser']")
    WebElement fielduser;
    public void setRole() {
        fielduser.click();
    }

    // Enter Mobile Number
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement mobileNumber;
    public void txtMobile(String mobilenumber) {
        mobileNumber.sendKeys(mobilenumber);
    }

    // Select Region dropdown
    @FindBy(xpath = "//span[normalize-space()='Region']")
    WebElement region;
    public void selRegion() {
        region.click();
    }

    // Select specific region
    @FindBy(xpath = "//span[normalize-space()='North']")
    WebElement SelRegion;
    public void setRegion() {
        SelRegion.click();
    }

    // Press Escape key to close dropdown
    public void pressEscKey(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    // Select Reporting Manager dropdown
    @FindBy(xpath = "//span[normalize-space()='Reporting Manager']")
    WebElement reportingManager;
    public void selRepmanager() {
        reportingManager.click();
    }

    // Select specific Reporting Manager
    @FindBy(xpath = "//span[normalize-space()='Superadmin Amazon']")
    WebElement selectmanager;
    public void selManager() {
        selectmanager.click();
    }

    // Select Vendor dropdown
    @FindBy(xpath = "//span[normalize-space()='Vendor']")
    WebElement vendor;
    public void selVendor() {
        vendor.click();
    }

    // Select specific Vendor
    @FindBy(xpath = "//span[.=' Aziro-Technologies']")
    WebElement setVendor;
    public void setvendor() {
        setVendor.click();
    }

    // Enter Login ID
    @FindBy(xpath = "//input[@placeholder='Login Id']")
    WebElement loginId;
    public void setLogin(String login) {
        loginId.sendKeys(login);
    }

    // Select Site checkbox
    @FindBy(xpath = "//label[@for='AMDG-input']")
    WebElement SiteName;
    public void SelectSite() {
        SiteName.click();
    }

    // Click Save button
    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement save;
    public void ClickSave() {
        save.click();
    }
    // Click Confirm button
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement confirm;
    public void ClickConfirm() {
        confirm.click();
    }

    // Check if Confirmation dialog is displayed
    public boolean isConfirmationDisplayed() {
        return driver.findElement(By.xpath("//div[contains(text(),'User Details Created Successfully')]")).isDisplayed();
    }

    // Click Notification icon
    @FindBy(xpath = "//img[@src='assets/images/communication.svg']")
    WebElement notificationIcon;
    public void ClicknotificationIcon() {
        notificationIcon.click();
    }

        // Search for Associates
    @FindBy(xpath = "//input[@placeholder='Search Associates']")
    WebElement searchAssociates;
    public void ClicksearchAssociates() {
        searchAssociates.click();
    }
    public void setSearchAssociates(String mobile) {
        searchAssociates.sendKeys(mobile);
    }
    public void pressEnterSearch() {
        searchAssociates.sendKeys(Keys.ENTER);
    }

    // Check if Search result is displayed
    public boolean isSearchResultDisplayed() {
        return driver.findElement(By.id("searchResult")).isDisplayed();
    }

    // Approve Associate
    @FindBy(xpath = "//i[@class='pi pi-check']")
    WebElement ActionApprove;
    public void ClickActionApprove() {
        ActionApprove.click();
    }

    // Check if Approval action was successful
    public boolean isApprovalSuccessful() {
        return driver.findElement(By.xpath("//div[contains(text(),'User approved successfully')]")).isDisplayed();
    }

    // Click Yes button
    @FindBy(xpath = "//button[@class='create-action text-capitalize']")
    WebElement yes;
    public void Clickyes() {
        yes.click();
    }

    // Search for User
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;
    public void Clicksearch() {
        search.click();
    }
    public void setsearch(String mobile) {
        search.clear();
        search.sendKeys(mobile);
    }
    public void pressEntersearch() {
        search.sendKeys(Keys.ENTER);
    }

    // Select User checkbox
    @FindBy(xpath = "//input[@ng-reflect-model='false']")
    WebElement SelectCheckbox;
    public void ClickSelectCheckbox() {
        SelectCheckbox.click();
    }

    // Delete User
    @FindBy(xpath = "//button[@class='delete-action create-action pull-right']")
    WebElement deleteUsers;
    public void ClickdeleteUsers() {
        deleteUsers.click();
    }
    @FindBy(xpath = "//button[@class='create-action text-capitalize']")
    WebElement delete;
    public void Clickdelete() {
        delete.click();
    }

    // Check if Delete action was successful
    public boolean isDeleteSuccessful() {
        return driver.findElement(By.id("deleteSuccessMessage")).isDisplayed();
    }

    // Clear Search field
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchclear;
    public void Clicksearchclear() {
        searchclear.clear();
    }

    // Refresh page
    public void Refresh() {
        searchclear.sendKeys(Keys.F5);
    }

    // Edit User
    @FindBy(xpath = "//img[@src='../../../../assets/images/action-normal.svg']")
    WebElement Username;
    public void ClickEdit() {
        Username.click();
    }


    // Check if Edit form is displayed
    public boolean isEditFormDisplayed() {
        return driver.findElement(By.id("editForm")).isDisplayed();
    }

    // Toggle Switch Button
    @FindBy(xpath = "//button[@role='switch']")
    WebElement SwitchButton;
    public void ClickSwitchButton() {
        SwitchButton.click();
    }

    // Add Role
    @FindBy(xpath = "//span[contains(text(),'Roles')]")
    WebElement roles;
    public void ClickRole() {
        roles.click();
    }
    @FindBy(xpath = "//span[normalize-space()='Add Role']")
    WebElement addRole;
    public void ClickAddRole() {
        addRole.click();
    }
    @FindBy(xpath = "//input[@placeholder='Role Name']")
    WebElement roleName;
    public void TxtAddRole(String AddRole) {
        roleName.sendKeys(AddRole);
    }
    @FindBy(xpath = "//input[@placeholder='Description']")
    WebElement description;
    public void TxtAddDesc(String AddDesc) {
        description.sendKeys(AddDesc);
    }

    // Select Role permissions
    @FindBy(xpath = "(//span[@class='module-name set-name text-capitalize'])[1]")
    WebElement associates;
    public void ClickCheckbox() {
        associates.click();
    }

    // Save Role
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SaveRole;
    public void ClickRoleSave() {
        SaveRole.click();
    }

    // Check if Role save action was successful
    public boolean isRoleSaveSuccessful() {
        return driver.findElement(By.id("roleSaveSuccessMessage")).isDisplayed();
    }

    // Confirm Role addition
    @FindBy(xpath = "//button[@class='create-action text-capitalize']")
    WebElement ConfirmRole;
    public void ClickRoleConfirm() {
        ConfirmRole.click();
    }

    // Check if Role confirmation dialog is displayed
    public boolean isRoleConfirmationDisplayed() {
        return driver.findElement(By.xpath("//div[@class='message']")).isDisplayed();
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchRole;
    public void ClicksearchRole() {
        search.click();
    }
    public void setSearch(String roleName) {
        searchRole.clear();
        searchRole.sendKeys(roleName);
    }
    public void pressEntersearchRole() {
        searchRole.sendKeys(Keys.ENTER);
    }


    // Delete Role
    @FindBy(xpath = "//button[@class='delete-role-button']")
    WebElement deleteRoleButton;
    public void ClickDeleteRole() {
        deleteRoleButton.click();
    }
    // Confirm Role deletion
    @FindBy(xpath = "//span[normalize-space()='DELETE ROLE']")
    WebElement deleteRoleConfirm;
    public void ClickDeleteRoleConfirm() {
        deleteRoleConfirm.click();
    }

    @FindBy(xpath = "//h5[contains(@class, 'card-title') and text()='Test Role1']")
    WebElement roleCard;
    public boolean isRoleCardDisplayed() {
        try {
            return roleCard.isDisplayed();
        } catch (Exception e) {
            return false; // Role card not found
        }
    }
    // Click Delete Role button
    @FindBy(xpath = "//i[@class='far fa-trash-can']")
    WebElement deleteRoleButtonInCard;
    public void ClickDeleteRoleButtonInCard() {
        deleteRoleButtonInCard.click();
    }
    // Confirm Role deletion in card
    @FindBy(xpath = "//span[normalize-space()='Yes']")
    WebElement confirmDeleteRole;
    public void ClickConfirmDeleteRole() {
        confirmDeleteRole.click();
    }


}