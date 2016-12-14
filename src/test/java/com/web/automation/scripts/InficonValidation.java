package com.web.automation.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.automation.logs.ExtentLogs;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.pages.ActivityCategoryPage;
import com.web.automation.pages.ActivityInformationPage;
import com.web.automation.pages.CreateRequestPage;
import com.web.automation.pages.FairMarketValuePage;
import com.web.automation.pages.GeneralActivityPage;
import com.web.automation.pages.Generic;
import com.web.automation.pages.GoToHomePage;
import com.web.automation.pages.LoginPage;
import com.web.automation.pages.NominationPage;
import com.web.automation.utilities.CommonVariables;

@Test
public class InficonValidation extends TestEngineWeb {

	private LoginPage loginPg = new LoginPage(CommonVariables.CommonDriver.get());
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extenLogs = new ExtentLogs();

	/**
	 * @author Jairam
	 * @param status
	 * @param reason
	 */
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}

	/**
	 * @author Jairam
	 * @throws Throwable
	 * @test case id: TCM-01
	 */
	@Test(description = "Sample GitHub and Jenkins Integration Test", groups = { "smoke", "regression" })
	public void sampleGitHubJenkinsTest() throws Throwable {
		System.out.println("**********Into the Test**********");

		try {

			loginPg.jenkins_login();

		} catch (Exception e) {
			testCaseFailureReason = "The sample test is failed";
			String stackTrace = extenLogs.getStackTraceAsString("Sample test validation", testCaseFailureReason, e);
			extenLogs.fail("Inficon:: Sample test validation", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}

		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	}
}
