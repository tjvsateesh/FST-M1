package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class WebElementsActivity2 {

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
		
		// Scrolling and clicking on the Login Form element
		String UiScrollable = "new UiScrollable(new UiSelector().scrollable(true))";
		driver.findElement(AppiumBy
				.androidUIAutomator(UiScrollable + ".scrollIntoView(new UiSelector().textContains(\"Login Form\"))"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
		
		// Passing the login creds
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Submit']")).click();
		
		// Assertion
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='Login Success!']")));
		String message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Login Success!']"))
				.getText();
		assertEquals(message, "Login Success!");

	}

	@Test
	public void loginFormWithInvalidCreds() {

		String UiScrollable = "new UiScrollable(new UiSelector().scrollable(true))";

		driver.findElement(AppiumBy
				.androidUIAutomator(UiScrollable + ".scrollIntoView(new UiSelector().textContains(\"Login Form\"))"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
		
		// Passing the login creds
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("user");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Submit']")).click();
		
		// Assertion
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				AppiumBy.xpath("//android.widget.TextView[@resource-id='subheading']")));
		String message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='subheading']"))
				.getText();
		assertEquals(message, "Invalid credentials");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
