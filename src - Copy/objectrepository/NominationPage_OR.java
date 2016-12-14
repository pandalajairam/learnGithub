package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class NominationPage_OR {

	public static By nomination_Name = By.cssSelector("input[id='spSearchValue']");
	public static By nomination_advanced_drpCountry = By.cssSelector("select[id='advanced_drpCountry']");
	public static By nomination_advanced_drpType = By.cssSelector("select[id='advanced_drpType']");
	public static By nomination_btnSearch = By.cssSelector("input[id='btnHCPMainSearch']");
	public static By nomination_nominees_section = By
			.xpath("//section[@class='bs-example bs-example-tabs NominationTabs active']//section[@id='myTabContent']");
	public static By nomination_nominees_section_button = By.cssSelector("button[id='btnNominate_Text']");

	public static By IsGovernmentOfficialUnderLocalLawYES = By.cssSelector("input[id='IsGovernmentOfficialUnderLocalLawYES']");
	public static By IsGovernmentOfficialUnderLocalLawNO = By.cssSelector("input[id='IsGovernmentOfficialUnderLocalLawNO']");

	public static By IsContractNegotiationOrPartYES = By.cssSelector("input[id='IsContractNegotiationOrPartYES']");
	public static By IsContractNegotiationOrPartNO = By.cssSelector("input[id='IsContractNegotiationOrPartNO']");

	public static By IsRequiredToPayAPersentageOfExpensesYES = By.cssSelector("input[id='IsRequiredToPayAPersentageOfExpensesYES']");
	public static By IsRequiredToPayAPersentageOfExpensesNO = By.cssSelector("input[id='IsRequiredToPayAPersentageOfExpensesNO']");

	public static By txtHCPEmailId = By.cssSelector("input[id='HCPEmailId']");

	public static By imgDatePicker = By.xpath("//input[@id='ServiceProviderCV_Document_EffectiveDate1']/..//img");
	
	
	public static By txtnominationScopeOfService = By.cssSelector("textarea[id='txtnominationScopeOfService']");
	

	public static By btnUpload = By.xpath("//div[@id='ServiceProviderCV']//input[@id='btnUpload']");
	public static By btnSaveNomineeDetails = By.cssSelector("input[id='SaveServiceProviders']");

	public static By btnSaveAndAdvanceToNextSection = By.cssSelector("input[id='btnSaveNominationAndMoveToNext']");
}
