package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class signup extends configAppium{
	
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
//		System.out.println("Return Home");

	}
//	@Test
//	public void test() {
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
//	}
	//---Check Continue with google----//
	
	
	@Test(priority=1, description="Try to google signup with provider logged in account")
	public void signup1() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[3]")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[12]")).getAttribute("contentDescription");
		String title1="Email already linked to a Provider account. Please use a different one.";
		Assert.assertEquals(title1,title2,"Title didn't matched");
		
	}
	
	@Test(priority=2, description="Try to google signup with email logged in account")
	public void signup2() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[2]")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[12]")).getAttribute("contentDescription");
//		System.out.println(title2);
		String title1="Please try a different email address.";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	//-------------------Email signup test----------------------//
	
	@Test(priority=3, description="Try to signup with provider account email in email login")
	public void signup3() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siam.qtec@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		String title1="Email already linked to a Provider account. Please use a different one.";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=4, description="Try to signup with google logged in account")
	public void signup4() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamali1499@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[9]")).getAttribute("contentDescription");
		String title1="This email already use in Google Login";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=5, description="Try to signup by keeping the email field empty")
	public void signup5() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("   ");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=6, description="Try to signup by giving invalid email")
	public void signup6() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siam.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=7, description="Try to signup by giving invalid email")
	public void signup7() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siam@gmailcom");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=8, description="Try to signup by keeping the OTP field empty")
	public void signup8() throws InterruptedException {
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
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=9, description="Try to signup by giving invalid otp")
	public void signup9() throws InterruptedException {
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
		System.out.println(title2);
		String title1="OTP doesn't matched";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=10, description="Try to signup by giving valid otp")
	public void signup10() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	
	@Test(priority=11, description="Try to signup by keeping the name field empty")
	public void signup11() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("");
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=12, description="Try to signup by giving only spaces in name field")
	public void signup12() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("     ");
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=13, description="Try to signup by giving name less then 3 character")
	public void signup13() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest2@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("si");
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=14, description="Try to signup by giving valid name and phone")
	public void signup14() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
		WebElement email=driver.findElement(By.className("android.widget.EditText"));
		email.click();
		email.sendKeys("siamtest3@gmail.com");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("siam");
		WebElement phone=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		phone.click();
		phone.sendKeys("1626023972");
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	
	//-------------------Phone signup test----------------------//
	
	
	@Test(priority=15, description="Keep the phone number field empty and try to signup")
	public void signup15() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	
	@Test(priority=16, description="Give invalid phone number and try to signup")
	public void signup16() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("016256");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="OTP has been sent to your email. Please check!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=17, description="Try to signup by keeping the OTP field empty on phone login")
	public void signup17() throws InterruptedException {
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
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=18, description="Try to signup by giving invalid otp on phone login")
	public void signup18() throws InterruptedException {
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
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	
	@Test(priority=19, description="Try to signup by giving valid otp on phone login")
	public void signup19() throws InterruptedException {
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
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=20, description="Try to signup by keeping the name field empty")
	public void signup20() throws InterruptedException {
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
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("");
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=21, description="Try to signup by giving only spaces in name field")
	public void signup21() throws InterruptedException {
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
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("     ");
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=22, description="Try to signup by giving name less then 3 character")
	public void signup22() throws InterruptedException {
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
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("si");
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertEquals(title1,title2,"Title didn't matched");
	}
	
	@Test(priority=23, description="Try to signup by giving valid name and email")
	public void signup23() throws InterruptedException {
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
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		name.sendKeys("siam");
		WebElement email=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		email.click();
		email.sendKeys("siamali1499@gmail.com");
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		String title2=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		System.out.println(title2);
		String title1="Sign up to your account!";
		Assert.assertNotEquals(title1,title2,"Title matched");
	}
	@Test(priority=24, description="Google signup with a new account")
	public void signuplast() {
		driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
		driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")).click();
//		String title2=driver.findElement(By.xpath("(//android.view.View)[12]")).getAttribute("contentDescription");
////		System.out.println(title2);
//		String title1="Please try a different email address.";
//		Assert.assertEquals(title1,title2,"Title didn't matched");

	}
	
	
	
	
	
	

}
