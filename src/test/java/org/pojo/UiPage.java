package org.pojo;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UiPage extends BaseClassTest {

	@FindBy(xpath = "//a[text()='Dynamic ID']")
	private WebElement DynamicID;

	@FindBy(xpath = "//a[text()='Hidden Layers']")
	private WebElement HiddenLayers;

	@FindBy(xpath = "//a[text()='Load Delay']")
	private WebElement LoadDelay;

	@FindBy(xpath = "//a[text()='Dynamic Table']")
	private WebElement DynamicTable;

	@FindBy(xpath = "//a[text()='Progress Bar']")
	private WebElement ProgressBar;

	@FindBy(xpath = "//a[text()='Disabled Input']")
	private WebElement DisabledElement;

	@FindBy(xpath = "	//a[text()='File Upload']")
	private WebElement FileUpload;

	public UiPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnDynamicID() {
		click(DynamicID);

	}

	public void clickOnHiddenLayers() {
		click(HiddenLayers);

	}

	public void clickOnLoadDelay() {
		click(LoadDelay);

	}

	public void clickOnDynamicTable() {
		click(DynamicTable);

	}

	public void clickOnProgressBar() {
		click(ProgressBar);

	}

	public void clickOnDisabledElement() {
		click(DisabledElement);

	}

	public void clickOnFileUpload() {
		click(FileUpload);

	}

}
