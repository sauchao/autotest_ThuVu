package verificationFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import functions.generalFunctions;
import interfaces.I_HomePage;
import objects.O_PersonalAccount;
import variables.TCResult;

public class F_AccountVerification {

	/**
	 * Verify account is created successfully
	 * 
	 * @param pAccount
	 *            Account needs to verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void accountCreatedSuccessfully(O_PersonalAccount pAccount, TCResult pResult) {

		By mWelcomeText = By.xpath("//div[@class='title']");

		WebElement eWelcomeText = generalFunctions.captureInterface(mWelcomeText);
		F_GeneralVerification.verifyElementValue("Welcome Text ", eWelcomeText.getText(), pAccount.WelcomeText,
				pResult);

		WebElement eUsername = generalFunctions.captureInterface(I_HomePage.lbl_Username);
		F_GeneralVerification.verifyElementValue("Username ", eUsername.getText(), pAccount.FullName, pResult);
	}
}
