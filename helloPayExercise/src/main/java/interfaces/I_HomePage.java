package interfaces;

import org.openqa.selenium.By;

public class I_HomePage {
	public static By btn_Register = By.xpath("//*[@class='mobileMenu']/..//a[.='Register']");
	public static By lbl_Username = By.xpath("//*[@id='verifyIcon']/..");
	public static By btn_Logout = By.xpath("//a[.='Logout']");
	public static By btn_Login = By.xpath("//*[@class='mobileMenu']/..//a[.='Login']");
	public static By drd_Country = By.xpath("//*[@id='countriesMenu']/..");
}
