package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

		AppiumDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void androidSetUp() throws MalformedURLException, URISyntaxException {
			// desired capabilities
			UiAutomator2Options caps = new UiAutomator2Options();
			caps.setPlatformName("android");
			caps.setAutomationName("UiAutomator2");
			caps.setAppPackage("com.google.android.apps.messaging");
			caps.setAppActivity(".ui.ConversationListActivity");
			caps.noReset();
			
			// set the appium server url
			URL serverURL = new URI("http://192.168.1.12:4723/").toURL();
			
			// initialize the android driver
			driver = new AndroidDriver(serverURL, caps);
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
		}
		
		@Test
		public void messageTest() {
			
			driver.navigate().back();
			
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Start chat")));
			driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("ContactSearchField")));
			driver.findElement(AppiumBy.id("ContactSearchField")).sendKeys("0728552006");
			driver.findElement(AppiumBy.id("ContactSearchField")).sendKeys(Keys.ENTER);
			
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
			driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
}
