package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		WebElement multiSelect = driver.findElement(By.xpath("//select[contains(@class, 'h-80 ')]"));
		
		Select select = new Select(multiSelect);
		
		select.selectByVisibleText("HTML");
		
		// selecting option 4, 5 and 6
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.selectByIndex(5);
		select.selectByValue("nodejs");
		
		//de-selecting option 5
		select.deselectByIndex(4);
		
		driver.quit();
		
	}

}
