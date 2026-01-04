package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

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

public class ToDoActivity2 {

	// declaring objects
	AppiumDriver driver;
	WebDriverWait wait;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu");

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
	public void editTask() {

		String setDeadlineDate = setDateToNextSaturday();

		WebElement firstTask = driver.findElement(AppiumBy.xpath(
				"(//android.widget.RelativeLayout[@resource-id='com.app.todolist:id/rl_exlv_task_group_root'])[1]"));
		
		// Long press and Edit
		ActionsBase.longPress(driver, firstTask);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")).click();

		// Set the deadline date
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/month_view")));
		driver.findElement(AppiumBy.accessibilityId(setDeadlineDate)).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/dialog_edit")));
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();

		// Validating the set date
		String deadline = driver
				.findElement(AppiumBy
						.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_deadline']"))
				.getText().split(":")[1].replace(".", " ").trim();
		String deadlineDate = LocalDate.parse(deadline, DateTimeFormatter.ofPattern("dd MM uuuu")).format(formatter);

		assertEquals(deadlineDate, setDeadlineDate);

	}

	public String setDateToNextSaturday() {

		LocalDate today = LocalDate.now();
		String comingSaturday = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).format(formatter);
		return comingSaturday;

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
