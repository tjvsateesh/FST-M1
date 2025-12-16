package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.cssSelector("#checkbox"));
		System.out.println("Is checkbox present? "+ checkbox.isDisplayed());
		
		WebElement toggleBtn = driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
		toggleBtn.click();
		
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		System.out.println("Is checkbox present after toggling off? "+ checkbox.isDisplayed());
		
		toggleBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		checkbox.click();
		
		System.out.println("Is checkbox selected? "+ checkbox.isSelected());
		
		driver.quit();

	}

}
