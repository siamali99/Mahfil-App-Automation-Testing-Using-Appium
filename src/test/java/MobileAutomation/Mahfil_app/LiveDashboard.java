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

public class LiveDashboard extends configAppium {

	public LiveDashboardLocators dashboard;
	public menuPageLocators menu;
	public homePageLocators home;
	public authenticationLocators authentication;
	public videoPlayerLocator videoPlayer;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		dashboard = new LiveDashboardLocators(driver);
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		authentication = new authenticationLocators(driver);
		videoPlayer = new videoPlayerLocator(driver);
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
		Thread.sleep(200);
		menu.clickDashboard();
	}

	@AfterMethod
	public void home() {
		home.returnHome();
	}

	@Test(priority = 1, description = "Livedashboard Testcase 01: Check login page is shown to guest user while click", groups = {
			"guest" })
	public void dashboardButtonCheckGuest() throws InterruptedException {
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Livedashboard Testcase 01: Check live dashboard button is working", groups = {
			"general" })
	public void dashboardButtonCheck() throws InterruptedException {
		dashboard.checkTitle("dashboardPageTitle", "Live Dashboard");
	}

	@Test(priority = 3, description = "Livedashboard Testcase 02: Check notification button is working in live dashboard page", groups = {
			"general" })
	public void notificationButtonCheck() throws InterruptedException {
		dashboard.clickNotification();
		dashboard.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 4, description = "Livedashboard Testcase 03: Check search button is working in live dashboard page", groups = {
			"general" })
	public void searchButtonCheck() throws InterruptedException {
		dashboard.clickSearch();
		dashboard.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 5, description = "Livedashboard Testcase 04: Check back button is working from live dashboard page", groups = {
			"general" })
	public void backButtonCheck() throws InterruptedException {
		dashboard.clickBackButton();
		dashboard.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 6, description = "Livedashboard Testcase 06: Check channel is opening from live dashboard on logo click", groups = {
			"general" })
	public void channelLogoCheck() throws InterruptedException {
		dashboard.clickChannelLogo();
		dashboard.checkTitle("channelTitle", "Holy Tv");
	}

	@Test(priority = 7, description = "Livedashboard Testcase 07: Check video is playing from live dashboard on click", groups = {
			"general" })
	public void LiveVideoCheck() throws InterruptedException {
		dashboard.playLiveVideo();
		dashboard.checkTitle("liveVideoPlayerPage", "Related Videos");
		videoPlayer.back();
		videoPlayer.stopVideo();
	}

	@Test(priority = 8, description = "Livedashboard Testcase 08: Check subscribe button is working in live dashboard", groups = {
			"general" })
	public void subscribeButtonCheck() throws InterruptedException {
		dashboard.clickSubscribeButton();
		dashboard.checkTitle("subscribeButtonTitle", "Subscribed");
	}

	@Test(priority = 9, description = "Livedashboard Testcase 09: Check unsubscribe button is working in live dashboard", groups = {
			"general" })
	public void unsubscribeButtonCheck() throws InterruptedException {
		dashboard.clickUnSubscribeButton();
		dashboard.checkTitle("subscribeButtonTitle", "Subscribe");
	}

	@Test(priority = 10, description = "Livedashboard Testcase 10: Check live video share is working in live dashboard", groups = {
			"general" })
	public void liveshareCheck() throws InterruptedException {
		dashboard.clickElipsis();
		dashboard.clickShare();
		dashboard.checkTitle("sharePageTitle", "Sharing link");
	}

	@Test(priority = 11, description = "Livedashboard Testcase 11: Check live video add to favourite is working in live dashboard", groups = {
			"general" })
	public void adFavCheck() throws InterruptedException {
		dashboard.clickElipsis();
		dashboard.clickFavourite();
		dashboard.clickElipsis();
		dashboard.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 12, description = "Livedashboard Testcase 12: Check live video remove from favourite is working in live dashboard", groups = {
			"general" })
	public void removeFavCheck() throws InterruptedException {
		dashboard.clickElipsis();
		dashboard.clickFavourite();
		dashboard.clickElipsis();
		dashboard.checkTitle("addFavouriteButton", "Add to Favourite");
	}

	@Test(priority = 13, description = "Livedashboard Testcase 13: Check report video is working in live dashboard", groups = {
			"general" })
	public void reportCheck() throws InterruptedException {
		dashboard.clickElipsis();
		dashboard.clickReportbutton();
		dashboard.report();
		dashboard.clickElipsis();
		dashboard.checkTitle("reportButton", "Already Reported");
	}

}
