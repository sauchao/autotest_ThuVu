package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.DefaultAnnotations;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import variables.valueList;
import verificationFunctions.F_PasswordVerification;
import objects.O_PersonalAccount;
import functions.F_Navigation;
import functions.F_Account;

public class Password_001 extends DefaultAnnotations {

	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.ThuVu })
	public void TC001_Forgot_Password_with_valid_email() {
		O_PersonalAccount mAccount = new O_PersonalAccount();

		// Precondition: create a helloPay account
		F_Navigation.goToHelloPayURL();
		F_Navigation.goToCreateNewAccount();
		F_Account.createAccount(mAccount);
		F_Navigation.logoutAccount(mAccount);

		// Main steps
		F_Navigation.goToForgotPassword();
		F_Account.resetPassword(mAccount.Email);
		F_PasswordVerification.verifySuccessMessageDisplayed(valueList.MessageText.ValidEmailText, Result);

		Assert.assertTrue(Result.Result, Result.Message);
	}

	@Test(groups = { Priority.High, TestSuite.Regression, AppFunction.Account, Owner.ThuVu })
	public void TC002_Forgot_Password_with_invalid_email() {
		O_PersonalAccount mAccount = new O_PersonalAccount();

		F_Navigation.goToHelloPayURL();

		F_Navigation.goToForgotPassword();
		F_Account.resetPassword(mAccount.Email);
		F_PasswordVerification.verifyErrorMessageDisplayed(valueList.MessageText.InvalidEmailErrorText, Result);

		Assert.assertTrue(Result.Result, Result.Message);
	}
}