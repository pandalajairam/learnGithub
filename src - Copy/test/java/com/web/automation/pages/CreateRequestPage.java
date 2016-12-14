package com.web.automation.pages;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.utilities.CommonVariables;

public class CreateRequestPage extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public static By drpTransactionOwnerCountry = By.xpath("//select[@id='drpTransactionOwnerCountry']");
	public static By drpBusinessUnit = By.xpath("//select[@id='drpBusinessUnit']");
	public static By drpDepartment = By.xpath("//select[@id='drpDepartment']");
	public static By drpProductCountry = By.xpath("//select[@id='drpProductCountry']");
	public Generic objGeneric = new Generic(CommonVariables.CommonDriver.get());;

	public CreateRequestPage(WebDriver driver) {
		super(driver);
		if (!actionLib.GetPageTitle().contains("Prizma")) {
			throw new IllegalStateException("This is not the 'Prizma' login page.");
		}
		driver = CommonVariables.CommonDriver.get();
	}

	public void clickCreateRequestBtn() {
		try {

			System.out.println("In the click Create Request button method");
			// actionLib.WaitForElementVisible(By.xpath("//span[text()='Create
			// New Request']"), 20);
			Thread.sleep(10000);
			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(By.xpath("//span[text()='Create New Request']")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String createRequest(String actTypeName) throws Throwable {

		String activityID = null;
		try {
			Thread.sleep(5000);

			//actionLib.WaitForElementVisible(By.xpath("//h1[text()='Create a New Request']"), 20);

			if (!CommonVariables.CommonDriver.get()
					.findElement(By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']"))
					.isSelected()) {
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']")), 2);
			}
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("IsRequestOnBehalOfOriginatorYes")),
					1);

			// Orginator name
			actionLib.Click(
					CommonVariables.CommonDriver.get()
							.findElement(By
									.xpath("//div[@id='SearchOriginator_Name']//div[@class='selectize-input items not-full']")),
					1);
			actionLib.type(CommonVariables.CommonDriver.get()
					.findElement(By.cssSelector("select[class*='selectOriginator']+div  input")), "Sub");
			Thread.sleep(Long.parseLong("5000"));
			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(By.cssSelector("div#SearchOriginator_Name div.selectize-dropdown-content>div")), 1);

			actionLib.selectByVisibleText(drpTransactionOwnerCountry, "Argentina", "Transaction owner country");
			// Thread.sleep(Long.parseLong("2000"));
			actionLib.selectByVisibleText(drpBusinessUnit, "003105_008852_Janssen Vaccines & Prevention B.V.",
					"Business Unit");
			// Thread.sleep(Long.parseLong("2000"));
			actionLib.selectByVisibleText(drpDepartment, "002233_007101_Marketing", "Department");
			Thread.sleep(Long.parseLong("2000"));

			actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("AreCoownersAvailablepNo")), 1);
			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(By.xpath("//input[@id='CostCenter' and @name = 'CostUnitId']")), 1);
			actionLib.type(CommonVariables.CommonDriver.get()
					.findElement(By.xpath("//input[@id='CostCenter' and @name = 'CostCenter']")), "123");
			actionLib.selectByVisibleText(drpProductCountry, "France", "Country");
			// Thread.sleep(Long.parseLong("2000"));

			// Therapeutic information
			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(By.cssSelector("select#drpDiseaseState+div input")));
			// Thread.sleep(2000);
			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(By.cssSelector("select#drpDiseaseState+div div.selectize-dropdown-content>div")));
			// Thread.sleep(2000);

			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(By.xpath("//label[text()='Product / Compound:']/../..")), 1);

			// Product/Compound information
			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(By.cssSelector("select#drpProduct+div input")), 3);
			// Thread.sleep(2000);
			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(By.cssSelector("select#drpProduct+div div.selectize-dropdown-content>div")), 3);

			actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.xpath("//input[@name='saveAndNext']")),
					3);

			Thread.sleep(10000);
			actionLib.Click(
					CommonVariables.CommonDriver.get()
							.findElement(By
									.xpath("//section[@id='sp_BNAActivityOverview']/..//div//button[contains(text(),'Edit Section')]")),
					2);
			Thread.sleep(3000);
			// Getting the activity ID
			activityID = CommonVariables.CommonDriver.get()
					.findElement(By.xpath("// div[@id='BNAActivityOverview-ActivityDisplayId']")).getText();

			System.out.println("The activity ID is " + activityID + " and the activty Type is " + actTypeName);

			actionLib.ScrollToElementVisible(CommonVariables.CommonDriver.get()
					.findElement(By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']")));
			actionLib.Click(CommonVariables.CommonDriver.get()
					.findElement(By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']")), 3);

			System.out.println("******Completed Create New activity request tab*******");

		}

		catch (

		Exception e) {
			e.printStackTrace();
		}

		return activityID;

	}

}
