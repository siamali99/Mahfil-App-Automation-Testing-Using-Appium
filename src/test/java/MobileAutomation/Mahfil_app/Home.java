package MobileAutomation.Mahfil_app;

import java.time.Duration;

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
import io.appium.java_client.TouchAction;

public class Home extends configAppium {
	public channelDescriptionPageLocators channel;
	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;
	public authenticationLocators authentication;

	@BeforeClass
	public void before() throws InterruptedException {
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		videoPlayer = new videoPlayerLocator(driver);
		authentication = new authenticationLocators(driver);
		channel = new channelDescriptionPageLocators(driver);
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

	@Test(priority = 1, description = "Home Testcase 01: Check menu section is opening", groups = { "all" })
	public void menuButtonCheck() {
		home.clickMenu();
		menu.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 2, description = "Home Testcase 02: Check notification is not accessable", groups = { "guest" })
	public void guestnotificationButtonCheck() {
		home.clickNotification();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 3, description = "Home Testcase 03: Check search is accessable", groups = { "guest" })
	public void searchButtonCheck() {
		home.clickSearch();
		home.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 4, description = "Home Testcase 04: Check channel is opening from channel logo click", groups = {
			"guest" })
	public void channelLogoCheck() throws InterruptedException {
		String title = home.checkClickedPopularChannelName();
		home.clickPopularChannel();
		channel.checkTitle("channelPageTitle", title);
	}

	@Test(priority = 5, description = "Home Testcase 05: Check subscribe button click taking guest user to login page", groups = {
			"guest" })
	public void guestSubscribeButtonCheck() throws InterruptedException {
		home.clickSubscribe();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 6, description = "Home Testcase 06: Check general video is shareable as a guest user", groups = {
			"guest" })
	public void guestGeneralVideoShareCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickShare();
		home.checkTitle("sharePageTitle", "Sharing link");
	}

	@Test(priority = 7, description = "Home Testcase 07: Check premium video is shareable as a guest user", groups = {
			"guest" })
	public void guestPremiumVideoShareCheck() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickShare();
		home.checkTitle("sharePageTitle", "Sharing link");
	}

	@Test(priority = 8, description = "Home Testcase 08: Check general video ad video favourite is not working as a guest user", groups = {
			"guest" })
	public void guestGeneralVideoAdFavCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 9, description = "Home Testcase 09: Check premium video ad video favourite is not working as a guest user", groups = {
			"guest" })
	public void guestPremiumVideoAdFavCheck() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickFavourite();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 10, description = "Home Testcase 10: Check video report is not working as a guest user", groups = {
			"guest" })
	public void guestGeneralVideoReportCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickReportbutton();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 11, description = "Home Testcase 11: Check premium video report is not working as a guest user", groups = {
			"guest" })
	public void guestPremiumVideoReportCheck() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickReportbutton();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 12, description = "Home Testcase 12: Check premium video is not playable as a guest user", groups = {
			"guest" })
	public void guestPremiumVideoPlay() throws InterruptedException {
		home.findPremiumVideo();
		home.playVideo();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");

	}

	@Test(priority = 13, description = "Home Testcase 13: Check general video is playable as a guest user", groups = {
			"guest" })
	public void guestGeneralVideoPlay() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.checkTitle("videoPlayerPageTitle", "Related Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 14, description = "Home Testcase 14: Check notification is accessable", groups = { "general" })
	public void notificationButtonCheck() {
		home.clickNotification();
		// passing exoected page and page title
		home.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 15, description = "Home Testcase 15: Check subscribe button is working", groups = { "general" })
	public void SubscribeButtonCheck() throws InterruptedException {
		home.clickSubscribe();
		home.checkTitle("subscribeButtonTitle", "Subscribed");
	}

	@Test(priority = 16, description = "Home Testcase 16: Check unsubscribe button is working", groups = { "general" })
	public void unSubscribeButtonCheck() throws InterruptedException {
		home.clickUnSubscribe();
		home.checkTitle("subscribeButtonTitle", "Subscribe");
	}

	@Test(priority = 17, description = "Home Testcase 17: Check general video add to favourite is working", groups = {
			"general" })
	public void generalVideoAdFavButtonCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.clickElipsis();
		home.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 18, description = "Home Testcase 18: Check general video remove from  favourite is working", groups = {
			"general" })
	public void generalVideoremoveFavButtonCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.clickElipsis();
		home.checkTitle("addFavouriteButton", "Add to Favourite");
	}

	@Test(priority = 19, description = "Home Testcase 19: Check general user can not ad premium video to favourite", groups = {
			"general" })
	public void premumVideoAdFavButtonCheck() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 20, description = "Home Testcase 20: Check general user can not report premium video", groups = {
			"general" })
	public void premumVideoReportCheck() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 21, description = "Home Testcase 21: Check general user can report general video", groups = {
			"general" })
	public void generalVideoReportCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.report();
		home.clickElipsis();
		home.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 22, description = "Home Testcase 22: Check general user can not play premium video", groups = {
			"general" })
	public void premumVideoplayCheckByGeneralUser() throws InterruptedException {
		home.findPremiumVideo();
		home.playVideo();
		home.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 23, description = "Home Testcase 23: Check premium user can ad general video to favourite", groups = {
			"premium" })
	public void premumVideoAdFavCheckByPremiumUser() throws InterruptedException {
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.clickElipsis();
		home.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 24, description = "Home Testcase 24: Check premium user can ad premium video to favourite", groups = {
			"premium" })
	public void premumVideoReportCheckByPremiumUser() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.report();
		home.clickElipsis();
		home.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 25, description = "Home Testcase 25: Check premium user can  play premium video", groups = {
			"premium" })
	public void premumVideoplayCheckByPremiumUser() throws InterruptedException {
		home.findPremiumVideo();
		home.playVideo();
		home.checkTitle("videoPlayerPageTitle", "Related Videos");
	}

}
