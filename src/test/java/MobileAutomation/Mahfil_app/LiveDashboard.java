package MobileAutomation.Mahfil_app;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LiveDashboard extends configAppium{
	
	
	@BeforeClass
	public void login() {
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
		
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();
		driver.navigate().back();
	}
	
	

	@BeforeMethod
	public void Menu() {
//		System.out.println("before class");
//		driver.findElement(AppiumBy.accessibilityId("Home Tab 1 of 5")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
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
	
	
	@Test(priority=1, description="Livedashboard Testcase 01: Check live dashboard button is working",groups= {"general","premium"})
	public void dashboardButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Live Dashboard";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Livedashboard Testcase 02: Check notification button is working in live dashboard page",groups= {"general","premium"})
	public void notificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Notifications";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=3, description="Livedashboard Testcase 03: Check search button is working in live dashboard page",groups= {"general","premium"})
	public void searchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=4, description="Livedashboard Testcase 04: Check back button is working from live dashboard page",groups= {"general","premium"})
	public void backButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Others";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=5, description="Livedashboard Testcase 05: Check channel is opening from live dashboard on logo click",groups= {"general","premium"})
	public void channelLogoCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.view.View)[9]")).click();
		String pagebounds=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("bounds");
		String expectedbounds="[252,201][1067,282]";
		Assert.assertEquals(pagebounds,expectedbounds,"Bounds didn't matched");
	}
	
	@Test(priority=6, description="Livedashboard Testcase 06: Check channel is opening from live dashboard on channel name click",groups= {"general"})
	public void channelNameCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		String pagebounds=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("bounds");
		String expectedbounds="[252,201][1067,282]";
		Assert.assertEquals(pagebounds,expectedbounds,"Bounds didn't matched");
	}
	
	@Test(priority=7, description="Livedashboard Testcase 07: Check video is playing from live dashboard on click",groups= {"general"})
	public void LiveVideoCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		Thread.sleep(2000);
		//comparing live video header details bounds
		String pagebounds=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("bounds");
		String expectedbounds="[572,200][883,263]";
		Assert.assertEquals(pagebounds,expectedbounds,"Bounds didn't matched");
	}
	
	@Test(priority=8, description="Livedashboard Testcase 08: Check subscribe button is working in live dashboard",groups= {"general","premium"})
	public void subscribeButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(2000);

		String buttonname=driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).getAttribute("contentDescription");
		String expectedname="Subscribed";
		Assert.assertEquals(buttonname,expectedname,"Subscribe button name didn't matched, button not working");
	}
	
	@Test(priority=9, description="Livedashboard Testcase 09: Check unsubscribe button is working in live dashboard",groups= {"general","premium"})
	public void unsubscribeButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(AppiumBy.accessibilityId("Yes")).click();
		Thread.sleep(2000);
	
		String buttonname=driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).getAttribute("contentDescription");
		String expectedname="Subscribe";
		Assert.assertEquals(buttonname,expectedname,"Subscribe button name didn't matched, button not working");
	}
	
	@Test(priority=10, description="Livedashboard Testcase 10: Check ellipsis button is working in live dashboard",groups= {"general","premium"})
	public void elipsisButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
	
		String buttonname=driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("contentDescription");
		String expectedname="Share";
		Assert.assertEquals(buttonname,expectedname,"Ellipsis button not working. share button not found");
	
	}
	
	@Test(priority=11, description="Livedashboard Testcase 11: Check live video share is working in live dashboard",groups= {"general","premium"})
	public void liveshareCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
		//click on share button
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//copy the video link and play the live video using the copied link
		String link=driver.findElement(By.xpath("(//android.widget.TextView)[2]")).getText();
		driver.navigate().back();
//		System.out.println(link);
		driver.get(link);
		Thread.sleep(3000);
	}
	
	@Test(priority=12, description="Livedashboard Testcase 12: Check live video add to favourite is working in live dashboard",groups= {"general","premium"})
	public void adFavCheck() throws InterruptedException {
		//click on live dashboard 
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		//click on ellipsis
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
		//click on add to favourite button
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		//click on ellipsis again to check
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//copy the video link and play the live video using the copied link
		String buttonname=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("contentDescription");
		String expectedTitle=" Remove from Favorite";
//		System.out.println(link);
		Assert.assertEquals(buttonname, expectedTitle,"Button name didn't match, add to favourite not working");

	}
	
	@Test(priority=13, description="Livedashboard Testcase 13: Check live video remove from favourite is working in live dashboard",groups= {"general","premium"})
	public void removeFavCheck() throws InterruptedException {
		//click on live dashboard 
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		//click on ellipsis
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
		//click on remove from  favourite button
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		//click on ellipsis again to check
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//copy the video link and play the live video using the copied link
		String buttonname=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("contentDescription");
		String expectedTitle="Add to Favourite";
//		System.out.println(link);
		Assert.assertEquals(buttonname, expectedTitle,"Button name didn't match, remove favourite not working");

	}
	
	@Test(priority=14, description="Livedashboard Testcase 13: Check report video is working in live dashboard",groups= {"general","premium"})
	public void reportCheck() throws InterruptedException {
		//click on live dashboard 
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		//click on ellipsis
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
		//click on report button
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		//click on report reason
		driver.findElement(AppiumBy.accessibilityId("Spam or misleading")).click();
		driver.findElement(AppiumBy.accessibilityId("Report")).click();
		//click on ellipsis again to check report
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		
		String buttonname=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Already Reported";
//		System.out.println(link);
		Assert.assertEquals(buttonname, expectedTitle,"Button name didn't match, remove favourite not working");

	}

}
