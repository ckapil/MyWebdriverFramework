package com.sm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sm.qa.base.TestBase;
import com.sm.qa.pages.ListingPage;
import com.sm.qa.pages.LoginPage;
import com.sm.qa.util.TestUtil;

public class ListingPageTest extends TestBase {

	LoginPage loginPage;
	ListingPage listingPage;

	String sheetName = "ListingPage";

	public ListingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		listingPage = loginPage.loginToSM(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void verifyUserInitialsTest() {
		String userInitials = listingPage.getUserInitials();
		Assert.assertEquals(userInitials, prop.getProperty("userInitials"));
	}

	@Test(priority = 2)
	public void verifyPageTitleTest() {
		String pageTitle = listingPage.getListingPageTitle();
		Assert.assertEquals(pageTitle, "Selling Manager");
	}

	@Test(priority = 1)
	public void verifyListingTableColNamesTest() {
		Object headers[][] = TestUtil.getTestData(sheetName, 0);
		Assert.assertTrue(listingPage.verifyListingTableColNames(headers), "Testing");

	}

	@DataProvider
	public Object[][] getSMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getSMTestData")
	public void verifyProductListingTest(String listingID, String title, String shippingEligibility, String status) {
		// Assert.assertTrue(listingPage.verifyProductListing("110291461180", "Apple
		// iPhone 7 Plus - 128GB - Gold", "Not Eligible", "Updated"));
		Assert.assertTrue(listingPage.verifyProductListing(listingID, title, shippingEligibility, status));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
