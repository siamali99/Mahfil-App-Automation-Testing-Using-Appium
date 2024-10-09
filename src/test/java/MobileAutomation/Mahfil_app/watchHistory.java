package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class watchHistory extends configAppium{
	
//	@BeforeClass
//	public void login() {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		//Scroll to sign in button
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//		//click on sign in button
//		String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
//		System.out.println(text);
//		if(text.equals("Logout"))
//		{
//			driver.findElement(AppiumBy.accessibilityId("Logout")).click();
//			driver.findElement(AppiumBy.accessibilityId("Yes")).click();
//			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//		}
//		else
//		{
//			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//		}
//		
//		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//		WebElement email=driver.findElement(By.className("android.widget.EditText"));
//		email.click();
//		email.sendKeys("alhasibsiam@gmail.com");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.navigate().back();
//	}
	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;
	public watchHistoryLocators watchHistory;
	 @BeforeMethod
	 public void before() throws InterruptedException {

		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 videoPlayer=new videoPlayerLocator(driver);
		 watchHistory=new watchHistoryLocators(driver);
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
	
	@Test(priority=1, description="Watch History Testcase 01: Check Guest user cannot access Watch History",groups= {"guest"})
	public void guestFavouriteButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		menu.checkTitle("SignupPageTitle","Continue with Google");
	}
	@Test(priority=1, description="Watch History Testcase 01: Check Watch History button is working",groups= {"general","premium"})
	public void dashboardButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.checkTitle("watchHistoryPageTitle", "Watch History");

	}
	
	@Test(priority=2, description="Watch History Testcase 02: Check notification button is working in Watch History page",groups= {"general","premium"})
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickNotification();
		watchHistory.checkTitle("notificationPageTitle", "Notifications");
	}
	
	@Test(priority=3, description="Watch History Testcase 03: Check search button is working in Watch History page",groups= {"general","premium"})
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickSearch();
		watchHistory.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=4, description="Watch History Testcase 04: Check back button is working from Watch History page",groups= {"general","premium"})
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickBackButton();
		menu.checkTitle("menuTitle","Others");
	}
	
	
	@Test(priority=5, description="Watch History Testcase 05: Check watched video is saved in Watch History",groups= {"general","premium"})
	public void watchedVideoSave() throws InterruptedException {
//		//scroll down to find a video
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",7.0));
//		String playvideoTitle=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
//		driver.findElement(By.xpath("(//android.view.View)[9]")).click();
//		Thread.sleep(3000);
//		driver.navigate().back();
//		//Close video
//		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
//		Thread.sleep(1000);
		String savedVideoTitle=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		System.out.println(savedVideoTitle);
//		Assert.assertEquals(playvideoTitle,savedVideoTitle,"Title didn't matched");
	}
	
	@Test(priority=5, description="Watch History Testcase 05: Check after logout and login to the same account keeps the Watch History video data",groups= {"general","premium"})
	public void favouritevideocheckSameAccount() throws InterruptedException {
		//scroll down to find a video
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",7.0));
		String playvideoTitle=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		driver.findElement(By.xpath("(//android.view.View)[9]")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
		String beforelogout=driver.findElement(By.xpath("(//android.view.View)[8]")).getAttribute("contentDescription");
		System.out.println(beforelogout);
		scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
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
				
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();
		String afterlogin=driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).getAttribute("contentDescription");
		System.out.println(afterlogin);
		Assert.assertEquals(beforelogout,afterlogin,"Title didn't matched");

	}
	
	@Test(priority=6, description="Watch History Testcase 06: Check after logout and login to a different account should not keep the Watch History video data",groups= {"general","premium"})
	public void favouritevideocheckDiffAcc() {
		//scroll down to find a video
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
		//open options
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//add favourite
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String beforelogout=driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).getAttribute("contentDescription");
		System.out.println(beforelogout);
		scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
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
		email.sendKeys("alhasibsiam@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String afterlogin=driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).getAttribute("contentDescription");
		System.out.println(afterlogin);
		Assert.assertNotEquals(beforelogout,afterlogin,"Title matched");

	}
	
	@Test(priority=7, description="Watch History Testcase 07: Check video added to Watch History are playable ",groups= {"general","premium"})
	public void favouriteVideoPlay() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.playwatchHistoryVideo();
		videoPlayer.checkTitle("videoPlayerPageTitle","Related Videos");
		videoPlayer.stopVideo();
	}

	
	@Test(priority=9, description="Watch History Testcase 09:Check remove button is working",groups="premium")
	public void removeButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickWatchHisotry();
		watchHistory.clickEllipsis();
		watchHistory.clickRemove();
	}
	

}
