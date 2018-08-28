package com.sm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sm.qa.base.TestBase;

public class ListingPage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//div[@class='header-username']")
	WebElement userInitials;

	public ListingPage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Get the initials of logged in user
	public String getUserInitials() {
		return userInitials.getText();
	}

	// Get the title of Login Page
	public String getListingPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyListingTableColNames(Object colNames[][]) {
		for (int i = 0; i < colNames.length; i++) {
			for (int j = 0; j < colNames[i].length; j++) {
				boolean isColDisplayed = driver
						.findElement(
								By.xpath("//tr//th[*]//span[contains(text(),'" + colNames[0][j].toString() + "')]"))
						.isDisplayed();
				if (isColDisplayed == false)
					return false;
			}
		}
		return true;
	}

	public WebElement getProductListingData(String listingID) {
		return driver.findElement(By.xpath("//tbody//tr[*]//td[contains(text(),'" + listingID + "')]//ancestor::tr"));
	}

	public boolean verifyProductListing(String listingID, String title, String shippingEligibility, String status) {
		WebElement tableRow = getProductListingData(listingID);
		if (tableRow.findElement(By.partialLinkText(title)).isDisplayed() == false
				|| tableRow.findElement(By.xpath("//td[contains(text(),'" + shippingEligibility + "')]"))
						.isDisplayed() == false
				|| tableRow.findElement(By.xpath("//td[contains(text(),'" + status + "')]")).isDisplayed() == false)
			return false;
		else
			return true;
	}

}
