package MobileAutomation.Mahfil_app;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class videoPlayer extends configAppium {

	public menuPageLocators menu;
	public homePageLocators home;
	public authenticationLocators authentication;
	public videoPlayerLocator videoPlayer;

	@BeforeClass
	public void before() throws InterruptedException {
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
	public void home() throws InterruptedException {
		videoPlayer.stopVideo();
	}

	@Test(priority = 1, description = "Check mashallah, like and download is not accessable by guest user", groups = {
			"guest" })
	public void reactionButtonCheckGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMashallah();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
		videoPlayer.clickLike();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
		videoPlayer.clickDownload();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 2, description = "Check guest user can not share video", groups = { "guest" })
	public void shareButtonCheckGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMore();
		videoPlayer.clickShare();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 3, description = "Check guest user can not add video to favourte ", groups = { "guest" })
	public void favouriteButtonCheckGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMore();
		videoPlayer.clickFavourite();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 4, description = "Check guest user can not report video", groups = { "guest" })
	public void reportButtonCheckGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMore();
		videoPlayer.clickReportbutton();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 5, description = "Check guest user cann't subscribe channel", groups = { "guest" })
	public void subscribeButtonGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickSubscribe();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 6, description = "Check guest user cann't comment", groups = { "guest" })
	public void commentCheckGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickComment();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 7, description = "Check guest user can share related video", groups = { "guest" })
	public void relatedVideoShareGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.Scroll(3);
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.clickRelatedVideoShare();
		videoPlayer.checkTitle("sharePageTitle", "Sharing link");
		videoPlayer.back();
	}

	@Test(priority = 8, description = "Check guest user can not add video to favourite from related section", groups = {
			"guest" })
	public void relatedVideoFavouriteGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.Scroll(3);
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.clickRelatedVideoAddToFavourite();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 9, description = "Check guest user can not report video from related section", groups = {
			"guest" })
	public void relatedVideoReportGuest() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.Scroll(3);
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.clickRelatedVideoReport();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
		authentication.back();
	}

	@Test(priority = 10, description = "Check mashallah, like is accessable by general user", groups = { "general" })
	public void reactionButtonCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMashallah();
		videoPlayer.clickLike();
	}

	@Test(priority = 11, description = "Check download is not accessable by general user", groups = { "general" })
	public void downloadButtonCheckGeneral() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickDownload();
		videoPlayer.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
		videoPlayer.back();
	}

	@Test(priority = 12, description = "Check general user can share video", groups = { "general" })
	public void shareButtonCheckGeneral() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMore();
		videoPlayer.clickShare();
		videoPlayer.checkTitle("sharePageTitle", "Sharing link");
		videoPlayer.back();
	}

	@Test(priority = 13, description = "Check general user can  add video to favourte ", groups = { "general" })
	public void favouriteButtonCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMore();
		videoPlayer.clickFavourite();
		videoPlayer.clickMore();
		videoPlayer.checkTitle("addFavouriteButton", " Remove from Favorite");
		videoPlayer.back();
	}

	@Test(priority = 14, description = "Check general user can report video", groups = { "general" })
	public void reportButtonCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickMore();
		videoPlayer.clickReportbutton();
		videoPlayer.report();
		videoPlayer.clickMore();
		videoPlayer.checkTitle("reportButton", "Already Reported");
	}

	@Test(priority = 15, description = "Check user can subscribe channel", groups = { "general" })
	public void subscribeButton() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickSubscribe();
		videoPlayer.checkTitle("subscribedButton", "Subscribed");
	}

	@Test(priority = 16, description = "Check user can unsubscribe channel", groups = { "general" })
	public void unsubscribeButton() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickUnSubscribe();
		videoPlayer.checkTitle("subscribeButton", "Subscribe");
	}

	@Test(priority = 17, description = "Check general user can comment", groups = { "general" })
	public void commentCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickComment();
		videoPlayer.writeComment();
	}

	@Test(priority = 18, description = "Check general user can share related video", groups = { "general" })
	public void relatedVideoShare() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.Scroll(3);
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.clickRelatedVideoShare();
		videoPlayer.checkTitle("sharePageTitle", "Sharing link");
		videoPlayer.back();
	}

	@Test(priority = 19, description = "Check general user can  add video to favourite from related section", groups = {
			"general" })
	public void relatedVideoFavourite() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.Scroll(3);
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.clickRelatedVideoAddToFavourite();
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.checkTitle("addFavouriteButton", " Remove from Favorite");
		videoPlayer.back();
	}

	@Test(priority = 20, description = "Check general user can report video from related section", groups = {
			"general" })
	public void relatedVideoReport() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.Scroll(3);
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.clickRelatedVideoReport();
		videoPlayer.report();
		videoPlayer.clickRelatedVideoElipsis();
		videoPlayer.checkTitle("reportButton", "Already Reported");
		videoPlayer.back();
	}

	@Test(priority = 21, description = "Check download is  accessable by premium user", groups = { "premium" })
	public void downloadButtonCheckPremium() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.clickDownload();
		videoPlayer.checkTitle("downloadConfirmation", "Download has started. Please wait a moment!");

	}

}
