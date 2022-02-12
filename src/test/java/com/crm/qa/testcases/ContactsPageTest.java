package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUpBrowser()
	{
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage.hoverAction();
		contactsPage = homePage.clickContactsLink();
	}
	
	//@Test (priority = 1)
	public void validateContactsPageLabelTest()
	{
		Assert.assertTrue(contactsPage.validateContactsPageLabel());
	}
	
	//@Test (priority = 2)
	public void validateNameLabelTest()
	{
		Assert.assertEquals(contactsPage.validateNameLabel(), "Name");
	}
	
	//@Test (priority = 3)
	public void selectContactsByNameTest()
	{
		contactsPage.selectContactsByName("test test");
		Assert.assertEquals(contactsPage.verifyContactName(),"test test");
	}
	
	//THIS DATA PROVIDER NOT WORKING: Giving Error "Unsyncronized Array Outbound Exception".
	//(Refer to "TestUtils" for the Excel file reader)
	//(Refer to "TestData" for the Excel File)
	@DataProvider
	public Object[][] getCRMTestData() throws EncryptedDocumentException, IOException
	{
		Object data[][] = null;
		try 
		{
			data = TestUtil.getTestData(sheetName);
		} 
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@Test (priority = 4, dataProvider = "getCRMTestData")
	public void clickOnCreateNewContactTest(String firstname, String lastname, String phonenumber)
	{
		contactsPage.ClickonAddNewContact();
		//contactsPage.addNewContact("abc", "xyz", "2343345674");
		contactsPage.addNewContact(firstname, lastname, phonenumber);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
