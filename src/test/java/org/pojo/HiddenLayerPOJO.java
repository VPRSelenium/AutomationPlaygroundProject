package org.pojo;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HiddenLayerPOJO extends BaseClassTest {

	@FindBy(id = "greenButton")
	private WebElement GreenButton;

	@FindBy(id = "blueButton")
	private WebElement BlueButton;

	public HiddenLayerPOJO() {
		PageFactory.initElements(driver, this);
	}

	public void clickButton() {
		String BlueText = GreenButton.getText();
		String GreenValue = GreenButton.getCssValue("background-color");
		click(GreenButton);
		String GreenText = BlueButton.getText();
		String BlueValue = BlueButton.getCssValue("background-color");
		Assert.assertNotEquals(GreenValue, BlueValue);
	}
}
