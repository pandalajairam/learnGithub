package com.Inficon.libs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.Inficon.page.HomePage;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class HomeLib extends InficonLib {

	public int sleepTime_chrome = 3000;
	String Patient, Patient1;

	String patientInsurance_prayername1, patientInsurance_prayerid1;

	public void homePageControlsValidation() throws Throwable {
		try {
			Thread.sleep(10000);
			new HomePage().Home_Page();

			// boolean isRunTabAVailable = isElementPresent(HomePage.tabRun,
			// "Validating the presence of Run tab");
			boolean isRunTabAVailable = Driver.findElement(HomePage.txtRuname).isDisplayed();
			System.out.println("**************" + isRunTabAVailable + "**************");

			if (isRunTabAVailable) {
				System.out.println("The Run tab is available");
				reporter.SuccessReport("Verify the presence of Run tab", "Test to check the presence of Run tab");
			} else {
				reporter.failureReport("Verify the presence of Run tab", "Test to check the presence of Run tab");
			}
			isElementPresent(HomePage.tabChromatogram, "Validating the presence of Chromatogram tab");
			isElementPresent(HomePage.tabReport, "Validating the presence of Report tab");
			isElementPresent(HomePage.btnAcum, "Validating the presence of Acum button");
			isElementPresent(HomePage.btnMarco, "Validating the presence of Macro button");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
