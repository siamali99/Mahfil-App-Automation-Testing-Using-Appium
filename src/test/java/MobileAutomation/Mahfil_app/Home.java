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

public class Home extends configAppium{
	public homePageLocators home;
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
	 public void before() {
		 home=new homePageLocators(driver);
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
	

	
	@Test(priority=1, description="Home Testcase 01: Check menu section is opening",groups= {"all"})
	public void menuButtonCheck() {
//		homePageLocators home=new homePageLocators(driver);
		home.clickMenu();
		home.checkTitle("menuPageTitle","Others");
	}
	
	@Test(priority=2, description="Home Testcase 02: Check notification is not accessable",groups= {"guest"})
	public void notificationButtonCheck() {
		home.clickNotification();
		//passing exoected page and page title
		home.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	
	@Test(priority=3, description="Home Testcase 03: Check search is accessable",groups= {"guest"})
	public void searchButtonCheck() {
		home.clickSearch();
		home.checkTitle("searchPageTitle","Popular Search");
	}
	
	@Test(priority=4, description="Home Testcase 04: Check channel is opening from channel logo click",groups= {"guest"})
	public void channelLogoCheck() throws InterruptedException {
		String title=home.checkClickedPopularChannelName();
		home.clickPopularChannel();
		home.checkTitle("channelPageTitle",title);
	}
	
	@Test(priority=5, description="Home Testcase 05: Check subscribe button click taking guest user to login page",groups= {"guest"})
	public void guestSubscribeButtonCheck() throws InterruptedException {
		home.clickSubscribe();
		home.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	
	@Test(priority=6, description="Home Testcase 06: Check video is shareable as a guest user",groups= {"guest"})
	public void guestShareButtonCheck() throws InterruptedException {
		home.Scroll(8);
		home.clickElipsis();
		home.clickShare();
		home.checkTitle("sharePageTitle","Sharing link");
		}
	
	@Test(priority=7, description="Home Testcase 07: Check ad video favourite is not working as a guest user",groups= {"guest"})
	public void guestAdFavButtonCheck() throws InterruptedException {
//		home.Scroll(8);
		home.clickElipsis();
		home.clickFavourite();
		home.checkTitle("SignupPageTitle","Continue with Google");
		}
	
	@Test(priority=8, description="Home Testcase 08: Check video report is not working as a guest user",groups= {"guest"})
	public void guestReportButtonCheck() throws InterruptedException {
//		home.Scroll(8);
		home.clickElipsis();
		home.clickReport();
		home.checkTitle("SignupPageTitle","Continue with Google");
		}
	
	@Test(priority=9, description="Home Testcase 09: Check premium video is not playable as a guest user",groups= {"guest"})
	public void guestPremiumVideoPlay() throws InterruptedException {
		home.playPremiumVideo();
		home.checkTitle("SignupPageTitle","Continue with Google");
	
	}
	
	@Test(priority=10, description="Home Testcase 10: Check general video is playable as a guest user",groups= {"guest"})
	public void guestGeneralVideoPlay() throws InterruptedException {
		home.playGeneralVideo();
		home.checkTitle("SignupPageTitle","Continue with Google");
	
	}
	
	
	
//	@Test(priority=1, description="Access menu options as signout user")
//	public void navigate_menu() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
//	}
//	
//	@Test(priority=2 ,description="Header notification,search and menu button check")
//	public void headerbuttoncheck() throws InterruptedException {
////		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//	}
//	
//	@Test(priority=3, description="Subscribe and unsubscribe from popular channel")
//	public void subscriptionbutton() {
//		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribe\"])[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribe\"])[2]")).click();
////		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribe\"])[3]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribed\"])[1]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Yes")).click();
//	}
//	
//	@Test(priority=4, description="Open salat reminder page from home page and return to home page")
//	public void prayerbuttoncheck() {
//		driver.findElement(AppiumBy.accessibilityId("All prayer times")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		
//	}
//	
//	@Test(priority=5, description="add favourite,share, report from home")
//	public void videoOptionCheck() {
//		//scroll down to find a video
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		//add favourite
//		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		//click Share and copy link
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Copy")).click();
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		//click report choose others and report button click
//		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Others")).click();
//		WebElement otherbox=driver.findElement(By.className("android.widget.EditText"));
//		otherbox.click();
//		otherbox.sendKeys("This is not good");
//		driver.navigate().back();
//		driver.findElement(AppiumBy.accessibilityId("Report")).click();
//
//		
//	}
//	
//	@Test(priority=6, description="Scroll down and play a video")
//	public void scrollandplay() throws InterruptedException {
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//
//		driver.findElement(By.xpath("(//android.view.View)[2]")).click();
//		Thread.sleep(5000);
//		driver.navigate().back();
//		}
//	@Test(priority=7, description="Check add subscribed channel and add favourites video")
//	public void checkaddfavouriteandsub() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
//	}
//	@Test
//	public void home() {
//		
//		while(true)
//		{
//			String test=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("bounds");
//			if(test.equals("[476,181][964,305]"))
//					{
//				break;
//					}
//			else
//			{
//				driver.navigate().back();
//			}
//	
//			
//		}
//
//	}
	
}
