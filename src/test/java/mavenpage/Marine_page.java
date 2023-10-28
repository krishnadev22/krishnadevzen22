package mavenpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Marine_page {
	WebDriver driver;
	By leaving=By.xpath("//*[@id=\"country-select-demo\"]");
	By going=By.xpath("//*[@id=\"country-select-demo\"]");
	By depart=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[2]/div[2]/div/div/div/button");
	By rightarrow=By.xpath("/html/body/div[2]/div[2]/div/div/div/div[1]/div[2]/button[2]");
	By day=By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/button");
	By month=By.xpath("/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/div");
	By year=By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[125]/button");
	By downarrow=By.xpath("/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/button");
	By travelers=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/div");
	By adult=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[1]/div/div/div[3]/p");
	By child=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[2]/div/div/div[3]/p");
	By business=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[4]/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input");
	By done=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[4]/div/div[2]/span");
	By search=By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[4]/input");
	
	public Marine_page(WebDriver driver) {
		this.driver=driver;
		
	}
	public void leavinggoing() {
		driver.findElement(leaving).click();
		driver.findElement(going).click();
		
		
	}
	public void departing() {
		driver.findElement(depart).click();
		driver.findElement(downarrow).click();
		driver.findElement(year).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		
		while(true) {
	WebElement mont=driver.findElement(month);
	String mon=mont.getText();
	if(mon.equals("November")) {
	System.out.println(mon);
	break;
	}
		
		else {
			driver.findElement(rightarrow).click();
		
	}
		}
	List<WebElement> dates=driver.findElements(day);
	for(WebElement dt:dates) {
		String d=dt.getText();
		if(d.equals("26")) {
			dt.click();
			break;
		}
	}		
	}
			
		
			
			
		
		public void travelers() {
			driver.findElement(travelers).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(adult).click();
			driver.findElement(child).click();
			driver.findElement(business).click();
			driver.findElement(done).click();
			
			
		}
		public void search() {
			driver.findElement(search).click();
		}
		
	
	
			
			
			
		}
		
	
	
	
	

	
