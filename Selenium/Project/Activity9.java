package project;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class Activity9 extends BaseTest {
	
	@Test
	public void backendLoginTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String expected_pageTitle = "Log In ‹ Alchemy Jobs — WordPress";
		String expected_homePageTitle = "Dashboard ‹ Alchemy Jobs — WordPress";
		String randomString = RandomString.make(4);
		String createdJobTitle = "Engineer: " + randomString;
		
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
		
		WebElement jobListings = driver.findElement(By.id("menu-posts-job_listing"));
		WebElement addNew = driver.findElement(By.cssSelector("#menu-posts-job_listing>ul>li:nth-child(3)>a"));
		Actions action = new Actions(driver);
		
		action.moveToElement(jobListings).perform();
		wait.until(ExpectedConditions.visibilityOf(addNew));
		action.moveToElement(addNew).click().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Welcome to the Block Editor']")));
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		
		WebElement position = driver.findElement(By.cssSelector("#post-title-0"));
		position.sendKeys(createdJobTitle);
		
		//scrolling the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
		
		WebElement companyName = driver.findElement(By.id("_company_name"));
		companyName.sendKeys("oneOf");
		
		WebElement publishBtn = driver.findElement(By
				.xpath("//div[@class='edit-post-header__settings']//button[contains(@class,'-post-publish-')]"));
		
		publishBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='editor-post-publish-panel']/div/div/button")));
		driver.findElement(By.xpath("//div[@class='editor-post-publish-panel']/div/div/button")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class,'header-published')]"), "Published"));
		logInfo("Created and publihsed the job with title: " + createdJobTitle);
		
		//Navigating to created job and validating it
		driver.findElement(By.linkText("View Job")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));
		String postedJobTitle = driver.findElement(By.className("entry-title")).getText();
		assertEquals(createdJobTitle, postedJobTitle);
			
	}
	

}
