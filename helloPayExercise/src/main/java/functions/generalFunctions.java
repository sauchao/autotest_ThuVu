package functions;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import variables.ConstantLib;
import variables.ConstantLib.Constants;

public class generalFunctions {

	/**
	 * Random a 5-character string
	 * 
	 * @param pPrefix
	 *            Prefix of the string
	 * @param mSuffix
	 *            Suffix of the string
	 * @return
	 */
	public static String randomString(String pPrefix, String mSuffix, int mlength) {

		String mSet1 = randomAlphabetic(mlength).toLowerCase();
		return pPrefix + mSet1 + mSuffix;
	}

	/**
	 * Randomize a number and return as a string
	 * 
	 * @param plength
	 *            Length of string
	 * @return Return a number as a String
	 */
	public static String randomNumber(int plength) {
		Random mRan = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < plength; i++) {
			int num = mRan.nextInt(10);
			sb.append(num);
		}

		return sb.toString();
	}

	/**
	 * Wait for specified time in seconds
	 */
	public static void waitForSeconds(double pSecond) {
		try {
			Thread.sleep((long) (pSecond * 1000));
		} catch (Exception e) {
		}
	}

	/**
	 * Click on a control on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void click(By pBy) {
		Constants.Driver.findElement(pBy).click();
	}

	/**
	 * Click on a control on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void clickbyJavascript(By pBy) {
		((JavascriptExecutor) ConstantLib.Constants.Driver).executeScript("arguments[0].click()",
				generalFunctions.captureInterface(pBy));
	}

	/**
	 * Select Drop down by hovering
	 */
	public static void selectDropdownByHover(By pDropdown, By pValue) {

		Actions action = new Actions(Constants.Driver);
		WebElement mDropdown = Constants.Driver.findElement(pDropdown);
		action.moveToElement(mDropdown).build().perform();
		generalFunctions.waitForSeconds(3);
		generalFunctions.clickbyJavascript(pValue);
	}

	/**
	 * Attempts to click on an element multiple times (to avoid stale element
	 * exceptions caused by rapid DOM refreshes)
	 *
	 * @param by
	 *            By element locator
	 */
	public static void waitAndClick(By pBy) {
		final int MAX_STALE_ELEMENT_RETRIES = 2;
		int retries = 0;
		while (retries < 2) {
			try {
				Constants.Wait.until(ExpectedConditions.elementToBeClickable(pBy)).click();
				return;
			} catch (Exception e) {
				if (retries < MAX_STALE_ELEMENT_RETRIES) {
					retries++;
					generalFunctions.waitForSeconds(2);
					continue;
				} else {
					System.out.println("Click - " + pBy + " Retry: " + retries);
				}
			}
		}
	}

	/**
	 * Enter value to element on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Value to enter
	 */
	public static void sendKeys(By pBy, String pValue) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		try {
			Constants.Wait.until(ExpectedConditions.elementToBeClickable(mElement));
		} catch (Exception e) {
		}
		mElement.sendKeys(pValue);

	}

	/**
	 * Capture a element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @return Return a WebElement object
	 */
	public static WebElement captureInterface(By pBy) {
		try {
			return Constants.Driver.findElement(pBy);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Wait for a element visible
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public void waitForElementVisible(By pBy) {
		try {
			Constants.Wait.until(ExpectedConditions.visibilityOfElementLocated(pBy));
		} catch (Exception e) {

		}
	}

	/**
	 * Wait for a element invisible
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public void waitForElementNotVisible(By pBy) {
		try {
			Constants.Wait.until(ExpectedConditions.invisibilityOfElementLocated(pBy));
		} catch (Exception e) {
			System.out.println(pBy + " Not Visible");
		}
	}

	/**
	 * Wait for a value is populated in an element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Expected value to wait for
	 */
	public void waitForElementValue(By pBy, String pValue) {
		try {
			Constants.Wait.until(ExpectedConditions.attributeToBe(pBy, "value", pValue));
		} catch (Exception e) {
		}
	}

	/**
	 * Wait for a value is selected in an element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Expected value to wait for
	 */
	public static void waitForElementValueSelected(By pBy, String pValue) {
		String mId;
		mId = generalFunctions.getElementID(pBy);
		By mBy = By.xpath("//*[@id = '" + mId + "']/following-sibling::*[1]/ul/li[@class='active']");
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 10000) {
			try {
				Constants.Wait.until(ExpectedConditions.attributeToBe(mBy, "innerText", pValue));
			} catch (Exception e) {
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
				}
			}
		}

	}

	/**
	 * Get id of element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @return Return id of element
	 */
	public static String getElementID(By pBy) {
		WebElement mElement;
		String mId;
		try {
			mId = generalFunctions.captureInterface(pBy).getAttribute("id");
		} catch (StaleElementReferenceException e) {
			mElement = generalFunctions.captureInterface(pBy);
			mId = mElement.getAttribute("id");
		}
		return mId;
	}

	/**
	 * Wait for element enabled
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public void waitForElementEnabled(By pBy) {
		try {
			Constants.Wait.until(ExpectedConditions.elementToBeClickable(pBy));
		} catch (Exception e) {
		}
	}

	/**
	 * Wait for element disabled
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public void waitForElementDisabled(By pBy) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < Constants.TimeOut * 1000) {
			WebElement mElement = generalFunctions.captureInterface(pBy);
			try {
				if (!mElement.getAttribute("disabled").contains("true")) {
					generalFunctions.waitForSeconds(2);
				} else {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
}