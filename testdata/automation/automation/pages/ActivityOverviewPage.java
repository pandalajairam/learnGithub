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

public class ActivityOverviewPage extends BasePage {
	
	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	
	WebDriver localDriver = CommonVariables.CommonDriver.get();
	
	public static By createNewRequest = By.xpath("//span[text()='Create New Request']");
	public static By drpTransactionOwnerCountry = By.xpath("//select[@id='drpTransactionOwnerCountry']");
	public static By drpBusinessUnit = By.xpath("//select[@id='drpBusinessUnit']");
	public static By drpDepartment = By.xpath("//select[@id='drpDepartment']");
	public static By drpProductCountry = By.xpath("//select[@id='drpProductCountry']");
	
	public Generic objGeneric = new Generic(CommonVariables.CommonDriver.get());;

	public ActivityOverviewPage(WebDriver driver) {
		super(driver);
		if (!actionLib.GetPageTitle().contains("Prizma")) {
			throw new IllegalStateException("This is not the 'Prizma' login page.");
		
	     }
		
     }
	
	 
	
	public void clickCreateNewRequestBtn() {
		try {

			System.out.println("In the click Create Request button method");
			actionLib.Click(localDriver.findElement(By.xpath("createNewRequest")));
		    } catch (Exception e) {
			e.printStackTrace();
		   }
	}
	
	
	

}
