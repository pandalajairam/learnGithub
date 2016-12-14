package com.web.automation.pages;

import java.awt.event.KeyEvent;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.FairMarketValue_OR;
import com.web.automation.objectrepository.GeneralActivity_OR;
import com.web.automation.utilities.CommonVariables;

public class FairMarketValuePage extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public FairMarketValuePage(WebDriver driver) {
		super(driver);
	}

	public void FairMarketValue() throws Throwable {

		try {
           
			 Thread.sleep(2000);
			System.out.println("******Started the FairMarketValue page********");
			/*int fmvCount = CommonVariables.CommonDriver.get()
					.findElements(By.xpath("//div[@id='NominationGridContent']//table//tr")).size();*/
		//	int fmvCount = CommonVariables.CommonDriver.get().findElements(By.xpath("//table[@id='tbl_cr_fmv']//tr")).size();
	//int fmvCount = CommonVariables.CommonDriver.get().findElements(By.xpath("//table[@id='tbl_cr_fmv']/tbody/tr")).size();
		
	//int fmvCount = CommonVariables.CommonDriver.get().findElements(By.xpath("//div[@id='NominationGridContent']//table[@id='tbl_cr']/tbody/tr[@class='coveredRecipents']")).size();
				
			int fmvCount = CommonVariables.CommonDriver.get().findElements(By.xpath("//table[@id='tbl_cr_fmv']/tbody/tr[@style='border: 1px solid black !Important;']")).size();
											
			System.out.println("The count of the nominees list added are " + fmvCount);
			
			for (int i = 0; i < fmvCount; i++) {
				
				System.out.println(" ******Entered in the For loop in the FMV page********" + fmvCount);

				// Wait added for IE Browser

			    Thread.sleep(1000);

				actionLib.selectByVisibleText(FairMarketValue_OR.currency, "USD - UNITED States dollar", "currency");

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.serviceProvider), 2);
				Thread.sleep(1000);
				
				/*actionLib.Click(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.attendee), 2);
				Thread.sleep(1000);
				*/
				actionLib.selectByVisibleText(FairMarketValue_OR.proposedRole, "Participant", "Select Proposed Role");

				actionLib.selectByVisibleText(FairMarketValue_OR.hcpStature, "Local KOL", "HCP Stature");
				Thread.sleep(2000);
				System.out.println("The checkbox is displyed, true or false " + CommonVariables.CommonDriver.get()
						.findElement(FairMarketValue_OR.serviceCheckBox).isDisplayed());

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.serviceCheckBox), 2);
				Thread.sleep(2000);

				actionLib.type(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.noOfHours), "1");
				String minRate = CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.serviceHours)
						.getText();
				
				System.out.println("The minimum rate value is " + minRate);
				actionLib.type(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.rate), minRate);
				Thread.sleep(5000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_UP);
				Thread.sleep(2000);
				actionLib.javascriptClick(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("div[id='divRoundtripTravel'] input[Id='RoundTravelNo']")), 2);
				Thread.sleep(2000);
				actionLib.type(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.preparationTime), "1");
				Thread.sleep(2000);
				actionLib.selectByVisibleText(FairMarketValue_OR.travelTimeOption,
						"No travel time compensation allowed/0", " Travel Time");
				Thread.sleep(3000);
				actionLib.type(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.totalAdditionalFees),
						"10"); 
				if (minRate.equals("0")) {
					actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("btnModifyStandardFee")), 2);
					Thread.sleep(5000);
					robot.keyPress(KeyEvent.VK_UP);
					Thread.sleep(2000);
					actionLib.type(CommonVariables.CommonDriver.get()
							.findElement(By.xpath("//input[contains(@id,'txtmhours')]")), "1");
					Thread.sleep(5000);
					actionLib.type(CommonVariables.CommonDriver.get()
							.findElement(By.xpath("//input[contains(@id,'txtmhourlyrate')]")), "100");
					Thread.sleep(5000);
					actionLib.type(CommonVariables.CommonDriver.get()
							.findElement(By.xpath("//textarea[@id='ProposedRateReason']")), "Random Text");

				}
				Thread.sleep(5000);
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("input[id='btnSaveServiceProviderDetails']")), 2);
				actionLib.waitForInVisibilityOfElement(By.cssSelector("div[class*='blockUI blockMsg blockPage']>img"), "progress icon", 45);
				// Thread.sleep(10000);
				//i++;

			}
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(FairMarketValue_OR.btnSaveAndNextSec), 1);
			
			actionLib.waitForInVisibilityOfElement(By.cssSelector("div[class*='blockUI blockMsg blockPage']>img"), "progress icon", 45);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
