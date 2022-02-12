package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//Define Page Factory/Object Repository/Page Libraries for Login Page Functionalities:
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(linkText = "Sign Up")
	WebElement signUpButton;
	
	@FindBy(linkText = "Classic CRM")
	WebElement switchToClassic;
	
	@FindBy(id = "onesignal-bell-launcher")
	WebElement subscriptButton;
	
	//Constructor Used to Initialize the above defined Page Factories in the current Class:
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions that needs to be Performed:
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateSubscriptButton()
	{
		return subscriptButton.isEnabled();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	
	public void valitadeSignUpButton()
	{
		signUpButton.click();
	}
	
	public void validateSwitchToClassicCRMButton()
	{
		switchToClassic.click();
	}
	
}