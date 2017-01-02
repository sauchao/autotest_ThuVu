package functions;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;

import interfaces.I_CreateAccountPage;
import interfaces.I_ForgotPasswordPage;
import objects.O_PersonalAccount;
import variables.valueList.MessageText;
import variables.valueList.MobilePrefix;
import variables.valueList;
import variables.valueList.Country;
import functions.generalFunctions;

public class F_Account {

	/**
	 * Randomize a Country
	 * 
	 * @param pExcept
	 *            Except value
	 * @return Country to return
	 */
	public static String randomCountry(String pExcept) {
		ArrayList<String> mList = new ArrayList<>();
		mList.add(Country.Singapore);
		mList.add(Country.Philippines);
		mList.add(Country.Indonesia);
		mList.add(Country.Malaysia);
		if (!pExcept.equals(""))
			mList.remove(pExcept);
		Random mRan = new Random();
		return mList.get(mRan.nextInt(mList.size()));
	}

	/**
	 * get Mobile Prefix
	 * 
	 * @param pAccount
	 *            Account needs to create
	 */
	public static void getMobilePrefix(O_PersonalAccount pAccount) {
		if (pAccount.Country.equals(Country.Singapore))
			pAccount.MobilePrefix = MobilePrefix.Singapore;
		else if (pAccount.Country.equals(Country.Philippines))
			pAccount.MobilePrefix = MobilePrefix.Philippines;
		else if (pAccount.Country.equals(Country.Malaysia))
			pAccount.MobilePrefix = MobilePrefix.Malaysia;
		else if (pAccount.Country.equals(Country.Indonesia))
			pAccount.MobilePrefix = MobilePrefix.Indonesia;
	}

	/**
	 * Randomize and return an email address
	 * 
	 * @param pAccount
	 *            Account needs to randomize email
	 * 
	 * @return An email string
	 */
	public static String randomEmail(O_PersonalAccount pAccount) {
		// String mSet1 = randomAlphabetic(5).toLowerCase();
		// String mSet2 = randomAlphabetic(5).toLowerCase();
		// String mSet3 = randomAlphabetic(3).toLowerCase();
		// String mSet4 = randomAlphabetic(2).toLowerCase();
		// Random mRan = new Random();
		// if (mRan.nextBoolean())
		// return mSet1 + "@" + mSet2 + "." + mSet3 + "." + mSet4;
		// else
		// return mSet1 + "@" + mSet2 + "." + mSet3;

		// TODO This is a temp solution, need to consider email rules later
		return pAccount.Firstname + "." + pAccount.Lastname + "@gmail.com";
	}

	/**
	 * Randomize and return a helloPay Password
	 * 
	 * @return A password string
	 */
	public static String randomPassword() {
		String mSet1 = randomAlphabetic(3).toUpperCase();
		String mSet2 = generalFunctions.randomNumber(3).toLowerCase();
		String mSet3 = randomAlphabetic(3).toLowerCase();

		return mSet1 + mSet2 + mSet3;

	}

	/**
	 * Randomize a phone number and return as a string
	 * 
	 * @param pAccount
	 *            Account to randomize phone number
	 * 
	 * @return Return a phone number as a String
	 */
	public static String randomPhoneNumber(O_PersonalAccount pAccount) {
		// TODO This is a temp solution, need to consider phone rules later
		String mPhoneNumber = "";
		if (pAccount.Country.equals(valueList.Country.Singapore)) {
			int n[] = { 3, 6, 8, 9 };
			Random random = new Random();
			String mSet1 = Integer.toString(n[random.nextInt(n.length)]);
			String mSet2 = generalFunctions.randomNumber(7);
			mPhoneNumber = mSet1 + mSet2;
		} else if (pAccount.Country.equals(valueList.Country.Philippines)) {
			int n[] = { 912, 915, 917, 918, 973 };
			Random random = new Random();
			String mSet1 = Integer.toString(n[random.nextInt(n.length)]);
			String mSet2 = generalFunctions.randomNumber(7);
			mPhoneNumber = mSet1 + mSet2;
		} else if (pAccount.Country.equals(valueList.Country.Malaysia)) {
			int n[] = { 042, 072 };
			Random random = new Random();
			String mSet1 = Integer.toString(n[random.nextInt(n.length)]);
			String mSet2 = generalFunctions.randomNumber(6);
			mPhoneNumber = mSet1 + mSet2;
		} else if (pAccount.Country.equals(valueList.Country.Indonesia)) {
			int n[] = { 21, 22, 24, 31 };
			Random random = new Random();
			String mSet1 = Integer.toString(n[random.nextInt(n.length)]);
			String mSet2 = generalFunctions.randomNumber(8);
			mPhoneNumber = mSet1 + mSet2;
		}
		return mPhoneNumber;
	}

	/**
	 * Enter new account detail
	 */
	public static void enterAccount(O_PersonalAccount pAccount) {

		generalFunctions.click(I_CreateAccountPage.tab_PersonalAccount);
		selectCountryDropdown(I_CreateAccountPage.drd_Country, pAccount.Country);
		generalFunctions.sendKeys(I_CreateAccountPage.txt_Fullname, pAccount.FullName);
		generalFunctions.sendKeys(I_CreateAccountPage.txt_MobileNumber, pAccount.MobileNumber);
		generalFunctions.sendKeys(I_CreateAccountPage.txt_Email, pAccount.Email);
		generalFunctions.sendKeys(I_CreateAccountPage.txt_Password, pAccount.Password);
	}

	/**
	 * Click Create Account button
	 */
	public static void clickCreateAccountButton() {
		generalFunctions.waitAndClick(I_CreateAccountPage.btn_OpenAccountNow);
	}

	/**
	 * Create HelloPay account
	 */
	public static void createAccount(O_PersonalAccount pAccount) {
		enterAccount(pAccount);
		clickCreateAccountButton();
		pAccount.WelcomeText += String.format(MessageText.Welcome, pAccount.FullName);
	}

	/**
	 * Input Forgot Password email and click on reset password button
	 */
	public static void resetPassword(String pEmail) {
		generalFunctions.sendKeys(I_ForgotPasswordPage.txt_EmailAddress, pEmail);
		generalFunctions.waitAndClick(I_ForgotPasswordPage.btn_ResetPassword);
	}

	/**
	 * Select value in Country drop down list on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Value to select
	 */
	public static void selectCountryDropdown(By pBy, String pValue) {

		String mId = generalFunctions.getElementID(pBy);
		By mClick = By.xpath("//*[@id = '" + mId + "']/following-sibling::*[1]/div");
		By mValue = By.xpath("//*[@id = '" + mId + "']/following-sibling::*[1]/ul/li[.='" + pValue + "']");
		generalFunctions.waitAndClick(mClick);
		generalFunctions.click(mValue);
		generalFunctions.waitForElementValueSelected(pBy, pValue);
	}
}
