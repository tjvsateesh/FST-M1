package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class WebElementsActivity1 {
	
	// declaring objects
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {

		// desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setAppPackage("com.android.chrome");
		caps.setAppActivity("com.google.android.apps.chrome.Main");
		caps.noReset();

		// set the appium server url
		URL serverURL = new URI("http://192.168.1.100:4723/").toURL();

		// initialize the android driver
		driver = new AndroidDriver(serverURL, caps);

		driver.get("https://training-support.net/webelements");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void loginFormWithValidCreds() {
		
		// Scrolling and clicking on the To-Do list element
		WebElement element = ActionsBase.findElementByScrolling(driver, 
				AppiumBy.androidUIAutomator("new UiSelector().textContains(\"To-Do List\")"), 5);
		element.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@text='Todo List']")));
		
		WebElement input = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='todo-input']"));
		WebElement add = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='todo-add']"));
		
		// Add tasks
		input.sendKeys("Add tasks to list");
		add.click();
		input.sendKeys("Get number of tasks");
		add.click();
		input.sendKeys("Clear the list");
		add.click();
		
		// Strike out added tasks
		By list = AppiumBy.xpath("//android.widget.ListView/android.view.View");
		List<WebElement> taskList = driver.findElements(list);
		for(int i = 3; i <= taskList.size(); i++) {
			driver.findElement(AppiumBy
					.xpath("//android.widget.ListView/android.view.View["+i+"]/android.view.View/android.widget.CheckBox")).click();
		}
		
		// Assertion
		assertEquals(taskList.size(), 5);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
