package com.sm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sm.qa.base.TestBase;
import com.sm.qa.pages.ListingPage;
import com.sm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	ListingPage listingPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Selling Manager");
	}

	@Test(priority = 2)
	public void signInBoxTitleTest() {
		String signInBoxTitle = loginPage.getSignInBoxTitle();
		Assert.assertEquals(signInBoxTitle, "Selling Manager ™");
	}

	@Test(priority = 3)
	public void loginTest() {
		listingPage = loginPage.loginToSM(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
