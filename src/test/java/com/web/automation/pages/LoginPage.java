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
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public LoginPage(WebDriver driver) {
		if (CommonVariables.getDriver() == null) {
			CommonVariables.setDriver(driver);
		}
		actionLib = CommonVariables.getActionLib();
		try {
			if (!ConfigManager.ArePropertiesSet.get()) {
				ConfigManager.setProperties();
				ConfigManager.UpdateProperties();
			}
		} catch (Exception e) {
			System.out.println("Failed to load Properties file");
		}
	}

	public void jenkins_login() throws Throwable {

		System.out.println("In the login method");
		String username = null;

		try {
			/*actionLib.type(CommonVariables.CommonDriver.get().findElement(By.id("j_username")), "inficon");
			actionLib.type(CommonVariables.CommonDriver.get().findElement(By.name("j_password")), "inficon");
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.xpath("//button[text()='log in']")));
			Thread.sleep(5000);
			username = CommonVariables.CommonDriver.get().findElement(By.xpath("b[text()='Jenkins_Inficon']"))
					.getText();*/
			
			CommonVariables.CommonDriver.get().findElement(By.id("j_username")).sendKeys("inficon");
			CommonVariables.CommonDriver.get().findElement(By.name("j_password")).sendKeys("inficon");
			CommonVariables.CommonDriver.get().findElement(By.xpath("//button[text()='log in']")).click();
			username = CommonVariables.CommonDriver.get().findElement(By.xpath("b[text()='Jenkins_Inficon']"))
					.getText();
			
			
			if (username.equalsIgnoreCase("Jenkins_Inficon")) {
				extentLogs.pass("Username validation", username);

			} else {
				extentLogs.fail("Username validation", username);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
