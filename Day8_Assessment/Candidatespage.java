package Day7_AssessmentPOM;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Candidatespage {
	WebDriver driver;
	Actions act;

	public Candidatespage(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@FindBy(xpath = "//a[text()='Candidates']")
	private WebElement candidates;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement cname;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[text()='Candidate']/ancestor::div[@class='orangehrm-container']/descendant::div[text()='Ramya  J']")
	private WebElement isRecordsFound;

	public void getCandidates() {
	    candidates.click();
	}

	public void getCname(String value) throws InterruptedException {
	    cname.sendKeys(value);
    }

	public void getSearchButton() {
	    searchButton.click();
	}

	public boolean getIsRecordsFound() {
	    if(isRecordsFound.isDisplayed())
	    	return true;
	    else
	    	return false; 			
	}
}
