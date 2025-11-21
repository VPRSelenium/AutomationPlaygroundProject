package org.pojo;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPOJO extends BaseClassTest {
	
	
	@FindBy(xpath="//button[text()='Button with Dynamic ID']")
	private WebElement button;
	
	
	public DynamicPOJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickDynamicId()
	{
		click(button);
	}
	
	

}
