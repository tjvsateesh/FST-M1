package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ToDoActivity1 {

	// declaring objects
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {

		File apkFile = new File("src/test/resources/ts-todo-list-v1.apk");
		// desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(apkFile.getAbsolutePath());
		caps.noReset();

		// set the Appium server url
		URL serverURL = new URI("http://192.168.1.102:4723/").toURL();

		// initialize the android driver
		driver = new AndroidDriver(serverURL, caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void addTask() throws InterruptedException {
			
			WebElement addBtn = driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task"));
			addBtn.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
			By name = AppiumBy.id("com.app.todolist:id/et_new_task_name");
			By priority = AppiumBy.id("com.app.todolist:id/tv_new_task_priority");
			By okayBtn = AppiumBy.id("com.app.todolist:id/bt_new_task_ok");
			
			// Creating task 1
			driver.findElement(name).sendKeys("Complete Activity 1");
			driver.findElement(priority).click();
			driver.findElement(AppiumBy
					.xpath("//android.widget.TextView[@text='High']")).click();
			driver.findElement(okayBtn).click();
			
			// Creating task 2
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(addBtn)));
			addBtn.click();
			wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.visibilityOfElementLocated(name)));
			driver.findElement(name).sendKeys("Complete Activity 2");
			driver.findElement(priority).click();
			driver.findElement(AppiumBy
					.xpath("//android.widget.TextView[@text='Medium']")).click();
			driver.findElement(okayBtn).click();
			
			// Creating task 3
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(addBtn)));
			addBtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(name));
			driver.findElement(name).sendKeys("Complete Activity 3");
			driver.findElement(priority).click();
			driver.findElement(AppiumBy
					.xpath("//android.widget.TextView[@text='Low']")).click();
			driver.findElement(okayBtn).click();
			
			// Validating that there are 3 task in the list
			List<WebElement> tasks = driver.findElements(AppiumBy
					.xpath("//android.widget.RelativeLayout[@resource-id='com.app.todolist:id/rl_exlv_task_group_root']"));
			assertEquals(tasks.size(), 3);
			
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
