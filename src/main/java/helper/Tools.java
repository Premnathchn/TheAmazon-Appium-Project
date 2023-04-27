package helper;

import java.util.List;

import base.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import exceptions.ApplicationException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tools {

	public String REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(String text) {
		String i = text.replace("\n", " ").replaceAll("\\s{2,}", " ").replaceAll("\\u00A0", "").trim();
		return i;
	}

	public String nbspRemove(String text) {
		return text.trim().replaceAll("\\u00A0", "");
	}

	public static void switchToIframe(WebElement iframeElement) throws ApplicationException {
		try {
			Keywords.driver.switchTo().frame(iframeElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- switchToIframe: " + e.getMessage());
		}
	}

	public static void switchToIframe(String str) throws ApplicationException {
		try {
			Keywords.driver.switchTo().frame(str);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- switchToIframe: " + e.getMessage());
		}
	}

	public static void switchToIframe(int index) throws ApplicationException {
		try {
			Keywords.driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- switchToIframe: " + e.getMessage());
		}
	}

	/**
	 * Sets/Initializes the browser and URL details. This is to facilitate the
	 * execution through commandline and passing arguments in commandline
	 *
	 * @throws Exception
	 */
	public static void setBrowserAndUrlDetails() throws Exception {

		try {
			String browser = System.getProperty("browser");
			String url = System.getProperty("url");

			if (browser == null) {
				browser = PropertyReader.testDataOf("browser");
				System.setProperty("browser", browser);
			}

			if (url == null) {
				url = PropertyReader.testDataOf("url");
				System.setProperty("url", url);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- setBrowserAndUrlDetails: " + e.getMessage());
		}

	}

	/**
	 * Compares if the expectedValue matches the values in any of the given
	 * listElements.
	 *
	 * @param strListNewsDescriptionsInH3Tag
	 * @param strListNewsDescriptionsInSpanTag
	 * @param strListNewsDescriptionsInDivTag
	 * @param strExpectedValue
	 * @throws ApplicationException
	 */
	public static void verifyIfTheStringIsPresentInAList(String strListNewsDescriptionsInH3Tag,
			String strListNewsDescriptionsInSpanTag, String strListNewsDescriptionsInDivTag, String strExpectedValue)
			throws ApplicationException {
		int count = 0;
		List<WebElement> listNewsDescriptionsInH3Tag = Keywords.driver
				.findElements(By.xpath(strListNewsDescriptionsInH3Tag));
		List<WebElement> listNewsDescriptionsInSpanTag = Keywords.driver
				.findElements(By.xpath(strListNewsDescriptionsInSpanTag));
		List<WebElement> listNewsDescriptionsInDivTag = Keywords.driver
				.findElements(By.xpath(strListNewsDescriptionsInDivTag));

		count = getCountOfMatchingElements(listNewsDescriptionsInH3Tag, strExpectedValue, 0);

		if (count < 2) {
			count = getCountOfMatchingElements(listNewsDescriptionsInSpanTag, strExpectedValue, count);

			if (count < 2) {
				count = getCountOfMatchingElements(listNewsDescriptionsInDivTag, strExpectedValue, count);
			}
		}
		if (count < 2) {
			throw new ApplicationException("Expected: 2 or more matching sources for the article. Actual: " + count
					+ " matching sources for the article");
		}
	}

	/**
	 * Return the count of matching elements
	 *
	 * @param listWebElement
	 * @param strExpectedValue
	 * @param count
	 * @return
	 * @throws ApplicationException
	 */
	public static int getCountOfMatchingElements(List<WebElement> listWebElement, String strExpectedValue, int count)
			throws ApplicationException {

		try {
			for (WebElement element : listWebElement) {

				if (element.getText().contains(strExpectedValue)) {
					count++;
					if (count > 2) {
						break;
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- getCountOfMatchingElements:: " + e.getMessage());
		}

	}

	/**
	 * Opens the given URL is the current browser session
	 *
	 * @param url
	 * @throws Exception
	 */
	public static void openURL(String url) throws Exception {
		try {
			Keywords.driver.get(url);
		} catch (Exception e) {
			throw new ApplicationException("Exception in method- openURL: " + url);
		}
	}

	/**
	 * Returns first webElement from a list of WebElements
	 *
	 * @param listWebelement
	 * @return
	 * @throws ApplicationException
	 */
	public static WebElement returnFirstWebElement(String listWebelement) throws ApplicationException {
		WebElement firstWebElement = Keywords.get.elementsBy(listWebelement).get(0);
		return firstWebElement;
	}

	/**
	 * This method return the count of matching instances from the given list of
	 * WebElement
	 *
	 * @param listWebElement
	 * @param strExpectedValue
	 * @return
	 * @throws ApplicationException
	 */
	public static boolean IsStringPresentInAList(List<WebElement> listWebElement, String strExpectedValue)
			throws ApplicationException {

		boolean isPresent = false;
		try {
			for (WebElement element : listWebElement) {

				String firstProductInCart = element.getText();

				if (firstProductInCart.equalsIgnoreCase(strExpectedValue)) {
					isPresent = true;
					break;
				}
			}
			return isPresent;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in method- getCountOfMatchingElements:: " + e.getMessage());
		}

	}


}