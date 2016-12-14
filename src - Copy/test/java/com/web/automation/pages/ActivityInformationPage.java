package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.ActivityInformation_OR;
import com.web.automation.objectrepository.GeneralActivity_OR;
import com.web.automation.utilities.CommonVariables;

public class ActivityInformationPage extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public Generic objGeneric = new Generic(CommonVariables.CommonDriver.get());

	public ActivityInformationPage(WebDriver driver) {
		super(driver);
		if (!actionLib.GetPageTitle().contains("Prizma")) {
			throw new IllegalStateException("This is not the 'Prizma' Activity Information page.");
		}

	}

	public void ActivityInfo(String actType) throws Throwable {

		System.out.println("**********In the ActivityInfo method********");

		// Thread.sleep(5000);

		actionLib.WaitForElementVisible(ActivityInformation_OR.btnAddVenue, 25);

		if (!(actType.equalsIgnoreCase("Master Service Agreement"))) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.btnAddVenue), 2);
				// Thread.sleep(3000);
				actionLib.WaitForElementVisible(ActivityInformation_OR.venueType, 25);
				System.out.println("Is The Add new venue page is displayed " + CommonVariables.CommonDriver.get()
						.findElement(ActivityInformation_OR.btnAddVenue).isDisplayed());
				actionLib.selectByVisibleText(ActivityInformation_OR.venueType, "Accommodation", "Venu Type");
				actionLib.type(CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.venueName),
						"Dental Club");
				actionLib.javascriptSendKeys(
						CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.address),
						"99900 Latouche St Suite 210, Anchorage, AK");
				actionLib.type(CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.meetingCity),
						"Copenhegan");
				actionLib.selectByVisibleText(ActivityInformation_OR.meetingCountry, "Denmark", "Meeting Country");
				actionLib.type(CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.zipCode), "12345");

				String meetingFromDate = actionLib.AddNoOfDaysInCurrentDate("yyyy MMM d", 1);
				String meetingEndDate = actionLib.AddNoOfDaysInCurrentDate("yyyy MMM d", 2);

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.meetingdatefromdateIMG),
						2);

				objGeneric.selectDateFromDatePicker(meetingFromDate);

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.meetingdateEnddateIMG),
						2);

				objGeneric.selectDateFromDatePicker(meetingEndDate);

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.addVenue), 2);

				// Thread.sleep(3000);

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityInformation_OR.saveAdvanceButton), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Activity information page will not be displayed for activity type " + actType);
		}

	}

}
