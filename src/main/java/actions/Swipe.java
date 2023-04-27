package actions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import base.Keywords;
import exceptions.ApplicationException;
import io.appium.java_client.TouchAction;

/**
 * <h1>List of reusable methods for swipe actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Swipe extends Keywords {

	/**
	 * Clicks on elementBy using co-ordinates of an element
	 *
	 * @param x
	 * @param y
	 * @throws ApplicationException
	 */
	public void tapByCoordinates(int x, int y) throws ApplicationException {
		try {
			new TouchAction(driver).tap(point(x, y)).waitAction(waitOptions(ofMillis(250))).perform();
		} catch (Exception e) {
			throw new ApplicationException("Exception occured in tapByCoordinates");
		}
	}

}
