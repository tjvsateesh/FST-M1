package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { 
            { "admin", "password" },
            { "adm", "pswd" }
        };
    }
	
	@Test(dataProvider = "Authentication")
	public void loginTest(String username, String password) {
		
		driver.get("https://training-support.net/webelements/login-form");
		
		WebElement usernameElement = driver.findElement(By.id("username"));
		WebElement passwordElement = driver.findElement(By.id("password"));

		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);

		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		try {
			driver.findElement(By.id("subheading")).isDisplayed();
			System.out.println("Invalid credentials");
			
		}catch(Exception e) {
			wait.until(ExpectedConditions.titleContains("Success"));

			String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
			Assert.assertEquals("Welcome Back, Admin!", loginMessage);
		}
	}
	
	@AfterClass
	public void tearDown() {

		driver.close();
	}

}
