package com.herokuqpp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

	private By usernameLocator  = By.id("username");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.tagName("button");
	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public SecureAreaPage login(String username, String password) {
		log.info("Executing login with username:"+username);
		//driver.findElement(usernameLocator).sendKeys(username);
		type(usernameLocator,username);
		//driver.findElement(passworLocator).sendKeys(password);
		type(passwordLocator,password);
		log.info("Executing login with password:"+password);

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(loginButtonLocator).click();
		click(loginButtonLocator);
		log.info("Click login button.");

		
		return new SecureAreaPage(driver,log);
	}

}
