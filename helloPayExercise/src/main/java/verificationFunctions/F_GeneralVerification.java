package verificationFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import variables.TCResult;
import variables.ConstantLib.Constants;

public class F_GeneralVerification {

	/**
	 * Verify that element is visible
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementVisible(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (!mElement.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is not displayed");
		}
	}

	/**
	 * Verify that element is invisible
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementInvisible(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (mElement != null && mElement.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is still displayed");
		}
	}

	/**
	 * Verify that element is selected
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementSelected(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (!mElement.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is not selected");
		}
	}

	/**
	 * Verify that element is not selected
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementNotSelected(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (mElement.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is selected");
		}
	}

	/**
	 * Compare text of actual and expected results
	 * 
	 * @param pFieldName
	 *            Name of the element
	 * @param pActualResult
	 *            Actual value needs to verify
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementValue(String pElementName, String pActualResult, String pExpectedResult,
			TCResult pResult) {
		if (!pActualResult.equals(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is displayed " + pActualResult + " instead of " + pExpectedResult);
		}
	}

	/**
	 * Verify element enable
	 * 
	 * @param pElementName
	 *            Name of the element
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void verifyElementEnabled(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (!mElement.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is not enabled");
		}
	}

	/**
	 * Verify element not enable
	 * 
	 * @param pElementName
	 *            Name of the element
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void verifyElementNotEnabled(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (mElement.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is enabled");
		}
	}
}
