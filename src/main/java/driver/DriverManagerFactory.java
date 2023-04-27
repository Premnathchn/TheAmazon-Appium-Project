package driver;

import org.apache.log4j.Logger;

import actions.Click;
import base.Test;
import constants.Keys;
import helper.PropertyReader;

public class DriverManagerFactory {

	private static Logger log = Logger.getLogger(Click.class);

	public static DriverManager getManager() {

		DriverManager driverManager = null;

		DriverType type = DriverType
				.valueOf(PropertyReader.valueOf("Device." + Test.attributes.get(Keys.Device) + ".OS").toUpperCase());

		switch (type) {
		case ANDROID:
			driverManager = new AndroidManager();
			break;
		case IOS:
			driverManager = new IOSManager();
			break;
		default:
			Logger.getLogger("Invalid driver type: " + type);
			break;
		}
		return driverManager;
	}
}