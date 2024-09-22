package MobileAutomation.Mahfil_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;

public class channelDescription extends configAppium{
	public channelDescriptionPageLocators channel;
	 @BeforeGroups(value = "premium")
	    public void premiumLogin() {
			driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
			//Scroll to sign in button
			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
			//click on sign in button
			String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
			System.out.println(text);
			if(text.equals("Logout"))
			{
				driver.findElement(AppiumBy.accessibilityId("Logout")).click();
				driver.findElement(AppiumBy.accessibilityId("Yes")).click();
				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
			}
			else
			{
				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
			}
			
			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
			WebElement email=driver.findElement(By.className("android.widget.EditText"));
			email.click();
			email.sendKeys("premium.mahfil@gmail.com");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.navigate().back();
	 }
	 
	 @BeforeGroups(value = "general")
	 public void generalLogin() {
			driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
			//Scroll to sign in button
			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
			//click on sign in button
			String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
			System.out.println(text);
			if(text.equals("Logout"))
			{
				driver.findElement(AppiumBy.accessibilityId("Logout")).click();
				driver.findElement(AppiumBy.accessibilityId("Yes")).click();
				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
			}
			else
			{
				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
			}
			
			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
			WebElement email=driver.findElement(By.className("android.widget.EditText"));
			email.click();
			email.sendKeys("general.mahfil@gmail.com");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.navigate().back();
	 }
	 @BeforeMethod
	 public void before() throws InterruptedException {
		 channel=new channelDescriptionPageLocators(driver);
		 channel.clickPopularChannel();
//		 channel.clickPopularChannelPremium();
		 Thread.sleep(1000);
	 }
	
	@AfterMethod
	public void home() {
		while(true)
		{
			String home_bounds=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("bounds");
			if(home_bounds.equals("[476,181][964,305]"))
					{
				break;
					}
			else
			{
				driver.navigate().back();
			}
	
		}
	}
//	@Test
//	public void test() {
//		driver.findElement(By.xpath("//android.widget.Button[2]")).click();
//	}
	

	
	@Test(priority=1, description="Channel Description Page Testcase 01: Check notification is not accessable by guest user",groups= {"guest"})
	public void guestNotificationButtonCheck() {
		channel.clickNotification();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=2, description="Channel Description Page Testcase 02: Check search is accessable by guest user",groups= {"guest"})
	public void searchButtonCheck() {
		channel.clickSearch();
		channel.checkTitle("searchPageTitle","Popular Search");
	}
	
