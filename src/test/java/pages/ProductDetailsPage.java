package pages;

import base.Keywords;
import exceptions.ApplicationException;

public class ProductDetailsPage extends Keywords {

	private String btnAddToCart = "Amazon.SearchResults.btnAddToCart";
	private String btnGoToCart = "Amazon.SearchResults.btnGoToCart";

	/**
	 * Clicks on "Add To Cart" button
	 */
	public void clickOnAddToCartButton() throws ApplicationException {
		click.elementBy(btnAddToCart);
	}

	/**
	 * Clicks on "Go To Cart" button
	 */
	public void clickOnGoToCartButton() throws ApplicationException {
		click.elementBy(btnGoToCart);
	}

}