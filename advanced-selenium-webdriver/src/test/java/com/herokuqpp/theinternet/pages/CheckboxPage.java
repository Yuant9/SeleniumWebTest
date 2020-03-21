package com.herokuqpp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage extends BasePageObject{
	
	private By checkbox = By.xpath("//input[@type='checkbox']");

	public CheckboxPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void selectAllCheckboxes() {
		log.info("checking all checkboxes");
		List<WebElement> checkboxes = findAll(checkbox);
		for(WebElement box:checkboxes) {
			if(!box.isSelected()) {
				box.click();
			}
		}
	}
	
	public Boolean areAllBoxesChecked() {
		log.info("Verifying all boxes are checked.");
		List<WebElement> checkboxes = findAll(checkbox);
		for(WebElement box:checkboxes) {
			if(!box.isSelected()) {
				return false;
			}
		}
		return true;
	}
	
	

	
	
}
