package vtiger.leads;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.IPathConstant;
import pomRepo.CreatingNewLeadPage;
import pomRepo.HomePage;
import pomRepo.LeadInformationPage;
import pomRepo.LeadsPage;

@Listeners(genericUtility.ListenerImplementationClass.class)

public class ToCreateALeadTest extends BaseClass {
	
	@Test//(retryAnalyzer = genericUtility.RetryAnalyserImplementationClass.class)
	public void tocreateALeadAndVerifyTheLeadNameTest() throws EncryptedDocumentException, IOException {
		
		String leadSalutation = eUtils.fetchDataFromExcelSheet(IPathConstant.LEADSHEETNAME, 16, 2);
		String firstName = eUtils.fetchDataFromExcelSheet(IPathConstant.LEADSHEETNAME, 17, 2);
		String lastName = eUtils.fetchDataFromExcelSheet(IPathConstant.LEADSHEETNAME, 18, 2);
		String comapanyName = eUtils.fetchDataFromExcelSheet(IPathConstant.LEADSHEETNAME, 19, 2);
		String assignedTo = eUtils.fetchDataFromExcelSheet(IPathConstant.LEADSHEETNAME, 22, 2);

		
		HomePage home=new HomePage(driver);
		home.clickOnLeadsModule();
		LeadsPage lead=new LeadsPage(driver);
		lead.clickOnCreateLeadPlusButton();
		
		CreatingNewLeadPage newLead = new CreatingNewLeadPage(driver);
		newLead.selectLeadNameSalutation(leadSalutation);
		newLead.enterLeadsFirstName(firstName);
		newLead.enterLeadsLastName(lastName);
		newLead.enterLeadsCompanyName(comapanyName);
		newLead.clickOnGroupRadioButton();
		newLead.selectFromAssignedToDropdown(assignedTo);
		newLead.clickOnSaveButton();
		
		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		String actualLeadLastName = leadInfo.verifyLeadsInformation(lastName);
		
		Assert.assertEquals(actualLeadLastName, lastName);
		System.out.println("The Lead has been created and verified");
	}

}
