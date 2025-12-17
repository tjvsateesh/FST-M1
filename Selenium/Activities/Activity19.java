package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity19 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		WebElement confirmBtn = driver.findElement(By.id("confirmation"));
		confirmBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Text of the alert: " + alert.getText());
		
		alert.accept();
		
		confirmBtn.click();
		
		alert.dismiss();
		
		driver.quit();
		
	}

}
