package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ToDoActivity3 {
	
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
	public void completeTask() {
		
		WebElement firstTask = driver.findElement(AppiumBy
				.xpath("(//android.widget.CheckBox[@resource-id='com.app.todolist:id/cb_task_done'])[1]"));
		WebElement secondTask = driver.findElement(AppiumBy
				.xpath("(//android.widget.CheckBox[@resource-id='com.app.todolist:id/cb_task_done'])[2]"));
		WebElement thirdTask = driver.findElement(AppiumBy.xpath(
				"(//android.widget.RelativeLayout[@resource-id='com.app.todolist:id/rl_exlv_task_group_root'])[3]"));
		
		// Complete first 2 tasks
		firstTask.click();
		secondTask.click();
		
		// Long press and Edit
		ActionsBase.longPress(driver, thirdTask);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")).click();
		
		// Slide the progress bar to 50%
		Dimension dims = driver.manage().window().getSize(); // 1080x2400

		int startX = (int)(0.28 * dims.getWidth());
		int startY = (int)(0.538 * dims.getHeight());
		Point start = new Point(startX, startY);
		
		int endX = (int)(0.60 * dims.getWidth());
		int endY = (int)(0.538 * dims.getWidth());
		Point end = new Point(endX, endY);
		
		ActionsBase.doSwipe(driver, start, end, 1000);
		
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		// View Completed tasks
		driver.findElement(AppiumBy.accessibilityId("More options")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				AppiumBy.xpath("//android.widget.TextView[@text='Completed tasks']")));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Completed tasks']")).click();
		
		 List<WebElement> completedTasks = driver.findElements(AppiumBy
					.xpath("//android.widget.RelativeLayout[@resource-id='com.app.todolist:id/rl_exlv_task_group_root']"));
		
		assertEquals(completedTasks.size(), 2);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
