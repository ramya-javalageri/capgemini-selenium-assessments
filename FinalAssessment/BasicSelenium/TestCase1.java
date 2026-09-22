package Final_Assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase1
{
	@Test
	public void TC1Test() throws InterruptedException
	{
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		
		WebElement t1 = driver.findElement(By.id("tog"));
		WebElement t2 = driver.findElement(By.id("togg"));
		
		WebElement t3=driver.findElement(By.id("toggl"));
		WebElement t4=driver.findElement(By.id("toggler"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", t1);
		js.executeScript("arguments[0].click()", t1);
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].removeAttribute('disabled')", t2);
		js.executeScript("arguments[0].click()", t2);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].removeAttribute('disabled')", t3);
		js.executeScript("arguments[0].click()", t3);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].removeAttribute('disabled')", t4);
		js.executeScript("arguments[0].click()", t4);
		
		
		driver.findElement(By.id("togglers")).click();
		
		if(driver.findElement(By.xpath("//p[text()='ORDER PLACED']")).isDisplayed())
			System.out.println("order is placed");
		else
			System.out.println("not placed");
		
		Thread.sleep(2000);
		driver.quit();
	
	}

}
