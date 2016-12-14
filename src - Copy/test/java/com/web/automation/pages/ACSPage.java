package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.ACS_OR;
import com.web.automation.utilities.CommonVariables;

public class ACSPage extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs=new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public ACSPage (WebDriver driver)
	{
		super(driver);
		if(!actionLib.GetPageTitle().contains("American") || !(actionLib.GetURl().contains("cancer"))){
			throw new IllegalStateException("This is not the 'American Cancer Society' page.");
		}
	}

	/**
	 * @author ashish jain
	 * @description:
	 * @param value
	 * @return
	 * @throws Throwable 
	 */
	public void registration(String email, String password, String secAnswer, String fName, String lName, String address, String city, String state, String zip) throws Throwable{
		try{
			if(!actionLib.GetURl().contains("//m.cancer")){
				Thread.sleep(Long.parseLong("3000"));}
			if(actionLib.IsElementDisplayInCurrentView(ACS_OR.closeDialog)){
				actionLib.Click(actionLib.FindElement(ACS_OR.closeDialog, timeoutInSecond), 1);
				extentLogs.pass("Overlay Dialog","'Overlay Dialog' closed successfully.");
			}

			if(actionLib.GetURl().contains("//m.cancer")){
				if(actionLib.IsElementVisible(ACS_OR.signIn)){
					actionLib.Click(actionLib.FindElement(ACS_OR.signIn, timeoutInSecond), 2);
					extentLogs.pass("Signin","'Signin' button clicked successfully.");
				}
			}

			if(!actionLib.GetURl().contains("//m.cancer")){
				actionLib.Click(actionLib.FindElement(ACS_OR.Registerlink, timeoutInSecond), 10);
			}else{
				actionLib.Click(actionLib.FindElement(ACS_OR.Registerlink, timeoutInSecond), 4);
			}
			extentLogs.pass("Register","'Register' link clicked successfully.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.Register_ACSaccountname), email);
			extentLogs.pass("User Name","User successfully entered user name : ******* "+email+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.New_Password), password);
			extentLogs.pass("New Password","User successfully entered password : ******* "+password+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.Confirm_Password), password);
			extentLogs.pass("Confirm Password","User successfully entered confirm password : ******* "+password+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.security_Answer), secAnswer);
			extentLogs.pass("Security Answer","User successfully entered security answer : ******* "+secAnswer+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.First_Name), fName);
			extentLogs.pass("First Name","User successfully entered first name : ******* "+fName+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.Last_Name), lName);
			extentLogs.pass("Last Name","User successfully entered last name : ******* "+lName+" ******* in registration page.");

			/*actionLib.Click(actionLib.FindElement(ACS_OR.Outside_US_Checkbox, timeoutInSecond), 0);
			extentLogs.pass("Outside US Checkbox","'Outside US Checkbox' link clicked successfully.");*/

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.addressLine1), address);
			extentLogs.pass("Address","User successfully entered address : ******* "+address+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.city), city);
			extentLogs.pass("City","User successfully entered city : ******* "+city+" ******* in registration page.");

			actionLib.SelectFromDropDown(CommonVariables.CommonDriver.get().findElement(ACS_OR.state), state, 1);
			extentLogs.pass("State","User successfully selected state : ******* "+state+" ******* in registration page.");

			actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.zip), zip);
			extentLogs.pass("City","User successfully entered zip code : ******* "+zip+" ******* in registration page.");

			actionLib.Click(actionLib.FindElement(ACS_OR.createAccountBtn, timeoutInSecond), 20);
			extentLogs.pass("Create Account","'Create Account' button clicked successfully.");

			if(!actionLib.GetURl().contains("//m.cancer")){
				if(actionLib.GetURl().contains("/login/")){
					while(actionLib.IsElementDisplayInCurrentView(ACS_OR.Signinbutton)){					
						actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.email), email);
						extentLogs.pass("User Name","User successfully entered email address : ******* "+email+" ******* in login page.");
						actionLib.type(CommonVariables.CommonDriver.get().findElement(ACS_OR.password), password);
						extentLogs.pass("Password","User successfully entered password : ******* "+password+" ******* in login page.");
						actionLib.Click(actionLib.FindElement(ACS_OR.Signinbutton, timeoutInSecond), 15);
						extentLogs.pass("Sign In","'Sign In' button clicked successfully in login page.");
					}
				}
			}
		}
		catch(Exception ex){
			throw ex;
		}
	}
}