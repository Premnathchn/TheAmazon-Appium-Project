package actions;

import java.util.List;

import org.openqa.selenium.By;

import base.Keywords;
import base.Test;
import constants.Keys;
import io.appium.java_client.MobileElement;

/**
 * <h1>List of reusable methods for Keyboard actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Keyboard extends Keywords {

	public void hideAndroid() {
		try {
			driver.hideKeyboard();
		} catch (Throwable ex) {
		}
	}

	public void hideIOS() {
		try {
			List<MobileElement> el = get.elementBy(By.className("XCUIElementTypeKeyboard"))
					.findElements(By.className("XCUIElementTypeButton"));
			if (el.size() > 2) {
				el.get(0).click();
			} else if (el.size() == 0) {
				get.elementBy(By.xpath("//XCUIElementTypeButton[@name='Toolbar Done Button']")).click();
			} else {
				el.get(el.size() - 1).click();
			}
		} catch (Throwable e) {
		}
	}

	/**
	 * Hides/closes system keyboard from the device screen, for Android
	 */
	public void hideIfAndroid() {
		if (Test.attributes.get(Keys.OS).equalsIgnoreCase("Android")) {
			hideAndroid();
		}
	}

	/**
	 * Hides/closes system keyboard from the device screen, for iOS
	 */
	public void hideIfIOS() {
		if (Test.attributes.get(Keys.OS).equalsIgnoreCase("IOS")) {
			hideIOS();
		}
	}

	/**
	 * Hides/closes system keyboard from the device screen
	 */
	public void hide() {
		if (Test.attributes.get(Keys.OS).equalsIgnoreCase("Android")) {
			hideAndroid();
		} else if (Test.attributes.get(Keys.OS).equalsIgnoreCase("IOS")) {
			hideIOS();
		}
	}
}