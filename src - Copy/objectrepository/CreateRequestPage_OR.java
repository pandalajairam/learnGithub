package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class CreateRequestPage_OR {

	public static By drpTransactionOwnerCountry = By.xpath("//select[@id='drpTransactionOwnerCountry']");
	public static By drpBusinessUnit = By.xpath("//select[@id='drpBusinessUnit']");
	public static By drpDepartment = By.xpath("//select[@id='drpDepartment']");
	public static By drpProductCountry = By.xpath("//select[@id='drpProductCountry']");
	public static By btnCreateNewRequest = By.xpath("//span[text()='Create New Request']");
	public static By chkActivityOverview = By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']");
	public static By IsRequestOnBehalOfOriginatorYes = By.id("IsRequestOnBehalOfOriginatorYes");
	public static By txtSearchOrginator = By
			.xpath("//div[@id='SearchOriginator_Name']//div[@class='selectize-input items not-full']");
	public static By txtSearchOrginatorCss = By.cssSelector("select[class*='selectOriginator']+div  input");
	public static By lstItemsOrginators = By
			.cssSelector("div#SearchOriginator_Name div.selectize-dropdown-content>div");
	public static By rbtnCoOwnersNo = By.id("AreCoownersAvailablepNo");
	public static By rbtnCostUnit = By.xpath("//input[@id='CostCenter' and @name = 'CostUnitId']");
	public static By txtCostCentre = By.xpath("//input[@id='CostCenter' and @name = 'CostCenter']");
	public static By txtTherapatic = By.cssSelector("select#drpDiseaseState+div input");
	public static By lstTherapaticItems = By
			.cssSelector("select#drpDiseaseState+div div.selectize-dropdown-content>div");
	public static By lblProductName = By.xpath("//label[text()='Product / Compound:']/../..");
	public static By txtProductName = By.cssSelector("select#drpProduct+div input");
	public static By lstProductNameItems = By.cssSelector("select#drpProduct+div div.selectize-dropdown-content>div");
	public static By btnSaveAndNextCreateRequestPage = By.xpath("//input[@name='saveAndNext']");
	public static By btnEditSectionCreateRequestPage = By
			.xpath("//section[@id='sp_BNAActivityOverview']/..//div//button[contains(text(),'Edit Section')]");
	public static By txtActivityID = By.xpath("// div[@id='BNAActivityOverview-ActivityDisplayId']");
	public static By btnBusinessNeedActivityOverviewSaveAndNext = By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']");

}
