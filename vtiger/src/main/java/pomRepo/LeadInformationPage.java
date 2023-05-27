package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadInformationPage {
	WebDriver driver;
	
	public LeadInformationPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String verifyLeadsInformation(String leadsLastName) {
		return driver.findElement(By.xpath("(//span[contains(text(), '"+leadsLastName+"')])[1]")).getText();
	}

}
