package mavenpage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Foundit_page {
	WebDriver driver;
	By foundit=By.xpath("//*[@id=\"topHeader\"]/div[3]/div[1]/div[2]/a/img");
	By hamburger=By.xpath("//*[@id=\"topHeader\"]/div[3]/div[1]/div[1]/div/i");
	By resume=By.xpath("//*[@id=\"130\"]/label/a/span");
	By skilltest=By.xpath("//*[@id=\"no-logged\"]/li[1]/a");
	By java=By.xpath("//*[@id=\"no-logged\"]/li[1]/div/ul[1]/li[1]/a");
	By java2=By.xpath("//*[@id=\"themeDefault\"]/section[2]/div[2]/div/div[3]/label/a");
    By foundit1=By.xpath("//*[@id=\"fixedHeader\"]/div[1]/div[1]/div[2]/a/img");
	By register=By.xpath("//*[@id=\"topHeader\"]/div[3]/div[2]/div/div[2]/ul/li[2]/a");
	By uploadresume=By.xpath("//*[@id=\"basicDetails\"]/div[1]/div[4]/div[1]");
	By login=By.xpath("//*[@id=\"topHeader\"]/div[3]/div[2]/div/div[2]/ul/li[1]/a/span");
	By email=By.xpath("//*[@id=\"signInName\"]");
	By password=By.xpath("//*[@id=\"password\"]");
	By login1=By.xpath("//*[@id=\"signInbtn\"]");
	public Foundit_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void titleverification() {
		String title=driver.getTitle();
		String t="found";
		if(title.equals(t)) {
			System.out.println("title same");
		}
		else {
			System.out.println("title diff");
		}
	}
	
	public void contentverification() {
		String  cont=driver.getPageSource();
		if(cont.contains("Skill Tests")) {
			System.out.println("contains");
			
		}
		else {
			System.out.println("not contains");
		}
	}
	
	
	
	
	public void logodisplay() {
		WebElement li=driver.findElement(foundit);
		boolean b=li.isDisplayed();
		if(b) {
			System.out.println("logo displayed");
			
		}
		else {
			System.out.println("logo not displayed");
		}
	}
	
	public void screenshot() throws Exception {
		File f=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
		FileHandler.copy(f,new File("./screenshot/foundit.png"));
	}
	
	public void click() {
		driver.findElement(hamburger).click();
		driver.findElement(resume).click();
	}
	
	public void mousehover() {
		
		WebElement a=driver.findElement(skilltest);
		Actions act=new Actions(driver);
		act.moveToElement(a);
		act.perform();
		driver.findElement(java).click();
	}
		public void scrol()
		{
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)","");
		}
		public void windowhandle() {
			String parent=driver.getWindowHandle();
			driver.findElement(By.xpath("//*[@id=\"themeDefault\"]/section[2]/div[2]/div/div[3]/label/a"));
			Set<String> windowhandle = driver.getWindowHandles();
			for(String hd:windowhandle)
			{
				if(!hd.equalsIgnoreCase(parent))
					
				{
					driver.switchTo().window(hd);
					driver.findElement(By.xpath("//*[@id=\"fixedHeader\"]/div[1]/div[1]/div[2]/a/img")).click();
					driver.close();
			
		}
		
		
			}
			driver.switchTo().window(parent);
		}
		public void fileupload() throws AWTException 
		
		{
			driver.findElement(register).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(uploadresume).click();
			
			
		 fileupload1("C:\\Users\\krishnadev sen\\Downloads\\SEAS MODEL QUESTIONS  CLASS 1X (1).pdf");
			
		}
		public void fileupload1(String p) throws AWTException
		{
			StringSelection strSelection=new StringSelection(p);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
			Robot robot=new Robot();
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
					
		}
		
		
		public void datadriven() throws Exception {
			
			driver.findElement(register).click();
			File f=new File("C:\\Users\\krishnadev sen\\Desktop\\data driven.xlsx");
		
			FileInputStream fi=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sh=wb.getSheet("Sheet1");
			System.out.println(sh.getLastRowNum());
			for(int i=1;i<sh.getLastRowNum();i++)
			{
				String Username=sh.getRow(i).getCell(0).getStringCellValue();
				System.out.println(Username);
				String Password=sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(Password);
				
				driver.findElement(email).clear();
				driver.findElement(email).sendKeys(Username);
				driver.findElement(password).clear();
				driver.findElement(password).sendKeys(Password);
				driver.findElement(login).click();
				
				
			}
			
			
			
			
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


