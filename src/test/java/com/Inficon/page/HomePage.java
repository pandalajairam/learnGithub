package com.Inficon.page;

import org.openqa.selenium.By;

import com.automation.accelerators.ActionEngine;
import com.automation.support.ConfiguratorSupport;

public class HomePage extends ActionEngine {

	public static By txtRuname;
	public static By txtCurrentTag;
	public static By btnAcum;
	public static By btnMarco;
	public static By tabRun;
	public static By tabChromatogram;
	public static By tabReport;

	public void Home_Page()

	{

		txtRuname = By.xpath("//input[@ng-model='details.runName']");
		txtCurrentTag = By.xpath("//input[@ng-model='currentTag']");
		btnAcum = By.xpath("//div[contains(text(),'Acum')]/../parent::button");
		btnMarco = By.xpath("//div[contains(text(),'Marco Seq')]/../parent::button");
		tabRun = By.xpath("//a[text()='Run']/parent::li");
		tabChromatogram = By.xpath("//a[text()='Chromatogram']/parent::li");
		tabReport = By.xpath("//a[text()='Report']/parent::li");

	}

}