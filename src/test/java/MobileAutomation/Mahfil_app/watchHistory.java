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

public class watchHistory extends configAppium {

	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;
	public authenticationLocators authentication;
	public watchHistoryLocators watchHistory;

	@BeforeClass
	public void before() throws InterruptedException {

		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		videoPlayer = new videoPlayerLocator(driver);
		watchHistory = new watchHistoryLocators(driver);
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

	@Test(priority = 1, description = "Watch History Testcase 01: Check Guest user cannot access Watch History", groups = {
			"guest" })
	public void guestFavouriteButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Watch History Testcase 02: Check Watch History button is working", groups = {
			"general", "premium" })
	public void dashboardButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.checkTitle("watchHistoryPageTitle", "Watch History");
	}

	@Test(priority = 3, description = "Watch History Testcase 03: Check notification button is working in Watch History page", groups = {
			"general", "premium" })
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickNotification();
		watchHistory.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 4, description = "Watch History Testcase 04: Check search button is working in Watch History page", groups = {
			"general", "premium" })
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickSearch();
		watchHistory.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 5, description = "Watch History Testcase 05: Check back button is working from Watch History page", groups = {
			"general", "premium" })
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickBackButton();
		menu.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 6, description = "Watch History Testcase 06: Check watched video is saved in Watch History", groups = {
			"general", "premium" })
	public void watchedVideoSave() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.stopVideo();
		home.clickMenu();
		menu.checkTitle("watchHisotryButton", "Watch History\n1 videos");
	}

	@Test(priority = 7, description = "Watch History Testcase 07: Check video added to Watch History is playable", groups = {
			"general", "premium" })
	public void favouriteVideoPlay() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.playwatchHistoryVideo();
		videoPlayer.checkTitle("videoPlayerPageTitle", "Related Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 8, description = "Watch History Testcase 08: Check remove button is working", groups = "premium")
	public void removeButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickEllipsis();
		watchHistory.clickRemove();
	}

}
