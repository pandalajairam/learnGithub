package com.Inficon.libs;

import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Inficon.page.AdminPage;
import com.Inficon.page.HomePage;
import com.Inficon.page.LoginPage;
import com.Inficon.page.PatientPage;
import com.automation.accelerators.ActionEngine;
import com.automation.utilities.TestUtil;
import com.automation.utilities.Xls_Reader;

public class InficonLib extends ActionEngine {
	public int sleepTime_chrome = 3000;

	HomePage h = new HomePage();

	public Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir") + "/TestData/TestData.xlsx");

	public final int LOWWAITTIME = 2000;
	public final int WAITTIME = 50000;
	public final int LONGWAITTIME = 200000;
	public String gErrMsg = "";

	/**
	 * Launches the Mumms Web Application
	 * 
	 * @return
	 * @throws Throwable
	 */
	public boolean launchUrl() throws Throwable {
		gErrMsg = "";
		boolean flag = false;
		try {
			/*
			 * if (configProps.getProperty("platformType").equalsIgnoreCase(
			 * "Mobile")) {
			 * remoteWebDriverForAppium.get("https://login.salesforce.com/");
			 * flag = true; } if
			 * (configProps.getProperty("platformType").equalsIgnoreCase(
			 * "Web_Fullscreen")) {
			 * driver.get("https://login.salesforce.com/?locale=in"); flag =
			 * true; }
			 */
			Driver.get("https://login.salesforce.com/?locale=in");
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			gErrMsg = "Launch Failed";
			return false;
		}

	}

	public void checkPageIsReadyUsingJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public void doLogin(String appUserName, String appPassword) throws Throwable {

		Robot robot = new Robot();
		new HomePage().Home_Page();
		new LoginPage().Login_Page();
		System.out.println("username - " + appUserName);
		System.out.println("password - " + appPassword);
		Thread.sleep(10000);
		StringSelection username = new StringSelection("demo");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(7000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		StringSelection password = new StringSelection("Fusion");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(password, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		System.out.println("login completed ");
/*		if (isElementPresent(HomePage.tabRun, "Run tag")) {
			System.out.println("The run tab is available");
			reporter.SuccessReport("Verify the presence of Run tab", "Test to check the presence of Run tab");
		} else {
			System.out.println("Not available");
		}*/

	}

}
