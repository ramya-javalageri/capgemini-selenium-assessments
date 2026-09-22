package Final_Assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase3 {
	@Test
	public void tc3() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));

		WebElement ele2 = driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		
		WebElement ele4 = driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		
		WebElement mobile = driver.findElement(By.xpath("//div[@id='dropZone1']"));
		
		WebElement laptop = driver.findElement(By.xpath("//div[@id='dropZone2']"));
		
		Actions act = new Actions(driver);
		
		ele1.click();
		ele3.click();
		act.dragAndDrop(ele1, mobile).perform();
		Thread.sleep(1000);
		
		ele2.click();
		ele4.click();
		act.dragAndDrop(ele2, laptop).perform();
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		driver.quit();
	
	}

}
