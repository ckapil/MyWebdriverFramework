package com.sm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//div[@class='signin-box']/h1")
	WebElement titleText;

	@FindBy(xpath = "//*[text()='Email']/following::input[1]")
	WebElement userSM;

	@FindBy(xpath = "//*[text()='Password']/following::input[1]")
	WebElement passwordSM;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	public LoginPage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Set user name
	public void setUserName(String strUserName) {
		userSM.sendKeys(strUserName);
	}

	// Set password
	public void setPassword(String strPassword) {
		passwordSM.sendKeys(strPassword);
	}

	// Click on login button
	public void clickLogin() {
		login.click();
	}

	// Get the title of Login Page
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	// Get the title of Sign In Box
	public String getSignInBoxTitle() {
		return titleText.getText();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public ListingPage loginToSM(String strUserName, String strPasword) {
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();

		return new ListingPage();
	}

}
