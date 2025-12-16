package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement textBox = driver.findElement(By.cssSelector("#textInput"));
		
		System.out.println("Is text box enabled? "+ textBox.isEnabled());
		
		driver.findElement(By.cssSelector("#textInputButton")).click();
		
		System.out.println("Is text box enabled after enabling? "+ textBox.isEnabled());
		
		driver.quit();

	}

}
