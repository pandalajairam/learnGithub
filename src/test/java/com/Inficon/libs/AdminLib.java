package com.Inficon.libs;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Inficon.page.AdminPage;
import com.Inficon.page.HomePage;
import com.Inficon.page.PatientPage;
import com.eviware.soapui.support.StringUtils;

public class AdminLib extends InficonLib {

	public int sleep = 3000;
	public String gstrInsuranceName, gstrHospiceDesc, gstrGroupName, type, reasondescription, hcpcs, rate;

}
