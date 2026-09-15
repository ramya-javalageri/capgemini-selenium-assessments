package Day7_AssessmentPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Recruitmentpage {
	WebDriver driver;
	Actions act;

	public Recruitmentpage(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addButton;
	
	@FindBy(name = "firstName")
	private WebElement fntf;
	
	@FindBy(name = "middleName")
	private WebElement mntf;
	
	@FindBy(name = "lastName")
	private WebElement lntf;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	private WebElement vacancy;
	
	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement emailtf;
	
	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	private WebElement phnotf;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
	private WebElement date;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//a[text()='Candidates']")
	private WebElement candidates;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
	private WebElement jobTitle;
	
	@FindBy(xpath = "//label[text()='Vacancy']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
	private WebElement cvacancy;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
	private WebElement hiringManager;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[4]")
	private WebElement status;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement cname;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromDate;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toDate;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//span[text()='No Records Found']")
	private List<WebElement> noRecordsFound;


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

	public void getVacancy() {
	    act.click(vacancy)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.ENTER)
	       .perform();
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

	public void getDate(String value) {
	    date.sendKeys(value);
	    date.click();
	}

	public void getSaveButton() {
	    saveButton.click();
	}

	public void getCandidates() {
	    candidates.click();
	}

	public void getJobTitle() {
	    act.click(jobTitle)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.ENTER)
	       .perform();
	}

	public void getCvacancy() {
	    act.click(cvacancy)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.ENTER)
	       .perform();
	}

	public void getHiringManager() {
	    act.click(hiringManager)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.ENTER)
	       .perform();
	}

	public void getStatus() {
	    act.click(status)
	       .sendKeys(Keys.DOWN)
	       .sendKeys(Keys.ENTER)
	       .perform();
	}

	public void getCname(String value) {
	    cname.sendKeys(value, Keys.DOWN, Keys.ENTER);
	}

	public void getFromDate(String value) {
	    fromDate.sendKeys(value, Keys.ENTER);
	}

	public void getToDate(String value) {
	    toDate.sendKeys(value, Keys.ENTER);
	}

	public void getSearchButton() {
	    searchButton.click();
	}

	public List<WebElement> getNoRecordsFound() {
	    return noRecordsFound;
	}
}

