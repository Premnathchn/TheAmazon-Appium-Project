package driver;

import base.Test;
import constants.Keys;
import helper.PropertyReader;

public class IOSManager extends DriverManager {
	@Override
	public void createDriver() throws Exception {
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("automationName", "XCUITest");
		// setAppCapabilities();
		Test.attributes.put(Keys.ObjectRepository, "src/test/resources/object-repository/Locators-IOS.properties");
		// driver = new IOSDriver(new
		// URL(PropertyReader.valueOf("Driver.ServerAddress").trim()), capabilities);
	}

	private void setAppCapabilities() {
		if (PropertyReader.valueOf("Driver.InstallMobileAppForEveryRun").trim().equalsIgnoreCase("yes")) {
			capabilities.setCapability("app",
					"<location of .ipa file>" + PropertyReader.valueOf("Application.Name").trim() + ".ipa");
		} else {
			capabilities.setCapability("bundleId", PropertyReader.valueOf("Application.IOS.BundleID").trim());
		}
	}
}
