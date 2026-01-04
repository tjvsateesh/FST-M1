package activities;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ActionsBase {

	private final static PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
		Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
				.addAction(finger.createPointerDown(LEFT.asArg())) // 0 = left
				.addAction(finger.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
				.addAction(finger.createPointerUp(LEFT.asArg())); // 0 = left
		driver.perform(Collections.singletonList(swipe));
	}
	
	public static void longPress(AppiumDriver driver, WebElement element) {
		Sequence longPress = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, Origin.fromElement(element), 0, 0))
				.addAction(finger.createPointerDown(LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofSeconds(2))) // hold for 2s
				.addAction(finger.createPointerUp(LEFT.asArg()));
		driver.perform(Collections.singletonList(longPress));
	}
	
	public static WebElement findElementByScrolling(AppiumDriver driver, By target, int maxScrolls) {
		for (int i = 0; i < maxScrolls; i++) {
			List<WebElement> element = driver.findElements(target);
			if (!element.isEmpty() && element.get(0).isDisplayed()) {
				return element.get(0);
			}
			// Perform one forward scroll in any visible scrollable container
			driver.findElement(
					AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		}
		throw new RuntimeException("Element not found after " + maxScrolls + " forward scrolls: " + target);
	}
}
