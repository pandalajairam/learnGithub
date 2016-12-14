package com.web.automation.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Optional;
import com.web.automation.fileutils.ExcelReader;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.FairMarketValue_OR;
import com.web.automation.objectrepository.NominationPage_OR;
import com.web.automation.utilities.CommonVariables;

public class NominationPage extends BasePage {

	public EventFiringWebDriver driver;

	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("20"));

	private static List<Map<String, String>> listOfRecords = ExcelReader
			.readExcelDataAsMap(System.getProperty("user.dir") + "\\testdata\\Nominees_List.xlsx");
	public Generic objGeneric = new Generic(CommonVariables.CommonDriver.get());

	public NominationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public FairMarketValuePage nominationsPage() throws Throwable {

		FairMarketValuePage fairrMarketPg = null;

		System.out.println("******In the nominationPage method********");

		System.out.println("The size of the list before the for loop is " + listOfRecords.size());

		for (int i = 0; i < 1 && listOfRecords.size() > 0; i++) {

			Map<String, String> rowData = listOfRecords.get(0);
			// Delete this record from list . so that it will not be duplicated
			// for next activity
			listOfRecords.remove(0);
			String nominationName = rowData.get("Name");
			String email = rowData.get("Email");
			String country = rowData.get("Country");
			String type = rowData.get("Type");

			System.out.println("Nomination process started for the name: " + nominationName + ", e-mail: " + email
					+ ", Country: " + country + ", Type: " + type);

			actionLib.WaitForElementVisible(NominationPage_OR.nomination_Name, 20);

			actionLib.type(CommonVariables.CommonDriver.get().findElement(NominationPage_OR.nomination_Name),
					nominationName);
			actionLib.selectByVisibleText(NominationPage_OR.nomination_advanced_drpCountry, country,
					"Country dropdown");
			actionLib.selectByVisibleText(NominationPage_OR.nomination_advanced_drpType, type, "Type dropdown");
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(NominationPage_OR.nomination_btnSearch), 2);

			Thread.sleep(10000);

			// Added wait for IE Browser
			//actionLib.WaitForElementVisible(NominationPage_OR.nomination_nominees_section_button, 50);
			actionLib.ScrollToElementVisible(
					CommonVariables.CommonDriver.get().findElement(By.cssSelector("button[id='btnNominate_Text']")));
			actionLib.Click(actionLib.FindElement(By.cssSelector("button[id='btnNominate_Text']"), timeoutInSecond));

			//actionLib.WaitForElementVisible(NominationPage_OR.IsGovernmentOfficialUnderLocalLawYES, 3);
			actionLib.ScrollToElementVisible(CommonVariables.CommonDriver.get()
					.findElement(NominationPage_OR.IsGovernmentOfficialUnderLocalLawYES));
			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(NominationPage_OR.IsGovernmentOfficialUnderLocalLawYES), 10);

			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(NominationPage_OR.IsContractNegotiationOrPartYES),
					2);

			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(NominationPage_OR.IsRequiredToPayAPersentageOfExpensesNO), 2);

			actionLib.type(CommonVariables.CommonDriver.get().findElement(NominationPage_OR.txtHCPEmailId), email);

			if (country.equalsIgnoreCase("France")) {
				actionLib.type(CommonVariables.CommonDriver.get().findElement(By.cssSelector("[id='RPPSNumber']")),
						"12345");
			}

			String meetingFromDate = actionLib.AddNoOfDaysInCurrentDate("yyyy MMM d", 1);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(NominationPage_OR.imgDatePicker), 2);
			objGeneric.selectDateFromDatePicker(meetingFromDate);

			actionLib.type(
					CommonVariables.CommonDriver.get().findElement(NominationPage_OR.txtnominationScopeOfService),
					"Sample test text");
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(NominationPage_OR.btnSaveNomineeDetails), 5);
			Thread.sleep(8000);
			System.out.println("Nomination process completed for the name: " + nominationName + ", e-mail: " + email);

		}
		System.out.println("******Completed adding nominees for all the items in the excel********");

		//actionLib.waitForElementNotPresent(NominationPage_OR.btnSaveAndAdvanceToNextSection, 10);
		actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(NominationPage_OR.btnSaveAndAdvanceToNextSection), 20);

		System.out.println("******Completed the nomination page********");
		fairrMarketPg = new FairMarketValuePage(CommonVariables.CommonDriver.get());

		return fairrMarketPg;
	}

}
