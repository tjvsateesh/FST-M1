package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");

	}
	
	@Test
	public void loginTest() {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		
		String expectedMessage = "Welcome Back, Admin!";
		
		String actualMessage = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	
	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
