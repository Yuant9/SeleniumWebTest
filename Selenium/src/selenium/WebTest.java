package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
	
	
	private static final String firstName = "Firstname";
	private static final String lastName = "Lastname";
	private static final String phone = "12345";
	private static final String email = "testt@email.com";
	private static final String password = "12345";

	
	public static WebDriver setUpDriver() {
		String exePath = "/Users/yuan/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static void register(WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		 driver.findElement(By.linkText("Register")).click();
		//fill the account info
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(password);
		driver.findElement(By.id("input-password")).sendKeys(phone);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		
		//check the check box to agree with Privacy Policy
		driver.findElement(By.name("agree")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")).click();
		System.out.println("Register done!");
	}
	
	public static void login(WebDriver driver) {
		 driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		 driver.findElement(By.linkText("Login")).click();
		
		 //fill the email and password
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
			
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")).click();
		System.out.println("Login done!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = setUpDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(4000);

		login(driver);
		 

	}
	
}
