package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity18 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		driver.findElement(By.id("simple")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Text of the Alert: " + alert.getText());
		
		alert.accept();
		
		driver.quit();
		
	}

}