	@Test(priority=3, description="Channel Description Page Testcase 03: Check subscribe button click take guest user to login page",groups= {"guest"})
	public void guestSubscribeButtonCheck() {
		channel.clickSubscribe();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=4, description="Channel Description Page Testcase 04: Check guest user can share general video from channel description page",groups= {"guest"})
	public void guestShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	
	@Test(priority=5, description="Channel Description Page Testcase 05: Check guest user can share premium video from channel description page",groups= {"guest"})
	public void guestShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	
	@Test(priority=6, description="Channel Description Page Testcase 06: Check guest user can not add general video to favourite  from channel description page",groups= {"guest"})
	public void guestAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=7, description="Channel Description Page Testcase 07: Check guest user can not add premium video to favourite  from channel description page",groups= {"guest"})
	public void guestAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=8, description="Channel Description Page Testcase 8: Check guest user can not report general video from channel description page",groups= {"guest"})
	public void guestReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=9, description="Channel Description Page Testcase 9: Check guest user can not report premium video from channel description page",groups= {"guest"})
	public void guestReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=10, description="Channel Description Page Testcase 10: Check guest user can play general video from channel description page",groups= {"guest"})
	public void guestGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle","Related Videos");
	}
	
	@Test(priority=11, description="Channel Description Page Testcase 11: Check guest user can not  play premium video from channel description page",groups= {"guest"})
	public void guestPremiumVideoPlayCheck() throws InterruptedException {
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=12, description="Channel Description Page Testcase 12: Check guest user can share general video from playlist",groups= {"guest"})
	public void guestPlaylistGeneralShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=13, description="Channel Description Page Testcase 13: Check guest user cannot add video to favourite from playlist",groups= {"guest"})
	public void guestPlaylistPremiumShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=14, description="Channel Description Page Testcase 14: Check guest user can not add general video to favourite from playlist",groups= {"guest"})
	public void guestPlaylistGeneralFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=15, description="Channel Description Page Testcase 15: Check guest user can not add premium video to favourite from playlist",groups= {"guest"})
	public void guestPlaylistPremiumFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=16, description="Channel Description Page Testcase 16: Check guest user can not report general video from playlist",groups= {"guest"})
	public void guestPlaylistGeneralReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=17, description="Channel Description Page Testcase 17: Check guest user can not report premium video from playlist",groups= {"guest"})
	public void guestPlaylistPremiumReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	
	@Test(priority=18, description="Channel Description Page Testcase 18: Check guest user can play general video from playlist",groups= {"guest"})
	public void guestGeneralVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle","Playlist Videos");
	}
	
	@Test(priority=19, description="Channel Description Page Testcase 19: Check guest user can not  play premium video from playlist",groups= {"guest"})
	public void guestPremiumVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=20, description="Channel Description Page Testcase 20: Check notification is accessable by general user",groups= {"general"})
	public void generalUserNotificationButtonCheck() {
		channel.clickNotification();
		channel.checkTitle("notificationPageTitle","Notifications");
	}
	
	@Test(priority=21, description="Channel Description Page Testcase 21: Check general user can subscribe channel from channel description page",groups= {"general"})
	public void generalUserSubscribeButtonCheck() {
		channel.clickSubscribe();
		channel.checkTitle("subscribeButtonTitle","Subscribed");
	}
	@Test(priority=22, description="Channel Description Page Testcase 22: Check general user can unsubscribe channel from channel description page",groups= {"general"})
	public void generalUserUnSubscribeButtonCheck() throws InterruptedException {
		channel.clickUnSubscribe();
		channel.checkTitle("subscribeButtonTitle","Subscribe");
	}
	@Test(priority=23, description="Channel Description Page Testcase 23: Check general user can share general video from channel description page",groups= {"general"})
	public void generalUserShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	
	@Test(priority=24, description="Channel Description Page Testcase 24: Check general user can share premium video from channel description page",groups= {"general"})
	public void generalUserShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	@Test(priority=25, description="Channel Description Page Testcase 25: Check general user can  add general video to favourite  from channel description page",groups= {"general"})
	public void generalUserAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton"," Remove from Favorite");
	}
	
	@Test(priority=26, description="Channel Description Page Testcase 26: Check general user can not add premium video to favourite  from channel description page",groups= {"general"})
	public void generalUserAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}

	@Test(priority=27, description="Channel Description Page Testcase 27: Check general user can report general video from channel description page",groups= {"general"})
	public void generalUserReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton","Already Reported");
	}
	
	@Test(priority=28, description="Channel Description Page Testcase 28: Check general user can not report premium video from channel description page",groups= {"general"})
	public void generalUserReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=29, description="Channel Description Page Testcase 29: Check general user can play general video from channel description page",groups= {"general"})
	public void generalUserGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle","Related Videos");
	}
	
	@Test(priority=30, description="Channel Description Page Testcase 30: Check general user can not  play premium video from channel description page",groups= {"general"})
	public void generalUserPremiumVideoPlayCheck() throws InterruptedException {
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=31, description="Channel Description Page Testcase 31: Check general user can share general video from playlist",groups= {"general"})
	public void generalUserPlaylistGeneralShareCheck() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=32, description="Channel Description Page Testcase 32: heck general user can share premium video from playlist",groups= {"general"})
	public void generalUserPlaylistPremiumShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=33, description="Channel Description Page Testcase 33: Check guest user can not add general video to favourite from playlist",groups= {"general"})
	public void generalUserPlaylistGeneralFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton"," Remove from Favorite");
	}
	
	@Test(priority=34, description="Channel Description Page Testcase 34: Check guest user can not add premium video to favourite from playlist",groups= {"general"})
	public void generalUserPlaylistPremiumFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=35, description="Channel Description Page Testcase 35: Check general user can report general video from playlist",groups= {"general"})
	public void generalUserPlaylistGeneralReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton","Already Reported");
	}
	
	@Test(priority=36, description="Channel Description Page Testcase 36: Check general user can not report premium video from playlist",groups= {"general"})
	public void generalUserPlaylistPremiumReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	
	@Test(priority=37, description="Channel Description Page Testcase 37: Check general user can play general video from playlist",groups= {"general"})
	public void generalUserGeneralVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle","Playlist Videos");
	}
	
	@Test(priority=38, description="Channel Description Page Testcase 38: Check general user can not  play premium video from playlist",groups= {"general"})
	public void generalUserPremiumVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=39, description="Channel Description Page Testcase 39: Check notification is accessable by premium user",groups= {"premium"})
	public void premiumUserNotificationButtonCheck() {
		channel.clickNotification();
		channel.checkTitle("notificationPageTitle","Notifications");
	}
	
	@Test(priority=40, description="Channel Description Page Testcase 40: Check premium user can subscribe channel from channel description page",groups= {"premium"})
	public void premiumUserSubscribeButtonCheck() {
		channel.clickSubscribe();
		channel.checkTitle("subscribeButtonTitle","Subscribed");
	}
	@Test(priority=41, description="Channel Description Page Testcase 41: Check premium user can unsubscribe channel from channel description page",groups= {"premium"})
	public void premiumUserUnSubscribeButtonCheck() throws InterruptedException {
		channel.clickUnSubscribe();
		channel.checkTitle("subscribeButtonTitle","Subscribe");
	}
	@Test(priority=42, description="Channel Description Page Testcase 42: Check premium user can share general video from channel description page",groups= {"premium"})
	public void premiumUserShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	
	@Test(priority=43, description="Channel Description Page Testcase 43: Check premium user can share premium video from channel description page",groups= {"premium"})
	public void premiumUserShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	@Test(priority=44, description="Channel Description Page Testcase 44: Check premium user can  add general video to favourite  from channel description page",groups= {"premium"})
	public void premiumUserAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton"," Remove from Favorite");
	}
	
	@Test(priority=45, description="Channel Description Page Testcase 45: Check premium user can add premium video to favourite  from channel description page",groups= {"premium"})
	public void premiumUserAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton"," Remove from Favorite");
	}

	@Test(priority=46, description="Channel Description Page Testcase 46: Check premium user can report general video from channel description page",groups= {"premium"})
	public void premiumUserReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton","Already Reported");
	}
	
	@Test(priority=47, description="Channel Description Page Testcase 47: Check premium user can report premium video from channel description page",groups= {"premium"})
	public void premiumUserReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton","Already Reported");
	}
	
	@Test(priority=48, description="Channel Description Page Testcase 48: Check premium user can play general video from channel description page",groups= {"premium"})
	public void premiumUserGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle","Related Videos");
		channel.stopVideo();
