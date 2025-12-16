package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/keyboard-events");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement textElement = driver.findElement(By.cssSelector(".mt-3.text-center.text-4xl.font-semibold.text-black"));
		
		action.sendKeys("Hello World!").build().perform();
		
		System.out.println("Entered text: " + textElement.getText());
		
		driver.quit();

	}

}
