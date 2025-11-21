package org.pojo;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicTablePOJO extends BaseClassTest{

	
	
	
	
	@FindBy(xpath="//div[@role='rowgroup'][2]//span[contains(text(),'Chrome')]/..//span[contains(text(),'%')]")
	private WebElement CpuValue;
	
	@FindBy(xpath="//p[@class='bg-warning']")
	private WebElement ComparingCpuValue;
	
	
	public DynamicTablePOJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void comapre()
	{
		
		String CpuText = CpuValue.getText();
		String ActualCpuText=ComparingCpuValue.getText();
     
		System.out.println(CpuText);
		

		System.out.println(ActualCpuText);

		if(CpuText.contains(ActualCpuText))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}

		
	}
}
