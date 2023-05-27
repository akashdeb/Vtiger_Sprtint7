package pomRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(linkText = "Leads")
	private WebElement leadsModule;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;
	
	@FindBy(linkText = "More")
	private WebElement moreDropdown;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;
	
	@FindBy(linkText = "Quotes")
	private WebElement quotesModule;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorDropdown;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutOption;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdministratorDropdown() {
		return administratorDropdown;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}

	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getMoreDropdown() {
		return moreDropdown;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getQuotesModule() {
		return quotesModule;
	}

	public void clickOnLeadsModule() {
		leadsModule.click();
	}
	
	public void clickOnOrganizationModule() {
		organizationsModule.click();
	}
	
	public void clickOnOpportunityModule() {
		opportunitiesModule.click();
	}
	
	public void clickOnCampaignModule() {
		Actions action=new Actions(driver);
		action.moveToElement(moreDropdown).perform();
		campaignsModule.click();
	}
	
	public void clickOnQuotesModule() {
		Actions action=new Actions(driver);
		action.moveToElement(moreDropdown).perform();
		quotesModule.click();	
	}
	
	public void logoutAction() {	
		Actions action = new Actions(driver);
		action.moveToElement(administratorDropdown).perform();
		signOutOption.click();
	}
}
