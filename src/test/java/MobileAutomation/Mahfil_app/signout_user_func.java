package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class signout_user_func extends configAppium{

//	@Test(priority=1, description="Access menu options as signout user")
//	public void navigate_menu() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
//	}
//
//	
//	@Test(priority=2, description="Navigate through app home, lecture,nasheed,telwat and other page")
//	public void navigation2() {
////		driver.findElement(By.xpath("(//android.widget.ImageView)[13]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[14]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[11]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[12]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[11]")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
//
//	}
//	
//	@Test(priority=3, description="try to access notification while signout")
//	public void accessNotification() {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
//		driver.navigate().back();
//	}
//	
//	@Test(priority=4, description="Searching video and channel while signout")
//	public void Searching() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		WebElement search=driver.findElement(By.className("android.widget.EditText"));
//		search.click();
//		search.sendKeys("Azhari tv");
//		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
//		Thread.sleep(2000);
//	}
//	
//	
//	@Test(priority=5, description="Try to subscribe searched channel as a signout user")
//	public void subscribefromsearch() throws InterruptedException {
//		//open channel section
//		driver.findElement(By.xpath("(//android.view.View)[7]")).click();
//		//click on subscribe to the first channel
//		driver.findElement(AppiumBy.accessibilityId("Subscribe")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		driver.navigate().back();
//		driver.navigate().back();
//		
//	}
//	
//	@Test(priority=6, description="click on popular channel and try to subscribe as a signout user")
//	public void subscribefrompopularchannel() throws InterruptedException {
//		//open a channel from popular channel
//		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView/android.view.View)[1]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Subscribe")).click();
//		driver.navigate().back();
////		driver.navigate().back();
//	}
//	@Test(priority=7, description="Check about section")
//	public void channelViewFunc1() {
//		driver.findElement(By.xpath("(//android.view.View)[13]")).click();
//		driver.findElement(By.xpath("(//android.view.View)[12]")).click();
//
//	}
//	
//	@Test(priority=8, description="add favourite,share, report from Channel view page as a signout user")
//	public void channelViewFunc2() {
//
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		//add favourite
//		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
//		driver.navigate().back();
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		//click Share and copy link
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Copy")).click();
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		//click report choose others and report button click
//		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
//		driver.navigate().back();
//	
//	}
//	@Test(priority=9, description="Play video from channel page view")
//	public void channelViewfunc3() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[6]")).click();
//		Thread.sleep(4000);
//		driver.navigate().back();
//		driver.navigate().back();
//	}
//	
//	@Test(priority=10, description="Open salat reminder page from home page and return to home page")
//	public void prayerbuttoncheck() {
//		driver.findElement(AppiumBy.accessibilityId("All prayer times")).click();
//		//Click on reminder
//		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
//		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
//	
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		
//	}
//	
//	@Test(priority=11, description="add favourite,share, report from home as a signout user")
//	public void videoOptionCheck() {
//		//scroll down to find a video
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		//add favourite
//		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
//		driver.navigate().back();
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		//click Share and copy link
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Copy")).click();
//		//open options
//		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
//		//click report choose others and report button click
//		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
//		driver.navigate().back();
//		
//	}
////	@Test(priority=7, description="Try to play premium video as a signout user")
////	public void playpremium() {
//////		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
////		WebElement element=driver.findElement(By.xpath("(//android.view.View)[2]"));
////		
////		String text2 = element.getAttribute("value");
////        System.out.println("Content Desc: " + text2);
////
//////		element.click();
//////		while(true)
//////		{
//////			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
//////			
//////			String text = driver.findElement(By.xpath("(//android.view.View)[1]")).getAttribute("content-desc");
//////	        System.out.println(text);
//////	        // Check if the text contains the word "premium"
//////	        if (text.contains("Premium")) {
//////	            System.out.println("The text contains the word 'premium'.");
//////	            break;
//////	        }
//////		}
////		
////	}
//	@Test(priority=12,description="Search a premium video and try to play the video as a signout user")
//	public void premiumVideoPlay() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		WebElement search=driver.findElement(By.className("android.widget.EditText"));
//		search.click();
//		search.sendKeys("premium");
//		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//android.view.View)[16]")).click();
//		driver.navigate().back();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
//	}
//	
//	@Test(priority=13, description="Open channel page on logo click from home page")
//	public void openchannelpage() {
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",3.0));
//		driver.findElement(By.xpath("(//android.view.View)[10]")).click();
//		driver.navigate().back();
//	}
	
	@Test(priority=14, description="Scroll down a play a video as a signout user")
	public void playvideo() throws InterruptedException {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));

		driver.findElement(By.xpath("(//android.view.View)[2]")).click();
		Thread.sleep(5000);
