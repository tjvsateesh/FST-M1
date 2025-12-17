package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		
		driver.get("https://training-support.net/webelements/popups");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		driver.findElement(By.id("launcher")).click();
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[.='Submit']"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		submitBtn.click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.flex.flex-col > div > h1"), "Login Success!"));
		String message = driver.findElement(By.cssSelector("div.flex.flex-col > div > h2")).getText();
		System.out.println("Message: " + message);
		
		driver.quit();

	}

}
