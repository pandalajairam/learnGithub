package com.Inficon.scripts;

import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Inficon.libs.HomeLib;
import com.Inficon.libs.InficonLib;
import com.Inficon.page.HomePage;
import com.automation.utilities.TestUtil;

public class Login extends InficonLib {

	HomeLib objHomelib = new HomeLib();

	/*
	 * @DataProvider public Object[][]
	 * getTestDataFor_loginWithDiffferentCredentials () { return
	 * TestUtil.getData("loginWithDiffferentCredentials", TestData, "Home"); }
	 */

	// @Test(dataProvider = "getTestDataFor_loginWithDiffferentCredentials")
	@Test
	public void inficonDemoApp() throws Throwable {

		try {

			this.reporter.initTestCaseDescription("Sample login Test");
			System.out.println("**********Into the SampleTest**********");
			doLogin("demo", "Fusion");
			System.out.println("The title of the page is - " + Driver.getTitle());
			Thread.sleep(5000);
			if (isElementPresent(HomePage.tabRun, "Validating the presence of Run tab")) {
				System.out.println("The Run tab is available");
				reporter.SuccessReport("Verify the presence of Run tab", "Test to check the presence of Run tab");
			} else {
				reporter.failureReport("Verify the presence of Run tab", "Test to check the presence of Run tab");
			}
			if (isElementPresent(HomePage.tabChromatogram, "Validating the presence of Chromatogram tab")) {
				System.out.println("The Chromatogram tab is available");
				reporter.SuccessReport("Verify the presence of Chromatogram tab",
						"Test to check the presence of Chromatogram tab");
			} else {
				reporter.failureReport("Verify the presence of Chromatogram tab",
						"Test to check the presence of Chromatogram tab");
			}
			if (isElementPresent(HomePage.tabReport, "Validating the presence of Report tab")) {
				System.out.println("The report tab is available");
				reporter.SuccessReport("Verify the presence of report tab", "Test to check the presence of report tab");
			} else {
				reporter.failureReport("Verify the presence of report tab", "Test to check the presence of report tab");
			}
			if (isElementPresent(HomePage.btnAcum, "Validating the presence of Acum button")) {
				System.out.println("The Acum button is available");
				reporter.SuccessReport("Verify the presence of Acum button",
						"Test to check the presence of Acum button");
			} else {
				reporter.failureReport("Verify the presence of Acum button",
						"Test to check the presence of Acum button");
			}

			if (isElementPresent(HomePage.btnMarco, "Validating the presence of Macro button"))

			{
				System.out.println("The Macro button is available");
				reporter.SuccessReport("Verify the presence of Macro button",
						"Test to check the presence of Macro button");
			} else {
				reporter.failureReport("Verify the presence of Macro button",
						"Test to check the presence of Macro button");
			}

			// objHomelib.homePageControlsValidation();
		}

		catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}
