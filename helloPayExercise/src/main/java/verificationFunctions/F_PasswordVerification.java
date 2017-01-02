package verificationFunctions;

import org.openqa.selenium.WebElement;

import functions.generalFunctions;
import interfaces.I_ForgotPasswordPage;
import variables.TCResult;

public class F_PasswordVerification {

	/**
	 * Verify Error Message Displayed
	 * 
	 * @param pMessageText
	 *            Message Text
	 * @param pResult
	 *            Result of the test case
	 */
	public static void verifyErrorMessageDisplayed(String pMessageText, TCResult pResult) {

		WebElement eErrorText = generalFunctions.captureInterface(I_ForgotPasswordPage.lbl_Error);
		F_GeneralVerification.verifyElementValue("Error Text ", eErrorText.getText(), pMessageText, pResult);
	}

	/**
	 * Verify Success Message Displayed
	 * 
	 * @param pMessageText
	 *            Message Text
	 * @param pResult
	 *            Result of the test case
	 */
	public static void verifySuccessMessageDisplayed(String pMessageText, TCResult pResult) {

		WebElement eSuccessText = generalFunctions.captureInterface(I_ForgotPasswordPage.lbl_SuccessText);
		F_GeneralVerification.verifyElementValue("Success Text ", eSuccessText.getText(), pMessageText, pResult);
	}
}
