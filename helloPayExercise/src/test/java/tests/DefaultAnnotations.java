package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import variables.TCResult;
import variables.ConstantLib.TestGroup;
import variables.ConstantLib.Constants;

import org.w3c.dom.Element;

public class DefaultAnnotations {

	public TCResult Result;

	@BeforeMethod(groups = { TestGroup.Initialization })
	public void beforeMethod() throws MalformedURLException {

		System.setProperty("webdriver.ie.driver", Constants.Init_Folder + "/IEDriverServer.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		dc.setJavascriptEnabled(true);
		Constants.Driver = new InternetExplorerDriver(dc);
		Constants.Driver.manage().window().maximize();
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
		Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
		Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);

		Result = new TCResult();
	}

	@AfterMethod(groups = { TestGroup.Initialization })
	public void afterMethod() {
		Constants.Driver.close();
		Constants.Driver.quit();
	}

	@BeforeSuite(groups = { TestGroup.Initialization })
	public void beforeTest() {
		try {
			File inputFile = new File(Constants.Init_Folder + "/Init.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			NodeList nList = doc.getElementsByTagName("helloPay");
			Constants.Url = ((Element) nList.item(0)).getElementsByTagName("URL").item(0).getTextContent();
			Constants.Country = ((Element) nList.item(0)).getElementsByTagName("Country").item(0).getTextContent();
			Constants.Email = ((Element) nList.item(0)).getElementsByTagName("Email").item(0).getTextContent();
			Constants.Password = ((Element) nList.item(0)).getElementsByTagName("Password").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite(groups = { TestGroup.Initialization })
	public void afterTest() {

	}
}