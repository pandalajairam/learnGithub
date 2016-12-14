package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.*;
import com.web.automation.utilities.CommonVariables;
import com.web.automation.utilities.ConfigManager;

public class LoginPage extends LoginPage_OR {

	public EventFiringWebDriver driver;
	public ActionsLibrary actionLib;
	public ExtentLogs extentLogs=new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	
	public LoginPage (WebDriver driver)
	{
		if(CommonVariables.getDriver()==null){
			CommonVariables.setDriver(driver);
		}
		actionLib = CommonVariables.getActionLib();
		try {
			if(!ConfigManager.ArePropertiesSet.get()){
				ConfigManager.setProperties();
				ConfigManager.UpdateProperties();
			}
		} 
		catch (Exception e) {
			System.out.println("Failed to load Properties file");
		}
	}
	
	public CreateRequestPage login() throws Throwable{
		
		
		try{
		actionLib.type(CommonVariables.CommonDriver.get().findElement(By.id("UserName")), "Submitter2");
		actionLib.type(CommonVariables.CommonDriver.get().findElement(By.id("Password")), "123");
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("LoginButton")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return new CreateRequestPage(CommonVariables.CommonDriver.get());
	}

}
