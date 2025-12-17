package activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		WebElement dropDown = driver.findElement(By.xpath("//select[contains(@class, 'h-10 ')]"));
		
		Select select = new Select(dropDown);
		
		select.selectByVisibleText("Two");
		select.selectByIndex(3);
		select.selectByValue("four");
		
		List<WebElement> allOptions = select.getOptions();
		System.out.println("All the options are:");
		for(WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		driver.quit();

	}

}
