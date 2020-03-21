package com.herokuapp.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.basetest.TestUtils;
import com.herokuqpp.theinternet.pages.LoginPage;
import com.herokuqpp.theinternet.pages.SecureAreaPage;
import com.herokuqpp.theinternet.pages.WelcomePage;

public class PositiveTests extends TestUtils{

	@Test
	public void logInTest(){
		System.out.println("Starting logIn test");
		log.info("Starting logIn test");

		// open welcome page
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthentication();

		// enter username and password

		SecureAreaPage securePage = loginPage.login("tomsmith", "SuperSecretPassword!");

		sleep(2500);

		// verifications
		// new url
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

		// logout button is visible
		Assert.assertTrue(securePage.isLogOutButtonVisible(),
				"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = securePage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);


	}
}
