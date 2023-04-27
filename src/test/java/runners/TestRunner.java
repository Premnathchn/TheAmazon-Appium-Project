package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import base.Test;
import constants.Device;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "stepdefinitions" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:", "pretty",
		"json:target/json-output/Automation-Summary.json" }, tags = { "@CartNavigation" })

public class TestRunner extends Test {
	@BeforeClass

	public static void initialize() {
		String deviceName = System.getProperty("Device");
		if (deviceName == null) {
			deviceName = Device.Pixel;
		}
		setup(deviceName);
	}

	@AfterClass
	public static void flush() {
		teardown();
	}
}