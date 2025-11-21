package org.testcases;

import java.io.IOException;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pojo.DynamicPOJO;
import org.pojo.UiPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utility.PropertiesUtility;

public class TC1Test extends BaseClassTest {

	

	
	@Test(priority = 0, groups = "Regression")
	public void dynamicIds() throws IOException {
		
		
		PropertiesUtility URL = new PropertiesUtility();
		String ActualURL = URL.propertiesFile("url");
		setUrl(ActualURL);
		driver.manage().window().maximize();
		UiPage ppa = new UiPage();
		ppa.clickOnDynamicID();
		DynamicPOJO cli = new DynamicPOJO();
		cli.clickDynamicId();
		refreshBrowser();
		cli.clickDynamicId();
	}
	
	@Test(priority=1, groups= {"smoke"})
	public void hiddenLayers() throws IOException
	{
		
		PropertiesUtility URL = new PropertiesUtility();
		String ActualURL = URL.propertiesFile("url");
		setUrl(ActualURL);
		UiPage ppa = new UiPage();
		ppa.clickOnHiddenLayers();
		
	}

}
