package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
	 WebDriver driver;
	 Alert alert;
	 
	    @BeforeClass
	    public void setUp() {

	        driver = new FirefoxDriver();
	        driver.get("https://training-support.net/webelements/alerts");
	        Reporter.log("Title of the page: " + driver.getTitle());
	    }
	 
	    @BeforeMethod
	    public void beforeMethod() {
	    	
	        Reporter.log("Test Case Setup started");
	        driver.switchTo().defaultContent();
	        
	    }
	 
	    @Test(priority = 1)
	    public void simpleAlertTestCase() {

	        driver.findElement(By.id("simple")).click();
	        Reporter.log("Clicked on Simple Alert");
	 
	        alert = driver.switchTo().alert();
	        Reporter.log("Switched to alert");
	 
	        String alertText = alert.getText();
	        Reporter.log("Alert text : " + alertText);
	 
	        // Assertion
	        Assert.assertEquals(alertText, "You've just triggered a simple alert!");
	 
	        alert.accept();
	        Reporter.log("Alert closed!");
	 
	    }
	 
	    @Test(priority = 2)
	    public void confirmAlertTestCase() {

	        driver.findElement(By.id("confirmation")).click();
	        Reporter.log("Clicked on Confirm Alert");

	        alert = driver.switchTo().alert();
	        Reporter.log("Switched to alert");
	 
	        String alertText = alert.getText();
	        Reporter.log("Alert text : " + alertText);
	 
	        // Assertion
	        Assert.assertEquals(alertText,"You've just triggered a confirmation alert!");
	 
	        alert.accept();
	        Reporter.log("Alert closed!");

	    }
	 
	    @Test(priority = 3)
	    public void promptAlertTestCase() {

	        driver.findElement(By.id("prompt")).click();
	        Reporter.log("Clicked on Prompt Alert");

	        alert = driver.switchTo().alert();
	        Reporter.log("Switched to alert");

	        String alertText = alert.getText();
	        Reporter.log("Alert text : " + alertText);
	 
	        // Assertion
	        Assert.assertEquals(alertText,"I'm a Prompt! Type something into me!");

	        alert.sendKeys("Hello!");
	        Reporter.log("Entered 'Hello' in the prompt");
	        alert.accept();
	        Reporter.log("Alert closed!");

	    }
	 
	    @AfterClass
	    public void tearDown() {
	        driver.close();
	    }
}
