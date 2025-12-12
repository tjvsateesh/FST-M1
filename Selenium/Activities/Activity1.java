package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		driver.findElement(By.linkText("About Us")).click();
		
		System.out.println("Title of the About Us page: " + driver.getTitle());
		
		driver.quit();
	}

}
