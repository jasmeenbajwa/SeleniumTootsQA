package Selenium_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//frame_Selenium();
		NestedFrames();
		
		
		
		
		
	}
	
	
	public static void frame_Selenium()
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
		WebElement frameTab= driver.findElement(By.xpath("//div[@class='accordion']/div[3]"));
		js.executeScript("arguments[0].scrollIntoView();", frameTab);
		driver.findElement(By.xpath("//div[@class='accordion']/div[3]/div/ul/li[3]")).click();
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame("frame1");
		System.out.println("This is Frame 1 "+driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().defaultContent();
		WebElement Frame2= driver.findElement(By.id("frame2Wrapper"));
		js.executeScript("arguments[0].scrollIntoView();", Frame2);
		driver.switchTo().frame("frame2");
		System.out.println("This is frame 2 "+driver.findElement(By.id("sampleHeading")).getText());   //switching between frames done
		
	}
	
	
	public static void NestedFrames()
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
		WebElement frameTab= driver.findElement(By.xpath("//div[@class='accordion']/div[3]"));
		js.executeScript("arguments[0].scrollIntoView();", frameTab);
		driver.findElement(By.xpath("//div[@class='accordion']/div[3]/div/ul/li[4]")).click();
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.tagName("body")).getText()); //parent frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
		System.out.println(driver.findElement(By.tagName("p")).getText());// child frame
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.tagName("body")).getText());// back to main frame
		
		//  Nested Frames done
	}
	
	}


