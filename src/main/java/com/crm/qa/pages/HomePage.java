package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase 
{
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement name;
	
	@FindBy(xpath = "//div[@class='header item']")
	WebElement logo;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]" )
	WebElement contacts;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasks;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNameLabel()
	{
		return name.isDisplayed();
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickContactsLink()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink()
	{
		deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink()
	{
		tasks.click();
		return new TasksPage();
	}
	
}
