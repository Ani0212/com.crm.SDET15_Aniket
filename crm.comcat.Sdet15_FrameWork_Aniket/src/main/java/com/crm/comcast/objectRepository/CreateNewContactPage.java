package com.crm.comcast.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.crm.comcast.GenericUtils.WebDriverUtils;

public class CreateNewContactPage extends WebDriverUtils {
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	  private WebElement organizationLookUpImage;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * @param lastName
	 */
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContact(String lastName , String orgName) {
		lastNameEdt.sendKeys(lastName);
		organizationLookUpImage.click();
		SwitchtoWindow(driver, "Accounts&action");
		OrganisationPage op = new OrganisationPage(driver);
		op.getSearchText().sendKeys(orgName);
		op.getSubmitSearch().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		SwitchtoWindow(driver, "Contacts");
		saveBtn.click();
	}

}
