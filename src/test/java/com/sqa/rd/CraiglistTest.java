/**
 *   File Name: CraiglistTest.java<br>
 *
 *   Dighe, Richa<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Richa Dighe<br>
 *   Created: Jun 22, 2016
 *   
 */

package com.sqa.rd;

import org.openqa.selenium.*;
import org.testng.annotations.*;

/**
 * CraiglistTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 * 
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 *
 */
public class CraiglistTest extends WebPageInit {
	@SuppressWarnings("javadoc")
	@DataProvider
	public static Object[][] getData() {
		return new Object[][] { { "Java automation" }, { "QA Automation" }, { "Java developer" }, { "Selenium" } };
	}

	/**
	 * @param baseURL
	 */
	public CraiglistTest(String baseURL) {
		super("http://sfbay.craigslist.org/");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("javadoc")
	@Test(dataProvider = "getData")
	public void craiglistTest(String keywords) throws InterruptedException {
		System.out.println("Perform Crailist Test");
		WebElement searchField = getDriver().findElement(By.cssSelector("input#query"));
		searchField.clear();
		searchField.sendKeys(keywords + " in jobs");
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	}
}
