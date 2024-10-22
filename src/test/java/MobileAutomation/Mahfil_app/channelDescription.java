package MobileAutomation.Mahfil_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;

public class channelDescription extends configAppium {
	public channelDescriptionPageLocators channel;
	public videoPlayerLocator videoPlayer;
	public authenticationLocators authentication;
	public homePageLocators home;
	public menuPageLocators menu;

	@BeforeClass
	public void before() throws InterruptedException {
		channel = new channelDescriptionPageLocators(driver);
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		videoPlayer = new videoPlayerLocator(driver);
		authentication = new authenticationLocators(driver);
		Thread.sleep(200);

	}
	@AfterClass
	public void returnHome() {
		home.report();
	}

	@BeforeGroups(value = "guest")
	public void Guest() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(2);
		menu.clickLogout();
		menu.back();
		home.clickSearch();
		channel.findChannel("Mahfil Original");
		channel.enterChannel("Mahfil Original");
	}

	@BeforeGroups(value = "general")
	public void General() throws InterruptedException {
		home.returnHome();
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
		home.clickSearch();
		channel.findChannel("Mahfil Original");
		channel.enterChannel("Mahfil Original");
	}

	@BeforeGroups(value = "premium")
	public void Premium() throws InterruptedException {
		home.returnHome();
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
		home.clickSearch();
		channel.findChannel("Mahfil Original");
		channel.enterChannel("Mahfil Original");
	}

	@AfterMethod
	public void returnChannel() {
		channel.returnChannel();
	}

	@Test(priority = 1, description = "Channel Description Page Testcase 01: Check notification is not accessable by guest user", groups = {
			"guest" })
	public void guestNotificationButtonCheck() {
		channel.clickNotification();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Channel Description Page Testcase 02: Check search is accessable by guest user", groups = {
			"guest" })
	public void searchButtonCheck() {
		channel.clickSearch();
		channel.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 3, description = "Channel Description Page Testcase 03: Check subscribe button click take guest user to login page", groups = {
			"guest" })
	public void guestSubscribeButtonCheck() {
		channel.clickSubscribe();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 4, description = "Channel Description Page Testcase 04: Check guest user can share general video from channel description page", groups = {
			"guest" })
	public void guestShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 5, description = "Channel Description Page Testcase 05: Check guest user can not add general video to favourite  from channel description page", groups = {
			"guest" })
	public void guestAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 6, description = "Channel Description Page Testcase 6: Check guest user can not report general video from channel description page", groups = {
			"guest" })
	public void guestReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 7, description = "Channel Description Page Testcase 7: Check guest user can play general video from channel description page", groups = {
			"guest" })
	public void guestGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		videoPlayer.checkTitle("videoPlayerPageTitle", "Related Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 8, description = "Channel Description Page Testcase 8: Check guest user can share general video from playlist", groups = {
			"guest" })
	public void guestPlaylistGeneralShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 9, description = "Channel Description Page Testcase 9: Check guest user can not add general video to favourite from playlist", groups = {
			"guest" })
	public void guestPlaylistGeneralFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 10, description = "Channel Description Page Testcase 10: Check guest user can not report general video from playlist", groups = {
			"guest" })
	public void guestPlaylistGeneralReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 11, description = "Channel Description Page Testcase 11: Check guest user can play general video from playlist", groups = {
			"guest" })
	public void guestGeneralVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle", "Playlist Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 12, description = "Channel Description Page Testcase 12: Check guest user can share premium from playlist", groups = {
			"guest" })
	public void guestPlaylistPremiumShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 13, description = "Channel Description Page Testcase 13: Check guest user can not add premium video to favourite from playlist", groups = {
			"guest" })
	public void guestPlaylistPremiumFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 14, description = "Channel Description Page Testcase 14: Check guest user can not report premium video from playlist", groups = {
			"guest" })
	public void guestPlaylistPremiumReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 15, description = "Channel Description Page Testcase 15: Check guest user can not  play premium video from playlist", groups = {
			"guest" })
	public void guestPremiumVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 16, description = "Channel Description Page Testcase 16: Check guest user can share premium video from channel description page", groups = {
			"guest" })
	public void guestShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 17, description = "Channel Description Page Testcase 17: Check guest user can not add premium video to favourite  from channel description page", groups = {
			"guest" })
	public void guestAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 18, description = "Channel Description Page Testcase 18: Check guest user can not report premium video from channel description page", groups = {
			"guest" })
	public void guestReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 19, description = "Channel Description Page Testcase 19: Check guest user can not  play premium video from channel description page", groups = {
			"guest" })
	public void guestPremiumVideoPlayCheck() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.playVideo();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 20, description = "Channel Description Page Testcase 20: Check notification is accessable by general user", groups = {
			"general" })
	public void generalUserNotificationButtonCheck() {
		channel.clickNotification();
		channel.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 21, description = "Channel Description Page Testcase 21: Check general user can subscribe channel from channel description page", groups = {
			"general" })
	public void generalUserSubscribeButtonCheck() {
		channel.clickSubscribe();
		channel.checkTitle("subscribeButtonTitle", "Subscribed");
	}

	@Test(priority = 22, description = "Channel Description Page Testcase 22: Check general user can unsubscribe channel from channel description page", groups = {
			"general" })
	public void generalUserUnSubscribeButtonCheck() throws InterruptedException {
		channel.clickUnSubscribe();
		channel.checkTitle("subscribeButtonTitle", "Subscribe");
	}

	@Test(priority = 23, description = "Channel Description Page Testcase 23: Check general user can share general video from channel description page", groups = {
			"general" })
	public void generalUserShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();

	}

	@Test(priority = 24, description = "Channel Description Page Testcase 24: Check general user can  add general video to favourite  from channel description page", groups = {
			"general" })
	public void generalUserAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 25, description = "Channel Description Page Testcase 25: Check general user can report general video from channel description page", groups = {
			"general" })
	public void generalUserReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 26, description = "Channel Description Page Testcase 26: Check general user can play general video from channel description page", groups = {
			"general" })
	public void generalUserGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle", "Related Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 27, description = "Channel Description Page Testcase 27: Check general user can share general video from playlist", groups = {
			"general" })
	public void generalUserPlaylistGeneralShareCheck() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 28, description = "Channel Description Page Testcase 28: Check guest user can add general video to favourite from playlist", groups = {
			"general" })
	public void generalUserPlaylistGeneralFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 29, description = "Channel Description Page Testcase 29: Check general user can report general video from playlist", groups = {
			"general" })
	public void generalUserPlaylistGeneralReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 30, description = "Channel Description Page Testcase 30: Check general user can play general video from playlist", groups = {
			"general" })
	public void generalUserGeneralVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle", "Playlist Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 31, description = "Channel Description Page Testcase 31: check general user can share premium video from playlist", groups = {
			"general" })
	public void generalUserPlaylistPremiumShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 32, description = "Channel Description Page Testcase 32: Check guest user can not add premium video to favourite from playlist", groups = {
			"general" })
	public void generalUserPlaylistPremiumFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 33, description = "Channel Description Page Testcase 33: Check general user can not report premium video from playlist", groups = {
			"general" })
	public void generalUserPlaylistPremiumReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 34, description = "Channel Description Page Testcase 34: Check general user can not  play premium video from playlist", groups = {
			"general" })
	public void generalUserPremiumVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 35, description = "Channel Description Page Testcase 35: Check general user can share premium video from channel description page", groups = {
			"general" })
	public void generalUserShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();

	}

	@Test(priority = 36, description = "Channel Description Page Testcase 36: Check general user can not add premium video to favourite  from channel description page", groups = {
			"general" })
	public void generalUserAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 37, description = "Channel Description Page Testcase 37: Check general user can not report premium video from channel description page", groups = {
			"general" })
	public void generalUserReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 38, description = "Channel Description Page Testcase 38: Check general user can not  play premium video from channel description page", groups = {
			"general" })
	public void generalUserPremiumVideoPlayCheck() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 39, description = "Channel Description Page Testcase 39: Check notification is accessable by premium user", groups = {
			"premium" })
	public void premiumUserNotificationButtonCheck() {
		channel.clickNotification();
		channel.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 40, description = "Channel Description Page Testcase 40: Check premium user can subscribe channel from channel description page", groups = {
			"premium" })
	public void premiumUserSubscribeButtonCheck() {
		channel.clickSubscribe();
		channel.checkTitle("subscribeButtonTitle", "Subscribed");
	}

	@Test(priority = 41, description = "Channel Description Page Testcase 41: Check premium user can unsubscribe channel from channel description page", groups = {
			"premium" })
	public void premiumUserUnSubscribeButtonCheck() throws InterruptedException {
		channel.clickUnSubscribe();
		channel.checkTitle("subscribeButtonTitle", "Subscribe");
	}

	@Test(priority = 42, description = "Channel Description Page Testcase 42: Check premium user can share general video from channel description page", groups = {
			"premium" })
	public void premiumUserShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();

	}

	@Test(priority = 43, description = "Channel Description Page Testcase 43: Check premium user can  add general video to favourite  from channel description page", groups = {
			"premium" })
	public void premiumUserAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 44, description = "Channel Description Page Testcase 44: Check premium user can report general video from channel description page", groups = {
			"premium" })
	public void premiumUserReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 45, description = "Channel Description Page Testcase 45: Check premium user can play general video from channel description page", groups = {
			"premium" })
	public void premiumUserGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle", "Related Videos");
		channel.stopVideo();

	}

	@Test(priority = 46, description = "Channel Description Page Testcase 46: Check premium user can share general video from playlist", groups = {
			"premium" })
	public void premiumUserPlaylistGeneralShareCheck() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}

	@Test(priority = 47, description = "Channel Description Page Testcase 47: Check premium user can add general video to favourite from playlist", groups = {
			"premium" })
	public void premiumUserPlaylistGeneralFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 48, description = "Channel Description Page Testcase 48: Check premium user can report general video from playlist", groups = {
			"premium" })
	public void premiumUserPlaylistGeneralReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 49, description = "Channel Description Page Testcase 49: Check premium user can play general video from playlist", groups = {
			"premium" })
	public void premiumUserGeneralVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle", "Playlist Videos");
		channel.stopVideo();
	}

	@Test(priority = 50, description = "Channel Description Page Testcase 50: check premium user can share premium video from playlist", groups = {
			"premium" })
	public void premiumUserPlaylistPremiumShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}

	@Test(priority = 52, description = "Channel Description Page Testcase 52: Check premium user can add premium video to favourite from playlist", groups = {
			"premium" })
	public void premiumUserPlaylistPremiumFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 53, description = "Channel Description Page Testcase 53: Check premium user can report premium video from playlist", groups = {
			"premium" })
	public void premiumUserPlaylistPremiumReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 54, description = "Channel Description Page Testcase 54: Check premium user can play premium video from playlist", groups = {
			"premium" })
	public void premiumUserPremiumVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle", "Playlist Videos");
		channel.stopVideo();
	}

	@Test(priority = 55, description = "Channel Description Page Testcase 55: Check premium user can share premium video from channel description page", groups = {
			"premium" })
	public void premiumUserShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		channel.back();
	}

	@Test(priority = 56, description = "Channel Description Page Testcase 56: Check premium user can add premium video to favourite  from channel description page", groups = {
			"premium" })
	public void premiumUserAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton", " Remove from Favorite");
	}

	@Test(priority = 57, description = "Channel Description Page Testcase 57: Check premium user can report premium video from channel description page", groups = {
			"premium" })
	public void premiumUserReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 58, description = "Channel Description Page Testcase 58: Check premium user can play premium video from channel description page", groups = {
			"premium" })
	public void premiumUserPremiumVideoPlayCheck() throws InterruptedException {
		channel.clickVideosTab();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle", "Related Videos");
		channel.stopVideo();
	}

}
