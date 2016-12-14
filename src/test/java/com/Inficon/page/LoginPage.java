package com.Inficon.page;

import org.openqa.selenium.By;
import com.automation.accelerators.ActionEngine;

public class LoginPage extends ActionEngine {

	public static By userName;
	public static By password;
	public static By loginBtn;
	public static By logOut;

	public void Login_Page()

	{
		{

			userName = By.id("j_username");
			password = By.name("j_password");
			loginBtn = By.xpath("//button[text()='log in']");
			logOut = By.xpath("//b[text()='Jenkins_Inficon']");
		}
	}
}