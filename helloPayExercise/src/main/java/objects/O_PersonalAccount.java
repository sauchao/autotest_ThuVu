package objects;

import functions.F_Account;
import functions.generalFunctions;
import tests.DefaultAnnotations;

public class O_PersonalAccount extends DefaultAnnotations {

	public String Country;
	public String Firstname;
	public String Lastname;
	public String FullName;
	public String MobilePrefix;
	public String MobileNumber;
	public String Email;
	public String Password;
	public String WelcomeText = "";

	public O_PersonalAccount() {
		this.Country = F_Account.randomCountry("");
		this.Firstname = generalFunctions.randomString("Fn", "", 5);
		this.Lastname = generalFunctions.randomString("Ln", "", 5);
		this.FullName = this.Firstname + " " + this.Lastname;
		F_Account.getMobilePrefix(this);
		this.MobileNumber = F_Account.randomPhoneNumber(this);
		this.Email = F_Account.randomEmail(this);
		this.Password = F_Account.randomPassword();
	}
}
