package com.web.automation.pages;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.utilities.CommonVariables;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public EventFiringWebDriver driver;

	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public Generic objGeneric;

/*	public void goToHomePage() throws Throwable {

		System.out.println("******In the Go to home page method********");
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.cssSelector("li[id='homeTab'] a")), 1);

	}*/ // TODO: Delete: KLC

	public void clickHome(){
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.cssSelector("li[id='homeTab'] a")), 1);
	}

	public void clickCreatNewRequest(){
		actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(By.xpath("//span[text()='Create New Request']")));
	}

	public void writeToCSV(String activityTypeName, String activityID) throws Throwable {
		System.out.println("In the write to CSV method");
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\testdata\\ActivityId.csv", true);
			PrintWriter out = new PrintWriter(fw);
			out.print(activityID);
			out.print(",");
			out.println(activityTypeName);
			out.flush();
			out.close();
			System.out.println("compelted writing the values to csv");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
