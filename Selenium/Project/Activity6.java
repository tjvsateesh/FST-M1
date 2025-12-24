package project;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6 extends BaseTest {
	
	@Test
	public void appyJobTest() throws InterruptedException {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8000));
		
		String expected_jobPageTitle = "Jobs – Alchemy Jobs";
		
		// Navigating to Job Page
		driver.findElement(By.linkText("Jobs")).click();
		String actual_jobPageTitle = driver.getTitle();
		
		Assert.assertEquals(actual_jobPageTitle, expected_jobPageTitle);
		
		WebElement searchBox = driver.findElement(By.id("search_keywords"));
		searchBox.sendKeys("Full stack tester");
		
		WebElement searchBtn = driver.findElement(By.className("search_submit"));
		searchBtn.click();
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("ul.job_listings > li"), 0));
		
		List<WebElement> resultList = driver.findElements(By.cssSelector("ul.job_listings > li"));
		
		boolean searchResult = driver.findElement(By.cssSelector("div.showing_jobs")).isDisplayed();
		
		// Proceed only if there are results for searched job
		if(!searchResult) {
			logInfo("There are no listings matching your search.");
			return;
		}
		
		Random random = new Random();
		int index = random.nextInt(1, resultList.size()+1);
		
		// select randomly
		driver.findElement(By.cssSelector("ul.job_listings > li:nth-of-type("+index+")")).click();
		
		driver.findElement(By.className("application_button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("application_details")));
		
		String email = driver.findElement(By.cssSelector("[class='application_details'] a")).getText();
		logInfo("Email address to apply for the job: " + email);
		
		
	}

}
