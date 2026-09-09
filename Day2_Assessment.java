//Testcase 1
/*
1.Navigate to the facebook application.
2.Click on create new account button.
3.Verify that fistname and surname textfields are aligned in same line or not.
*/

package Day2_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {

		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get("https://www.facebook.com/");
		
		//locate create new account and click
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		
		//locate fn tf and get location
		Point fn = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_")).getLocation();
		
		//locate surname tf and get location
		Point sn = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_")).getLocation();
		
		System.out.println(fn +" "+sn);
		
		//verify the fn and surname tf are allinged on same or not 
		if(fn.x==sn.x || fn.y==sn.y )
			System.out.println("in same line");
		else
			System.out.println("Not is same line");
	
		//close the browser
		Thread.sleep(2000);
		driver.quit();
	}

}


//Testcase 2 
/*
1.Navigate to facebook application 
2.capture the location of create new account button.
3.Capture the Dom Attribute and dom property for email address textfield before and after entering email address
4.click on create new account capture the size of submit button
5.capture the css properties of submit button (minimum 3).
*/
package Day2_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser window
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get("https://www.facebook.com/");
		
		//locate create new account element and get location
		Point p = driver.findElement(By.xpath("//span[text()='Create new account']")).getLocation();
		System.out.println("create new account location: "+p);
		
		//locate email text field
		WebElement ele = driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
		
		System.out.println("Before entering email");
		System.out.println("Dom attribute: "+ele.getDomAttribute("value"));
		System.out.println("Dom property: "+ele.getDomProperty("value"));
		ele.sendKeys("ramya@gmail.com");
		System.out.println("After entering email");
		System.out.println("Dom attribute: "+ele.getDomAttribute("value"));
		System.out.println("Dom property: "+ele.getDomProperty("value"));
		
		//click create new account button
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		
		//locate submit button
		WebElement button = driver.findElement(By.xpath("//span[text()='Submit']"));
		
		//get the size of the submit button
		Dimension size = driver.findElement(By.xpath("//span[text()='Submit']")).getSize();
		
		//print the submit button size
		System.out.println("Size of submit button: "+size);
		
		//print the styles of the submit button
		System.out.println("submit button font-family: "+button.getCssValue("font-family"));
		System.out.println("submit button max-width: "+button.getCssValue("max-width"));
		System.out.println("submit button display: "+button.getCssValue("display"));
		System.out.println("submit button overflow-y: "+button.getCssValue("overflow-y"));
		System.out.println("submit button color: "+button.getCssValue("color"));
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
			
	
	}

}


//Testcase 3 
/*
1.Navigate to demowebshop
2.Identify the webelement(14.1-inch laptop)-->identify add to cart button capture the size and them click on the buuton.
3.Click on shopping cart link.
4.verify remove check box is selected or not and capture the complete information using getRect().
5.Verify Alert message is displayed or not before and after clicking on Apply coupon button
6.Take screenshot of image(Laptop).
*/

package Day2_Assessment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TeastCase3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get("https://demowebshop.tricentis.com/");
		
		//locate add to cart button
		WebElement cartbutton = driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']"));
	
		//get the size of the add to cart button
		Dimension size = cartbutton.getSize();
		
		System.out.println("size of add to cart button: "+size);
		
		//click the add to cart button
		cartbutton.click();
		
		//locate shopping cart and click
		WebElement sclink = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		sclink.click();
		
		//locate remote check box
		WebElement removecheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	
		//verify remove check box is selected or not
		if(removecheckbox.isSelected())
			System.out.println("remove check box is selected");
		else
			System.out.println("remove check box is not selected");
		
		//print the location and size using getRect() of remove check box
		System.out.println("check box width: "+removecheckbox.getRect().getWidth());
		System.out.println("check box Height: "+removecheckbox.getRect().getHeight());
		System.out.println("check box x offset: "+removecheckbox.getRect().getX());
		System.out.println("check box y offset: "+removecheckbox.getRect().getY());
		
		//check if alert message is displayed or not before clicking apply coupon
		try
		{
			String text = driver.findElement(By.xpath("//div[@class='message']")).getText();
			System.out.println("alert message before clicking Apply coupon button: "+text);
		
		}
		catch(Throwable e)
		{
			System.out.println("alert message is not displayed before clicking apply coupon button");
		}
		
		//click apply coupon button
		driver.findElement(By.xpath("//input[@value='Apply coupon']")).click();
		Thread.sleep(2000);
		
		//check if alert message is displayed or not After clicking apply coupon
		String text1 = driver.findElement(By.xpath("//div[@class='message']")).getText();
		
		if(text1.isBlank())
			System.out.println("alert message is not displayed after clicking apply coupon button");
		else
			System.out.println("alert message is displayed after clicking apply coupon button");
		
		//take screenshot of the laptop
		WebElement laptop = driver.findElement(By.xpath("(//img[@title='Show details for 14.1-inch Laptop'])[2]"));
		File src = laptop.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/laptop.png");
		FileHandler.copy(src, des);
		System.out.println("Screenshot taken successfully");
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
		
	}

}
