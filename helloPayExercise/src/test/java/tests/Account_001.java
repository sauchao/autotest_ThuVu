package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.DefaultAnnotations;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AccountVerification;
import verificationFunctions.F_GeneralVerification;
import objects.O_PersonalAccount;
import functions.F_Navigation;
import interfaces.I_HomePage;
import functions.F_Account;

public class Account_001 extends DefaultAnnotations {

	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.ThuVu })
	public void TC001_Able_to_create_new_account() {
		O_PersonalAccount mAccount = new O_PersonalAccount();

		// Pre-condition
		F_Navigation.goToHelloPayURL();

		// Main steps
		F_Navigation.goToCreateNewAccount();
		F_Account.createAccount(mAccount);
		F_AccountVerification.accountCreatedSuccessfully(mAccount, Result);

		Assert.assertTrue(Result.Result, Result.Message);
	}

	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.ThuVu })
	public void TC001_Able_to_logout_helloPay_account() {
		O_PersonalAccount mAccount = new O_PersonalAccount();

		// Pre-condition: create a helloPay account
		F_Navigation.goToHelloPayURL();
		F_Navigation.goToCreateNewAccount();
		F_Account.createAccount(mAccount);

		// Main steps
		F_Navigation.logoutAccount(mAccount);
		F_GeneralVerification.verifyElementVisible(I_HomePage.btn_Login, "Login button", Result);

		Assert.assertTrue(Result.Result, Result.Message);
	}
}