package variables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstantLib {

	public static class Constants {
		public static int TimeOut = 30;
		public static String Init_Folder = "Init";

		public static String Url;
		public static String Country;
		public static String Email;
		public static String Password;

		public static WebDriver Driver;
		public static WebDriverWait Wait;
	}

	public class TestGroup {
		public static final String Initialization = "Initialization";

		public class AppFunction {
			public static final String Account = "Account";
			public static final String Password = "Password";
		}

		public class Priority {
			public static final String Critical = "Critical";
			public static final String High = "High";
			public static final String Medium = "Medium";
			public static final String Low = "Low";
		}

		public class Owner {
			public static final String ThuVu = "Thu Vu";
		}

		public class TestSuite {
			public static final String SmokeTest = "Smoke Test";
			public static final String Regression = "Regression";
		}
	}
}
