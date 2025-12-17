package activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity13 {

	public static void main(String[] args) {

	WebDriver driver = new ChromeDriver();
	
	driver.get("https://training-support.net/webelements/tables");
	
	System.out.println("Title of the page: "+ driver.getTitle());
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr"));
	List<WebElement> columns = driver.findElements(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead//th"));
	WebElement thirdRow = driver.findElement(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[3]"));
	WebElement secondRow_secondColumn = driver.findElement(By.xpath("//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[2]/td[2]"));
	
	System.out.println("Number of rows are: " + rows.size());
	System.out.println("Number of columns are: " + columns.size());
	
	System.out.println("Values in the 3rd row are: " + thirdRow.getText());
	
	System.out.println("Value at second row-second column is: " + secondRow_secondColumn.getText());
	
	driver.quit();
	
	}

}
