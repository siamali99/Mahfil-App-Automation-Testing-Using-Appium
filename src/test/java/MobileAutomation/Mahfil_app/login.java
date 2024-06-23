package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class login extends configAppium{

	@BeforeMethod
	public void reg_page() {
//		System.out.println("before class");
//		driver.findElement(AppiumBy.accessibilityId("Home Tab 1 of 5")).click();
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
	
	
	//-----------Login with google----------//
	@Test(priority=1, description="Login TestCase 01: Try to google login with provider logged in account")
	public void login1() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[3]")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[12]")).getAttribute("contentDescription");
		String title1="Email already linked to a Provider account. Please use a different one.";
		Assert.assertEquals(title1,title2,"Title didn't matched");
		
	}
	
	@Test(priority=2, description="Login TestCase 02:Try to google login with email logged in account")
	public void login2() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[2]")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[12]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Please try a different email address.";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=3, description="Login TestCase 03:Google login with a valid account")
	public void login3() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();


	}
	
	
	//--------------Login with Email----------------//
	
	@Test(priority=4, description="Login TestCase 04:Try to login with provider account email")
	public void login4() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siam.qtec@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		String title1="Email already linked to a Provider account. Please use a different one.";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=5, description="Login TestCase 05:Try to login with google logged in account")
	public void login5() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamali1499@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		String title1="This email already use in Google Login";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=6, description="Login TestCase 06:Try to login by keeping the email field empty")
	public void login6() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("   ");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=7, description="Login TestCase 07:Try to login by giving invalid email")
	public void login7() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siam.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=8, description="Login TestCase 08:Try to login by giving invalid email")
	public void login8() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siam@gmailcom");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=9, description="Login TestCase 09:Try to login by keeping the OTP field empty")
	public void login9() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys(" ");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys(" ");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys(" ");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys(" ");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=10, description="Login TestCase 10:Try to login by giving invalid otp")
	public void login10() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("2");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("5");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("6");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("8");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[17]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="OTP doesn't matched";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=11, description="Login TestCase 11:Try to login by giving valid otp in email login")
	public void signup10() throws InterruptedException {
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
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	//--------------login with phone number-----------//

	@Test(priority=12, description="Login TestCase 12:Keep the phone number field empty and try to login")
	public void login12() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	
	@Test(priority=13, description="Login TestCase 13:Give invalid phone number and try to login")
	public void login13() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("016256");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=14, description="Login TestCase 14:Try to login by keeping the OTP field empty on phone login")
	public void login14() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("1626023972");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=15, description="Login TestCase 15:Try to login by giving invalid otp on phone login")
	public void login15() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("1626023972");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("5");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("5");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("5");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("5");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=16, description="Login TestCase 16:Try to login by giving valid otp on phone login")
	public void login16() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("1842908695");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
}
	
