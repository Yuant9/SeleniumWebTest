package com.herokuqpp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";
	private By authenticationLinkLocator = By.linkText("Form Authentication");
	
	
	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);

	}
	
	public void openPage() {
		log.info("Opening page:"+ pageUrl);
		openUrl(pageUrl);
		log.info("Page opened.");
	}
	
	public LoginPage clickFormAuthentication() {
		log.info("Clicking form authenticatino link on website.");
		click(authenticationLinkLocator);
		return new LoginPage(driver,log);
	}
	
	
	

}
