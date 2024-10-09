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

public class Downloads extends configAppium{

//	private AndroidDriver androidDriver;
//	 @BeforeGroups(value = "general")
//	    public void beforeGeneral() {
// 		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
// 		//Scroll to sign in button
// 		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
// 		//click on sign in button
// 		String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
// 		System.out.println(text);
// 		if(text.equals("Logout"))
// 		{
// 			
// 			driver.findElement(AppiumBy.accessibilityId("Logout")).click();
// 			driver.findElement(AppiumBy.accessibilityId("Yes")).click();
// 			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
// 		}
// 		else
// 		{
// 			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
// 		}
//		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//		WebElement email=driver.findElement(By.className("android.widget.EditText"));
//		email.click();
//		email.sendKeys("general.mahfil@gmail.com");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.navigate().back();
//	 }
//	 
//	 @BeforeGroups(value = "premium")
//	 public void beforePremium() {
//		 driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
// 		//Scroll to sign in button
// 		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
// 		//click on sign in button
// 		String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
// 		System.out.println(text);
// 		if(text.equals("Logout"))
// 		{
// 			driver.findElement(AppiumBy.accessibilityId("Logout")).click();
// 			driver.findElement(AppiumBy.accessibilityId("Yes")).click();
// 			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
// 		}
// 		else
// 		{
// 			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
// 		}
// 		
//		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//		WebElement email=driver.findElement(By.className("android.widget.EditText"));
//		email.click();
//		email.sendKeys("premium.mahfil@gmail.com");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.navigate().back();
//	 }
	public downloadLocators download;
	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;
	 @BeforeMethod
	 public void before() throws InterruptedException {
		 download=new downloadLocators(driver);
		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 videoPlayer=new videoPlayerLocator(driver);
		 Thread.sleep(200);
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
	@Test(priority=1, description="Download Testcase 01:Check generel users can't access downloads",groups="general")
	public void downloadButtonCheckguest() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		menu.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=2, description="Download Testcase 01:Check generel users can't access downloads",groups="general")
	public void downloadButtonCheck_general() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		menu.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=3, description="Download Testcase 02:Check premium popup close button is working in downloads",groups="general")
	public void premiumcloseButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		menu.closePremiumPopUp();
		menu.checkTitle("menuTitle","Others");
	}
	
	@Test(priority=4, description="Download Testcase 03:Check premium users can access downloads",groups="premium")
	public void dashboardButtonCheck_premium() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		download.checkTitle("downloadPageTitle", "Downloaded Videos");

	}
	
	@Test(priority=5, description="Download Testcase 04:Check downloaded video saved on downloads",groups="premium")
	public void downloadCheck() throws InterruptedException {
		
		home.findGeneralVideo();
		home.playVideo();
		videoPlayer.downloadVideo();
		videoPlayer.stopVideo();
		home.clickMenu();
		menu.checkTitle("downloadButton","Downloads\n"
				+ "1 videos Downloaded");
	}
	
	@Test(priority=6, description="Download Testcase 05:Check downloaded video is playable",groups="premium")
	public void downloadvideoplaycheck() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		download.playDownloadedVideo();
		videoPlayer.checkTitle("videoPlayerPageTitle","Related Videos");

	}
	
	@Test(priority=7, description="Download Testcase 06:Check downloaded video is playable in offline",groups="premium")
	public void offlinedownloadvideoplaycheck() throws InterruptedException {
		download.toggleInternet();
		download.clickSeeDownloadedVideo();
		download.playDownloadedVideo();
		download.toggleInternet();
	
	}
	
	
	@Test(priority=8, description="Download Testcase 08:Check remove button is working",groups="premium")
	public void removeButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickDownload();
		download.clickEllipsis();
		download.clickRemove();
		Thread.sleep(1000);
//		menu.checkTitle("emptyDownloadPageTitle","Videos you download will appear here!");
		
	}
	
	

}
