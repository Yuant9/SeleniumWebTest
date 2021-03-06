package com.herokuapp.theinternet;

import java.util.Map;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.basetest.CsvDataProvider;
import com.herokuapp.theinternet.basetest.TestUtils;
import com.herokuqpp.theinternet.pages.LoginPage;
import com.herokuqpp.theinternet.pages.SecureAreaPage;
import com.herokuqpp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtils{

	

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1,dataProvider="csvReader",dataProviderClass=CsvDataProvider.class)
	public void loginTest(String[] dataset) {
		System.out.println("Starting negativeTest");
		
		String no = dataset[0];
		String username = dataset[1];
		String password = dataset[2];
		String expectedErrorMessage = dataset[3];
		String description = dataset[4];
		
		log.info("Starting negativeTest no."+no);

		// open main page
		String url = "http://the-internet.herokuapp.com/";
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
//		driver.get(url);
//		System.out.println("Main page is opened.");
//		log.info("Main page is opened.");

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthentication();
		//driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
		SecureAreaPage securePage = loginPage.login(username, password);

		// push log in button
//		driver.findElement(By.className("radius")).click();

		// Verification
		String actualErrorMessage = securePage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}
	




}
