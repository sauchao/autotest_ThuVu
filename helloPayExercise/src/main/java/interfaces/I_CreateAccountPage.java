package interfaces;

import org.openqa.selenium.By;

public class I_CreateAccountPage {
	public static By tab_PersonalAccount = By.xpath("//a[@href='/register/consumer']");
	public static By drd_Country = By.id("countryCode");
	public static By txt_Fullname = By.id("fullName");
	public static By txt_MobilePrefix = By.id("mobilePrefix");
	public static By txt_MobileNumber = By.id("mobile");
	public static By txt_Email = By.id("email");
	public static By txt_Password = By.id("password");
	public static By btn_OpenAccountNow = By.id("register");
}
