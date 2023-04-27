package driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Test;
import constants.Keys;
import helper.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public abstract class DriverManager {

	protected AppiumDriver<WebElement> driver;
	protected WebDriverWait wait;
	protected DesiredCapabilities capabilities = new DesiredCapabilities();

	protected abstract void createDriver() throws Exception;

	public AppiumDriver getDriver() throws Exception {
		if (null == driver) {
			capabilities.setCapability("platformVersion",
					PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".Version"));
			capabilities.setCapability("deviceName",
					PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".Name"));
			capabilities.setCapability("udid",
					PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".ID"));
			capabilities.setCapability("appium:adbExecTimeout", "500000");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
					PropertyReader.valueOf("Application.chrome.Package"));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
					PropertyReader.valueOf("Application.chrome.Activity"));
			capabilities.setCapability("noReset", true);
			createDriver();
			wait = new WebDriverWait(driver, Integer.parseInt(PropertyReader.valueOf("Driver.Timeout").trim()));
		}
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
}