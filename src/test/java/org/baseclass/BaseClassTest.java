package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClassTest {

	public static  WebDriver driver;
	public static Robot robo;
	public static boolean useBeforeMethod = true;
	// in base class before class and before method create 2 different methods with
	// diffrent annotations
	// launch the browser accoreding to the xml conditions

	
	
	@Parameters({ "browser", "Allbatch" })
	@BeforeTest()
	public void openBrowserBeforeClass(String browser, String Allbatch) {

		if (Allbatch.equalsIgnoreCase("methods")) {
			useBeforeMethod=true;
			
		}
		else if (Allbatch.equalsIgnoreCase("class")) {
			useBeforeMethod=false;
			setupBeforeClass(browser);
		}

	}
	@Parameters({ "browser"})
	@BeforeMethod
	public void setupBeforeMethod(String browser) {
		System.out.println("Launching browser before each method");
		if(useBeforeMethod)
		{
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			driver = new  ChromeDriver(opt);
		}

		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(opt);
			return;
		}
		}
	}
	public void setupBeforeClass(String browser) {
		System.out.println("Launching browser once before class");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(opt);
		}

		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(opt);
			return;
		}
	}

	public void launchBrowser() {
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(opt);
	}
	// pass the url
	public static void setUrl(String url) {
	    if (driver == null) {
	        System.out.println("Driver was null. Launching browser now.");
	        ChromeOptions opt = new ChromeOptions();
	        opt.setAcceptInsecureCerts(true);
	        driver = new ChromeDriver(opt);
	    }
	    driver.get(url);
	}


	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void minimizeBrowser() {
		driver.manage().window().minimize();

	}

	public static void refreshBrowser() {
		driver.navigate().refresh();

	}

	// Actions

	public static void initalizeAction() {
		Actions acts = new Actions(driver);

		acts = new Actions(driver);
	}

	public static void click(WebElement element) {
		Actions acts = new Actions(driver);
		acts.click(element).perform();
	}

	public static void rightClick(WebElement element) {
		Actions acts = new Actions(driver);
		acts.contextClick(element).perform();
	}

	public static void doubleClick(WebElement element) {
		Actions acts = new Actions(driver);

		acts.doubleClick(element).perform();
	}

	public static void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
		Actions acts = new Actions(driver);

		acts.dragAndDrop(sourceElement, targetElement).perform();
	}

	public static void dragAndDropBy(WebElement element, int xAxis, int yAxis) {
		Actions acts = new Actions(driver);

		acts.dragAndDropBy(element, xAxis, yAxis).perform();

	}

	public static void mouseHover(WebElement element) {
		Actions acts = new Actions(driver);

		acts.moveToElement(element).perform();

	}
//robot 

	public static void initalizeRobot() {
		try {
			robo = new Robot();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void keyUp(int cond) {
		for (int i = 0; i < cond; i++) {
			robo.keyPress(KeyEvent.VK_DOWN);
			robo.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public static void enter() {
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

	// Alerts

	public static void simpleAlertAccept() {
		Alert alertt = driver.switchTo().alert();
		alertt.accept();

	}

	public static void simpleAlertDismiss() {
		Alert alertt = driver.switchTo().alert();
		alertt.dismiss();

	}

	public static void promptAlertSendkeys(String value) {
		Alert alertt = driver.switchTo().alert();
		alertt.sendKeys(value);
	}

	public static void promptAlertGetText(String Text) {
		Alert alertt = driver.switchTo().alert();
		Text = alertt.getText();
	}

	// Select
	public static void selectByValue(WebElement element, String value) {
		Select drop = new Select(element);
		drop.selectByValue(value);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select drop = new Select(element);
		drop.selectByIndex(index);
	}

	public static void selectByText(WebElement element, String text) {
		Select drop = new Select(element);
		drop.selectByVisibleText(text);
	}

	public static boolean isMultiple(WebElement element) {
		Select drop = new Select(element);
		return drop.isMultiple();
	}

	public static List<WebElement> getOptions(WebElement element) {
		Select drop = new Select(element);
		List<WebElement> options = drop.getOptions();
		return options;

	}

	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select drop = new Select(element);
		List<WebElement> options = drop.getAllSelectedOptions();
		return options;

	}

	public static WebElement getFirstOptions(WebElement element) {
		Select drop = new Select(element);
		WebElement options = drop.getFirstSelectedOption();
		return options;

	}

	public static void deSelectByText(WebElement element, String text) {
		Select drop = new Select(element);
		drop.deselectByVisibleText(text);
	}

	public static void deSelectByValue(WebElement element, String value) {
		Select drop = new Select(element);
		drop.deselectByValue(value);
	}

	public static void deSelectAll(WebElement element) {
		Select drop = new Select(element);
		drop.deselectAll();
	}

	public static void deSelectByIndex(WebElement element, int index) {
		Select drop = new Select(element);
		drop.deselectByIndex(index);
	}

	// frames
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void frameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void frameByValue(String name) {
		driver.switchTo().frame(name);
	}

	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	// javascript executor

	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollfalse(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void sendValue(WebElement element, String val) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',val)", element);
	}

	public static void clicks(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	// screenshot

	public static void screenshotWebPage(String url) throws IOException {

		TakesScreenshot snap = (TakesScreenshot) driver;
		File source = snap.getScreenshotAs(OutputType.FILE);
		File destination = new File(url);
		FileUtils.copyFile(source, destination);
	}

	public static void screenshotElement(WebElement element, String url) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		File destination = new File(url);
		FileUtils.copyFile(source, destination);

	}

	// window handling

	public static void switchingWindow(int windows) {
		Set<String> Windows = driver.getWindowHandles();

		List<String> lis = new LinkedList();
		lis.addAll(Windows);
		String wind = lis.get(windows);
		driver.switchTo().window(wind);

	}

	public static void switchingMultipleBrowser(String title) {
		Set<String> Windows = driver.getWindowHandles();
		for (String wind : Windows) {
			driver.switchTo().window(wind);
			String Title = driver.getTitle();

			if (Title.contains(title)) {
				break;
			}
		}

	}

//	wait
	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public static void elementTobeSelected(int time, WebElement element) {
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(time));
		wai.until(ExpectedConditions.elementToBeSelected(element));
	}

	public static void elementTobeClickable(int time, WebElement element) {
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(time));
		wai.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void alertIsPresent(int time, WebElement element) {
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(time));

		wai.until(ExpectedConditions.alertIsPresent());

	}

	public static void visibilityOfElement(int time, WebElement element) {
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(time));
		wai.until(ExpectedConditions.visibilityOf(element));
	}

	public static void frameTobeAvailable(int time, WebElement element) {
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(time));

		wai.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public static void fluentWait() {

	}

}
