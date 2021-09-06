package Selenium_Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class First_Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//practice_form();
		//check_box();   /*this portion working done*/
		//windows();
		droppable();
	}

	
	public static void practice_form() throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jasme\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // to globally tell driver to find each element for at least 3 seconds
		JavascriptExecutor js=(JavascriptExecutor) driver;  /*to execute jsexecuter*/
		driver.get("https://www.demoqa.com/");
		driver.manage().window().maximize(); //to maximize browser window
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		WebElement form= driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[2]"));
		form.click();
		driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[2]/div")).click();
		driver.findElement(By.cssSelector("a[id='close-fixedban']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Jasmeen");
		driver.findElement(By.id("lastName")).sendKeys("Kaur");
		driver.findElement(By.id("userEmail")).sendKeys("jasmeenkaur1234@gmail.com");
		driver.findElement(By.xpath("//div[@id='genterWrapper']/div/div[2]/label")).click();
		driver.findElement(By.id("userNumber")).sendKeys("123456789123568");
		driver.findElement(By.id("dateOfBirthInput")).click();
		driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']")).click();
		driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']/option[2]")).click();
		driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']")).click();
		driver.findElement(By.xpath("//option[@value='1997']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Choose Monday, February 17th, 1997']")).click();			
		driver.findElement(By.id("subjectsInput")).sendKeys("Hello there i am filling form");
		driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
		driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
		driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\jasme\\Pictures\\image7.jpg");
		driver.findElement(By.id("currentAddress")).sendKeys("5 Argelia Crescent, Brampton, ON, L6X5N5");
		WebElement state= driver.findElement(By.id("stateCity-wrapper"));
		js.executeScript("arguments[0].scrollIntoView();",state);   /*to scroll until find state filed else throws error */
		driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/div[2]/div/div/div[1]/div[2]/div/input")).sendKeys("NCR",Keys.TAB);
		driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/div[3]/div/div/div[1]/div[2]/div/input")).sendKeys("Delhi",Keys.TAB);
		driver.findElement(By.id("submit")).click();
		WebElement close_button=driver.findElement(By.id("closeLargeModal"));
		js.executeScript("arguments[0].scrollIntoView();",close_button);
		driver.findElement(By.id("closeLargeModal")).click();
		driver.close();
		driver.quit();
		
		
	
}
	
	public static void check_box() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jasme\\\\Downloads\\\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.demoqa.com/");
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		driver.findElement(By.xpath("//div[@class='accordion']/div")).click();
		driver.findElement(By.xpath("//div[@class='accordion']/div[1]/div/ul/li[2]")).click();
		driver.findElement(By.cssSelector("button[aria-label='Toggle']")).click();
		driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/span/button")).click();
		driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/span/button")).click();
		driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='result']/span[2]")).getText());
		driver.close();
		driver.quit();
		
		
		
	}
	
	public static void windows() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jasme\\\\Downloads\\\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		driver.findElement(By.xpath("//div[@class='accordion']/div[3]")).click();
		//driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("windowButton")).click();
		//driver.findElement(By.id("messageWindowButton")).click();
		Set<String> newtab = driver.getWindowHandles();
		Iterator<String>it = newtab.iterator();
		String parentId= it.next();
		String childId= it.next();
		driver.switchTo().window(childId);
		//System.out.println(driver.findElement(By.tagName("body")).getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().window(parentId);
		//System.out.println(driver.getTitle());
		/*driver.switchTo().window(childId2);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		driver.switchTo().window(childId3);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.tagName("body")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());*/
		
		
		
	}
	
	
	public static void droppable()
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jasme\\\\Downloads\\\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		JavascriptExecutor js= (JavascriptExecutor) driver;         
		driver.get("https://www.demoqa.com/");
		WebElement card= driver.findElement(By.xpath("//div[@class='home-body']"));
		card.click();
		driver.findElement(By.cssSelector("a[id='close-fixedban']")).click();
		WebElement drop= driver.findElement(By.xpath("//div[@class='accordion']/div[5]"));
		js.executeScript("arguments[0].scrollIntoView();",drop);
		drop.click();
		driver.findElement(By.xpath("//div[@class='accordion']/div[5]/div/ul/li[4]")).click();
		Actions a = new Actions(driver);
		WebElement Source= driver.findElement(By.id("draggable"));
		WebElement Target= driver.findElement(By.id("droppable"));
		a.dragAndDrop(Source,Target).build().perform();   //simple drop done
		
		
	}
	
	
	

	
	
	}

