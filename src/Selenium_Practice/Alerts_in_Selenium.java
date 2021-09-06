package Selenium_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_in_Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		alert_Selenium();
	}
	
	
	public static void alert_Selenium() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jasme\\\\Downloads\\\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		driver.get("https://www.demoqa.com/");
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		driver.findElement(By.cssSelector("a[id='close-fixedban']")).click();
		WebElement AlertTab= driver.findElement(By.xpath("//div[@class='accordion']/div[3]"));
		js.executeScript("arguments[0].scrollIntoView();", AlertTab);
		AlertTab.click();
		driver.findElement(By.xpath("//div[@class='accordion']/div[3]/div/ul/li[2]")).click();
		driver.findElement(By.id("alertButton")).click();
		System.out.println(driver.switchTo().alert().getText()); 
		driver.switchTo().alert().accept();      // click a button
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();       //Click button wait for 5 seconds
		driver.findElement(By.id("confirmButton")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());// click button and display selection
		driver.findElement(By.id("promtButton")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Jasmeen Kaur");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());// click button and enter name in alert box
		//all alerts done in ToolQA
		
		
		
		
		
		
		
	}

}
