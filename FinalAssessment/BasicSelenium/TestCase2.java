package Final_Assessment1;

import org.testng.annotations.Test;
import org.openqa.selenium.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	@Test
	public void tc2() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");

		WebElement p1 = driver.findElement(By.xpath("//input[@value='40']"));
		
		p1.sendKeys(Keys.RIGHT);
		Thread.sleep(1000);
		p1.sendKeys(Keys.RIGHT);
		Thread.sleep(1000);
		p1.sendKeys(Keys.RIGHT);
		
		boolean val = driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']")).isDisplayed();
		
		if(val)
			System.out.println("slidded till Mens Cotton Jacket");
		else
			System.out.println("not slided");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
