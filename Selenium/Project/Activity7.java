package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class Activity7 extends BaseTest {
	
	@Test
	public void createJobTest() throws InterruptedException {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String expected_postJobTitle = "Post a Job – Alchemy Jobs";
		String randomString = RandomString.make(4);
		String jobTitleName = "Engineer: " + randomString;
		
		// Navigating to Post a Job Page
		driver.findElement(By.linkText("Post a Job")).click();
		String actual_postJobTitle = driver.getTitle();
		
		Assert.assertEquals(actual_postJobTitle, expected_postJobTitle);
		
		WebElement email = driver.findElement(By.id("create_account_email"));
		WebElement jobTitle = driver.findElement(By.id("job_title"));
		WebElement descriptionFrame = driver.findElement(By.id("job_description_ifr"));
		WebElement applicationUrl = driver.findElement(By.id("application"));
		WebElement companyName = driver.findElement(By.id("company_name"));
		WebElement previewBtn = driver.findElement(By.xpath("//input[@value='Preview']"));

		
		email.sendKeys("someone."+randomString.toLowerCase()+"@oneof.com");
		jobTitle.sendKeys(jobTitleName);
		
		// scrolling the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/3);");
		
		driver.switchTo().frame(descriptionFrame);
		WebElement description = driver.findElement(By.cssSelector("body#tinymce"));
		wait.until(ExpectedConditions.elementToBeClickable(description));	
		description.click();
		description.sendKeys("Great place to work");
		driver.switchTo().defaultContent();
		
		applicationUrl.sendKeys("https://oneof.com/");
		companyName.sendKeys("oneOf");
		previewBtn.click();
		
		WebElement submitListingBtn = driver.findElement(By.id("job_preview_submit_button"));
		wait.until(ExpectedConditions.elementToBeClickable(submitListingBtn));
		submitListingBtn.click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".entry-content"), "Job listed successfully. To view your listing click here."));
		logInfo("Created Job with title: " + jobTitleName);
		
		//verifying created job by searching it
		driver.findElement(By.linkText("Jobs")).click();
		
		WebElement searchBox = driver.findElement(By.id("search_keywords"));
		searchBox.sendKeys(jobTitleName);
		
		WebElement searchBtn = driver.findElement(By.className("search_submit"));
		searchBtn.click();
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("ul.job_listings > li"), 0));
		String searchResult = driver.findElement(By.xpath("//ul[@class='job_listings']/li/a//h3")).getText();
		Assert.assertEquals(searchResult, jobTitleName);

	}

}
