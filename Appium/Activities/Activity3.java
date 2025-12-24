package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	
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
		public void calculator() {
			
			String result;
			//5+9 | 10-5 | 5*100  | 50/2
			WebElement five = driver.findElement(AppiumBy.id("digit_5"));
			WebElement one = driver.findElement(AppiumBy.id("digit_1"));
			WebElement zero = driver.findElement(AppiumBy.id("digit_0"));
			WebElement nine = driver.findElement(AppiumBy.id("digit_9"));
			WebElement two = driver.findElement(AppiumBy.id("digit_2"));
			WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
			By finalResult = AppiumBy.id("result_final");
			
			//5+9=14
			five.click();
			driver.findElement(AppiumBy.accessibilityId("plus")).click();
			nine.click();
			equals.click();
			result = driver.findElement(finalResult).getText();
			assertEquals(result, "14");
			
			//10-5=5
			one.click();
			zero.click();
			driver.findElement(AppiumBy.accessibilityId("minus")).click();
			five.click();
			equals.click();
			result = driver.findElement(finalResult).getText();
			assertEquals(result, "5");
			
			//5*100=500
			five.click();
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			one.click();
			zero.click();
			zero.click();
			equals.click();
			result = driver.findElement(finalResult).getText();
			assertEquals(result, "500");
			
			//50/2
			five.click();
			zero.click();
			driver.findElement(AppiumBy.accessibilityId("divide")).click();
			two.click();
			equals.click();
			result = driver.findElement(finalResult).getText();
			assertEquals(result, "25");
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
