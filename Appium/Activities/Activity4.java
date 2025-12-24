package activities;

import static org.testng.Assert.assertEquals;

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

public class Activity4 {
	
	// declaring objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {
		// desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setAppPackage("com.google.android.contacts");
		caps.setAppActivity("com.android.contacts.activities.PeopleActivity");
		caps.noReset();
		
		// set the appium server url
		URL serverURL = new URI("http://192.168.1.12:4723/").toURL();
		
		// initialize the android driver
		driver = new AndroidDriver(serverURL, caps);
		
	}
	
	@Test
	public void contacts() {
		
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Aaditya");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Varma");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]")).sendKeys("999148292");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Save\"]")).click();
		//validating call button after Saving the contact
		boolean flag = driver.findElement(AppiumBy.accessibilityId("Call")).isDisplayed();
		assertEquals(flag, true);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
