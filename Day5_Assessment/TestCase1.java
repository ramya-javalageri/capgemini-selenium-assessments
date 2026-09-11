
/*
//Test- case  1 
1.Navigate to DemoWebshop application 
2.Click on login link .
3.Enter email and password and click on login button by reading the data from property file.
 */

package Day5_Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//to fetch the data from properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/Day5/TestCase1.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String email = p.getProperty("email");
		String pwd = p.getProperty("password");
		
		WebDriver driver = null;
		
		//launch the browser
		switch(browser)
			{
			case("chrome"):
			{
				driver = new ChromeDriver();
				break;
			}
			case("edge"):
			{
				driver = new EdgeDriver();
				break;
			}
			case("firefox"):
			{
				driver = new FirefoxDriver();
				break;
			}
		}
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get(url);
		
		//locate login button
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		//locate email tf and send data
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
		
		//locate password tf and send data
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
		
		//locate login button and click
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		//verify
		WebElement text = driver.findElement(By.linkText("Log out"));
		
		if(text.isDisplayed())
			System.out.println("login successfull");
		else
			System.out.println("not login");
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
		

	}

}
