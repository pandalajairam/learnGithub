package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class ActivityInformation_OR {

	public static By btnAddVenue = By.id("btnAddVenue");
	public static By txtAddNewVenue = By.xpath("//span[text()='Add New Venue']");
	public static By venueType = By
			.xpath("//span[text()='Add New Venue']/../..//div[@id='venueDialog']//select[@id='drpActivityTypes']");
	public static By venueName = By
			.xpath("//span[text()='Add New Venue']/../..//div[@id='venueDialog']//input[@id='ActivityName']");
	public static By address = By.xpath(
			"//span[text()='Add New Venue']/../..//div[@id='venueDialog']//input[@id='MeetingAddress_MeetingAddress']");
	public static By meetingCity = By
			.xpath("//span[text()='Add New Venue']/../..//div[@id='venueDialog']//input[@id='MeetingAddress_City']");
	public static By meetingCountry = By
			.xpath("//span[text()='Add New Venue']/../..//div[@id='venueDialog']//select[@id='venue_drpCountry']");
	public static By zipCode = By.id("MeetingZipCode");
	public static By meetingdatefromdateIMG = By.xpath(
			"//span[text()='Add New Venue']/../..//div[@id='venueDialog']//div[@class='form-item datepickerLeft40PerWidth']//img");
	public static By meetingdateEnddateIMG = By.xpath(
			"//span[text()='Add New Venue']/../..//div[@id='venueDialog']//div[@class='form-item datepickerRight40PerWidth']//img");
	public static By addVenue = By
			.xpath("//span[text()='Add New Venue']/../..//div[@id='venueDialog']//input[@id='submitBtnAddVenue']");
	public static By saveAdvanceButton = By.id("btnSubmitActivityInfo");
	//
	//

}
