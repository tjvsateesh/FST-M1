package project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 extends BaseTest {

	@Test
	public void secondHeadingTest() {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		String expected_secondHeadingText = "Quia quis non";
		String actual_secondHeadingText = driver.findElement(By.xpath("//div[contains(@class, 'entry-content')]//h2"))
				.getText();
		Assert.assertEquals(actual_secondHeadingText, expected_secondHeadingText);

	}

}
