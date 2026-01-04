package activities;

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
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity7 {
	
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

		driver.get("https://training-support.net/webelements/lazy-loading");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	@Test
	public void lazyLoading() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
		By images = AppiumBy.className("android.widget.Image");
		List<WebElement> imageList = driver.findElements(images);
		System.out.println("=== Images Preset in current view === "+ imageList.size());
		
		// Scrolling to find Helen's image
		ActionsBase.findElementByScrolling(driver, 
				AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Helen\")"), 5);
		
		List<WebElement> listAfterScroll = driver.findElements(images);
		System.out.println("=== Images Preset after scrolling  === "+ listAfterScroll.size());
		
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
