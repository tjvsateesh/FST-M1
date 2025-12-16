package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/mouse-events");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement cargoLockBtn = driver.findElement(By.xpath("//h1[.='Cargo.lock']"));
		WebElement cargoTomlBtn = driver.findElement(By.xpath("//h1[.='Cargo.toml']"));
		WebElement srcBtn = driver.findElement(By.xpath("//h1[.='src']"));
		WebElement targetBtn = driver.findElement(By.xpath("//h1[.='target']"));
		WebElement result = driver.findElement(By.cssSelector("#result"));
		
		action.click(cargoLockBtn).moveToElement(cargoTomlBtn).click().build().perform();
		
		System.out.println("Result Text: " + result.getText());
		
		action.doubleClick(srcBtn).contextClick(targetBtn).click().build().perform();
		
		WebElement open = driver.findElement(By.xpath("//button[@class = 'flex w-full p-2']//span[.='Open']"));
		
		action.click(open).perform();
		Thread.sleep(2000);
		
		System.out.println("Result Text: " + result.getText());
		
		driver.quit();

	}

}
