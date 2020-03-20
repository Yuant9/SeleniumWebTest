package com.herokuapp.theinternet.basetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

	protected WebDriver driver;
	protected Logger log;


	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun=true)
	public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		
		log = LogManager.getLogger(testName);
		
		// Create driver
		System.out.println("Create driver: " + browser);
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		

		
	}
	
	@AfterMethod(alwaysRun=true)
	private void tearDown() {
		System.out.println("Close driver");
		log.info("Close driver");
		// Close browser
		driver.quit();
	}

}
