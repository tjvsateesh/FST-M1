package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
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
		
	}
	
	@Test
	public void webTest() {
		driver.get("https://training-support.net/");
		
		String expectedHeading = "Training Support";
		String actualHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
		assertEquals(actualHeading, expectedHeading);
		
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		String expectedAbtUs_heading = "About Us";
		String actualAbtUs_heading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
		assertEquals(actualAbtUs_heading, expectedAbtUs_heading);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
