package com.web.automation.pages;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.fileutils.ExcelReader;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.GeneralActivity_OR;
import com.web.automation.objectrepository.NominationPage_OR;
import com.web.automation.utilities.CommonVariables;

public class GoToHomePage extends BasePage {

	public GoToHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public EventFiringWebDriver driver;

	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public Generic objGeneric;

	public void goToHomePage() throws Throwable {

		System.out.println("******In the Go to home page method********");
	//	actionLib.WebdriverWaitForPage();
		actionLib.WaitForElementVisible(By.cssSelector("li[id='homeTab'] a"), 20);
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.cssSelector("li[id='homeTab'] a")), 1);

	}
	
	public void clickHome(){
		actionLib.WaitForElementVisible(By.cssSelector("li[id='homeTab'] a"), 20);
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.cssSelector("li[id='homeTab'] a")), 1);
		
		}

	public void clickCreateNewRequest(){
		
	}



}
