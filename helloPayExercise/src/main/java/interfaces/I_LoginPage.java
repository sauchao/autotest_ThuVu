package interfaces;

import org.openqa.selenium.By;

public class I_LoginPage {
	public static By lnk_ForgotPassword = By.xpath("//a[.='Forgot your password?']");
	public static By btn_SecureLogin = By.xpath("//input[@id='login' and contains(@value,'Secure Login')]");
	public static By txt_Email = By.id("email");
	public static By txt_Password = By.id("password");
}
