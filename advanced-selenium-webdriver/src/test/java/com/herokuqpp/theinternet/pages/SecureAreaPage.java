package com.herokuqpp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	private By textIdLocator = By.id("flash-messages");
	private By logoutButtonLocator = By.xpath("//a[@class='button secondary radius']");
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getText() {
		log.info("Getting secure area text.");
		return getText(textIdLocator);
	}
	
	public Boolean isLogOutButtonVisible() {
		return find(logoutButtonLocator).isDisplayed();
	}

}
