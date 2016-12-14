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

public class PrizmaValidation extends TestEngineWeb {

	private LoginPage loginPg;
	private CreateRequestPage requestPg;
	private GeneralActivityPage objGeneralActPg;
	private ActivityCategoryPage activityCategoryPg;
	private GoToHomePage objGoToHomePage;
	private ActivityInformationPage objActivityInformationPage;
	private NominationPage objNavigationPage;
	private FairMarketValuePage objFairMarketValuePage;
	private Generic objGeneric;
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private String firstName = "";
	private ExtentLogs extenLogs = new ExtentLogs();

	/**
	 * @author ashish jain
	 * @param status
	 * @param reason
	 */
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}

	/**
	 * @author ashish jain
	 * @throws Throwable
	 * @test case id: TCM-01
	 */
	@Test(description = "Activity ID Generation", groups = { "smoke", "regression" })
	public void createActvityID_Save() throws Throwable {
		try {
			objGeneric = new Generic(CommonVariables.CommonDriver.get());
			loginPg = new LoginPage(CommonVariables.CommonDriver.get());
			objGeneralActPg = new GeneralActivityPage(CommonVariables.CommonDriver.get());
			activityCategoryPg = new ActivityCategoryPage(CommonVariables.CommonDriver.get());
			objActivityInformationPage = new ActivityInformationPage(CommonVariables.CommonDriver.get());
			objFairMarketValuePage = new FairMarketValuePage(CommonVariables.CommonDriver.get());
			objNavigationPage = new NominationPage(CommonVariables.CommonDriver.get());
			objGoToHomePage = new GoToHomePage(CommonVariables.CommonDriver.get());
			requestPg = loginPg.login();
			for (int actTypeNo = 7; actTypeNo <= 8; actTypeNo++) {
				String activityTypeName = objGeneric.returnActivityType(actTypeNo);
				if (actTypeNo != 5) {
					Thread.sleep(5000);
					requestPg.clickCreateRequestBtn();
					Thread.sleep(5000);
					String activityID = requestPg.createRequest(activityTypeName);
					Thread.sleep(5000);
					objGeneralActPg.general(activityTypeName);
					Thread.sleep(5000);
					activityCategoryPg.ActivityType(activityTypeName);
					Thread.sleep(5000);
					objActivityInformationPage.ActivityInfo(activityTypeName);
					Thread.sleep(5000);
					objNavigationPage.nominationsPage();
					Thread.sleep(5000);
					objFairMarketValuePage.FairMarketValue();
					Thread.sleep(5000);
					objGeneric.writeToCSV(activityTypeName, activityID);
					objGoToHomePage.goToHomePage();
					Thread.sleep(7000);
				} else {
					System.out.println("Not required to create an acitivity ID for Master Service Agreement ");
				}
			}
		} catch (Exception e) {
			testCaseFailureReason = "Failed to generate Activity ID's.";
			String stackTrace = extenLogs.getStackTraceAsString("Activity ID Generation", testCaseFailureReason, e);
			extenLogs.fail("Prizma:: Activity ID Generation", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}

		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	}
}