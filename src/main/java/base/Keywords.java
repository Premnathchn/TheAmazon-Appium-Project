package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Click;
import actions.Get;
import actions.Keyboard;
import actions.Screenshot;
import actions.Swipe;
import actions.Type;
import actions.Verify;
import driver.DriverManager;
import driver.DriverManagerFactory;
import exceptions.ApplicationException;
import exceptions.EnvironmentException;
import io.appium.java_client.AppiumDriver;

public class Keywords {

	private static Logger log = Logger.getLogger(Keywords.class);

	public static AppiumDriver driver;
	public static WebDriverWait wait;

	public static Get get = new Get();
	public static Click click = new Click();
	public static Keyboard keyboard = new Keyboard();
	public static Verify verify = new Verify();

	public static Type type = new Type();
	public static Screenshot screenshot = new Screenshot();
	public static Swipe swipe = new Swipe();

	public static void launchApplication() throws EnvironmentException {
		if (driver != null) {
			driver.launchApp();
		} else {
			DriverManager driverManager = DriverManagerFactory.getManager();
			try {
				driver = driverManager.getDriver();
				wait = driverManager.getWait();
			} catch (Throwable ex) {
				throw new EnvironmentException("Driver failed to launch \n" + ex);
			}
		}
		log.info("Application launched");
	}

	public static void enterurl(String url) throws ApplicationException, InterruptedException {
		if (driver != null) {
			driver.get(url);
		}
		log.info("Application '" + url + "' started");
	}

	public static void closeApplication() {
		if (driver != null) {
			driver.closeApp();
		}
		log.info("Application closed");
	}

	public static void quitDriver() {
		driver.quit();
	}
}