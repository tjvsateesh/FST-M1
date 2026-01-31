package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;

	@BeforeClass (alwaysRun = true)
	public void setUp() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");

	}
	
	@Test
	public void titleTest() {
		
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
		
	}
	
	@Test (groups = {"HeaderTests"})
	public void headerTest1() {
		
		String actual_header3Text = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
		Assert.assertEquals(actual_header3Text, "Heading #3");
		
	}
	
	@Test (groups = {"HeaderTests"})
	public void headerTest2() {
		
		Color actual_header5Color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
        Assert.assertEquals(actual_header5Color.asHex(), "#9333ea");
        
	}
	
	@Test (groups = {"ButtonTests"})
	public void buttonTest1() {
			
		String actual_emeraldButtonText = driver.findElement(By.xpath("//button[contains(@class, '-emerald-')]")).getText();
		Assert.assertEquals(actual_emeraldButtonText, "Emerald");
		
	}
	
	@Test (groups = {"ButtonTests"})
	public void buttonTest2() {
		
		Color actual_button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(., 'Purple')]")).getCssValue("color"));
        Assert.assertEquals(actual_button2Color.asHex(), "#581c87");
        
	}
	
	@AfterClass (alwaysRun = true)
	public void tearDown() {

		driver.quit();

	}
	
}
