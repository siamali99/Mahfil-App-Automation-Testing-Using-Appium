package MobileAutomation.Mahfil_app;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class subscription extends configAppium {
	public menuPageLocators menu;
	public homePageLocators home;
	public subscriptionLocator subscription;
	public authenticationLocators authentication;

	@BeforeClass
	public void before() throws InterruptedException {
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		subscription = new subscriptionLocator(driver);
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
	
	@BeforeGroups(value = "premium")
	public void Premium() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(2);
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("premium.mahfil@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		menu.checkTitle("authButton", "Logout");
		menu.back();
	}

	@AfterMethod
	public void home() {
		home.returnHome();
	}

	@Test(priority = 1, description = "Subscription Testcase 01: Check Subscription button is working for guest user", groups = {
			"guest" })
	public void subscriptionButtonCheckGuest() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.buyPremium();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Subscription Testcase 02: Check Subscription button is working for logged-in user", groups = {
			"general" })
	public void subscriptionButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.checkTitle("subscriptionPageTitle", "Subscription");
	}

	@Test(priority = 3, description = "Subscription Testcase 03: Check notification button is working on Subscription page", groups = {
			"general" })
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.clickNotification();
		subscription.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 4, description = "Subscription Testcase 04: Check search button is working on Subscription page", groups = {
			"general" })
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.clickSearch();
		subscription.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 5, description = "Subscription Testcase 05: Check back button is working from Subscription page", groups = {
			"general" })
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.clickBackButton();
		menu.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 6, description = "Subscription Testcase 06: Check buy premium button is displayed on Subscription page", groups = {
			"general" })
	public void premiumButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.checkTitle("buyPremiumButton", "প্রিমিয়াম কিনুন");
	}

	@Test(priority = 7, description = "Subscription Testcase 07: Check buy premium button is functional on Subscription page", groups = {
			"general" })
	public void premiumBuyURLCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.buyPremium();
		Thread.sleep(2000);
		System.out.println("Visited Premium buy page");
	}

	@Test(priority = 8, description = "Subscription Testcase 08: Check subscribed package is displayed for premium user on Subscription page", groups = {
			"premium" })
	public void premiumCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.checkTitle("packageInfo", "Yearly Package - BDT");
	}

}
