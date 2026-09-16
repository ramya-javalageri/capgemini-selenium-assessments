package Day7_AssessmentPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Recruitmentpage {
	WebDriver driver;
	Actions act;

	public Recruitmentpage(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addButton;
	
	@FindBy(name = "firstName")
	private WebElement fntf;
	
	@FindBy(name = "middleName")
	private WebElement mntf;
	
	@FindBy(name = "lastName")
	private WebElement lntf;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement vacancy;

	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement emailtf;
	
	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	private WebElement phnotf;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	

	public void getAddButton() {
	    addButton.click();
	}

	public void getFntf(String value) {
	    fntf.sendKeys(value);
	}

	public void getMntf(String value) {
	    mntf.sendKeys(value);
	}

	public void getLntf(String value) {
	    lntf.sendKeys(value);
	}
	
	public void selectVacancy() throws InterruptedException, AWTException {
		vacancy.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getEmailtf(String value) {
	    emailtf.sendKeys(value);
	}

	public void getPhnotf(String value) {
	    phnotf.sendKeys(value);
	}

	public void getFileUpload(String value) {
	    fileUpload.sendKeys(value);
	}

	public void getSaveButton() {
	    saveButton.click();
	}

}

