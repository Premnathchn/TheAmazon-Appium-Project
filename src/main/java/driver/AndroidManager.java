package driver;

import java.net.URL;

import base.Test;
import constants.Keys;
import helper.PropertyReader;
import io.appium.java_client.android.AndroidDriver;

public class AndroidManager extends DriverManager {

	@Override
	public void createDriver() throws Exception {
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UiAutomator2");
		// setAppCapabilities();
		Test.attributes.put(Keys.ObjectRepository, "src/test/resources/object-repository/Locators-Android.properties");
		driver = new AndroidDriver(new URL(PropertyReader.valueOf("Driver.ServerAddress").trim()), capabilities);
		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
	}

	private void setAppCapabilities() {
		if (PropertyReader.valueOf("Driver.InstallMobileAppForEveryRun").trim().equalsIgnoreCase("yes")) {
			capabilities.setCapability("app",
					"<location of apk file>" + PropertyReader.valueOf("Application.Name").trim() + ".apk");
		} else {
			capabilities.setCapability("appPackage", PropertyReader.valueOf("Application.Android.Package").trim());
			capabilities.setCapability("appActivity",
					PropertyReader.valueOf("Application.Android.LaunchActivity").trim());
		}
	}
}
