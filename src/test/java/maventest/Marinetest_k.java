package maventest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils.Task;

import mavenpage.Marine_page;

public class Marinetest_k {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
		
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://marinersforex.com/Flights-Booking");
		
	}
	@Test
	
	
	public void test()
	{
		Marine_page mt=new Marine_page(driver);
		driver.manage().window().maximize();
		mt.leavinggoing();
		mt.departing();
		mt.travelers();
		mt.search();
		
	}

}
