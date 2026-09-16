package SauceDemoKeyword;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordImplementation {
	WebDriver driver;
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void openUrl()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public void usernameTf()
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	
	public void pwdTf()
	{
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	public void loginButton()
	{
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
