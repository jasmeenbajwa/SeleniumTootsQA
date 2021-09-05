package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class First_Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		practice_form();
		//check_box();   /*this portion working done*/
	
		
		
	}

	
	public static void practice_form() throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jasme\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;  /*to execute jsexecuter*/
		driver.get("https://www.demoqa.com/");
		//driver.manage().window().maximize();
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		WebElement form= driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[2]"));
		form.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[2]/div")).click();
		driver.findElement(By.id("firstName")).sendKeys("Jasmeen");
		driver.findElement(By.id("lastName")).sendKeys("Kaur");
		driver.findElement(By.id("userEmail")).sendKeys("jasmeenkaur1234@gmail.com");
		driver.findElement(By.xpath("//div[@id='genterWrapper']/div/div[1]/label")).click();
		driver.findElement(By.id("userNumber")).sendKeys("123456789123568");
		driver.findElement(By.id("dateOfBirthInput")).click();
		driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']")).click();
		driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']/option[2]")).click();
		driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='1997']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Choose Monday, February 17th, 1997']")).click();
		//Thread.sleep(2000);			
		driver.findElement(By.id("subjectsInput")).sendKeys("Hello there i am filling form");
		
		
		
		//driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[3]/input")).click();
		//driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
		//System.out.println(driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).isSelected());
		//driver.findElement(By.xpath("//input[@value='hobbiesWrapper']/div/div[3]/label")).click();
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\jasme\\Pictures\\image7.jpg");
		driver.findElement(By.id("currentAddress")).sendKeys("5 Argelia Crescent, Brampton, ON, L6X5N5");
		//WebElement staticdropdown= driver.findElement(By.id(""));
		//Select dropdown= new Select(form);
		Thread.sleep(2000);
		WebElement state= driver.findElement(By.id("stateCity-wrapper"));
		js.executeScript("arguments[0].scrollIntoView();",state);   /*to scroll until find state filed else throws error */
		driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/div[2]/div/div/div[1]/div[2]/div/input")).sendKeys("Haryana");
		//driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/div[3]")).click();
		driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/div[3]/div/div/div[1]/div[2]/div/input")).sendKeys("Panipat");
		
	
		
	
}
	
	public static void check_box() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jasme\\\\Downloads\\\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.demoqa.com/");
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='accordion']/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='accordion']/div[1]/div/ul/li[2]")).click();
		driver.findElement(By.cssSelector("button[aria-label='Toggle']")).click();
		driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/span/button")).click();
		driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/span/button")).click();
		driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='result']/span[2]")).getText());
			
		
		
		
	}
	}

