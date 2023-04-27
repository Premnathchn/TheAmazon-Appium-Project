package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Tools;

public class CartPage extends Keywords {

	private String imgCartColumn = "Google.SearchResults.imgCartColumn";
	private String listItemsInCart = "Amazon.CartPage.listItemsInCart";

	/**
	 * Verifies if navigated to Cart Page by checking if the Active cart section is
	 * visible
	 */
	public void verifyIfNavigatedToCartPage() throws ApplicationException {
		verify.elementIsPresent(imgCartColumn);
	}

	/**
	 * Verifies if added item present in Cart
	 *
	 * @throws ApplicationException
	 */
	public void verifyAddedItemAvailableInCart() throws ApplicationException {
		String addedProductName = System.getProperty("strFirstProductName");

		boolean isPresent = Tools.IsStringPresentInAList(get.elementsBy(listItemsInCart), addedProductName);

		if (!isPresent) {
			throw new ApplicationException("Added product not present in the Cart: " + addedProductName);
		}
	}

}