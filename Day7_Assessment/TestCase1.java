package Day7_Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Day7_AssessmentPOM.Homepage;
import Day7_AssessmentPOM.Loginpage;
import Day7_AssessmentPOM.Recruitmentpage;

public class TestcaseImplementation {
	public static void main(String [] args) throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Day7/CommonData.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pwd = p.getProperty("pwd");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day7/TestCase1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String mn = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String phno = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String filepath = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		String date = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		String cname = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
		String fromdate = wb.getSheet("Sheet1").getRow(1).getCell(8).getStringCellValue();
		String todate = wb.getSheet("Sheet1").getRow(1).getCell(9).getStringCellValue();
		
		
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
		rec.getMntf(mn);
		rec.getLntf(ln);
		rec.getVacancy();
		rec.getEmailtf(email);
		rec.getPhnotf(phno);
		rec.getFileUpload(filepath);
//		rec.getDate(date);
		rec.getSaveButton();
		Thread.sleep(2000);
		
		//candidates
		rec.getCandidates();
//		rec.getJobTitle();
		rec.getCvacancy();
//		rec.getHiringManager();
//		rec.getStatus();
		rec.getCname(cname);
//		rec.getFromDate(fromdate);
//		rec.getToDate(todate);
		rec.getSearchButton();
		
		//verify
		if(rec.getNoRecordsFound().size()>0)
			System.out.println("Record not found");
		else
			System.out.println("record found");
		
		Thread.sleep(4000);
		//log out
		homepage.getLogoutButton();
		System.out.println("Logged out successfully");
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
			
		
		
				
		
	}
}
