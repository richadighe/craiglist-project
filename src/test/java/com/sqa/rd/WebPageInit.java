package com.sqa.rd;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class WebPageInit {
	private static String baseURL = "http://www.google.com";
	private static WebDriver driver;

	/**
	 * @return the baseURL
	 */
	public static String getBaseURL() {
		return baseURL;
	}

	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public static void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	public WebPageInit(String baseURL) {
		super();
		WebPageInit.baseURL = baseURL;
	}

	// @DataProvider
	// public Object[][] dp() {
	// return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" },
	// };
	// }

}
