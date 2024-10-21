package MobileAutomation.Mahfil_app;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MobileAutomation.TestUtils.Listeners.class)
public class privacy extends configAppium {

	public menuPageLocators menu;
	public homePageLocators home;
	public privacyLocators privacy;
	public authenticationLocators authentication;

	@BeforeClass
	public void before() throws InterruptedException {
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		privacy = new privacyLocators(driver);
		authentication = new authenticationLocators(driver);
		Thread.sleep(200);

	}

	@BeforeGroups(value = "guest")
	public void Guest() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(2);
		menu.clickLogout();
		menu.back();
	}

	@BeforeGroups(value = "general")
	public void General() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(2);
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("general.mahfil@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		menu.checkTitle("authButton", "Logout");
		menu.back();
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(1);
		menu.clickPrivacy();
	}

	@AfterMethod
	public void home() {
		home.returnHome();
	}

	@Test(priority = 1, description = "Privacy Testcase 01: Check notification button is not working for guest in Privacy page", groups = {
			"guest" })
	public void notificationButtonCheckGuest() {
		privacy.clickNotification();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Privacy Testcase 02: Check Privacy button is working", groups = { "general" })
	public void privacyButtonCheck() {
		privacy.checkTitle("privacyPageTitle", "Privacy");
	}

	@Test(priority = 3, description = "Privacy Testcase 03: Check notification button is working in Privacy page", groups = {
			"general" })
	public void notificationButtonCheck() {
		privacy.clickNotification();
		privacy.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 4, description = "Privacy Testcase 04: Check search button is working in Privacy page", groups = {
			"general" })
	public void searchButtonCheck() {
		privacy.clickSearch();
		privacy.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 5, description = "Privacy Testcase 05: Check back button is working from Privacy page", groups = {
			"general" })
	public void backButtonCheck() {
		privacy.clickBackButton();
		menu.checkTitle("menuTitle", "Others");
	}

}
