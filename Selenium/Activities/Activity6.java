package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity6 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.cssSelector("#checkbox"));
		
		System.out.println("Is checkbox selected? "+ checkbox.isSelected());
		
		checkbox.click();
		
		System.out.println("Is checkbox selected after clicking? "+ checkbox.isSelected());
		
		driver.quit();

	}

}
