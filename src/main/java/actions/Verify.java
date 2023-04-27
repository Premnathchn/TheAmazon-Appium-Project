package actions;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import base.Keywords;
import base.Test;
import exceptions.ApplicationException;

/**
 * <h1>List of reusable methods for Verify actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Verify extends Keywords {

	private static Logger log = Logger.getLogger(Verify.class);

	/**
	 * Checks if an element is present in a page. Input- locatorKey(as String)
	 *
	 * @param locatorKey
	 * @throws ApplicationException
	 */
	public void elementIsPresent(String locatorKey) throws ApplicationException {
		log.info("Verify element [" + locatorKey + "] is present");
		get.elementBy(locatorKey);
		log.info("Element is present!");
	}

	/**
	 * Checks if an element is present in a page. Input- locatorKey(as By)
	 *
	 * @param locator
	 * @throws ApplicationException
	 */
	public void elementIsPresent(By locator) throws ApplicationException {
		log.info("Verify element [" + locator + "] is present");
		get.elementBy(locator);
		log.info("Element is present!");
	}

	/**
	 * Checks if an elementText is matching with an expected String value. Input:
	 * locatorKey(String), expectedValue(String)
	 *
	 * @param locatorKey
	 * @param expectedValue
	 * @throws ApplicationException
	 */
	public void elementTextMatching(String locatorKey, String expectedValue) throws ApplicationException {
		log.info("Verify element [" + locatorKey + "] text is matching with [" + expectedValue + "]");
		String actualValue = Test.tools
				.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locatorKey).getText().trim());
		try {
			isMatching(expectedValue, actualValue);
		} catch (Exception ex) {
			log.error(ex);
			throw new ApplicationException(ex.getMessage());
		}
		log.info("Condition verified!");
	}

	/**
	 * Checks if an elementText contains an expected String value. Input:
	 * locatorKey(String), expectedValue(String)
	 *
	 * @param locatorKey
	 * @param expectedValue
	 * @throws ApplicationException
	 */
	public void elementTextContains(String locatorKey, String expectedValue) throws ApplicationException {
		log.info("Verify element [" + locatorKey + "] text is matching with [" + expectedValue + "]");
		String actualValue = Test.tools
				.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locatorKey).getText().trim());
		try {
			Assert.assertTrue(actualValue.contains(expectedValue.trim()));
		} catch (AssertionError ex) {
			log.error("Actual value [" + actualValue + "] not matching with the Expected value[" + expectedValue + "]");
			throw new ApplicationException(
					"Actual value [" + actualValue + "] not matching with the Expected value[" + expectedValue + "]");
		}
		log.info("Condition verified!");
	}

	/**
	 * Checks if an elementText is matching with an expected String value. Input:
	 * locatorKey(By), expectedValue(String)
	 *
	 * @param locator
	 * @param expectedValue
	 * @throws ApplicationException
	 */
	public void elementTextMatching(By locator, String expectedValue) throws ApplicationException {
		log.info("Verify element [" + locator + "] text is matching with [" + expectedValue + "]");
		String actualValue = Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locator).getText().trim());
		try {
			isMatching(expectedValue, actualValue);
		} catch (Exception ex) {
			log.error(ex);
			throw new ApplicationException(ex.getMessage());
		}
		log.info("Condition verified!");
	}

	/**
	 * Checks if an elementText contains an expected String value. Input:
	 * locatorKey(By), expectedValue(String)
	 *
	 * @param locator
	 * @param expectedValue
	 * @throws ApplicationException
	 */
	public void elementTextContains(By locator, String expectedValue) throws ApplicationException {
		log.info("Verify element [" + locator + "] text is matching with [" + expectedValue + "]");
		String actualValue = Test.tools.nbspRemove(get.elementBy(locator).getText().trim());
		try {
			Assert.assertTrue(actualValue.contains(expectedValue.trim()));
		} catch (AssertionError ex) {
			log.error("Actual value [" + actualValue + "] don't contain the Expected value[" + expectedValue + "]");
			throw new ApplicationException(
					"Actual value [" + actualValue + "] don't contain the Expected value[" + expectedValue + "]");
		}
		log.info("Condition verified!");
	}

	/**
	 * Compares two string values to see if they are equal
	 *
	 * @param expected
	 * @param actual
	 * @throws ApplicationException
	 */
	public void isMatching(String expected, String actual) throws ApplicationException {
		try {
			Assert.assertEquals(Test.tools.nbspRemove(actual).toLowerCase(), expected.trim().toLowerCase());
		} catch (AssertionError ex) {
			log.info(ex);
			throw new ApplicationException(ex.getMessage());
		}
		log.info("Expected value [" + expected + "] is matching with the actual [" + actual + "]");
	}

}