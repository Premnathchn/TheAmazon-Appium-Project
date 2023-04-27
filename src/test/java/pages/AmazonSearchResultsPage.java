package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Tools;

public class AmazonSearchResultsPage extends Keywords {

	private String listSearchResults = "Amazon.SearchResults.listSearchResults";

	/**
	 * Clicks on the first search result
	 */
	public void clickOnTheFirstSearchResult() throws ApplicationException {
		click.elementBy(Tools.returnFirstWebElement(listSearchResults));
	}

	public void getTheFirstSearchResult() throws ApplicationException {
		verify.elementIsPresent(listSearchResults);
		String strFirstProductName = get.elementText(Tools.returnFirstWebElement(listSearchResults));
		System.setProperty("strFirstProductName", strFirstProductName);
	}

}