package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	
	public CreatingNewLeadPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "salutationtype")
	private WebElement salutationDropdown;
		
	@FindBy (name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy (name = "lastname")
	private WebElement lastNameTextField;  
	
	@FindBy (name = "company")
	private WebElement companyNameTextField;
	
	@FindBy (name = "assigntype")
	private WebElement groupToRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getAssignedToDropDown() {
		return assignedToDropDown;
	}
	
	public WebElement getSalutationDropdown() {
		return salutationDropdown;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getGroupToRadioButton() {
		return groupToRadioButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void selectLeadNameSalutation(String salutation) {
		new Select(salutationDropdown).selectByVisibleText(salutation);
	}
	
	public void enterLeadsFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterLeadsLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	
	public void enterLeadsCompanyName(String comapanyName) {
		companyNameTextField.sendKeys(comapanyName);
	}
	
	public void clickOnGroupRadioButton() {
		groupToRadioButton.click();
	}
	
	public void selectFromAssignedToDropdown(String option) {
		new Select(assignedToDropDown).selectByVisibleText(option);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
