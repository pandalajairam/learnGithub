package com.web.automation.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.ActivityCategory_OR;
import com.web.automation.objectrepository.GeneralActivity_OR;
import com.web.automation.utilities.CommonVariables;

public class Generic extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public Generic(WebDriver driver) {
		super(driver);
		if (!actionLib.GetPageTitle().contains("Prizma")) {
			throw new IllegalStateException("This is not the 'Prizma' login page.");
		}

	}

	public String returnActivityType(int actType) throws Throwable {
		String activityType = null;
		try {

			System.out.println("In the returnActivityType method of the Generic page");

			switch (actType) {

			case 1:
				activityType = "Advisory Boards and Committees";
				break;
			case 2:
				activityType = "Company Sponsored Research (Non-IIS)";
				break;
			case 3:
				activityType = "Contractual Arrangements";
				break;
			case 4:
				activityType = "Educational Related Activities";
				break;
			case 5:
				activityType = "Master Service Agreement";
				break;
			case 6:
				activityType = "Professional Advertising & Promotion";
				break;
			case 7:
				activityType = "Promotional Events/Activities";
				break;
			case 8:
				activityType = "Royalties";
				break;
			case 9:
				activityType = "Sponsorship of Attendance";
				break;
			case 10:
				activityType = "Training Related Activities";
				break;

			case 11:
				System.out.println("Invalid activity type");
				activityType = "Invalid activity type";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return activityType;
	}

	public void selectDateFromDatePicker(String formattedDate) {

		String tokens[] = formattedDate.split(" ");

		String yearOfDate = tokens[0].trim();
		String monthOfDate = tokens[1].trim();
		String dayOfDate = tokens[2].trim();

		// Selects Year
		actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(By.xpath("//select[@class='ui-datepicker-year']")), 0);
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[text()='" + yearOfDate + "']")), 0);

		// Selects Month
		actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(By.xpath("//select[@class='ui-datepicker-month']")), 0);
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(
				By.xpath("//select[@class='ui-datepicker-month']/option[text()='" + monthOfDate + "']")), 0);

		// Selects Date
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='" + dayOfDate + "']")), 0);
	}

	public void writeToCSV(String activityType, String activityID) throws Throwable {
		System.out.println("In the write to CSV method");
		try {

			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\testdata\\ActivityId.csv", true);
			PrintWriter out = new PrintWriter(fw);
			out.print(activityID);
			out.print(",");
			out.println(activityType);
			out.flush();
			out.close();
			System.out.println("compelted writing the values to csv");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
