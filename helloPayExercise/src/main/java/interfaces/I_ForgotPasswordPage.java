package interfaces;

import org.openqa.selenium.By;

public class I_ForgotPasswordPage {
	public static By txt_EmailAddress = By.id("uid");
	public static By btn_ResetPassword = By.xpath("//input[@id='login' and contains(@value,'Reset Your Password')]");
	public static By lbl_Error = By
			.xpath("//input[@id='login' and contains(@value,'Reset Your Password')]/preceding-sibling::*[1]");
	public static By lbl_SuccessText = By.xpath("//div[@class='mainAlert successGeneral']");
}
