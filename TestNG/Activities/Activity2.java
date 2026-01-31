package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");

	}

	@Test
	public void titleTest() {

		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");

	}
	
	@Test
	public void failureTest() {
		
		WebElement blackBtn = driver.findElement(By.xpath("//button[text()= 'Black']"));
		Assert.assertEquals(true, blackBtn.isDisplayed());
	
	}
	
	@Test (enabled = false)
	public void skipTest() {
		
		System.out.println("This test is skipped by disabling it");
	}
	
	@Test
	public void throwSkipTest() {
		
		throw new SkipException("This test is skipped with an exception");
		
	}
	
	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
