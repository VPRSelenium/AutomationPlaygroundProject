package org.pojo;

import java.time.Duration;

import org.baseclass.BaseClassTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class ProgressBarPOJO extends BaseClassTest {

	@FindBy(id = "startButton")
	private WebElement StartButton;

	@FindBy(id = "stopButton")
	private WebElement StopButton;

	@FindBy(id = "progressBar")
	private WebElement ProgressBar;

	public ProgressBarPOJO() {
		PageFactory.initElements(driver, this);
	}
	

	public void waitUntilProgressReaches( int targetValue) {
		
		click(StartButton);
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(15))
	        .pollingEvery(Duration.ofMillis(500))
	        .ignoring(Exception.class);

	    while (true) {
	        String value = ProgressBar.getAttribute("aria-valuenow");
	        System.out.println("Progress: " + value + "%");

	        if (Integer.parseInt(value)>= targetValue) {
	        	click(StopButton);
	            break;
	        }

	        try {
	            Thread.sleep(500); // mimic polling
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	

	}