//		Thread.sleep(5000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("//android.widget.Button[2]")).click();
	}
	
	@Test(priority=49, description="Channel Description Page Testcase 49: Check premium user can play premium video from channel description page",groups= {"premium"})
	public void premiumUserPremiumVideoPlayCheck() throws InterruptedException {
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle","Related Videos");
		channel.stopVideo();
	}
	
	@Test(priority=50, description="Channel Description Page Testcase 50: Check premium user can share general video from playlist",groups= {"premium"})
	public void premiumUserPlaylistGeneralShareCheck() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=51, description="Channel Description Page Testcase 51: check premium user can share premium video from playlist",groups= {"premium"})
	public void premiumUserPlaylistPremiumShareCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=52, description="Channel Description Page Testcase 52: Check premium user can add general video to favourite from playlist",groups= {"premium"})
	public void premiumUserPlaylistGeneralFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton"," Remove from Favorite");
	}
	
	@Test(priority=53, description="Channel Description Page Testcase 53: Check premium user can add premium video to favourite from playlist",groups= {"premium"})
	public void premiumUserPlaylistPremiumFavouriteCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.clickElipsis();
		channel.checkTitle("addFavouriteButton"," Remove from Favorite");
	}
	
	@Test(priority=54, description="Channel Description Page Testcase 54: Check premium user can report general video from playlist",groups= {"premium"})
	public void premiumUserPlaylistGeneralReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton","Already Reported");
	}
	
	@Test(priority=55, description="Channel Description Page Testcase 55: Check premium user can report premium video from playlist",groups= {"premium"})
	public void premiumUserPlaylistPremiumReportCheck() throws InterruptedException {

		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.report();
		channel.clickElipsis();
		channel.checkTitle("reportButton","Already Reported");
	}
	
	
	@Test(priority=56, description="Channel Description Page Testcase 56: Check premium user can play general video from playlist",groups= {"premium"})
	public void premiumUserGeneralVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle","Playlist Videos");
		channel.stopVideo();
	}
	
	@Test(priority=57, description="Channel Description Page Testcase 57: Check premium user can play premium video from playlist",groups= {"premium"})
	public void premiumUserPremiumVideoPlayCheckFromPlaylist() throws InterruptedException {
		channel.clickPlaylistTab();
		channel.clickPlaylist();
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("playlistPlayerPageTitle","Playlist Videos");
		channel.stopVideo();
	}
}
