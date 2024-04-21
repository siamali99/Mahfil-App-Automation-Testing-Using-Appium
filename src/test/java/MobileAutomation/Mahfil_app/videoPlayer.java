package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class videoPlayer extends configAppium{
	String Actual,Expected;

//	@BeforeTest(description="Scroll down a play a video ")
//	public void playvideo() throws InterruptedException {
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
//
//		driver.findElement(By.xpath("(//android.view.View)[2]")).click();
//		Thread.sleep(5000);
//		}
//	
//	@BeforeMethod(description="Play and pause video, Enter and exit full screen")
//	public void playpause() throws InterruptedException {
//		driver.findElement(By.xpath("(//android.view.View)[2]")).click();
//		Thread.sleep(5000);
//		//video pause button check
//		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
//		//Full screen play
////		driver.findElement(By.xpath("(//android.view.View)[12]")).click();
////		Thread.sleep(2000);
////		driver.findElement(By.xpath("(//android.view.View)[11]")).click();
//
//	}
//	
//	@AfterMethod
//	public void returnHome() {
//		driver.navigate().back();
//	}
	
	
//	@BeforeClass
	public void beforetest() {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",5.0));
		System.out.println("Scroll before test");
	}
	
	
	@AfterTest
	public void aftertest() {
		System.out.println("Test Done");
	}
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		driver.findElement(By.xpath("(//android.view.View)[2]")).click();
		Thread.sleep(5000);
		//video pause button check
		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
		Thread.sleep(100);
		System.out.println("Play video Pause Video");
	}
	@AfterMethod
	public void home() {
		while(true)
		{
			String test=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("bounds");
			if(test.equals("[476,181][964,305]"))
					{
				break;
					}
			else
			{
				driver.navigate().back();
			}
	
		}
		System.out.println("Return Home");

	}
	
	@Test(priority=3, description="Change playback speed, quality, audio, subtitle of video ")
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
	
	@Test(priority=4, description="Seek left right on video")
	public void seek() {
		driver.findElement(By.xpath("(//android.view.View)[9]")).click();
		System.out.println("Seek right");
		driver.findElement(By.xpath("(//android.view.View)[7]")).click();
		System.out.println("Seek Left");
	}
	
	
	@Test(priority=5, description="Mute unmute of video")
	public void muteUnmute() throws InterruptedException {
		driver.findElement(By.xpath("(//android.view.View)[11]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//android.view.View)[11]")).click();
	}
	
	@Test(priority=6, description="Video details button check and description")
	public void videoDetailsbutton() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).click();

	}
	
	@Test(priority=7, description="reactions and download button check")
	public void ReactionAndDownload() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[3]")).click();
		
		try {
			String desc= driver.findElement(AppiumBy.accessibilityId("Subscribe")).getAttribute("content-desc");
			Thread.sleep(1000);
			if(desc.equals("Subscribe"))
			{
				System.out.println(desc);
//				driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
				driver.navigate().back();
			}
		} catch (NoSuchElementException e) {
		    // Handle the exception or log the error
		    System.out.println("Premium user ");
		}
		
	}
	
	
	@Test(priority=8, description="More button check")
	public void morebutton() {
		//open options
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[4]")).click();
		//add favourite
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		//open options
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[4]")).click();
		//click Share and copy link
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Copy")).click();
		//open options
		driver.findElement(By.xpath("(//android.widget.HorizontalScrollView//android.widget.ImageView)[4]")).click();
		//click report choose others and report button click
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		driver.findElement(AppiumBy.accessibilityId("Others")).click();
		WebElement otherbox=driver.findElement(By.className("android.widget.EditText"));
		otherbox.click();
		otherbox.sendKeys("This is not good");
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Report")).click();

	}
	@Test(priority=9, description="Make comments , like, dislike ,reply, edit and delete")
	public void comment() throws InterruptedException {
		String test=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).getAttribute("content-desc");
		System.out.println(test);
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).click();
		
		WebElement comment=driver.findElement(By.className("android.widget.EditText"));
		comment.click();
		comment.sendKeys("Alhamdulilah");
		driver.findElement(By.xpath("//android.widget.ImageView")).click();
		Thread.sleep(500);
		//Like dislike comments
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(500);
		
		//Reply
		driver.findElement(By.xpath("(//android.view.View)[7]")).click();
		WebElement reply=driver.findElement(By.className("android.widget.EditText"));
		reply.click();
		reply.sendKeys("Mashallah");
		driver.findElement(By.xpath("//android.widget.ImageView")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		//Edit reply
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(AppiumBy.accessibilityId("Edit")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(" mashallah");
		driver.findElement(By.xpath("(//android.widget.EditText//android.widget.ImageView)[1]")).click();
		//Delete reply
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(AppiumBy.accessibilityId("Delete")).click();
		driver.navigate().back();
		//Edit
		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		driver.findElement(AppiumBy.accessibilityId("Edit")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(" mashallah");
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		Thread.sleep(1000);
		//Delete
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		driver.findElement(AppiumBy.accessibilityId("Delete")).click();
		Thread.sleep(500);
		driver.navigate().back();
		
	}

	//	@Test
//	public void miniplayertest() throws InterruptedException {
//		String access=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("content-desc");
//		System.out.println(access);
//		//goes miniplayer
//		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//android.widget.Button")).click();
//		//go back to default
//		driver.findElement(AppiumBy.accessibilityId(access)).click();
//	}
//	
//	
//	@Test(priority=10,description="Scroll down in related videos and open channel on logo click")
//	public void openChannelRealtedVideo() {
////		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//		//click on channel logo
//		String test=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).getAttribute("content-desc");
//		System.out.println(test);
//		driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[4]")).click();
//	}

	
	
	@Test(priority=10,description="Checking autoplay toast messages turn off")
	public void autoplay1() {
//		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
		driver.findElement(By.xpath("//android.widget.Switch")).click();
		Actual=driver.findElement(AppiumBy.accessibilityId("Autoplay is off")).getAttribute("contentDescription");
//		System.out.println(Actual);
		String Expected="Autoplay is off";
		Assert.assertEquals(Actual,Expected,"Toast didn't match");
	}
	
	@Test(priority=10,description="Turn off auto play and seek to the last to see if the next video plays automatically")
	public void autoplay3() throws InterruptedException {
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
//		driver.findElement(By.xpath("//android.widget.Switch")).click();
		String title1=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("contentDescription");
		System.out.println(title1);
		String info=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		while(true)
		{
			if(info.charAt(0)==info.charAt(8) && info.charAt(1)==info.charAt(9) && info.charAt(3)==info.charAt(11) && info.charAt(4)==info.charAt(12) )
			{
				break;
			}
			else {
				Thread.sleep(500);
				driver.findElement(By.xpath("(//android.view.View)[9]")).click();
				info=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
			}
//			System.out.println(info.length());
////			for(int i=0;i<info.length())
//			driver.findElement(By.xpath("//android.widget.Switch")).click();
//			String Actual=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("contentDescription");
//			System.out.println(Actual);
		}
		Thread.sleep(8000);
		String title2=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("contentDescription");
		System.out.println(title2);
		Assert.assertEquals(title1,title2,"Title didn't matched");
		
	}
	
	
	@Test(priority=10,description="Checking autoplay toast messages on turn on")
	public void autoplay2() {
//		driver.findElement(By.xpath("(//android.view.View)[5]")).click();
		driver.findElement(By.xpath("//android.widget.Switch")).click();
		Actual=driver.findElement(AppiumBy.accessibilityId("Autoplay is on")).getAttribute("contentDescription");
//		System.out.println(Actual);
		Expected="Autoplay is on";
		Assert.assertEquals(Actual,Expected,"Toast didn't match");

	}
	
	
	@Test(priority=10,description="Turn off auto play and seek to the last to see if the next video plays automatically")
	public void autoplay4() throws InterruptedException {
		driver.findElement(By.xpath("(//android.view.View)[8]")).click();
//		driver.findElement(By.xpath("//android.widget.Switch")).click();
		String title1=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("contentDescription");
		System.out.println(title1);
		String info=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		while(true)
		{
			if(info.charAt(0)==info.charAt(8) && info.charAt(1)==info.charAt(9) && info.charAt(3)==info.charAt(11) && info.charAt(4)==info.charAt(12) )
			{
				break;
			}
			else {
				Thread.sleep(500);
				driver.findElement(By.xpath("(//android.view.View)[9]")).click();
				info=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
			}
//			System.out.println(info.length());
////			for(int i=0;i<info.length())
//			driver.findElement(By.xpath("//android.widget.Switch")).click();
//			String Actual=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("contentDescription");
//			System.out.println(Actual);
		}
		Thread.sleep(8000);
		String title2=driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.View)[1]")).getAttribute("contentDescription");
		System.out.println(title2);
		Assert.assertNotEquals(title1,title2,"Title didn't matched");
		
	}
	

	
	
	
	
	

	
	
}
