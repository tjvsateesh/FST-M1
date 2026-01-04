package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

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
		URL serverURL = new URI("http://192.168.1.12:4723/").toURL();

		// initialize the android driver
		driver = new AndroidDriver(serverURL, caps);

		driver.get("https://training-support.net/webelements/sliders");

	}

	@Test
	public void volume25Test() {
		
		// Wait for page to load
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));

		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		int startX = (int)(0.5 * dims.getWidth());
		int startY = (int)(0.77 * dims.getHeight());
		Point start = new Point(startX, startY);
		
		int endX = (int)(0.33 * dims.getWidth());
		int endY = (int)(0.77 * dims.getWidth());
		Point end = new Point(endX, endY);
		
		// Perform swipe
		ActionsBase.doSwipe(driver, start, end, 2000);

		// validation
		String volumeText = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]"))
				.getText(); 

		assertEquals(volumeText, "25%");
		
	}

	@Test
	public void volume75Test() {
		
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		int startX = (int)(0.5 * dims.getWidth());
		int startY = (int)(0.77 * dims.getHeight());
		Point start = new Point(startX, startY);
		
		int endX = (int)(0.67 * dims.getWidth());
		int endY = (int)(0.77 * dims.getWidth());
		Point end = new Point(endX, endY);
		
		// Perform swipe
		ActionsBase.doSwipe(driver, start, end, 2000);

		// validation
		String volumeText = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]"))
				.getText(); 

		assertEquals(volumeText, "75%");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
