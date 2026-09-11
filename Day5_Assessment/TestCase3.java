/*
//Testcase 3 
1.Navigate to Demoappsqspiders application
2.Enter name, email,password and click on login  submit button
3.Read the data from json file.
*/

package Day5_Assessment;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase3 {

	public static void main(String[] args) throws IOException, Exception {

		//to fetch data from json file
		FileReader fir = new FileReader("./src/test/resources/Day5/TestCase3.json");
		
		JSONParser j = new JSONParser();
		
		Object javaobj = j.parse(fir);
		
		JSONObject json = (JSONObject)javaobj;
		
		String browser = json.get("browser").toString();
		String url = json.get("url").toString();
		String name = json.get("name").toString();
		String email = json.get("email").toString();
		String pwd = json.get("password").toString();
		
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
		
		//locate tf and send data
		driver.findElement(By.id("name")).sendKeys(name,Keys.TAB,email,Keys.TAB,pwd);
		
		//locate login button and click
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();

	}

}
