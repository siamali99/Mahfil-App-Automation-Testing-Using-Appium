package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class videoPlayerLocator {
	AndroidDriver driver;
	public videoPlayerLocator(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Video pause button  locators
	@AndroidFindBy(xpath="(//android.view.View)[18]")
	private WebElement pauseButton;
	
	//Download button  locators
	@AndroidFindBy(accessibility="DOWNLOAD")
	private WebElement downloadButton;
	
	@AndroidFindBy(xpath="(//android.widget.Button)[2]")
	private WebElement cutVideo;
	
	//Video player identifer Related Videos
//	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView//android.widget.ImageView)[4]")
	@AndroidFindBy(accessibility = "Related Videos")
	private WebElement videoPlayerPageTitle;
	

	
	public void pauseVideo() throws InterruptedException {
		pauseButton.click();
		Thread.sleep(3000);
	}
	
	public void downloadVideo() throws InterruptedException {
		downloadButton.click();
		Thread.sleep(3000);
	}
	
	public void back() {
		driver.navigate().back();
	}
	
	public void stopVideo() throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(2000);
		cutVideo.click();
	}
	
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("videoPlayerPageTitle"))
		{
			actualTitle=videoPlayerPageTitle.getAttribute("contentDescription");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

}
}
