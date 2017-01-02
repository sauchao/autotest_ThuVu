package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import functions.generalFunctions;
import interfaces.I_HomePage;
import interfaces.I_LoginPage;
import objects.O_PersonalAccount;
import variables.ConstantLib.Constants;

public class F_Navigation {

	/**
	 * Go to HelloPay URL
	 */
	public static void goToHelloPayURL() {
		Constants.Driver.navigate().to(Constants.Url);
		generalFunctions.waitForSeconds(3);
	}

	/**
	 * Login HelloPay app
	 * 
	 * @param pCountry
	 *            Country to login
	 * @param pEmail
	 *            Email to login
	 * @param pPassword
	 *            Password to login
	 */
	public static void loginHelloPay(String pCountry, String pEmail, String pPassword) {
		By drd_CountryValue = By.xpath("//*[@id='countriesMenu']//span[.='" + pCountry + "']");
		generalFunctions.selectDropdownByHover(I_HomePage.drd_Country, drd_CountryValue);
		generalFunctions.clickbyJavascript(I_HomePage.btn_Login);
		generalFunctions.sendKeys(I_LoginPage.txt_Email, pEmail);
		generalFunctions.sendKeys(I_LoginPage.txt_Password, pPassword);
		generalFunctions.clickbyJavascript(I_LoginPage.btn_SecureLogin);
	}

	/**
	 * Login HelloPay app
	 */
	public static void loginHelloPay(O_PersonalAccount pAccount) {
		loginHelloPay(pAccount.Country, pAccount.Email, pAccount.Password);
	}

	/**
	 * Logout HelloPay account
	 */
	public static void logoutAccount(O_PersonalAccount pAccount) {

		Actions action = new Actions(Constants.Driver);
		WebElement mUsername = Constants.Driver.findElement(I_HomePage.lbl_Username);
		action.moveToElement(mUsername).build().perform();
		generalFunctions.waitForSeconds(3);
		generalFunctions.clickbyJavascript(I_HomePage.btn_Logout);
	}

	/**
	 * Go to Create new account
	 */
	public static void goToCreateNewAccount() {
		generalFunctions.clickbyJavascript(I_HomePage.btn_Register);
	}

	/**
	 * Go to Forgot Password
	 */
	public static void goToForgotPassword() {
		if (generalFunctions.captureInterface(I_HomePage.btn_Login).isEnabled()) {
			generalFunctions.clickbyJavascript(I_HomePage.btn_Login);
		}
		generalFunctions.clickbyJavascript(I_LoginPage.lnk_ForgotPassword);
	}
}
