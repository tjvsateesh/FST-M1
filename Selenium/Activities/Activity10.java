package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/drag-drop");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement ball = driver.findElement(By.id("ball"));
		WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		
		action.dragAndDrop(ball, dropzone1).pause(2000).perform();
		System.out.println("Ball "+ dropzone1.getText() + " in dropzone1");
		
		action.dragAndDrop(ball, dropzone2).pause(2000).perform();
		System.out.println("Ball "+ dropzone2.getText() + " in dropzone2");
		
		driver.quit();
		
	}

}
