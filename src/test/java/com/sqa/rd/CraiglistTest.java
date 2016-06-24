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
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.rd.helpers.*;

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
		return new Object[][] { { "Java automation", 5, 50 }, { "QA Automation", 5, 50 }, { "Java developer", 5, 50 },
				{ "Selenium", 5, 50 } };
	}

	/**
	 * @param baseURL
	 */
	public CraiglistTest(String baseURL) {
		super("http://sfbay.craigslist.org/");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("javadoc")
	@Test(dataProvider = "getExcelData")
	// (dataProvider = "getData")
	public void craiglistTest(String keywords, int minExpectedResults, int maxExpectedResults)
			throws InterruptedException {
		System.out.println("Perform Crailist Test");
		// WebElement searchField =
		// getDriver().findElement(By.cssSelector("input#query"));
		WebElement searchField = getDriver().findElement(By.id("query"));
		searchField.clear();
		searchField.sendKeys(keywords + " in jobs");
		searchField.sendKeys(Keys.ENTER);
		// Thread.sleep(10000);
		// select the option from dropbox to jobs and set the value to "JOBS"
		WebElement selectdropbox = getDriver().findElement(By.id("catAbb"));
		Select selectCat = new Select(selectdropbox);
		selectCat.selectByVisibleText("jobs");
		// find the total number of results found
		String totalcount = getDriver().findElement(By.cssSelector("span.button.pagenum")).getText();
		// System.out.println(keywords + "=" + totalcount);
		int totalResults = 0;
		if (totalcount.equalsIgnoreCase("no results")) {
			// System.out.println("There are no results available for " +
			// keywords);
		} else if (totalcount.split("of").length > 1) {
			totalResults = Integer.parseInt(totalcount.split("of")[1].trim());
			// System.out.println("Total Results:" + totalResults);
		} else {
			totalResults = Integer.parseInt(totalcount.split("to")[1].trim());
			// System.out.println("Total Results:" + totalResults);
		}

		// capture the screenshots of the test
		// captureScreenshot(keywords);

		Assert.assertTrue(totalResults >= minExpectedResults && totalResults <= maxExpectedResults,
				"Number of results(" + totalResults + ") is not within the range of expected (" + minExpectedResults
						+ " - " + maxExpectedResults + ")");
		Thread.sleep(10000);
	}

	@DataProvider
	public Object[][] getExcelData() {
		System.out.println("test");
		Object[][] data = DataHelper.getExcelFileData("src/main/resources/", "craiglisttest1.xlsx", true);
		// DisplayHelper.multArray(data);
		System.out.println("Reading excel data");
		return data;
	}
}
