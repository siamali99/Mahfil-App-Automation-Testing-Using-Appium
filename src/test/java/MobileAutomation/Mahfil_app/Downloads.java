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

	private AndroidDriver androidDriver;
	 @BeforeGroups(value = "general")
	    public void beforeGeneral() {
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
	 
	 @BeforeGroups(value = "premium")
	 public void beforePremium() {
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
	public void downloadButtonCheck_general() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		String pageTitle=driver.findElement(By.xpath("//android.widget.Button")).getAttribute("contentDescription");
		System.out.println(pageTitle);
		String expectedTitle="আজই প্রিমিয়াম কিনুন";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Download Testcase 02:Check premium popup close button is working in downloads",groups="general")
	public void premiumcloseButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
//		System.out.println(pageTitle);
		String expectedTitle="Others";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=3, description="Download Testcase 03:Check premium users can access downloads",groups="premium")
	public void dashboardButtonCheck_premium() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		System.out.println(pageTitle);
		String expectedTitle="Downloaded Videos";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=4, description="Download Testcase 04:Check downloaded video saved on downloads",groups="premium")
	public void downloadCheck() throws InterruptedException {
		//Scroll down and download a video
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",6.0));
//		String playvideoTitle=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		driver.findElement(By.xpath("(//android.view.View)[9]")).click();
		Thread.sleep(4000);
		//video pause 
		driver.findElement(By.xpath("(//android.view.View)[18]")).click();
		Thread.sleep(500);
		driver.findElement(AppiumBy.accessibilityId("DOWNLOAD")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		Thread.sleep(1000);
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		System.out.println("Video downloaded");
//		String videoTitle=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
//		System.out.println(videoTitle);
//		Assert.assertEquals(playvideoTitle,videoTitle,"Title didn't matched");
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
	}
	
	@Test(priority=5, description="Download Testcase 05:Check downloaded video is playable",groups="premium")
	public void downloadvideoplaycheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		System.out.println("Video played");
	}
	
	@Test(priority=6, description="Download Testcase 06:Check downloaded video is playable in offline",groups="premium")
	public void offlinedownloadvideoplaycheck() throws InterruptedException {
//		androidDriver = (AndroidDriver) driver;
//        androidDriver.openNotifications();
//        Thread.sleep(2000);
        ((AndroidDriver) driver).toggleWifi();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("See Downloaded videos")).click();
        driver.findElement(By.xpath("(//android.view.View)[8]")).click();
        ((AndroidDriver) driver).toggleWifi();
        Thread.sleep(5000);
        System.out.println("downloaded video played offline");

	}
	
	@Test(priority=7, description="Download Testcase 07:Check ellipsis button is working",groups="premium")
	public void ellipsisButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String actualTitle=driver.findElement(By.xpath("(//android.widget.Button)[1]")).getAttribute("contentDescription");
		System.out.println(actualTitle);
		String expectedTitle="Remove";
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");
		driver.navigate().back();

	}
	
	@Test(priority=8, description="Download Testcase 08:Check remove button is working",groups="premium")
	public void removeButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
//		String actualTitle=driver.findElement(By.xpath("(//android.widget.Button)[1]")).getAttribute("contentDescription");
		System.out.println("Video removed");


	}
	
	

}
