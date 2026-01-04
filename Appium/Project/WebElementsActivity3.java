package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

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
import io.appium.java_client.remote.SupportsContextSwitching;

public class WebElementsActivity3 {

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
	public void popupLogin() throws InterruptedException {
		
		// Scrolling and clicking on the PopUp element
		WebElement element = ActionsBase.findElementByScrolling(driver,
				AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Popups\")"), 5);
		element.click();
		
		// Clicking on the launcher button
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id='launcher']")));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='launcher']")).click();
		Thread.sleep(2000);
		

		for (String ctx : ((SupportsContextSwitching) driver).getContextHandles()) {
			System.out.println("Context: " + ctx);

			if (ctx.startsWith("WEBVIEW")) {
				((SupportsContextSwitching) driver).context(ctx);
				return;
			}

		}

		// Passing the login creds
		wait.until(ExpectedConditions
				.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='popup']")));
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
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
