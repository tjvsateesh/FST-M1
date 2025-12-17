package activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity14 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebElement fifthRowBookName;
		
		driver.get("https://training-support.net/webelements/tables");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead//th"));
		fifthRowBookName = driver.findElement(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[5]/child::td[2]"));
		WebElement price = driver.findElement(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead//th[5]"));
		
		System.out.println("Number of rows are: " + rows.size());
		System.out.println("Number of columns are: " + columns.size());
		
		System.out.println("Fifth row book name: " + fifthRowBookName.getText());
		
		price.click();
		
		fifthRowBookName = driver.findElement(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[5]/child::td[2]"));
		
		System.out.println("Fifth row book name after sorting price in ascending order: " + fifthRowBookName.getText());
		
		driver.quit();
	}

}
