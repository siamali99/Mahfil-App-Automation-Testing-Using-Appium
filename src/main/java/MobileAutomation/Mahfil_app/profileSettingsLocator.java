package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class profileSettingsLocator {
	AndroidDriver driver;
	public profileSettingsLocator(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Profile Settings page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement profileSettingsPageTitle;
	
	//Notification button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement notificationButton;
	//Notificatoin page title locators
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
	
	//Name field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	private WebElement nameField;
	//Email field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[2]")
	private WebElement emailField;
	//Phone number field locators
	@AndroidFindBy(xpath="(//android.widget.EditText)[3]")
	private WebElement numberField;
	//Save button locators
	@AndroidFindBy(accessibility="Save")
	private WebElement saveButton;
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}
	public void clickBackButton() {
		backButton.click();
	}
	public String modifyName(String name) {
		nameField.click();
		String initialName=nameField.getText();
		nameField.clear();
		nameField.sendKeys(name);
		return initialName;
	}
	public String modifyEmail(String email) {
		emailField.click();
		String initialName=emailField.getText();
		emailField.clear();
		emailField.sendKeys(email);
		return initialName;
	}
	public String modifyPhone(String number) {
		numberField.click();
		String initialName=numberField.getText();
		numberField.clear();
		numberField.sendKeys(number);
		return initialName;
	}
	public void clickSave() {
		saveButton.click();
		
	}
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("profileSettingsPageTitle"))
		{
			actualTitle=profileSettingsPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("notificationPageTitle"))
		{
			actualTitle=notificationPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("searchPageTitle"))
		{
			actualTitle=searchPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("nameField"))
		{
			nameField.click();
			actualTitle=nameField.getText();
		}
		else if(page.equals("emailField"))
		{
			emailField.click();
			actualTitle=emailField.getText();
		}
		else if(page.equals("numberField"))
		{
			numberField.click();
			actualTitle=numberField.getText();
		}


		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}

}
