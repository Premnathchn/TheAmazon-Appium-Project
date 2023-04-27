package actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;

import com.cucumber.listener.Reporter;

import base.Keywords;
import base.Test;
import constants.Keys;

/**
 * <h1>List of reusable methods for reporting purpose.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Screenshot extends Keywords {

	private static Logger log = Logger.getLogger(Screenshot.class);

	private String takeScreenshot(String filename) {
		log.info("Capture screenshot");
		String imgName = filename + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
		try {
			File img = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File(Test.attributes.get(Keys.RunFolder) + "images/" + imgName));
			log.info("Captured!");
		} catch (Throwable e) {
			log.warn("Problem while capturing the screenshot\n" + e.getMessage());
		}
		return imgName;
	}

	public void attachScreenshot(String filename) {
		try {
			String currentDir = System.getProperty("user.dir");
			System.setProperty("user.dir", Test.attributes.get(Keys.RunFolder));
			Reporter.addScreenCaptureFromPath("images/" + takeScreenshot(filename));
			System.setProperty("user.dir", currentDir);
		} catch (Throwable e) {
			log.warn("Problem while attaching the screenshot to extent report\n" + e.getMessage());
		}
	}
}
