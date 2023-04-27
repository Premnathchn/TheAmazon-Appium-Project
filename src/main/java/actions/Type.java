package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import base.Keywords;
import exceptions.ApplicationException;

/**
 * <h1>List of reusable methods for Type actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Type extends Keywords {

	private static Logger log = Logger.getLogger(Type.class);

	/**
	 * Enters data in a text-box. Inputs are locatorKey(String),valueToEnter(String)
	 *
	 * @param locatorKey
	 * @param value
	 * @throws ApplicationException
	 */
	public void data(String locatorKey, String value) throws ApplicationException {
		log.info("Type the value [" + value + "] into element [" + locatorKey + "]");
		try {
			get.elementBy(locatorKey).sendKeys(value);
		} catch (StaleElementReferenceException ex) {
			get.elementBy(locatorKey).sendKeys(value);
		}
		keyboard.hideIfIOS();
		log.info("Type Successful!");
	}

	/**
	 * Enters data in a text-box. Inputs are locatorKey(By), valueToEnter(String)
	 *
	 * @param locator
	 * @param value
	 * @throws ApplicationException
	 */
	public void data(By locator, String value) throws ApplicationException {
		log.info("Type the value [" + value + "] into element [" + locator + "]");
		get.elementBy(locator).sendKeys(value);
		keyboard.hideIfIOS();
		log.info("Type Successful!");
	}

	/**
	 * Enters data in a text-box and hides the keyboard. Inputs are
	 * locatorKey(String), valueToEnter(String), hideKeyboardNeeded?(true/false)
	 *
	 * @param locatorKey
	 * @param value
	 * @param hideKeyboard
	 * @throws ApplicationException
	 */
	public void data(String locatorKey, String value, boolean hideKeyboard) throws ApplicationException {
		log.info("Type the value [" + value + "] into element [" + locatorKey + "]");
		get.elementBy(locatorKey).sendKeys(value);
		if (hideKeyboard) {
			keyboard.hideAndroid();
		}
		log.info("Type Successful!");
	}

	/**
	 * Enters data in a text-box and hides the keyboard. Inputs are locatorKey(By),
	 * valueToEnter(String), hideKeyboardNeeded?(true/false)
	 *
	 * @param locator
	 * @param value
	 * @param hideKeyboard
	 * @throws ApplicationException
	 */
	public void data(By locator, String value, boolean hideKeyboard) throws ApplicationException {
		log.info("Type the value [" + value + "] into element [" + locator + "]");
		get.elementBy(locator).sendKeys(value);
		if (hideKeyboard) {
			keyboard.hideAndroid();
		}
		log.info("Type Successful!");
	}

}