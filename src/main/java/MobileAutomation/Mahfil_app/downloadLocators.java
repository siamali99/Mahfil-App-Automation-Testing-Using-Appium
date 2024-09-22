package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class downloadLocators {
	AndroidDriver driver;
	public downloadLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Download page title locators
	@AndroidFindBy(xpath="(//android.view.View)[5]")
	private WebElement downloadPageTitle;
	
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("downloadPageTitle"))
		{
			actualTitle=downloadPageTitle.getAttribute("contentDescription");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