//		driver.navigate().back();
		}
	
	@Test(priority=15, description="Play and pause video as signout user")
	public void playpause() throws InterruptedException {
		//video pause button check
		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		//Full screen play
//		driver.findElement(By.xpath("(//android.view.View)[12]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//android.view.View)[11]")).click();

	}
	
	@Test(priority=16, description="Change playback speed, quality, audio, subtitle of video ")
	public void threedotmenu() throws InterruptedException {
		//three dot menu 
		driver.findElement(By.xpath("(//android.view.View)[6]")).click();
		//change playback speed
		driver.findElement(AppiumBy.accessibilityId("Playback speed")).click();
		driver.findElement(AppiumBy.accessibilityId("1.25 x")).click();
		//subtitle
		driver.findElement(By.xpath("(//android.view.View)[6]")).click();
		driver.findElement(AppiumBy.accessibilityId("Subtitles")).click();
		driver.findElement(AppiumBy.accessibilityId("None")).click();
		//Quality
		driver.findElement(By.xpath("(//android.view.View)[6]")).click();
		driver.findElement(AppiumBy.accessibilityId("Quality")).click();
		driver.findElement(AppiumBy.accessibilityId("1280x720 ~656 KBit/s ")).click();
		//Audio
		driver.findElement(By.xpath("(//android.view.View)[6]")).click();
		driver.findElement(AppiumBy.accessibilityId("Audio")).click();
		driver.findElement(AppiumBy.accessibilityId("Default")).click();
		
	}
	
	@Test(priority=17, description="Seek left right on video")
	public void seek() throws InterruptedException {
		driver.findElement(By.xpath("(//android.view.View)[9]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.view.View)[7]")).click();
	}
	
	
	@Test(priority=18, description="Mute unmute of video")
	public void muteUnmute() throws InterruptedException {
		driver.findElement(By.xpath("(//android.view.View)[11]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.view.View)[11]")).click();
	}
	
	@Test(priority=19, description="Video details button check and description")
	public void videoDetailsbutton() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).click();

	}
	
	@Test(priority=20, description="reactions and download button check and try to comment")
	public void ReactionAndDownload() throws InterruptedException {
		//Mashallah button click
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[1]")).click();
		driver.navigate().back();
		//Like button click
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[2]")).click();
		driver.navigate().back();
		//Try to download
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[3]")).click();
		driver.navigate().back();
		//Try to comment
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).click();
		driver.navigate().back();
		
	}
	@Test(priority=21,description="Try to subscribe channel from video player page")
	public void subscribebutton() {
		driver.findElement(AppiumBy.accessibilityId("Subscribe")).click();
		driver.navigate().back();
	}
	
	@Test(priority=22,description="Play video from related videos while signout")
	public void playRelatedvideo() throws InterruptedException {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",3.0));
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
	}
	
	@Test(priority=23,description="Open channel page from related videos while signout")
	public void openchannelpage3() {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",3.0));
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).click();
	}
	

	
//	@Test(priority=8, description="Settings and theme change as signout user")
//	public void settingschange() {
//
//		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
//		driver.navigate().back();
//		driver.findElement(AppiumBy.accessibilityId("Auto Day-Night")).click();
//		driver.findElement(AppiumBy.accessibilityId("Light Mode")).click();
//		driver.findElement(AppiumBy.accessibilityId("Dark Mode")).click();
//		driver.findElement(AppiumBy.accessibilityId("Light Mode")).click();
//		driver.findElement(AppiumBy.accessibilityId("Auto Day-Night")).click();
//		driver.navigate().back();
//		
//	}
	@AfterTest
	public void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
}
