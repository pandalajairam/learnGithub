package com.web.automation.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.web.automation.accelerators.ActionsLibrary;

public class LoginPage_OR extends ActionsLibrary {

	public static By user_name = By.id("UserName");
	public static By user_password = By.id("Password");
	public static By login_button = By.id("LoginButton");
	public static By Logout = By.linkText("Logout");

}
