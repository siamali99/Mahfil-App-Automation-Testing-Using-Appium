package MobileAutomation.Mahfil_app;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Locale;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class configAppium {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	Locale locale=Locale.of("en","IN");
	Faker fake= new Faker(locale);
//	public WebDriver chromeDriver;
	
	@BeforeTest
	public void config() throws MalformedURLException {
		service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\alhas\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();	
		service.start();
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("device1");
		//Azure live server
		options.setApp("C:\\Users\\alhas\\eclipse-workspace\\Mahfil_app\\src\\test\\java\\resources\\Mahfil_azure_testserver.apk");

		//Azure apk  test server
//		options.setApp("C:\\Users\\alhas\\eclipse-workspace\\Mahfil_app\\src\\test\\java\\resources\\azure server app.apk");
		options.setCapability("noReset", true);
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//implicit wait. app will wait 10 seconds for a element to visible. if it find before 10 it will work instantly.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Appium Start");
	}
	
	@AfterTest
	public void closeConnection() throws InterruptedException {
		driver.quit();
		service.stop();
		System.out.println("Appium Stop");
	}

}
