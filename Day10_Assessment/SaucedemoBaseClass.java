package Day10_BaseclassUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Day10_POMpages.CartPage;
import Day10_POMpages.CheckoutOverviewPage;
import Day10_POMpages.CheckoutPage;
import Day10_POMpages.HomePage;
import Day10_POMpages.LoginPage;
import Day10_POMpages.checkoutCompletePage;
import Day10_data.Data;

public class SaucedemoBaseClass extends Data {
	
	protected WebDriver driver;
	protected HomePage homePage;
	protected CartPage cartPage;
	protected CheckoutPage checkoutPage;
	protected CheckoutOverviewPage checkoutOverviewPage;
	protected checkoutCompletePage checkoutCompletePage;
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		Reporter.log("Open database connectivity",true);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("close database connectivity",true);
	}
	
	@BeforeTest
	public void beforeTest()
	{
		Reporter.log("pre conditions",true);
	}
	
	@AfterTest
	public void afterTest()
	{
		Reporter.log("post conditions",true);
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		// Avoid Change Password popup
		data();
		if(browser.equals("chrome"))
		{
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		}
		else if(browser.equals("edge"))
		{
			EdgeOptions settings = new EdgeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(settings);
		}
		else if(browser.equals("firefox"))
		{
			FirefoxOptions settings = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("signon.management.page.breachAlert.enabled", false);
			settings.setProfile(profile);
			driver = new FirefoxDriver(settings);
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new checkoutCompletePage(driver);
		
		Reporter.log("launch the browser",true);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		Reporter.log("close the browser",true);
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		Thread.sleep(2000);
		LoginPage login = new LoginPage(driver);
		
		driver.get(url);
		
		login.getUntf(un);
		Thread.sleep(1000);
		
		login.getPwdtf(pwd);
		Thread.sleep(1000);
		
		login.getLoginButton();
		Thread.sleep(2000);
		
		Reporter.log("login done",true);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		Reporter.log("logout done",true);
	}
}
