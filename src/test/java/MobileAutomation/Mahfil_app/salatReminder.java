package MobileAutomation.Mahfil_app;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class salatReminder extends configAppium{
	
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
	
	@Test(priority=1, description="Salat Reminder Testcase 01: Check Salat Reminder button is working",groups= {"general","premium"})
	public void salatReminderButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		String expectedTitle="Salat Time";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Salat Reminder Testcase 02: Check back button is working from Salat Reminder page",groups= {"general","premium"})
	public void backButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Others";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
		
	}
	
	@Test(priority=3, description="Salat Reminder Testcase 03: Check reminder switch button is working from Salat Reminder page",groups= {"general","premium"})
	public void reminderSwitchbuttonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		System.out.println(state1);
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		String state2=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		System.out.println(state2);
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		Assert.assertNotEquals(state1,state2,"Title matched");
		
	}
	
	
	@Test(priority=4, description="Salat Reminder Testcase 04: Check turning off reminder switch button turns off all other salat switches in Salat Reminder page",groups= {"general","premium"})
	public void reminderSwitchbuttoncheck2() {
		 String[] arr= new String[5];
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		System.out.println(state1);
		for(int i=2;i<=6;i++)
		{
			arr[i-2]=driver.findElement(By.xpath("(//android.widget.Switch)["+i+"]")).getAttribute("checked");
			Assert.assertEquals(state1,arr[i-2],"Title didn't matched");
		}

		
	}
	
	@Test(priority=5, description="Salat Reminder Testcase 05: Check turning on reminder switch button  turns on all other salat switches in Salat Reminder page",groups= {"general","premium"})
	public void reminderSwitchbuttoncheck3() {
		 String[] arr= new String[5];
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		System.out.println(state1);
		for(int i=2;i<=6;i++)
		{
			arr[i-2]=driver.findElement(By.xpath("(//android.widget.Switch)["+i+"]")).getAttribute("checked");
			Assert.assertEquals(state1,arr[i-2],"Title didn't matched");
		}
	
	}
	
	
	@Test(priority=6, description="Salat Reminder Testcase 06: Check turning on reminder shows set reminder pop up and on time reminder button is working",groups= {"general","premium"})
	public void reminderSwitchbuttoncheck4() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		String actualTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Set Reminder";
		Assert.assertEquals(actualTitle,expectedTitle, "Title didn't matched");
		driver.findElement(AppiumBy.accessibilityId("On Time Reminder")).click();
	}
	
	@Test(priority=7, description="Salat Reminder Testcase 07: Check set reminder time buttons are working",groups= {"general","premium"})
	public void reminderSwitchbuttoncheck5() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
//		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
//		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
//		driver.findElement(AppiumBy.accessibilityId("5 min")).click();
//		driver.findElement(AppiumBy.accessibilityId("10 min")).click();
//		driver.findElement(AppiumBy.accessibilityId("30 min")).click();
//		driver.findElement(AppiumBy.accessibilityId("60 min")).click();
//		driver.findElement(AppiumBy.accessibilityId("Done")).click();
//		System.out.println("buttons are working");

		WebDriver driver = null; // Assigned elsewhere
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("By.xpath('(//android.widget.Switch)[2]').setAttribute('checked', 'false')");
		String actualTitle=driver.findElement(By.xpath("(//android.widget.Switch)[2]")).getAttribute("contentDescription");
		System.out.println(actualTitle);
	}
	
	
}
