package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	//Before each Test Case -- Launch the Browser and Login
	//Test Cases should be Executed Separately and should be Independent with each other
	//After each Test Case -- Close the Browser
	
	@BeforeMethod
	public void setUpBrowser()
	{
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title does not Match");
	}
	
	@Test (priority = 2)
	public void verifyNameLabelTest()
	{
		Assert.assertTrue(homePage.verifyNameLabel());
	}
	
	@Test (priority = 3)
	public void verifyContactsLinkTest()
	{
		contactsPage = homePage.clickContactsLink();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}
