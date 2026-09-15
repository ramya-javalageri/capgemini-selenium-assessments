package Day7_AssessmentPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pim;
	
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement admin;
	
	@FindBy(xpath = "//span[text()='Recruitment']")
	private WebElement recruitment;
	
	@FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
	private WebElement logout;
	
	@FindBy(xpath = "//a[text()='Logout']") 
	private WebElement logoutButton;
	
	public void getRecruitment() {
		recruitment.click();
	}

	public void getPim() {
		pim.click();
	}

	public void getAdmin() {
		admin.click();
	}
	
	public void getLogoutButton() {
		logout.click();
		logoutButton.click();
	}
	
}
