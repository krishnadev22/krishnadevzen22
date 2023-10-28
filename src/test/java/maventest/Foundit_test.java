package maventest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mavenpage.Foundit_page;

public class Foundit_test {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		
	}
@BeforeMethod
public void url()
{
	driver.get("https://www.foundit.in/");
	
}
@Test
 public void test() throws Exception {
	Foundit_page obj=new Foundit_page(driver);
	driver.manage().window().maximize();
	obj.titleverification();
	obj.contentverification();
	obj.logodisplay();
	obj.screenshot();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	obj.click();
	obj.mousehover();
	obj.scrol();
	driver.navigate().back();
	driver.navigate().back();
	obj.windowhandle();
	obj.fileupload();
	driver.navigate().back();
	obj.datadriven();
	
	

}
}