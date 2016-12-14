package com.web.automation.objectrepository;

import org.openqa.selenium.By;

import com.google.api.client.util.DateTime;

public class GeneralActivity_OR {

	public static By activitytitletextbox = By.cssSelector("input[name='ActivityTitle']");

	public static By FromDate = By.cssSelector("div[class*='datepickerLeft']>img");
	public static By toDate = By.cssSelector("div[class*='datepickerRight']>img");

	// public static By toDate =
	// By.linkText(DateTime.class)(DateTime.AddDays(7).Day.ToString());

	public static By fromcalenderdate = By.xpath("//*[@id='ActivityStartDate']/../img");
	public static By fromcalendermonth = By.xpath("//select[@class='ui-datepicker-month']");
	public static By fromcalenderyear = By.xpath("//select[@class='ui-datepicker-year']");

	public static By sendcalenderdate = By.xpath("//*[@class='ui-datepicker-calendar']");
	public static By sendcalendermonth = By.xpath("//*[@class='ui-datepicker-month']");
	public static By sendcalenderyear = By.xpath("//*[@class='ui-datepicker-year']");

	// public static By activitycountrydropdown = By.id("drpActivityCountry");

	public static By activitycity = By.id("ActivityCity");

	public static By activityState = By.id("drpActivityState");
	public static By drpActivityCategory = By.xpath("//*[@id='drpActivityCategory']");
	public static By drpActivitySubCategory = By.xpath("//select[@id='drpActivitySubCategory']");
	public static By activityrelatedradiobutton = By.xpath("//*[@id='IsRequestOnSeriesofActivitiespNo']");

	public static By BusinessNeed = By.cssSelector("textarea#BusinessNeed");
	public static By MainObjectives = By.cssSelector("div[id='MainObjectives'] textarea");
	public static By CriteriaRationale = By.cssSelector("div[id='CriteriaRationale'] textarea");
	public static By ScopeofService = By.cssSelector("div[id='ScopeofService'] textarea");
	public static By ActivityMaterial = By.cssSelector("div[id='divGenActivityMaterial'] textarea");
	public static By advisorsORconsultants = By.id("IsRequestOninformationtoadequatelypNo");
	public static By drpShireContractingEntity = By.id("drpShireContractingEntity");
	public static By NoAOP = By.xpath("//span[text()='No Approved Plan Exists']/parent::*//input");
	public static By NoBusinessPlanExplain = By.name("NoBusinessPlanExplain");
	public static By Curency = By.xpath("//select[@id='drpCurency']");
	public static By RequestActualAmount = By.xpath("//input[@id='RequestActualAmount']");
	public static By btnBNAGeneralsaveAndNext = By.id("btnBNAGeneralsaveAndNext");

	public static By activityDescription = By.xpath("//div[@id='divGenActivityDescription']//textarea");
	public static By mdeonV1 = By.id("GenIsMdeonV1ApprovalNo");
	public static By externalApprovals = By.id("GenAnyExternalApprovalNo");
	public static By researchDevelopment = By.id("GenResearchDevelopmentRelatedNo");
	public static By IsResearch = By.xpath("//label[contains(text(),'Is this Research & Development related')]");
	
	//public static By researchDevelopment = By.xpath("//input[contains(@id,'GenResearchDevelopmentRelatedNo')]");
//	public static By researchDevelopment = By.cssSelector("input[id='IsRequestOninformationtoadequatelypNo']");
//	public static By researchDevelopment = By.cssSelector("input[id='GenResearchDevelopmentRelatedNo']");
	

	
	public static By referencePlanStored = By.id("txtAnnualPlanNameStoreSomeWhereElse");

	public static By cmeAccredited = By.id("WillEventCMEAccreditedNo");
	public static By mdeonV2 = By.id("IsMdeonv2ApprovalRequiredERANo");
	public static By saveAndNext = By.id("btnbusinessNeedActCategorySaveNext");
	public static By durationService = By.xpath("//div[@id='divGenDurationServiceProvider']//textarea");

}
