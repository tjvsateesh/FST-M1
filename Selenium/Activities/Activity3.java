package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/login-form/");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		
		driver.quit();
		

	}
}
