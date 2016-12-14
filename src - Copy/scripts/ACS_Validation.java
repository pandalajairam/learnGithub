package com.web.automation.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.web.automation.accelerators.ActionsLibrary.Mode;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.ACS_OR;
import com.google.common.base.Optional;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.pages.ACSPage;
import com.web.automation.utilities.CommonVariables;
import com.web.automation.utilities.ConfigManager;

public class ACS_Validation extends TestEngineWeb{

	private ACSPage acsPg;
	private String testCaseFailureReason="";
	private boolean testCaseStatus = true;
	private String firstName="";
	private ExtentLogs extenLogs=new ExtentLogs();

	/**
	 * @author ashish jain
	 * @param status
	 * @param reason
	 */
	public void TestCaseStatus(Boolean status, String reason)
	{
		if(status== false)
		{
			Assert.fail("Test Case Failed because - "+reason);
		}
	}

	/**
	 * @author ashish jain
	 * @throws Throwable 
	 * @test case id: TCM-01
	 */
	@SuppressWarnings("static-access")
	@Test(description="ACS Registration For Desktop Web Scenario",groups = {"smoke","regression"})
	public void ACS_AccountRegistration_Web_Passed() throws Throwable{
		try{
			String email=objCommonFunc.generateRandomString(3, Mode.ALPHA)+"."+objCommonFunc.generateRandomString(2, Mode.ALPHANUMERIC)+"@gmail.com";
			String password="AT"+objCommonFunc.generateRandomString(7, Mode.NUMERIC);
			String answer=objCommonFunc.generateRandomString(6, Mode.ALPHA);
			String firstName=objCommonFunc.generateRandomString(6, Mode.ALPHA);
			String lName=objCommonFunc.generateRandomString(4, Mode.ALPHA);
			String address=objCommonFunc.generateRandomString(10, Mode.ALPHANUMERIC);
			acsPg=new ACSPage(CommonVariables.CommonDriver.get());
			acsPg.registration(email,password,answer,firstName,lName,address,"New York","NY","10003");
			if(!objCommonFunc.getElementText(ACS_OR.userName, "Logged In User").contains(firstName)){
				testCaseFailureReason = "Failed to create ACS Account.";
				extenLogs.fail("ACS Registration:: TCM01", testCaseFailureReason);
				testCaseStatus=false;
			}
			else{
				extenLogs.pass("ACS Registration:: TCM01", "Successfully created ACS Account.");
			}
		}
		catch(Exception e)
		{
			testCaseFailureReason = "Failed to create ACS Account.";
			String stackTrace=extenLogs.getStackTraceAsString("Test01",testCaseFailureReason,e);
			extenLogs.fail("ACS Registration:: TCM01", testCaseFailureReason+"Failed Reason : "+stackTrace);
			testCaseStatus=false;
		}
		finally{
			if(objCommonFunc.IsElementVisible(ACS_OR.signOut)){
				objCommonFunc.Click(objCommonFunc.FindElement(ACS_OR.signOut, Optional.of(Long.parseLong("2"))), 20);
				extenLogs.pass("Sign Out","'Sign Out' button clicked successfully in home page.");
			}
		}
		TestCaseStatus(testCaseStatus,testCaseFailureReason);
	}

	/**
	 * @author ashish jain
	 * @throws Throwable 
	 * @test case id: TCM-02
	 */
	@Test(dependsOnMethods = { "ACS_AccountRegistration_Web_Passed" }, description="ACS Registration For Failed Scenario",groups = {"smoke","regression"})
	public void ACS_AccountRegistration_Web_Failed() throws Throwable{
		try{
			objCommonFunc.OpenApplication(ConfigManager.getProperties().getProperty("url"));
			if(objCommonFunc.getElementText(ACS_OR.userName, "Logged In User").contains(firstName)){
				testCaseFailureReason = "Failed to create ACS Account.";
				extenLogs.fail("ACS Registration:: TCM02", testCaseFailureReason);
				testCaseStatus=false;
			}
		}
		catch(Exception e)
		{
			testCaseFailureReason = "Failed to create ACS Account.";
			String stackTrace=extenLogs.getStackTraceAsString(e);
			extenLogs.error("ACS Registration:: TCM02", testCaseFailureReason+"Failed Reason : "+stackTrace);
			testCaseStatus=false;
		}
		TestCaseStatus(testCaseStatus,testCaseFailureReason);
	}

	/**
	 * @author ashish jain
	 * @throws Throwable 
	 * @test case id: TCM-03
	 */
	@SuppressWarnings("static-access")
	@Test(description="ACS Registration For Mobile Web Scenario",groups = {"mobile"})
	public void ACS_AccountRegistration_mobile() throws Throwable{
		try{
			objCommonFunc.OpenApplication(ConfigManager.getProperties().getProperty("url"));
			String email=objCommonFunc.generateRandomString(3, Mode.ALPHA)+"."+objCommonFunc.generateRandomString(2, Mode.ALPHANUMERIC)+"@gmail.com";
			String password="AT"+objCommonFunc.generateRandomString(7, Mode.NUMERIC);
			String answer=objCommonFunc.generateRandomString(6, Mode.ALPHA);
			String firstName=objCommonFunc.generateRandomString(6, Mode.ALPHA);
			String lName=objCommonFunc.generateRandomString(4, Mode.ALPHA);
			String address=objCommonFunc.generateRandomString(10, Mode.ALPHANUMERIC);
			acsPg=new ACSPage(CommonVariables.CommonDriver.get());
			acsPg.registration(email,password,answer,firstName,lName,address,"New York","NY","10003");
			if(!objCommonFunc.GetURl().equalsIgnoreCase("http://m.cancer.org/")){
				testCaseFailureReason = "Failed to create ACS Account in mobile browser.";
				extenLogs.fail("ACS Registration:: TCM03", testCaseFailureReason);
				testCaseStatus=false;
			}
			else{
				extenLogs.pass("ACS Registration:: TCM03", "Successfully created ACS Account in mobile browser.");
			}
		}
		catch(Exception e)
		{
			testCaseFailureReason = "Failed to create ACS Account in mobile browser.";
			String stackTrace=extenLogs.getStackTraceAsString("Test03",testCaseFailureReason,e);
			extenLogs.fail("ACS Registration:: TCM03", testCaseFailureReason+"Failed Reason : "+stackTrace);
			testCaseStatus=false;
		}
		TestCaseStatus(testCaseStatus,testCaseFailureReason);
	}
}