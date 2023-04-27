package stepdefinitions;

import static base.Keywords.enterurl;
import static base.Keywords.launchApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.ApplicationException;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;
import pages.CartPage;
import pages.ProductDetailsPage;

public class TheSportsbetStepDef {

	private static AmazonHomePage amazonHomePage = new AmazonHomePage();
	private static AmazonSearchResultsPage amazonSearchResultsPage = new AmazonSearchResultsPage();
	private static CartPage cartPage = new CartPage();
	private static ProductDetailsPage productDetailsPage = new ProductDetailsPage();

	@Given("^I launch the (.*) and navigate to Homepage$")
	public void i_launch_the_url_and_navigate_to_Homepage(String url) throws Exception {
		launchApplication();
		enterurl(url);
	}

	@When("^I Search for the given keyword (.*)$")
	public void i_Search_for_the_given_keyword(String searchTerm) throws ApplicationException {
		amazonHomePage.verifyIfNavigatedToHomePage();
		amazonHomePage.enterValueInTextBox(searchTerm);
	}

	@When("Add the product in the first search result to the Cart")
	public void add_the_product_in_the_first_search_result_to_the_Cart() throws ApplicationException {
		amazonSearchResultsPage.getTheFirstSearchResult();
		amazonSearchResultsPage.clickOnTheFirstSearchResult();
		productDetailsPage.clickOnAddToCartButton();
	}

	@When("Navigate to the Cart page")
	public void navigate_to_the_Cart_page() throws ApplicationException {
		productDetailsPage.clickOnGoToCartButton();
	}

	@Then("I should see the added product in the Cart page")
	public void i_should_see_the_added_product_in_the_Cart_page() throws ApplicationException {
		cartPage.verifyIfNavigatedToCartPage();
		cartPage.verifyAddedItemAvailableInCart();
	}

}
