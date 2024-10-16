package MobileAutomation.Mahfil_app;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class helpAndFeedbackLocators {
	AndroidDriver driver;
	public helpAndFeedbackLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Favourite page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement feedbackPageTitle;
	
	//Notification button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement notificationButton;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement notificationPageTitle;
	
	//Search button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement searchButton;
	//Search page title locators
	@AndroidFindBy(xpath="(//android.view.View)[8]")
	private WebElement searchPageTitle;
	
	//Back button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement backButton;
	
	//Email field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	private WebElement emailField;
	//Name field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[2]")
	private WebElement nameField;
	//Subject field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[3]")
	private WebElement subjectField;
	//Description field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[4]")
	private WebElement descriptionField;
	//Send button locators
	@AndroidFindBy(accessibility="Send")
	private WebElement sendButton;
	
	//Toast message locator
	@AndroidFindBy(accessibility="Fields are incorrect")
	private WebElement toastMessage;
	//Success message locator
	@AndroidFindBy(accessibility="Report sending successful")
	private WebElement successMessage;
	
	public void Scroll(int times) {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",times));
	}
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}
	public void clickBackButton() {
		backButton.click();
	}
	public void enterEmail(String email) {
		emailField.click();
		emailField.sendKeys(email);
	}
	public void enterName(String name) {
		nameField.click();
		nameField.sendKeys(name);
	}
	public void enterSubject(String subject) {
		subjectField.click();
		subjectField.sendKeys(subject);
	}
	public void enterDescription(String descripton) {
		descriptionField.click();
		descriptionField.sendKeys(descripton);
	}
	public void clickSendButton() {
		sendButton.click();
	}
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("feedbackPageTitle"))
		{
			actualTitle=feedbackPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("notificationPageTitle"))
		{
			actualTitle=notificationPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("searchPageTitle"))
		{
			actualTitle=searchPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("toastMessage"))
		{
			actualTitle=toastMessage.getAttribute("contentDescription");
		}
		else if(page.equals("successMessage"))
		{
			actualTitle=successMessage.getAttribute("contentDescription");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
