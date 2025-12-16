package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		driver.get("https://training-support.net/webelements/dynamic-content");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		driver.findElement(By.id("genButton")).click();
		
		WebElement text = driver.findElement(By.id("word"));
		
		if(wait.until(ExpectedConditions.textToBePresentInElement(text, "release")))
			System.out.println("Word \"release\" found");
		else
			System.out.println("Word \"release\" not found");
		
		driver.quit();
		
	}

}
