package project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity5 extends BaseTest {

	@Test
	public void jobPageTitleTest() {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		String expected_jobPageTitle = "Jobs – Alchemy Jobs";
		// Navigating to Job Page
		driver.findElement(By.linkText("Jobs")).click();
		String actual_jobPageTitle = driver.getTitle();
		
		Assert.assertEquals(actual_jobPageTitle, expected_jobPageTitle);

	}

}
