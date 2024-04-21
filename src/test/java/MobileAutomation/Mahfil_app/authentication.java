package MobileAutomation.Mahfil_app;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.MobileBy;


public class authentication extends configAppium{
	
	@BeforeMethod
	public void loginplace() {
//		driver.findElement(AppiumBy.accessibilityId("Home Tab 1 of 5")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
	}
//	@AfterMethod
//	public void afterlogin()
//	{
//		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Nasheed Tab 3 of 5']")).click();
//	}
	@Test
	public void signup() throws InterruptedException {
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("1000000002");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("Siam");
		Thread.sleep(2000);
		WebElement email=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		email.click();
		email.sendKeys("siam@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		driver.navigate().back();
//		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Nasheed Tab 3 of 5']")).click();
		
	}
	
	@Test
	public void login() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
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
	
	@Test(priority=3, description="login with google account")
	public void googleLogin() {
		driver.findElement(AppiumBy.accessibilityId("Sign in with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();
		driver.navigate().back();
	}
	

}
