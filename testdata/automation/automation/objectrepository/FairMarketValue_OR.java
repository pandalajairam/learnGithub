package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class FairMarketValue_OR {

	public static By currency = By.cssSelector("select[id='drpCurencyFMV']");
	public static By serviceProvider = By.cssSelector("input[id='IsCRPerformingActivityYes']");
	public static By attendee = By.cssSelector("input[id='IsCRPerformingActivityNo']");
	public static By proposedRole = By.cssSelector("select[id='drpProposedRoleId']");
	public static By hcpStature = By.cssSelector("Select[id='drpselectedKOLId']");
	public static By hcpStature_css = By.cssSelector("Select[id='drpselectedKOLId']");
	public static By serviceCheckBox = By.xpath("//input[contains(@id,'ckselect') and @type='checkbox']");
	public static By noOfHours = By.xpath("//input[contains(@id,'txthours')]");
	public static By serviceHours = By.xpath("//input[contains(@id,'serviceHours')]/parent::td");
	public static By fmvMidRate = By.xpath("//input[contains(@id,'fmvMidRate')]");
	public static By rate = By.xpath("//input[contains(@id,'fmvRate')]");
	public static By roundTripTravel = By.cssSelector("input[id='RoundTravelNo']");
	public static By preparationTime = By.cssSelector("input[id='PreparationHour']");
	public static By travelTimeOption = By.cssSelector("select#ddlTravelTimeOption");
	public static By totalAdditionalFees = By.cssSelector("input#dspTotalAdditionalFees");
	public static By btnSaveAndNextSec = By.cssSelector("input#btnSaveAndNExt");

}
