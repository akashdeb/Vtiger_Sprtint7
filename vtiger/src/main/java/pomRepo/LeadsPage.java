package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	@FindBy(xpath = "//img[@title=\"Create Lead...\"]")
	private WebElement createLeadPlusButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateLeadPlusButton() {
		return createLeadPlusButton;
	}

	public void clickOnCreateLeadPlusButton() {
		createLeadPlusButton.click();
	}

	
}
