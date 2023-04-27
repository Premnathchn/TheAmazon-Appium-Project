package pages;

import base.Keywords;
import exceptions.ApplicationException;

public class AmazonHomePage extends Keywords {

	private String txtSearchBox = "Amazon.Homepage.txtSearchBox";
	private String imgLogo = "Amazon.Homepage.imgLogo";

	/**
	 * This method enters the given text in the searchBox in Amazon homepage
	 * 
	 * @param textToEnter
	 *
	 * @throws ApplicationException
	 */
	public void enterValueInTextBox(String textToEnter) throws ApplicationException {

		verify.elementIsPresent(txtSearchBox);
		type.data(txtSearchBox, textToEnter);
		click.pressEnterKey(txtSearchBox);
	}

	/**
	 * Verifies if the Amazon logo is present in the page
	 *
	 * @throws ApplicationException
	 */
	public void verifyIfNavigatedToHomePage() throws ApplicationException {
		verify.elementIsPresent(imgLogo);
	}

}