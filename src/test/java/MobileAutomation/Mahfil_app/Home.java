package MobileAutomation.Mahfil_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;

public class Home extends configAppium{
	@Test(priority=1, description="Access menu options as signout user")
	public void navigate_menu() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
	}
	
	@Test(priority=2 ,description="Header notification,search and menu button check")
	public void headerbuttoncheck() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
	}
	
	@Test(priority=3, description="Subscribe and unsubscribe from popular channel")
	public void subscriptionbutton() {
		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribe\"])[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribe\"])[2]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribe\"])[3]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Subscribed\"])[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Yes")).click();
	}
	
	@Test(priority=4, description="Open salat reminder page from home page and return to home page")
	public void prayerbuttoncheck() {
		driver.findElement(AppiumBy.accessibilityId("All prayer times")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		
	}
	
	@Test(priority=5, description="add favourite,share, report from home")
	public void videoOptionCheck() {
		//scroll down to find a video
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
		//open options
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//add favourite
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		//open options
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//click Share and copy link
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Copy")).click();
		//open options
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		//click report choose others and report button click
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		driver.findElement(AppiumBy.accessibilityId("Others")).click();
		WebElement otherbox=driver.findElement(By.className("android.widget.EditText"));
		otherbox.click();
		otherbox.sendKeys("This is not good");
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Report")).click();

		
	}
	
	@Test(priority=6, description="Scroll down and play a video")
	public void scrollandplay() throws InterruptedException {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));

		driver.findElement(By.xpath("(//android.view.View)[2]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		}
	@Test(priority=7, description="Check add subscribed channel and add favourites video")
	public void checkaddfavouriteandsub() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
	}
	@Test
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

	}
	
}
