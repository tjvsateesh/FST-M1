package project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 extends BaseTest {

	@Test
	public void titleTest() {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		String expectedTitle = "Alchemy Jobs – Job Board Application";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		

	}

}
