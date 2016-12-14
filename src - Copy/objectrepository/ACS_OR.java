package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class ACS_OR {

	public static By closeDialog=By.id("closeButtonFC");
	public static By signIn=By.cssSelector("a[href*='/signin']");
	public static By Registerlink =By.cssSelector("a[href*='/Register']");
	public static By Register_ACSaccountname = By.id("ctl00_RootBox_Email_txtEmailAddress");
	public static By New_Password = By.id("ctl00_RootBox_NewPassword_txtNewPassword");
	public static By Confirm_Password= By.id("ctl00_RootBox_NewPassword_txtNewPasswordConfirm");
	public static By security_question= By.id("ctl00_RootBox_Question_lbSecurityQuestions");
	public static By security_Answer= By.id("ctl00_RootBox_Question_txtAnswer");
	public static By First_Name= By.id("ctl00_RootBox_Address_txtFirstName");
	public static By Last_Name= By.id("ctl00_RootBox_Address_txtLastName");
	public static By Outside_US_Checkbox= By.id("ctl00_RootBox_Address_chkOutsideUS");
	public static By addressLine1=By.id("ctl00_RootBox_Address_txtStreet1");
	public static By city=By.id("ctl00_RootBox_Address_txtCity");
	public static By state= By.id("ctl00_RootBox_Address_lstState");
	public static By Register_Button= By.id("ctl00_RootBox_btnRegister");
	public static By zip=By.id("ctl00_RootBox_Address_txtZip");
	public static By createAccountBtn= By.id("ctl00_RootBox_btnRegister");
	public static By userName=By.xpath("//p[starts-with(text(),'Welcome,')]");
	public static By email= By.id("username");
	public static By password= By.id("password");
	public static By Signinbutton= By.xpath("//*[@id='acsAccountForm']//input[@class='signin-button']");
	public static By signOut=By.cssSelector("a[href*='/signout']");

}
