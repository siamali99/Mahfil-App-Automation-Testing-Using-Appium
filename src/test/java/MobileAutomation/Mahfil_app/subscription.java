package MobileAutomation.Mahfil_app;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class subscription extends configAppium{
	
//	 @BeforeGroups(value = "premium")
//	    public void premiumLogin() {
//			driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//			//Scroll to sign in button
//			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//			//click on sign in button
//			String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
//			System.out.println(text);
//			if(text.equals("Logout"))
//			{
//				driver.findElement(AppiumBy.accessibilityId("Logout")).click();
//				driver.findElement(AppiumBy.accessibilityId("Yes")).click();
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			else
//			{
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			
//			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//			WebElement email=driver.findElement(By.className("android.widget.EditText"));
//			email.click();
//			email.sendKeys("premium.mahfil@gmail.com");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.navigate().back();
//	 }
//	 
//	 @BeforeGroups(value = "general")
//	 public void generalLogin() {
//			driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//			//Scroll to sign in button
//			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//			//click on sign in button
//			String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
//			System.out.println(text);
//			if(text.equals("Logout"))
//			{
//				driver.findElement(AppiumBy.accessibilityId("Logout")).click();
//				driver.findElement(AppiumBy.accessibilityId("Yes")).click();
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			else
//			{
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			
//			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//			WebElement email=driver.findElement(By.className("android.widget.EditText"));
//			email.click();
//			email.sendKeys("general.mahfil@gmail.com");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.navigate().back();
//	 }
	 
		public menuPageLocators menu;
		public homePageLocators home;
		public subscriptionLocator subscription;

		 @BeforeMethod
	public void before() throws InterruptedException {
		menu=new menuPageLocators(driver);
		home=new homePageLocators(driver);
		subscription=new subscriptionLocator(driver);
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
	
	@Test(priority=1, description="Subscription Testcase 01: Check Subscription button is working",groups= {"general"})
	public void subscriptionButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.checkTitle("subscriptionPageTitle", "Subscription");
	}
	
	@Test(priority=2, description="Subscription Testcase 02: Check notification button is working in Subscription page",groups= {"general"})
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.clickNotification();
		subscription.checkTitle("notificationPageTitle", "Notifications");
	}
	
	@Test(priority=3, description="Subscription Testcase 03: Check search button is working in Subscription page",groups= {"general"})
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.clickSearch();
		subscription.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=4, description="Subscription Testcase 04: Check back button is working from Subscription page",groups= {"general"})
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.clickBackButton();
		menu.checkTitle("menuTitle","Others");
	}
	
	@Test(priority=5, description="Subscription Testcase 05: Check buy premium button is showing in Subscription page",groups= {"general"})
	public void premiumButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.checkTitle("buyPremiumButton", "প্রিমিয়াম কিনুন");
	}
	
	@Test(priority=6, description="Subscription Testcase 06: Check buy premium button is working in Subscription page",groups= {"general"})
	public void premiumBuyURLCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.buyPremium();
//		String url=driver.getCurrentUrl();
//		System.out.println(url);
		Thread.sleep(2000);
		System.out.println("Visited Premium buy page");

	}
	
	@Test(priority=7, description="Subscription Testcase 07: Check subscribed package is showing in Subscription page",groups= {"premium"})
	public void premiumCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscription();
		subscription.checkTitle("packageInfo", "Yearly Package - BDT");
	}
}
