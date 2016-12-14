package com.web.automation.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.ActivityCategory_OR;
import com.web.automation.objectrepository.GeneralActivity_OR;
import com.web.automation.pages.Generic;
import com.web.automation.utilities.CommonVariables;

public class ActivityCategoryPage extends BasePage {

	public EventFiringWebDriver driver;
	public Generic objGeneric;

	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public ActivityCategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ActivityType(String actType) throws Throwable {
		Robot robot = new Robot();
		objGeneric = new Generic(CommonVariables.CommonDriver.get());
		Thread.sleep(1000);

		try {

			switch (actType) {

			case "Advisory Boards and Committees":
				System.out.println("******In the Advisory Boards and Committees activity type*******");
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.radioButtonNo), 2);
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.browseButton), 2);
			      
				//	actionLib.declineAlert();
				String filePath = System.getProperty("user.dir") + "\\testdata\\TestFile.txt";

				System.out.println("The file path is " + filePath);
				StringSelection ss = new StringSelection(filePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				 Thread.sleep(2000);

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.uploadButton), 2);
				//actionLib.WaitForElementVisible(ActivityCategory_OR.saveAndAdvanceToNextButton, 10);
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						10);

				System.out.println("******Completed Advisory Boards and Committees activity type*******");
				break;

			case "Company Sponsored Research (Non-IIS)":
				System.out.println("******In the Company Sponsored Research (Non-IIS) activity type*******");
				System.out.println("******There is nothing to fill the fields for this Actiity type*******");
				break;

			case "Contractual Arrangements":
				System.out.println("******In the Contractual Arrangements activity type*******");
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.IsMdeonv2ApprovalRequiredCANo), 1);
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						1);
				System.out.println("******Completed Contractual Arrangements activity type*******");
				break;
			case "Educational Related Activities":
				System.out.println("******In the Educational Related Activities activity type*******");
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.WillEventCMEAccreditedNo),
						1);

				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.IsMdeonv2ApprovalRequiredERANo), 1);
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						1);
				System.out.println("******Completed Educational Related Activities activity type*******");
				break;

			case "Master Service Agreement":
				System.out.println("******In the Master Service Agreement activity type*******");
				actionLib.type(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.txtActCatBusinessJustification), "Text area - Sample");
				actionLib.type(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.txtActCatTypeServiceProvider), "Text area - Sample");
				actionLib.type(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.txtActCatExpectedEvidenceOfService), "Text area - Sample");
				actionLib.type(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.txtActCatQualificationSkills), "Text area - Sample");

				actionLib.selectByVisibleText(GeneralActivity_OR.Curency, "USD - UNITED States dollar", "Currency");
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						1);
				System.out.println("******Completed Master Service Agreement activity type*******");
				break;

			case "Professional Advertising & Promotion":
				System.out.println("******In the Professional Advertising & Promotion activity type*******");

				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.IsMdeonv2ApprovalRequiredPAPNo), 1);

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						1);
				System.out.println("******Completed Professional Advertising & Promotion activity type*******");
				break;

			case "Promotional Events/Activities":
				System.out.println("******In the Promotional Events/Activities activity type*******");

				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(ActivityCategory_OR.IsMdeonv2ApprovalRequiredPEANo), 1);

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						1);
				System.out.println("******Completed Promotional Events/Activities activity type*******");
				break;

			case "Royalties":
				System.out.println("******In the Royalties activity type*******");
				System.out.println("******There is nothing to fill the fields for this Actiity type*******");
				break;

			case "Sponsorship of Attendance":
				System.out.println("******In the Sponsorship of Attendance activity type*******");

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.IsEUCOMEDApprovalRequiredNo),
						1);

				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(ActivityCategory_OR.saveAndAdvanceToNextButton),
						1);
				System.out.println("******Completed Sponsorship of Attendance activity type*******");
				break;
			case "Training Related Activities":
				System.out.println("******In the Training Related Activities activity type*******");
				System.out.println("******There is nothing to fill the fields for this Actiity type*******");
				break;

			case "Invalid activity type":
				System.out.println("Invalid activity type");
				break;

			default:
				System.out.println("Invalid activity type");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
