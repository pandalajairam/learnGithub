package com.web.automation.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.utilities.CommonVariables;
import com.web.automation.objectrepository.FairMarketValue_OR;
import com.web.automation.objectrepository.GeneralActivity_OR;
import com.web.automation.objectrepository.NominationPage_OR;

public class GeneralActivityPage extends BasePage {

	public EventFiringWebDriver driver;
	public Generic objGeneric = new Generic(CommonVariables.CommonDriver.get());;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public GeneralActivityPage(WebDriver driver) {
		super(driver);
		if (!actionLib.GetPageTitle().contains("Prizma")) {
			throw new IllegalStateException("This is not the 'Prizma' login page.");
		}

	}

	@SuppressWarnings("unused")
	public void general(String actTypeName) throws Throwable {

		// Thread.sleep(3000);

		try {

			System.out.println("In the general method of the GeneralActivity page");
			Thread.sleep(5000);
			// actionLib.WaitForElementVisible(GeneralActivity_OR.activitytitletextbox,
			// 10);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.activitytitletextbox), 5);

			actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.activitytitletextbox),
					"HC Activity Title");

			actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.FromDate), 5);

			String startDate = actionLib.getCurrentDataTime("yyyy MMM d");
			objGeneric.selectDateFromDatePicker(startDate);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.toDate), 5);
			String toDate = actionLib.AddNoOfDaysInCurrentDate("yyyy MMM d", 4);
			objGeneric.selectDateFromDatePicker(toDate);

			actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.activitycity), "Paris");

			actionLib.selectByVisibleText(GeneralActivity_OR.drpActivityCategory, actTypeName, "Activity type");

			Thread.sleep(3000);

			actionLib.selectByIndex(GeneralActivity_OR.drpActivitySubCategory, 1, "Activity sub type");

			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.activityrelatedradiobutton));

			if (!(actTypeName.equalsIgnoreCase("Master Service Agreement"))) {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.NoAOP));

				Thread.sleep(10000);
				// commented sleep time and added wait time for element visible
				// actionLib.WaitForElementVisible(GeneralActivity_OR.BusinessNeed,
				// 10);
				System.out.println("The Business text field is " + CommonVariables.CommonDriver.get()
						.findElement(GeneralActivity_OR.BusinessNeed).isDisplayed());
				// actionLib.Click(
				// CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.BusinessNeed),2);
				Thread.sleep(2000);
				actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.BusinessNeed),
						"BusinessNeed");

				// actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.MainObjectives),
				// 2);
				Thread.sleep(2000);
				// actionLib.WaitForElementVisible(GeneralActivity_OR.MainObjectives,
				// 10);
				actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.MainObjectives),
						"To conduct quarterly meeting");

				// actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.CriteriaRationale),
				// 2);
				Thread.sleep(2000);
				// actionLib.WaitForElementVisible(GeneralActivity_OR.CriteriaRationale,
				// 10);

				actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.CriteriaRationale),
						"Minimum 3 years experience");

				// actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.ScopeofService),
				// 2);

				// actionLib.WaitForElementVisible(GeneralActivity_OR.ScopeofService,
				// 5);

				actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.ScopeofService),
						"Dental surgery");

				// actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.durationService),
				// 2);

				// actionLib.WaitForElementVisible(GeneralActivity_OR.durationService,
				// 5);
				actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.durationService),
						"Automation Duration");

				// actionLib.WaitForElementVisible(GeneralActivity_OR.advisorsORconsultants,
				// 5);
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.advisorsORconsultants));

				// actionLib.fluentWait(10, 5);

				// actionLib.WaitForElementVisible(GeneralActivity_OR.activityDescription,
				// 5);

				actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.activityDescription),
						"Test Activity Description");
				// actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.ActivityMaterial),
				// 2);
				// actionLib.fluentWait(10, 5);

				// actionLib.WaitForElementVisible(GeneralActivity_OR.ActivityMaterial,
				// 5);

				actionLib.javascriptSendKeys(
						CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.ActivityMaterial),
						"Test Description for Activity Material");

				// actionLib.actionMethod().sendKeys("Test Description for
				// Activity Material").build().perform();

				// actionLib.WaitForElementVisible(GeneralActivity_OR.mdeonV1,
				// 5);
				// actionLib.fluentWait(10, 5);

				actionLib.ScrollToElementVisible(
						CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.mdeonV1));

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.mdeonV1), 2);

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.externalApprovals),
						2);

				// actionLib.fluentWait(10, 5);
				// actionLib.WaitForElementVisible(GeneralActivity_OR.IsResearch,
				// 5);

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.IsResearch), 2);

				actionLib.ScrollToElementVisible(
						CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.researchDevelopment));

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.researchDevelopment),
						2);

			}

			actionLib.selectByVisibleText(GeneralActivity_OR.Curency, "USD - UNITED States dollar", "Currency");

			actionLib.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.RequestActualAmount), 2);
			actionLib.type(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.RequestActualAmount),
					"1100");

			actionLib
					.Click(CommonVariables.CommonDriver.get().findElement(GeneralActivity_OR.btnBNAGeneralsaveAndNext));

			System.out.println("******Completed General Activity tab*******");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
