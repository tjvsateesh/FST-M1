package project;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Activity3 extends BaseTest {

	@Test
	public void headerImageUrlTest() {
		
		driver.get("https://alchemy.hguy.co/jobs");
		
		String imageUrl = driver.findElement(By.xpath("//header[contains(@class,'entry-header ')]/div/img"))
				.getAttribute("src");
		System.out.println("URL of the header image: " + imageUrl);

	}

}
