package com.Inficon.scripts;

import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Inficon.libs.InficonLib;
import com.automation.utilities.TestUtil;

public class Login extends InficonLib {

	/*
	 * @DataProvider public Object[][]
	 * getTestDataFor_loginWithDiffferentCredentials () { return
	 * TestUtil.getData("loginWithDiffferentCredentials", TestData, "Home"); }
	 */

	// @Test(dataProvider = "getTestDataFor_loginWithDiffferentCredentials")
	@Test
	public void loginToJenkins() throws Throwable {
		try {

			this.reporter.initTestCaseDescription("Sample login Test");
			System.out.println("**********Into the SampleTest**********");
			checkPageIsReadyUsingJavaScript();
			doLogin("demo", "Fusion");
			System.out.println("The title of the page is - " + Driver.getTitle());
			assertTrue(StringUtils.containsIgnoreCase(Driver.getTitle(), "Micro"),
					"Page title");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}
