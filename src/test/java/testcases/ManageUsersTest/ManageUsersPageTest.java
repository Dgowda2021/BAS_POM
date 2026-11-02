package testcases.ManageUsersTest;

import Actions.RoleActions;
import Pages.ManageUsers;
import Pages.SwitchButtonControl;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageUsersPageTest extends BaseClass {

    @Test(priority=1)
    public void ManageUsersAddUserTest() throws InterruptedException {
        // Initialize the ManageUsers page object
        ManageUsers manageaddUsers = new ManageUsers(driver);

        // Navigate to the Manage Users section
        manageaddUsers.ClickManageUsers();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("manage-users"), "Failed to navigate to Manage Users section");

        // Click the Add User button to open the user creation form
        manageaddUsers.btnAddUser();
//       Assert.assertTrue(manageaddUsers.isAddUserFormDisplayed(), "Add User form is not displayed");

        // Fill in user details (First Name, Last Name, Role, Mobile Number)
        manageaddUsers.txtFirstName("Testfirst");
        manageaddUsers.txtLastName("Testlast");
        manageaddUsers.selctRole();
        manageaddUsers.setRole();
        manageaddUsers.txtMobile("9669669645");

        // Select the region from the dropdown
        manageaddUsers.selRegion();
        manageaddUsers.setRegion();
        manageaddUsers.pressEscKey(driver);

        // Select the reporting manager
        manageaddUsers.selRepmanager();
        manageaddUsers.selManager();

        // Select the vendor from the dropdown
        manageaddUsers.selVendor();
        manageaddUsers.setvendor();

        // Set login credentials for the user
        manageaddUsers.setLogin("testloginauto");

        // Select the site for the user
        manageaddUsers.SelectSite();

        // Save the user details
        manageaddUsers.ClickSave();
        Thread.sleep(3000);

        // Confirm the save action
        manageaddUsers.ClickConfirm();
        Thread.sleep(3000);
        //Assert.assertTrue(manageaddUsers.isConfirmationDisplayed(), "User Details Created Successfully dialog is not displayed");
        if (manageaddUsers.isConfirmationDisplayed()) {
            System.out.println("User Details Created Successfully.");
        } else {
            System.out.println("Failed to add User.");
        }
    }

    @Test(priority=2)
    public void ManageApproveTest() throws InterruptedException {
        // Initialize the ManageUsers page object
        ManageUsers manageaddUsers = new ManageUsers(driver);

        // Click the notification icon to view pending approvals
        manageaddUsers.ClicknotificationIcon();
        Thread.sleep(3000);

        // Search for the associate using their mobile number
        manageaddUsers.ClicksearchAssociates();
        manageaddUsers.setSearchAssociates("9669669645");
        manageaddUsers.pressEnterSearch();
        Thread.sleep(3000);

        // Approve the associate
        manageaddUsers.ClickActionApprove();
        manageaddUsers.Clickyes();
        Assert.assertTrue(manageaddUsers.isApprovalSuccessful(), "Failed to approve the associate");
    }
    @Test(priority=3)
    public void ManageActiveFeatureTest() throws InterruptedException {
        // Initialize the ManageUsers and SwitchButtonControl page objects
        ManageUsers manageaddUsers = new ManageUsers(driver);
        SwitchButtonControl switchButtonControl = new SwitchButtonControl(driver);

        // Navigate to the Manage Users section
        manageaddUsers.ClickManageUsers();
        Thread.sleep(3000);
        //Assert.assertTrue(driver.getCurrentUrl().contains("manage-users"), "Failed to navigate to Manage Users section");

        // Search for the user to edit using their mobile number
        manageaddUsers.Clicksearch();
        manageaddUsers.setsearch("9449490144");
        manageaddUsers.pressEntersearch();
        Thread.sleep(3000);
        //Assert.assertTrue(manageaddUsers.isSearchResultDisplayed(), "Search result is not displayed");

        // Edit the user details
        manageaddUsers.ClickEdit();
        Thread.sleep(3000);
        //Assert.assertTrue(manageaddUsers.isEditFormDisplayed(), "Edit form is not displayed");

        // Toggle the switch button twice to test the active feature
        manageaddUsers.ClickSwitchButton();
        Thread.sleep(3000);
        switchButtonControl.setToggleState(false); // Set to OFF
        Thread.sleep(3000);
        manageaddUsers.ClickSwitchButton();
        Thread.sleep(3000);
        switchButtonControl.setToggleState(true); // Set to ON
        Thread.sleep(3000);
//        switchButtonControl.SwitchButtonClickFirst();
//        Thread.sleep(3000);
//        manageaddUsers.ClickSwitchButton();
//        Thread.sleep(3000);
//        switchButtonControl.SwitchButtonClickSecond();
//        Thread.sleep(3000);

//        manageaddUsers.clickSwitchButton(); // Opens the menu/toggle area
//        Thread.sleep(3000);
//
//        if (manageaddUsers.isToggleActive()) {
//            // If our check says the toggle is currently ON
//            SwitchButtonControl.switchButtonClickFirst();
//        } else {
//            // If our check says the toggle is currently OFF
//            switchButtonControl.switchButtonClickSecond();
//        }

        Thread.sleep(3000);

// Final wait after the action is performed
        Thread.sleep(3000);
        // Navigate back to the Manage Users section
        manageaddUsers.ClickManageUsers();

    }

    @Test(priority=4)
    public void ManageDeletTest() throws InterruptedException {
        // Initialize the ManageUsers page object
        ManageUsers manageaddUsers = new ManageUsers(driver);

        // Navigate to the Manage Users section
        manageaddUsers.ClickManageUsers();
        Thread.sleep(3000);

        // Search for the user to delete using their mobile number
        manageaddUsers.Clicksearch();
        manageaddUsers.setsearch("9669669645");
        manageaddUsers.pressEntersearch();
        Thread.sleep(3000);

        // Select the user and delete them
        manageaddUsers.ClickSelectCheckbox();
        manageaddUsers.ClickdeleteUsers();
        manageaddUsers.Clickdelete();
        Thread.sleep(3000);

        // Clear the search field and refresh the page
        manageaddUsers.Clicksearchclear();
        manageaddUsers.Refresh();
    }

    @Test(priority=5)
    public void AddRoleTest() throws InterruptedException {
        // Initialize the ManageUsers page object
        ManageUsers manageaddUsers = new ManageUsers(driver);

        // Navigate to the Manage Users section
        manageaddUsers.ClickManageUsers();
        Thread.sleep(3000);

        // Add a new role with name and description
        manageaddUsers.ClickRole();
        manageaddUsers.ClickAddRole();
        manageaddUsers.TxtAddRole("Test Role1");
        manageaddUsers.TxtAddDesc("Test Description1");

        // Select the checkbox for the role permissions
        manageaddUsers.ClickCheckbox();

        // Save the new role
        manageaddUsers.ClickRoleSave();
        Thread.sleep(3000);

        // Confirm the role addition
        manageaddUsers.ClickRoleConfirm();
        Thread.sleep(3000);
        Assert.assertTrue(manageaddUsers.isRoleConfirmationDisplayed(), "Role confirmation dialog is not displayed");
    }

    @Test(priority = 6)
    public void DeleteRoleTest() throws InterruptedException {
        // Initialize the ManageUsers and RoleActions page objects
        ManageUsers manageUsers = new ManageUsers(driver);
        RoleActions roleActions = new RoleActions(driver);

        // Navigate to the Manage Users section
        manageUsers.ClickManageUsers();
        Thread.sleep(3000);

        // Navigate to the Roles section
        manageUsers.ClickRole();
        Thread.sleep(3000);

        // Search for the role using its name
        manageUsers.ClicksearchRole();
        Thread.sleep(2000);
        manageUsers.setSearch("Test Role1"); // Ensure this method sends valid input
        Thread.sleep(2000);
        manageUsers.pressEntersearchRole();
        Thread.sleep(3000);

        // Verify if the role card is displayed
        Assert.assertTrue(manageUsers.isRoleCardDisplayed(), "Role card for 'Test Role1' is not displayed");

        // Hover over the role card to make the delete button visible
        roleActions.hoverOverRoleCard("Test Role1");
        Thread.sleep(2000); // Wait for the delete button to appear

        // Click the delete button for the role
        roleActions.clickDeleteButton("Test Role1");
        Thread.sleep(3000);

        // Confirm the role deletion
        roleActions.confirmRoleDeletion();
        Thread.sleep(3000);

        // Verify the role card is no longer displayed
        Assert.assertFalse(manageUsers.isRoleCardDisplayed(), "Role card for 'Test Role1' is still displayed after deletion");
    }
}