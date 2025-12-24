package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity8 extends BaseTest {

	@Test
	public void backendLoginTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String expected_pageTitle = "Log In ‹ Alchemy Jobs — WordPress";
		String expected_homePageTitle = "Dashboard ‹ Alchemy Jobs — WordPress";
		String actual_pageTitle = driver.getTitle();
		Assert.assertEquals(actual_pageTitle, expected_pageTitle);
		
		WebElement username = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));
		WebElement loginBtn = driver.findElement(By.id("wp-submit"));
		
		username.sendKeys("root");
		password.sendKeys("pa$$w0rd");
		loginBtn.click();
		
		wait.until(ExpectedConditions.titleContains("Dashboard "));
		String actual_homePageTitle = driver.getTitle();
		Assert.assertEquals(actual_homePageTitle, expected_homePageTitle);
		
	}

}
