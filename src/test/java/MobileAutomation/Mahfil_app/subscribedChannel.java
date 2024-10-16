package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.netty.util.internal.SystemPropertyUtil;

public class subscribedChannel extends configAppium {

	public menuPageLocators menu;
	public homePageLocators home;
	public subscribedChannelLocators subscribedChannel;
	public authenticationLocators authentication;

	@BeforeClass
	public void before() throws InterruptedException {

		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		subscribedChannel = new subscribedChannelLocators(driver);
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

	@AfterMethod
	public void home() {
		home.returnHome();
	}

	@Test(priority = 1, description = "Subscribed Channel Testcase 01: Check Guest user cannot access Subscribed Channel", groups = {
			"guest" })
	public void guestFavouriteButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Subscribed Channel Testcase 02 Check Subscribed Channel button is working", groups = {
			"general", "premium" })
	public void subscribedChannelButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.checkTitle("subscribedChannelPageTitle", "Subscribed Channels");
	}

	@Test(priority = 3, description = "Subscribed Channel Testcase 03: Check notification button is working in Subscribed Channel page", groups = {
			"general", "premium" })
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickNotification();
		subscribedChannel.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 4, description = "Subscribed Channel Testcase 04: Check search button is working in Subscribed Channel page", groups = {
			"general", "premium" })
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickSearch();
		subscribedChannel.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 5, description = "Subscribed Channel Testcase 05: Check back button is working from Subscribed Channel page", groups = {
			"general", "premium" })
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickBackButton();
		menu.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 6, description = "Subscribed Channel Testcase 06: Check subscribed channe is shown in Subscribed Channel page", groups = {
			"general", "premium" })
	public void subscriptionChannelCheck() throws InterruptedException {
		home.clickSubscribe();
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickBackButton();
		menu.checkTitle("subscribedChannelButton", "Subscribed Channel\n" + "1 Channels");
	}

	@Test(priority = 7, description = "Subscribed Channel Testcase 07: Check channel unsubscribe is working in Subscribed Channel page", groups = {
			"general", "premium" })
	public void unsubscribeChannelCheck() throws InterruptedException {

		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickSubscribed();
		subscribedChannel.checkTitle("emptysubscribedChannelPageTitle", "Subscribed channel will appear here!");

	}

}
