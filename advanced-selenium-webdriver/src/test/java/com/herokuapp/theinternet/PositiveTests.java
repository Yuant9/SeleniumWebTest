package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.basetest.BaseTest;
import com.herokuapp.theinternet.basetest.TestUtils;
import com.herokuqpp.theinternet.pages.LoginPage;
import com.herokuqpp.theinternet.pages.SecureAreaPage;
import com.herokuqpp.theinternet.pages.WelcomePage;

public class PositiveTests extends TestUtils{

	@Test
	public void logInTest(){
		System.out.println("Starting logIn test");
		log.info("Starting logIn test");

		// open main page
		//String url = "http://the-internet.herokuapp.com/";
//		driver.get(url);
//		System.out.println("Main page is opened.");
//		log.info("Main page is opened.");
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();

		// Click on Form Authentication link
		//driver.findElement(By.linkText("Form Authentication")).click();
		LoginPage loginPage = welcomePage.clickFormAuthentication();

		// enter username and password
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
//		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		SecureAreaPage securePage = loginPage.login("tomsmith", "SuperSecretPassword!");

		sleep(2500);

		// click login button
//		WebElement logInButton = driver.findElement(By.className("radius"));
//		wait.until(ExpectedConditions.elementToBeClickable(logInButton));
//		logInButton.click();

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
