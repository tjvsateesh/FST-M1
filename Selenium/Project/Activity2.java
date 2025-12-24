package project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2 extends BaseTest {

	@Test
	public void headingTest() {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		String expectedHeading = "Welcome to Alchemy Jobs";
		String actualHeading = driver.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(actualHeading, expectedHeading);

	}

}
