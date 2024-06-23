package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	@Test(priority=1, description="Subscribed Channel Testcase 01: Check Subscribed Channel button is working",groups= {"general","premium"})
	public void subscribedChannelButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Subscribed Channels";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Subscribed Channel Testcase 02: Check notification button is working in Subscribed Channel page",groups= {"general","premium"})
	public void notificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Notifications";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=3, description="Subscribed Channel Testcase 03: Check search button is working in Subscribed Channel page",groups= {"general","premium"})
	public void searchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=4, description="Subscribed Channel Testcase 04: Check back button is working from Subscribed Channel page",groups= {"general","premium"})
	public void backButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Others";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=5, description="Subscribed Channel Testcase 05: Check subscribed channe is shown in Subscribed Channel page",groups= {"general","premium"})
	public void subscriptionChannelCheck() {
		String actualTitle=driver.findElement(By.xpath("(//android.view.View)[15]")).getAttribute("contentDescription");
		System.out.println(actualTitle);
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Yes")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		String foundTitle=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(foundTitle);
		Assert.assertEquals(actualTitle,foundTitle,"Title didn't matched");
	}

	
	@Test(priority=6, description="Subscribed Channel Testcase 05: Check channel unsubscribe is working in Subscribed Channel page",groups= {"general","premium"})
	public void unsubscribeChannelCheck() {


		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String actualTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).getAttribute("contentDescription");
		System.out.println(actualTitle);
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"Subscribed\"])[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Yes")).click();
		driver.navigate().back();
		String foundTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).getAttribute("contentDescription");
		System.out.println(foundTitle);
		Assert.assertNotEquals(actualTitle,foundTitle,"Title  matched");
	}
	
	
}
