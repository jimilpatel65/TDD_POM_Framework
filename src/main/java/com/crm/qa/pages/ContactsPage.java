package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	
	@FindBy(xpath = "//i[@class='users icon']")
	WebElement target;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//th[contains(text(),'Name')]")
	WebElement nameLabel;
	
	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[1]")
	WebElement contactName;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createNewContactBtn;
	
	@FindBy(xpath ="//div[@class='ui header item mb5 light-black']")
	WebElement newContactLabel;
	
	@FindBy(name = "first_name")
	WebElement addFirstName;
	
	@FindBy(name = "last_name")
	WebElement addLastName;
	
	@FindBy(xpath = "//div[@class='four wide field']/button")
	WebElement privatizeContact;
	
	@FindBy(xpath = "//input[@placeholder='Number']")
	WebElement addNumber;
	
	@FindBy(name = "day")
	WebElement addDay;
	
	@FindBy(name = "year")
	WebElement addYear;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveContact;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void hoverAction()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(target).build().perform();
		builder.moveByOffset(1000,300).build().perform();
	}
	
	public boolean validateContactsPageLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public String validateNameLabel()
	{
		return nameLabel.getText();
	}
	
	public void selectContactsByName(String name)
	{
		List<WebElement> contactNames = driver.findElements(By.tagName("input"));
		contactNames.get(0).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
	
	public String verifyContactName()
	{
		return contactName.getText();
	}
	
	public String ClickonAddNewContact()
	{
		createNewContactBtn.click();
		return newContactLabel.getText();
	}
	
	public void addNewContact(String first, String last, String num)
	{
		addFirstName.sendKeys(first);
		addLastName.sendKeys(last);
		addNumber.sendKeys(num);
		
		/*WebElement addCountry = driver.findElement(By.xpath("//div[@class='four fields']/div[1]/div[1]/div[2]/div"));
		Select countryCode = new Select(addCountry);
		countryCode.selectByVisibleText(country);*/
		
		List<WebElement> doNot = driver.findElements(By.xpath("//div[@class='ui toggle checkbox']//label"));
		doNot.get(0).click();
		doNot.get(1).click();
		
		/*addDay.sendKeys(day);
		List<WebElement> dropDown = driver.findElements(By.xpath("//div[@class='menu transition']"));
		dropDown.get(6).click();
		div[@name='month']/div[2]//div
		dddYear.sendKeys(year);*/
		
		privatizeContact.click();
		//saveContact.click();
		
	}
}
