package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class authenticationLocators {
	AndroidDriver driver;
	public authenticationLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Continue with google locators
	@AndroidFindBy(accessibility="Continue with Google")
	private WebElement googleLogin;
	//Continue with email locators
	@AndroidFindBy(accessibility="Continue with Email")
	private WebElement emailLogin;
	//Email field locators
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement emailField;
	//Continue another way locators
	@AndroidFindBy(accessibility="Continue another way")
	private WebElement anotherWayButton;
	//Log in with mobile locators
	@AndroidFindBy(accessibility="Log in with Mobile")
	private WebElement mobileLogin;
	//Phone number field locators
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement numberField;
	
	//Continue button
	@AndroidFindBy(accessibility="Continue")
	private WebElement continueButton;
	
	//Google Login account locators
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[1]")
	private WebElement googleAccount;  //This email is used for google login valid account
	//Email Login account locators
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[2]")
	private WebElement emailAccount; //This email is used for email login
	//Provider  account locators
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[3]")
	private WebElement providerAccount; //This email is used in provider login
	//Error toast message locators google login page
	@AndroidFindBy(xpath="(//android.view.View)[11]")
	private WebElement errorMessageGoogle;
	//Error toast message locators email login page
	@AndroidFindBy(xpath="(//android.view.View)[8]")
	private WebElement errorMessageEmail;
	//Email page title locators
	@AndroidFindBy(accessibility="Continue with your Email")
	private WebElement emailPage;
	//Phone number page title locators
	@AndroidFindBy(accessibility="Continue with your phone number")
	private WebElement phonePage;
	//Name and phone page title locators
	@AndroidFindBy(accessibility="Sign up to your account!")
	private WebElement namePage;
	//Otp locators
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")
	private WebElement otpField1;
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")
	private WebElement otpField2;
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")
	private WebElement otpField3;
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")
	private WebElement otpField4;
	//OTP error message  locators
	@AndroidFindBy(accessibility="OTP doesnt matched")
	private WebElement otpErrorMessage;
	
	@AndroidFindBy(xpath="//android.widget.EditText[1]")
	private WebElement nameField;
	@AndroidFindBy(xpath="//android.widget.EditText[2]")
	private WebElement phoneField;
	@AndroidFindBy(accessibility="Save")
	private WebElement saveButton;
	public void clickGoogleLogin() throws InterruptedException {
		googleLogin.click();
		Thread.sleep(2000);
	}
	public void clickEmailLogin() throws InterruptedException {
		emailLogin.click();
	}
	public void clickMobileLogin() throws InterruptedException {
		anotherWayButton.click();
		mobileLogin.click();
	}
	
	public void clickGoogleAccount() {
		googleAccount.click();
	}
	public void clickEmailAccount() {
		emailAccount.click();
	}
	public void clickProviderEmail() {
		providerAccount.click();
	}
	public void enterEmail(String email) {
		emailField.click();
		emailField.sendKeys(email);
	}
	public void enterOTP(String a,String b,String c, String d) throws InterruptedException {
		otpField1.sendKeys(a);
		otpField2.sendKeys(b);
		otpField3.sendKeys(c);
		otpField4.sendKeys(d);
		Thread.sleep(2000);
	}
	public void clickContinue() throws InterruptedException {
		continueButton.click();
		Thread.sleep(1000);
	}
	
	public void enterName(String name) {
		nameField.click();
		nameField.sendKeys(name);
	}
	public void enterPhone(String phone) {
		phoneField.click();
		phoneField.sendKeys(phone);
	}
	
	public void clickSave() {
		saveButton.click();
	}
	
	public void enterNumber(String number) {
		numberField.click();
		numberField.sendKeys(number);
	}
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("errorMessageGoogle"))
		{
			actualTitle=errorMessageGoogle.getAttribute("contentDescription");
		}
		else if(page.equals("errorMessageEmail"))
		{
			actualTitle=errorMessageEmail.getAttribute("contentDescription");
		}
		else if(page.equals("emailPage"))
		{
			actualTitle=emailPage.getAttribute("contentDescription");
		}
		else if(page.equals("otpErrorMessage"))
		{
			actualTitle=otpErrorMessage.getAttribute("contentDescription");
		}
		else if(page.equals("namePage"))
		{
			actualTitle=namePage.getAttribute("contentDescription");
		}
		else if(page.equals("phonePage"))
		{
			actualTitle=phonePage.getAttribute("contentDescription");
		}
		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
