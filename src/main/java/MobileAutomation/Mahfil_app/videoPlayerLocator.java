package MobileAutomation.Mahfil_app;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class videoPlayerLocator {
	AndroidDriver driver;
	WebDriverWait wait;
	public videoPlayerLocator(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Video player display button  locators
	@AndroidFindBy(xpath="(//android.view.View)[10]")
	private WebElement player;
	
	//AutoPlay button  locators
	@AndroidFindBy(xpath="//android.widget.Switch")
	private WebElement autoPlay;
	//Autoplay off message locator
	@AndroidFindBy(accessibility="Autoplay is off")
	private WebElement autoPlayOff;
	//Autoplay on message locator
	@AndroidFindBy(accessibility="Autoplay is on")
	private WebElement autoPlayOn;
	
	//Three dot locator
	@AndroidFindBy(xpath="(//android.view.View)[20]")
	private WebElement elipsisButton;
	//Left seek locator
	@AndroidFindBy(xpath="(//android.view.View)[21]")
	private WebElement leftSeekButton;
	//Right Seek locator
	@AndroidFindBy(xpath="(//android.view.View)[23]")
	private WebElement rightSeekButton;
	//pause play locator
	@AndroidFindBy(xpath="(//android.view.View)[22]")
	private WebElement pausePlayButton;
	//Mute unmute locator
	@AndroidFindBy(xpath="(//android.view.View)[25]")
	private WebElement soundButton;
	//Full screen locator
	@AndroidFindBy(xpath="(//android.view.View)[26]")
	private WebElement fullScreenButton;
	
	//mashallah button locator
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView//android.widget.ImageView)[1]")
	private WebElement mashallahButton;
	//like button locator
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView//android.widget.ImageView)[2]")
	private WebElement likeButton;
	//download button locator
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView//android.widget.ImageView)[3]")
	private WebElement downloadButton;
	//Download has started. Please wait a moment!
	//Download start message
	@AndroidFindBy(accessibility="Download has started. Please wait a moment!")
	private WebElement downloadConfirmation;
	//more button locator
	@AndroidFindBy(accessibility="MORE")
	private WebElement moreButton;
	//share button locators
	@AndroidFindBy(accessibility="Share")
	private WebElement shareButton;
	@AndroidFindBy(id="com.android.intentresolver:id/headline")
	private WebElement sharePageTitle;
	
	//add to favourite button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement addFavouriteButton;
	
	//report button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement reportButton;
	
	//Subscribe button locator
	@AndroidFindBy(accessibility="Subscribe")
	private WebElement subscribeButton;
	@AndroidFindBy(accessibility="Subscribed")
	private WebElement subscribedButton;
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement subscribeButtonTitle;
	@AndroidFindBy(accessibility = "Yes")
	private WebElement yesButton;
	//comment button locators
	@AndroidFindBy(xpath="//*[contains(@content-desc, 'Add Comment')]")
	private WebElement commentButton;
	//comment box locator
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement commentField;
	//comment send icon locator
	@AndroidFindBy(xpath="//android.widget.ImageView")
	private WebElement commentIcon;
	//Related video elipsis button
	//Three dot locator
	@AndroidFindBy(xpath="(//android.widget.ImageView)[7]")
	private WebElement relatedElipsisButton;
	//Video pause button  locators
	@AndroidFindBy(xpath="(//android.view.View)[18]")
	private WebElement pauseButton;
	//premium pop up identifier
	@AndroidFindBy(xpath="(//android.widget.Button)")
	private WebElement premiumPopUpTitle;
//	//Download button  locators
//	@AndroidFindBy(accessibility="DOWNLOAD")
//	private WebElement downloadButton;
	
	@AndroidFindBy(xpath="(//android.widget.Button)[2]")
	private WebElement cutVideo;
	
	//Video player identifer Related Videos
//	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView//android.widget.ImageView)[4]")
	@AndroidFindBy(accessibility = "Related Videos")
	private WebElement videoPlayerPageTitle;
	
	public void clickPlayer() {
		player.click();
	}
	public void clickAutoPlay() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(autoPlay));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch"))); 
		autoPlay.click();
	}
	
	public void checkPlayerFunctions() {
		wait.until(ExpectedConditions.visibilityOf(pausePlayButton));
		pausePlayButton.click();
		elipsisButton.click();
		rightSeekButton.click();
		leftSeekButton.click();
		soundButton.click();
		soundButton.click();
		fullScreenButton.click();
	}
	

	
	public void clickMashallah() {
		mashallahButton.click();
	}
	public void clickLike() {
		likeButton.click();
	}
	public void clickDownload() {
		downloadButton.click();
	}
	public void clickMore() {
		moreButton.click();
	}
	
	public void clickShare() throws InterruptedException {
		shareButton.click();
		Thread.sleep(1000);
	}	
	public void clickFavourite() {
		addFavouriteButton.click();
	}
	public void Scroll(int times) {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",times));
	}
	
	public void clickReportbutton() {
		reportButton.click();
	}
	public void report() {
		driver.findElement(AppiumBy.accessibilityId("Spam or misleading")).click();
		driver.findElement(AppiumBy.accessibilityId("Report")).click();
		
	}
	public void clickSubscribe() {
		subscribeButton.click();
	}
	public void clickUnSubscribe() throws InterruptedException {
		subscribedButton.click();
		yesButton.click();

	}
	public void pauseVideo() throws InterruptedException {
		pauseButton.click();
		Thread.sleep(3000);
	}
	
	public void downloadVideo() throws InterruptedException {
		downloadButton.click();
		Thread.sleep(3000);
	}
	public void clickComment() {
		commentButton.click();
	}
	
	public void writeComment() {

		commentField.click();
		commentField.sendKeys("Alhamdulilah");
		commentIcon.click();
	}
	
	public void clickRelatedVideoElipsis() {
		relatedElipsisButton.click();
	}
	
	public void clickRelatedVideoShare() throws InterruptedException {
		shareButton.click();
		Thread.sleep(1000);
	}
	
	public void clickRelatedVideoAddToFavourite() throws InterruptedException {
		addFavouriteButton.click();
		Thread.sleep(1000);
	}
	
	public void clickRelatedVideoReport() throws InterruptedException {
		reportButton.click();
		Thread.sleep(1000);
	}
	public void back() {
		driver.navigate().back();
	}
	
	public void stopVideo() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(cutVideo));
		cutVideo.click();
	}
	
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("videoPlayerPageTitle"))
		{
			actualTitle=videoPlayerPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("autoPlayOff"))
		{
			actualTitle=autoPlayOff.getAttribute("contentDescription");
		}
		else if(page.equals("autoPlayOn"))
		{
			actualTitle=autoPlayOn.getAttribute("contentDescription");
		}
		else if(page.equals("sharePageTitle"))
		{
			actualTitle=sharePageTitle.getText();
		}
		else if(page.equals("addFavouriteButton"))
		{
			actualTitle=addFavouriteButton.getAttribute("contentDescription");
		}
		else if(page.equals("reportButton"))
		{
			actualTitle=reportButton.getAttribute("contentDescription");
		}
		else if(page.equals("premiumPopUpTitle"))
		{
			actualTitle=premiumPopUpTitle.getAttribute("contentDescription");
		}
		else if(page.equals("subscribedButton"))
		{
			actualTitle=subscribedButton.getAttribute("contentDescription");
		}
		else if(page.equals("subscribeButton"))
		{
			actualTitle=subscribeButton.getAttribute("contentDescription");
		}
		else if(page.equals("downloadConfirmation"))
		{
			actualTitle=downloadConfirmation.getAttribute("contentDescription");
		}
		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

}
}
