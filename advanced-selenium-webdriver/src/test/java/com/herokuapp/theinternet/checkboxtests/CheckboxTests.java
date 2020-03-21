package com.herokuapp.theinternet.checkboxtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.basetest.TestUtils;
import com.herokuqpp.theinternet.pages.CheckboxPage;
import com.herokuqpp.theinternet.pages.WelcomePage;

public class CheckboxTests extends TestUtils{
	
	@Test
	public void selectTwoCheckboxTest() {
		log.info("star selecting two checkboxes test.");
		
		WelcomePage welcomePage  = new WelcomePage(driver,log);
		
		welcomePage.openPage();
		CheckboxPage checkboxPage = welcomePage.clickCheckboxPage();
		
		checkboxPage.selectAllCheckboxes();
		
		Assert.assertTrue(checkboxPage.areAllBoxesChecked(),"Not all checkboxes are selected.");
	}

}

