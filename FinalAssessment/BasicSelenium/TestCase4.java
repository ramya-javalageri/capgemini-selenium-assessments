package Final_Assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase4 {
	@Test
	public void tc4() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.shoppersstack.com/");
		
		driver.findElement(By.xpath("//img[@alt='iphone']")).click();
		driver.findElement(By.xpath("//input[@id='Check Delivery']")).sendKeys("583104");
		WebElement ref = driver.findElement(By.xpath("//button[@id='Check']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ref));
		ref.click();
		String text = driver.findElement(By.xpath("//p[text()='Not Deliveriable.']")).getText();
		System.out.println(text);
		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
