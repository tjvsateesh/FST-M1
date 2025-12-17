package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity20 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		WebElement confirmBtn = driver.findElement(By.id("prompt"));
		confirmBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Text of the alert: " + alert.getText());
		
		alert.sendKeys("Awesome!");
		
		alert.accept();
		
		String enteredText = driver.findElement(By.id("result")).getText();
		System.out.println("Result after typing and accepting the alert: " + enteredText);
		
		driver.quit();
	}

}
