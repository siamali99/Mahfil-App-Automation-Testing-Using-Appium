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
	@Test(priority=1, description="Favourite Testcase 01: Check favourite button is working",groups= {"general","premium"})
	public void dashboardButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Favourite Videos";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Favourite Testcase 02: Check notification button is working in favourite page",groups= {"general","premium"})
	public void notificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Notifications";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=3, description="Favourite Testcase 03: Check search button is working in favourite page",groups= {"general","premium"})
	public void searchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=4, description="Favourite Testcase 04: Check back button is working from favourite page",groups= {"general","premium"})
	public void backButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Others";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=5, description="Favourite Testcase 05: Check after logout and login to the same account keeps the favourite video data",groups= {"general","premium"})
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
	
	@Test(priority=6, description="Favourite Testcase 06: Check after logout and login to a different account should not keep the favourite video data",groups= {"general","premium"})
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
	
	@Test(priority=7, description="Favourite Testcase 07: Check video added to favourites are playable ",groups= {"general","premium"})
	public void favouriteVideoPlay() throws InterruptedException {
		//scroll down to find a video
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
		//open options
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//add favourite
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		Thread.sleep(2000);
		System.out.println("Video played");
	}
	
	@Test(priority=8, description="favourite Testcase 08:Check ellipsis button is working",groups="premium")
	public void ellipsisButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		String actualTitle=driver.findElement(By.xpath("(//android.widget.Button)[1]")).getAttribute("contentDescription");
		System.out.println(actualTitle);
		String expectedTitle="Remove";
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");
		driver.navigate().back();

	}
	
	@Test(priority=9, description="Favourite Testcase 09:Check remove button is working",groups="premium")
	public void removeButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//CLick on Downloads button
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
//		String actualTitle=driver.findElement(By.xpath("(//android.widget.Button)[1]")).getAttribute("contentDescription");
		System.out.println("Video removed");


	}
	
	
	
}
