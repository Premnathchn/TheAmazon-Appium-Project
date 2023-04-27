package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import base.Keywords;
import exceptions.ApplicationException;

/**
 * <h1>List of reusable methods for click actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Click extends Keywords {

	private static Logger log = Logger.getLogger(Click.class);

	/**
	 * Clicks on elementBy locatorKey (String)
	 *
	 * @param locatorKey
	 * @throws ApplicationException
	 */
	public void elementBy(String locatorKey) throws ApplicationException {
		log.info("Click element [" + locatorKey + "]");
		try {
			get.elementBy(locatorKey).click();
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clicking element: " + locatorKey);
		}
		log.info("Click Successful!");
	}

	/**
	 * Clicks on elementBy locatorKey (By)
	 *
	 * @param locator
	 * @throws ApplicationException
	 */
	public void elementBy(By locator) throws ApplicationException {
		log.info("Click element [" + locator + "]");
		try {
			get.elementBy(locator).click();
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clicking element: " + locator);
		}
		log.info("Click Successful!");
	}

	/**
	 * Clicks on elementBy locatorKey (String), If its present in the page
	 *
	 * @param locatorKey
	 * @throws ApplicationException
	 */
	public void clickIfPresent(String locatorKey) throws ApplicationException {
		log.info("clickIfPresent [" + locatorKey + "]");
		try {
			if (get.elementBy(locatorKey).isDisplayed()) {
				get.elementBy(locatorKey).click();
			}
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clickIfPresent element: " + locatorKey);
		}
		log.info("Click Successful!");
	}
	
	/**
	 * This method allows to press enter key on a WebElement
	 * 
	 * @param element
	 * @throws ApplicationException
	 */
	public void pressEnterKey(String element) throws ApplicationException {
		try {
			get.elementBy(element).sendKeys(Keys.RETURN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- clickEnterKey: " + e.getMessage());
		}
	}

	/**
	 * Clicks on elementBy locatorKey (By)
	 *
	 * @param locator
	 * @throws ApplicationException
	 */
	public void elementBy(WebElement element) throws ApplicationException {
		log.info("Click element [" + element + "]");
		try {
			element.click();
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clicking element: " + element);
		}
		log.info("Click Successful!");
	}

}
