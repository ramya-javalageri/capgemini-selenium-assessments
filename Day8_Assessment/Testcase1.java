package Day7_Assessment;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Day7_AssessmentPOM.Candidatespage;
import Day7_AssessmentPOM.Homepage;
import Day7_AssessmentPOM.Loginpage;
import Day7_AssessmentPOM.Recruitmentpage;

public class TestcaseImplementation {
	public static void main(String [] args) throws IOException, InterruptedException, AWTException
	{
		//fetch data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/Day7/CommonData.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pwd = p.getProperty("pwd");
		
		//fetch data from excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day7/TestCase1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String phno = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String filepath = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		
		
		//launch the browser
		WebDriver driver = null;
		
		if(browser.contains("chrome"))
			driver = new ChromeDriver();
		
		if(browser.contains("edge"))
			driver = new EdgeDriver();
		
		if(browser.contains("firefox"))
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Loginpage login = new Loginpage(driver);
		Homepage homepage = new Homepage(driver);
		Recruitmentpage rec = new Recruitmentpage(driver);
		Candidatespage c = new Candidatespage(driver);
		driver.get(url);
		
		//login
		login.getUntf(un);
		login.getPwdtf(pwd);
		login.getLoginButton();
		
		//home page
		homepage.getRecruitment();
		
		//add
		rec.getAddButton();
		
		rec.getFntf(fn);
		
		rec.getLntf(ln);
		Thread.sleep(2000);
		
		rec.selectVacancy();
		Thread.sleep(3000);
		
		rec.getEmailtf(email);
		
		rec.getPhnotf(phno);
		
		rec.getFileUpload(filepath);
		
		rec.getSaveButton();
		Thread.sleep(2000);
		
		//candidates
		c.getCandidates();
		
		c.getCname(fn);
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		c.getSearchButton();
		Thread.sleep(2000);
		
		//verify
		if(c.getIsRecordsFound())
			System.out.println("Record found");
		else
			System.out.println("No record found");
		
		Thread.sleep(3000);
		
		//log out
		homepage.getLogoutButton();
		System.out.println("Logged out successfully");
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();		
		
				
		
	}
}
