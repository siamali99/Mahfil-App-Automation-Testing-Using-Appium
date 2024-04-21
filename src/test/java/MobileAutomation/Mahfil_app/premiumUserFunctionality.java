package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class premiumUserFunctionality extends configAppium{
	String ExpectedTitle, ActualTitle;
	
	@Test
	public void premiumLogin() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("1626023972");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		Thread.sleep(1000);
		driver.navigate().back();
	}
	@BeforeMethod
	public void beforemethod() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
	}
	
	@AfterMethod
	public void home() {
		while(true)
		{
			String test=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("bounds");
			if(test.equals("[476,181][964,305]"))
					{
				break;
					}
			else
			{
				driver.navigate().back();
			}
	
		}
		System.out.println("Return Home");

	}
	
	//----Live DashBoard check---
	@Test(priority=1,description="Click on live dashboard check notification button")
	public void livedashboardNotification() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		//notification button check
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		ActualTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		System.out.println(ActualTitle);
		ExpectedTitle="Notifications";
		Assert.assertEquals(ActualTitle,ExpectedTitle,"Page Title didn't match");
	}
	@Test(priority=2,description="Click on live dashboard check search button")
	public void livedashboardSearch() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		//Search button check
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		ActualTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		ExpectedTitle="Popular Search";
		Assert.assertEquals(ActualTitle,ExpectedTitle,"Page Title didn't match");
	}
	
	@Test(priority=3,description="Click on live dashboard click on subscribe button and subscribe channel")
	public void livedashboardSubscribe() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		//Subscribe button check
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		ActualTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).getAttribute("contentDescription");
		ExpectedTitle="Subscribed";
		Assert.assertEquals(ActualTitle,ExpectedTitle,"Subscribe button not working");
	}
	
	@Test(priority=4,description="Click on live dashboard click on unsubscribe button and unsubscribe channel")
	public void livedashboardUnSubscribe() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		//UnSubscribe button check
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(AppiumBy.accessibilityId("Yes")).click();
		ActualTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).getAttribute("contentDescription");
		ExpectedTitle="Subscribe";
		Assert.assertEquals(ActualTitle,ExpectedTitle,"UnSubscribe button not working");
	}
	

}
