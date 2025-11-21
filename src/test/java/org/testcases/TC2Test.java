package org.testcases;

import java.io.IOException;

import org.baseclass.BaseClassTest;
import org.pojo.DynamicPOJO;
import org.pojo.DynamicTablePOJO;
import org.pojo.HiddenLayerPOJO;
import org.pojo.ProgressBarPOJO;
import org.pojo.UiPage;
import org.testng.annotations.Test;
import org.utility.PropertiesUtility;

public class TC2Test extends BaseClassTest {

	@Test(priority = 3, groups = "Regression",enabled=false)
	public void dynamicTable() throws IOException {

		PropertiesUtility URL = new PropertiesUtility();
		String ActualURL = URL.propertiesFile("url");
		setUrl(ActualURL);
		driver.manage().window().maximize();
		UiPage ppa = new UiPage();
		ppa.clickOnDynamicTable();
		DynamicTablePOJO cli = new DynamicTablePOJO();
		cli.comapre();

	}

	
	@Test(priority = 4, groups = "Regression")
	public void scrollProgressBar() throws IOException, InterruptedException {

		PropertiesUtility URL = new PropertiesUtility();
		String ActualURL = URL.propertiesFile("url");
		setUrl(ActualURL);
		driver.manage().window().maximize();
		UiPage ppa = new UiPage();
		ppa.clickOnProgressBar();
		ProgressBarPOJO cli = new ProgressBarPOJO();
		cli.waitUntilProgressReaches(75);

	}
	
}









//invocationcount-done
//parameter-done
//dataprovider-done
//@optional-done
//data driven-done
//assertions
//grouping
//parallel-in progress
//annotations
//cross browser testing


//listners
//extent reports
//dependson method
