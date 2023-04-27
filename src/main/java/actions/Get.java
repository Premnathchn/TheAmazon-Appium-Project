package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Keywords;
import exceptions.ApplicationException;
import helper.PropertyReader;

import java.util.List;

/**
 * <h1>List of reusable methods for Get actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 20 April 2023
 */
public class Get extends Keywords {

	private static Logger log = Logger.getLogger(Get.class);
	private static WebElement singleTestObj = null;
	private static List<WebElement> listTestObj = null;

	/**
	 * Returns WebElement by accepting locationKey as String
	 *
	 * @param locatorKey
	 * @return
	 * @throws ApplicationException
	 */
	public WebElement elementBy(String locatorKey) throws ApplicationException {
		try {
			singleTestObj = wait
					.until(ExpectedConditions.presenceOfElementLocated(PropertyReader.locatorOf(locatorKey)));
		} catch (TimeoutException ex) {
			log.error("Element [" + locatorKey + "] not found!");
			throw new ApplicationException("Element [" + locatorKey + "] not found!");
		} catch (WebDriverException ex) {
			singleTestObj = wait
					.until(ExpectedConditions.presenceOfElementLocated(PropertyReader.locatorOf(locatorKey)));
		}
		return singleTestObj;
	}

	/**
	 * Returns WebElement by accepting locationKey as By
	 *
	 * @param locator
	 * @return
	 * @throws ApplicationException
	 */
	public WebElement elementBy(By locator) throws ApplicationException {
		try {
			singleTestObj = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException ex) {
			log.error("Element [" + locator + "] not found!");
			throw new ApplicationException("Element [" + locator + "] not found!");
		} catch (WebDriverException ex) {
			singleTestObj = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		return singleTestObj;
	}

	/**
	 * Returns elementText by accepting locationKey as String
	 *
	 * @param locatorKey
	 * @return
	 * @throws ApplicationException
	 */
	public String elementText(String locatorKey) throws ApplicationException {
		log.info("Retrieved the value of text property from the element [" + locatorKey + "]");
		String txt = null;
		try {
			txt = elementBy(locatorKey).getText();
		} catch (WebDriverException ex) {
			throw new ApplicationException("Element [" + locatorKey + "] not found!");
		}
		log.info("Text [" + txt + "] retrieved successfully!");
		return txt.trim();
	}

	/**
	 * Returns elementText by accepting locationKey as WebElement
	 *
	 * @param element
	 * @return
	 * @throws ApplicationException
	 */
	public String elementText(WebElement element) throws ApplicationException {
		log.info("Retrieved the value of text property from the element [" + element + "]");
		String txt = null;
		try {
			txt = element.getText();
		} catch (WebDriverException ex) {
			throw new ApplicationException("Element [" + element + "] not found!");
		}
		log.info("Text [" + txt + "] retrieved successfully!");
		return txt.trim();
	}

	/**
	 * Returns elementText by accepting locationKey as By
	 *
	 * @param locator
	 * @return
	 * @throws ApplicationException
	 */
	public String elementText(By locator) throws ApplicationException {
		log.info("Retrieve the value of text property from the element [" + locator + "]");
		String txt = null;
		try {
			txt = elementBy(locator).getText();
		} catch (WebDriverException ex) {
			throw new ApplicationException("Element [" + locator + "] not found!");
		}
		log.info("Text retrieved successfully!");
		return txt.trim();
	}

	/**
	 * Returns WebElement by accepting locationKey as String
	 *
	 * @param locatorKey
	 * @return
	 * @throws ApplicationException
	 */
	public List<WebElement> elementsBy(String locatorKey) throws ApplicationException {
		List<WebElement> list = null;
		try {
			list = driver.findElements(PropertyReader.locatorOf(locatorKey));
		} catch (TimeoutException ex) {
			log.error("Element [" + locatorKey + "] not found!");
			throw new ApplicationException("Element [" + locatorKey + "] not found!");
		}
		return list;
	}

}