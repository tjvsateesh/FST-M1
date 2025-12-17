package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity15 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full name']"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder, 'Email')]"));
		WebElement eventDate = driver.findElement(By.xpath("//input[@type='date']"));
		WebElement details = driver.findElement(By.xpath("//textarea[contains(@name,  'additional-details')]"));
		WebElement submitBtn = driver.findElement(By.cssSelector(".font-bold.svelte-7bqce9"));
		
		fullName.sendKeys("Y Someone");
		email.sendKeys("yone@gmail.com");
		eventDate.sendKeys("17-12-2025");
		details.sendKeys("NA");
		submitBtn.click();
		
		String confirmation = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confirmation messgage: " + confirmation);
		
		driver.quit();

	}

}
