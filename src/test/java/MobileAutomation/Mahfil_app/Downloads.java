package MobileAutomation.Mahfil_app;

import java.lang.reflect.Method;

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
import io.appium.java_client.android.AndroidDriver;

public class Downloads extends configAppium {

	public downloadLocators download;
	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;
	public authenticationLocators authentication;

	@BeforeClass
	public void before() throws InterruptedException {
		download = new downloadLocators(driver);
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		videoPlayer = new videoPlayerLocator(driver);
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

	@Test(priority = 1, description = "Download Testcase 01: Check guest users can't access downloads", groups = "guest")
	public void downloadButtonCheckguest() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		authentication.checkTitle("SignupPageTitle", "Continue with Google");
	}

	@Test(priority = 2, description = "Download Testcase 02: Check general users can't access downloads", groups = "general")
	public void downloadButtonCheck_general() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		menu.checkTitle("premiumPopUpTitle", "আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority = 3, description = "Download Testcase 03: Check premium popup close button is working in downloads", groups = "general")
	public void premiumcloseButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		menu.closePremiumPopUp();
		menu.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 4, description = "Download Testcase 04: Check premium users can access downloads", groups = "premium")
	public void dashboardButtonCheck_premium() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		download.checkTitle("downloadPageTitle", "Downloaded Videos");
	}

	@Test(priority = 5, description = "Download Testcase 05: Check downloaded video saved on downloads", groups = "premium")
	public void downloadCheck() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.downloadVideo();
		videoPlayer.stopVideo();
		home.clickMenu();
		menu.checkTitle("downloadButton", "Downloads\n1 videos Downloaded");
	}

	@Test(priority = 6, description = "Download Testcase 06: Check downloaded video is playable", groups = "premium")
	public void downloadvideoplaycheck() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		download.playDownloadedVideo();
		videoPlayer.checkTitle("videoPlayerPageTitle", "Related Videos");
		videoPlayer.stopVideo();
	}

	@Test(priority = 7, description = "Download Testcase 07: Check downloaded video is playable offline", groups = "premium")
	public void offlinedownloadvideoplaycheck() throws InterruptedException {
		download.toggleInternet();
		download.clickSeeDownloadedVideo();
		download.playDownloadedVideoOffline();
		download.toggleInternet();
	}

	@Test(priority = 8, description = "Download Testcase 08: Check remove button is working", groups = "premium")
	public void removeButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		download.clickEllipsis();
		download.clickRemove();
		Thread.sleep(1000);
		// menu.checkTitle("emptyDownloadPageTitle", "Videos you download will appear
		// here!");
	}

}
