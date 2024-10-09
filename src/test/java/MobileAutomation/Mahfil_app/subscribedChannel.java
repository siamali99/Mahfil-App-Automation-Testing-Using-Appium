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
import io.netty.util.internal.SystemPropertyUtil;

public class subscribedChannel extends configAppium{
	
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
	public subscribedChannelLocators subscribedChannel;
	 @BeforeMethod
	 public void before() throws InterruptedException {

		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 subscribedChannel=new subscribedChannelLocators(driver);
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
	
	@Test(priority=1, description="Subscribed Channel Testcase 01: Check Guest user cannot access Subscribed Channel",groups= {"guest"})
	public void guestFavouriteButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		menu.checkTitle("SignupPageTitle","Continue with Google");
	} 
	
	@Test(priority=2, description="Subscribed Channel Testcase 02 Check Subscribed Channel button is working",groups= {"general","premium"})
	public void subscribedChannelButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.checkTitle("subscribedChannelPageTitle", "Subscribed Channels");
	}
	
	@Test(priority=3, description="Subscribed Channel Testcase 03: Check notification button is working in Subscribed Channel page",groups= {"general","premium"})
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickNotification();
		subscribedChannel.checkTitle("notificationPageTitle", "Notifications");
	}
	
	@Test(priority=4, description="Subscribed Channel Testcase 04: Check search button is working in Subscribed Channel page",groups= {"general","premium"})
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickSearch();
		subscribedChannel.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=5, description="Subscribed Channel Testcase 05: Check back button is working from Subscribed Channel page",groups= {"general","premium"})
	public void backButtonCheck() throws InterruptedException {
		
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickBackButton();
		menu.checkTitle("menuTitle","Others");
	}
	
	@Test(priority=6, description="Subscribed Channel Testcase 06: Check subscribed channe is shown in Subscribed Channel page",groups= {"general","premium"})
	public void subscriptionChannelCheck() throws InterruptedException {
		home.clickSubscribe();
		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickBackButton();
		menu.checkTitle("subscribedChannelButton","Subscribed Channel\n"
				+ "1 Channels");
	}

	
	@Test(priority=7, description="Subscribed Channel Testcase 07: Check channel unsubscribe is working in Subscribed Channel page",groups= {"general","premium"})
	public void unsubscribeChannelCheck() throws InterruptedException {

		home.clickMenu();
		menu.clickSubscribedChannel();
		subscribedChannel.clickSubscribed();
		subscribedChannel.checkTitle("emptysubscribedChannelPageTitle", "Subscribed channel will appear here!");

	}
	
	
}
