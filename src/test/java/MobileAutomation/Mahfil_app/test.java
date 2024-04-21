package MobileAutomation.Mahfil_app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test extends configAppium {

	@BeforeClass
	public void beforetest() {
		System.out.println("Before test");
	}
	
	
	@AfterClass
	public void aftertest() {
		System.out.println("After test");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before Method");
	}
	
	
	@Test
	public void test2() {
		System.out.println("test1");
	}
	
	@Test
	public void test3() {
		System.out.println("test2");
	}
	
	
}
