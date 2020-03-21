package com.herokuqpp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	
	protected WebDriver driver;
	protected Logger log;
	public BasePageObject(WebDriver driver, Logger log) {
		super();
		this.driver = driver;
		this.log = log;
	}
	
	/**
	 * wait for expectedCondition for specific seconds
	 * @param condition
	 * @param timeOutSeconds
	 */
	private void waitFor(ExpectedCondition<WebElement>condition, Integer timeOutSeconds) {
		timeOutSeconds = timeOutSeconds != null ? timeOutSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
		wait.until(condition);
	}
	
	/**
	 * wait for seconds for element with given locator to be visible on the page
	 * @param locator
	 * @param timeOutSeconds
	 */
	protected void waitForVisibilityOf(By locator, Integer...timeOutSeconds) {
		int attemps = 0;
		while(attemps < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutSeconds.length > 0 ? timeOutSeconds[0] : null));
				break;
			}catch(StaleElementReferenceException e){
				
			}
			attemps++;
		}
	}
	
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		waitForVisibilityOf(locator,5);
		find(locator).click();
	}
	
	protected void type(By locator, String text) {
		waitForVisibilityOf(locator,5);
		find(locator).sendKeys(text);
	}
	
	protected String getText(By locator) {
		waitForVisibilityOf(locator,5);
		return find(locator).getText();
	}
	
	protected List<WebElement> findAll(By locator){
		return driver.findElements(locator);
	}

	

}
