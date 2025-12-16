package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/target-practice");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		String thirdHeadingText = driver.findElement(By.xpath("//div//h3[contains(.,'#3')]")).getText();
		System.out.println("Text of 3rd header: "+ thirdHeadingText);
		
		String fifthHeadingColor = driver.findElement(By.xpath("//h5[@class = 'text-3xl font-bold text-purple-600']"))
				.getCssValue("color");
		System.out.println("Color of 5th heading: "+ fifthHeadingColor);
		
		String purpleButtonClass = driver.findElement(By.cssSelector("button.rounded-xl.bg-purple-200.p-2.text-3xl.font-bold.text-purple-900.svelte-2hb4ib"))
				.getAttribute("class");
		System.out.println("Class of Purple button: " + purpleButtonClass);
		
		String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
		System.out.println("Slate button text: "+ slateButtonText);
		
		driver.quit();
		

	}

}
