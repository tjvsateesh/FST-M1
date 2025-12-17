package activity;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		
		driver.get("https://training-support.net/webelements/tabs");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		driver.findElement(By.cssSelector(".bg-purple-200.svelte-1bfwg86")).click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		System.out.println("All open windows: " + driver.getWindowHandles());
		
		for(String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		
		System.out.println("New window's title: " + driver.getTitle());
		
		String message = driver.findElement(By.cssSelector(".mt-5")).getText();
		System.out.println("New window's messgage: " + message);
		
		driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		for(String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		
		System.out.println("Another new window's messgage: " + driver.findElement(By.cssSelector(".mt-5")).getText());
		
		driver.quit();

	}

}
