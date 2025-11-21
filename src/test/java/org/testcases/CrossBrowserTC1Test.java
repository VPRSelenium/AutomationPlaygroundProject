package org.testcases;

import java.io.IOException;

import org.baseclass.BaseClassTest;
import org.pojo.DisabledPOJO;
import org.pojo.UiPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utility.PropertiesUtility;

public class CrossBrowserTC1Test extends BaseClassTest {

	
	@Test(priority=5,groups= {"smoke","regression"})
	public void disabled() throws InterruptedException, IOException {
		PropertiesUtility URL = new PropertiesUtility();
		String ActualURL = URL.propertiesFile("url");
		setUrl(ActualURL);
		UiPage pages = new UiPage();
		pages.clickOnDisabledElement();
		DisabledPOJO page = new DisabledPOJO();
		page.clickButton();

	}
}
