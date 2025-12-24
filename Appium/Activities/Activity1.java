package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	// declaring objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {
		// set the path of the app file
		File apkFile = new File("src/test/resources/Calculator.apk");
		// desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(apkFile.getAbsolutePath());
		caps.noReset();
		
		// set the appium server url
		URL serverURL = new URI("http://192.168.1.12:4723/").toURL();
		
		// initialize the android driver
		driver = new AndroidDriver(serverURL, caps);
		
	}
	
	@Test
	public void calculate() {
		// locate and tap
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		assertEquals(result, "25");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
