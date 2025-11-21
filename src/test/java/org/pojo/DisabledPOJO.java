package org.pojo;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DisabledPOJO extends BaseClassTest {

	@FindBy(id = "enableButton")
	private WebElement Button;

	@FindBy(id = "inputField")
	private WebElement TextBox;

	public DisabledPOJO() {
		PageFactory.initElements(driver, this);
	}

	public void clickButton() throws InterruptedException {
		click(Button);

		try {
			elementTobeClickable(5, TextBox);
			TextBox.sendKeys("pradhiv");
			Assert.assertEquals(TextBox.getAttribute("value"), "pradhiv");
			System.out.println("Test case is done");
		} catch (Exception e) {
			Assert.assertFalse(false);
			System.out.println("It is still disabled");

		}
	}

}
