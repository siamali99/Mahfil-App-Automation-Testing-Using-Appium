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

public class favourites extends configAppium{
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
//		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
//		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();
//		driver.navigate().back();
//	}
	
	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;

	public favouriteLocator favourite;
	 @BeforeMethod
	 public void before() throws InterruptedException {

		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 favourite=new favouriteLocator(driver);
		 videoPlayer= new videoPlayerLocator(driver);
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
	@Test(priority=1, description="Favourite Testcase 01: Check Guest user cannot access favourite",groups= {"guest"})
	public void guestFavouriteButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickFavourite();
		menu.checkTitle("SignupPageTitle","Continue with Google");
	}
	@Test(priority=2, description="Favourite Testcase 02: Check favourite button is working",groups= {"general","premium"})
	public void dashboardButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickFavourite();
		favourite.checkTitle("favouritePageTitle", "Favourite Videos");
	}
	
	@Test(priority=3, description="Favourite Testcase 03: Check notification button is working in favourite page",groups= {"general","premium"})
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickFavourite();
		favourite.clickNotification();
		favourite.checkTitle("notificationPageTitle", "Notifications");
	}
	
	@Test(priority=4, description="Favourite Testcase 04: Check search button is working in favourite page",groups= {"general","premium"})
	public void searchButtonCheck() throws InterruptedException {
		
		home.clickMenu();
		menu.clickFavourite();
		favourite.clickSearch();
		favourite.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=5, description="Favourite Testcase 05: Check back button is working from favourite page",groups= {"general","premium"})
	public void backButtonCheck() throws InterruptedException {
		
		home.clickMenu();
		menu.clickFavourite();
		favourite.clickBackButton();
		menu.checkTitle("menuTitle","Others");
	}
	
	@Test(priority=6, description="Favourite Testcase 06: Check after logout and login to the same account keeps the favourite video data",groups= {"general","premium"})
	public void favouritevideocheckSameAccount() {
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
				
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();
		String afterlogin=driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).getAttribute("contentDescription");
		System.out.println(afterlogin);
		Assert.assertEquals(beforelogout,afterlogin,"Title didn't matched");

	}
	
	@Test(priority=7, description="Favourite Testcase 07: Check after logout and login to a different account should not keep the favourite video data",groups= {"general","premium"})
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
	
	@Test(priority=8, description="Favourite Testcase 08: Check video added to favourites are playable ",groups= {"general","premium"})
	public void favouriteVideoPlay() throws InterruptedException {
		
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.clickMenu();
		menu.clickFavourite();
		favourite.playFavouriteVideo();
//		videoPlayer.checkTitle("videoPlayerPageTitle","Related Videos");
//		videoPlayer.stopVideo();
	}

	
	@Test(priority=9, description="Favourite Testcase 09:Check remove button is working",groups="premium")
	public void removeButtonCheck() throws InterruptedException {
		
		home.clickMenu();
		menu.clickFavourite();
		favourite.clickEllipsis();
		favourite.clickRemove();
		favourite.checkTitle("emptyFavouritePageTitle","There are no favorites yet!");

		
	}
	
	
	
}
