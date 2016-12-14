package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.utilities.CommonVariables;

public class ActivityOverviewPage extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public static By drpTransactionOwnerCountry = By.xpath("//select[@id='drpTransactionOwnerCountry']");
	public static By drpBusinessUnit = By.xpath("//select[@id='drpBusinessUnit']");
	public static By drpDepartment = By.xpath("//select[@id='drpDepartment']");
	public static By drpProductCountry = By.xpath("//select[@id='drpProductCountry']");
	private HomePage homePage;
	public Generic objGeneric;

	public ActivityOverviewPage(WebDriver driver) {
		super(driver);
		if (!actionLib.GetPageTitle().contains("Prizma")) {
			throw new IllegalStateException("This is not the 'Prizma' login page.");
		}
		driver = CommonVariables.CommonDriver.get();
	}

/*	public void clickCreateRequestBtn() {
		try {
			Thread.sleep(7000);
			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(By.xpath("//span[text()='Create New Request']")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/// TODO: Delet: KLC

	public boolean isCreateNewRequestHeadingVisible(){
		return actionLib.IsElementVisible(By.xpath("//h1[text()='Create a New Request']"));
	}
	
	public boolean isActivityOverviewSelected(){
		return CommonVariables.CommonDriver.get()
			.findElement(By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']"))
			.isSelected();	
	}

	public void checkActivityOverView(){
		//TODO Review:  Use check method instead of click
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(
				By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']")), 2);
	}

	public void selectIsRequestOnBehalOfOriginator(String yesOrNo){
		if(yesOrNo.equalsIgnoreCase("YES")){
			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(By.id("IsRequestOnBehalOfOriginatorYes")), 1);
		} else {
			actionLib.Click(
					CommonVariables.CommonDriver.get().findElement(By.id("IsRequestOnBehalOfOriginatorNo")), 1);//TODO: Check the locator
		}
	}

	public void selectOriginatorName(String originatorName) throws Throwable{
		actionLib.Click(
				CommonVariables.CommonDriver.get()
						.findElement(By
								.xpath("//div[@id='SearchOriginator_Name']//div[@class='selectize-input items not-full']")),
				1);
		actionLib.type(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("select[class*='selectOriginator']+div  input")), originatorName);
		Thread.sleep(Long.parseLong("5000"));
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(
				By.cssSelector("div#SearchOriginator_Name div.selectize-dropdown-content>div")), 1);
	}

	public void selectTransactionOwnerCountry(String country) throws Throwable{
		actionLib.selectByVisibleText(drpTransactionOwnerCountry, country, "Transaction owner country");
	}

	public void selectBusinessUnit(String businessUnit) throws Throwable {
		actionLib.selectByVisibleText(drpBusinessUnit, businessUnit,
				"Business Unit");
	}

	public void selectDepartment(String dept) throws Throwable{
		actionLib.selectByVisibleText(drpDepartment, dept, "Department");
	}

	public void selectAreCoOwnersAvailable(String yesOrNo){
		if(yesOrNo.equalsIgnoreCase("Yes")){
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("AreCoownersAvailablepYes")), 1);
		} else {
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("AreCoownersAvailablepNo")), 1);
		}
	}

	public void clickCostCenterRadio(){
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.xpath("//input[@id='CostCenter' and @name = 'CostUnitId']")), 1);
	}

	public void setCostCenter(String costCenter) throws Throwable{
		actionLib.type(CommonVariables.CommonDriver.get()
				.findElement(By.xpath("//input[@id='CostCenter' and @name = 'CostCenter']")),costCenter);
	}

	public void selectProductCountry(String productCountry) throws Throwable{
		actionLib.selectByVisibleText(drpProductCountry, "France", productCountry);
	}

	//Review: SHould opt the value based on value, avoid index
	public void selectFirstOptionFromTherapeutic() throws InterruptedException{
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("select#drpDiseaseState+div input")));
		//Thread.sleep(2000);
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("select#drpDiseaseState+div div.selectize-dropdown-content>div")));
		
		
	}

	public void selectTherapeutic(String option){
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("select#drpDiseaseState+div input")));
		//Code to click on the option as per the parameter
	}

	public void selectFirstProductOrCompound() throws InterruptedException{
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.xpath("//label[text()='Product / Compound:']/../..")), 1);

		// Product/Compound information
		actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(By.cssSelector("select#drpProduct+div input")));
		//Thread.sleep(2000);
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("select#drpProduct+div div.selectize-dropdown-content>div")));
	}

	public void selectProductOrCompound(String option){
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.xpath("//label[text()='Product / Compound:']/../..")), 1);

		// Product/Compound information
		actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(By.cssSelector("select#drpProduct+div input")));
		//Implement code to click on given option
	}

	public void clickSaveAndNext(){
		/*actionLib.Click(
				CommonVariables.CommonDriver.get().findElement(By.xpath("//input[@name='saveAndNext']")));*/
		actionLib.ScrollToElementVisible(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']")));
		actionLib.Click(CommonVariables.CommonDriver.get()
				.findElement(By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']")));
	}

	public void clickEditSection(){
		actionLib.Click(
				CommonVariables.CommonDriver.get()
						.findElement(By
								.xpath("//section[@id='sp_BNAActivityOverview']/..//div//button[contains(text(),'Edit Section')]")),
				2);
	}

	public String getACtivityId(){
		return CommonVariables.CommonDriver.get()
		.findElement(By.xpath("// div[@id='BNAActivityOverview-ActivityDisplayId']")).getText();
	}
	
	
/*	public GeneralActivityPage createRequest(String actTypeNo) throws Throwable {
		try {
			Thread.sleep(5000);
			homePage = new HomePage(CommonVariables.CommonDriver.get());
			if (actionLib.IsElementVisible(By.xpath("//h1[text()='Create a New Request']"))) {
				if (!CommonVariables.CommonDriver.get()
						.findElement(By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']"))
						.isSelected()) {
					actionLib.Click(CommonVariables.CommonDriver.get().findElement(
							By.xpath("//div[@id='activity_overview']//div[@class='checkbox pull-left']")), 2);
				}
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(By.id("IsRequestOnBehalOfOriginatorYes")), 1);

				// actionLib.javascriptClick(CommonVariables.CommonDriver.get().findElement(By.id("IsRequestOnBehalOfOriginatorYes")));

				// Orginator name
				actionLib.Click(
						CommonVariables.CommonDriver.get()
								.findElement(By
										.xpath("//div[@id='SearchOriginator_Name']//div[@class='selectize-input items not-full']")),
						1);
				actionLib.type(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("select[class*='selectOriginator']+div  input")), "Sub");
				Thread.sleep(Long.parseLong("5000"));
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(
						By.cssSelector("div#SearchOriginator_Name div.selectize-dropdown-content>div")), 1);
				
				 * CommonVariables.CommonDriver.get() .findElement(By .xpath(
				 * "//div[@id='SearchOriginator_Name']//div[contains(@class,'selectize-input items not-full')]"
				 * )) .sendKeys(Keys.ENTER);
				 

				actionLib.selectByVisibleText(drpTransactionOwnerCountry, "Argentina", "Transaction owner country");
				Thread.sleep(Long.parseLong("2000"));
				actionLib.selectByVisibleText(drpBusinessUnit, "003105_008852_Janssen Vaccines & Prevention B.V.",
						"Business Unit");
				Thread.sleep(Long.parseLong("2000"));
				actionLib.selectByVisibleText(drpDepartment, "002233_007101_Marketing", "Department");
				Thread.sleep(Long.parseLong("2000"));

				actionLib.Click(CommonVariables.CommonDriver.get().findElement(By.id("AreCoownersAvailablepNo")), 1);
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.xpath("//input[@id='CostCenter' and @name = 'CostUnitId']")), 1);
				actionLib.type(CommonVariables.CommonDriver.get()
						.findElement(By.xpath("//input[@id='CostCenter' and @name = 'CostCenter']")), "123");
				actionLib.selectByVisibleText(drpProductCountry, "France", "Country");
				Thread.sleep(Long.parseLong("2000"));

				// Therapeutic information
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("select#drpDiseaseState+div input")));
				Thread.sleep(2000);
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("select#drpDiseaseState+div div.selectize-dropdown-content>div")));
				Thread.sleep(2000);
				
				 * actionLib.Click(CommonVariables.CommonDriver.get().
				 * findElement( By.cssSelector(
				 * "select#drpDiseaseState+div div.selectize-dropdown-content>div"
				 * )));
				 

				// Click on the empty space to activate the next field
				
				 * actionLib.Click(CommonVariables.CommonDriver.get()
				 * .findElement(By.xpath(
				 * "//input[@id='CostCenter' and @name = 'CostUnitId']")), 1);
				 
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.xpath("//label[text()='Product / Compound:']/../..")), 1);

				// Product/Compound information
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(By.cssSelector("select#drpProduct+div input")));
				Thread.sleep(2000);
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("select#drpProduct+div div.selectize-dropdown-content>div")));
				
				 * actionLib.Click(CommonVariables.CommonDriver.get().
				 * findElement( By.cssSelector(
				 * "select#drpProduct+div div.selectize-dropdown-content>div"
				 * )));
				 
				actionLib.Click(
						CommonVariables.CommonDriver.get().findElement(By.xpath("//input[@name='saveAndNext']")));

				System.out.println("******Completed Create New activity request tab*******");

				Thread.sleep(10000);
				actionLib.Click(
						CommonVariables.CommonDriver.get()
								.findElement(By
										.xpath("//section[@id='sp_BNAActivityOverview']/..//div//button[contains(text(),'Edit Section')]")),
						2);

				String activityID = CommonVariables.CommonDriver.get()
						.findElement(By.xpath("// div[@id='BNAActivityOverview-ActivityDisplayId']")).getText();

				System.out.println("The activity ID is " + activityID + " and the actTypeNo is " + actTypeNo);

				// objGoToHomePage.writeToCSV(actTypeNo, activityID);
				System.out.println("In the write to CSV method");

				homePage.writeToCSV(actTypeNo, activityID);
				actionLib.ScrollToElementVisible(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']")));
				actionLib.Click(CommonVariables.CommonDriver.get()
						.findElement(By.cssSelector("input[id='btnBusinessNeedActivityOverviewSaveAndNext']")));

			} else {
				System.out.println("***** Request Form is not visisble *****");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new GeneralActivityPage(CommonVariables.CommonDriver.get());

	}*/

}
