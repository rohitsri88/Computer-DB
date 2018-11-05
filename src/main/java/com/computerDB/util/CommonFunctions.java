package com.computerDB.util;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import comm.computerDB.pagelib.LoggingClass;

public class CommonFunctions {

	public static boolean fillData(WebElement el, WebDriver driver, String value, String nameOfControl) {
		if (value.equals("")) {
			LoggingClass.getLogger().info("The value for the field " + nameOfControl + " is not present in Test Data");
			return false;
		}
		if (!checkElement(el, driver)) {
			LoggingClass.getLogger().info("The value for the field is present in Test Data but locator is missing");
			Assert.assertTrue(false);
		}
		el.sendKeys(value);
		LoggingClass.getLogger().info("Successfully send the vlaue into control");
		return true;

	}
	public static boolean selectData(WebElement el, WebDriver driver, String value, String nameOfControl){
		Select sel = new Select(el);
		sel.selectByVisibleText(value);
		return true;
	}

	public static void clickElement(WebElement el, WebDriver driver, String nameOfControl) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(80, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			el.click();
			LoggingClass.getLogger().info("Successfully clicked");
			

		} catch (Exception e) {
			LoggingClass.getLogger().info("Element not clickable");

		}

	}

	public static boolean checkElement(WebElement el, WebDriver driver) {
		boolean result = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(el));
		} catch (Exception e) {
			LoggingClass.getLogger().info("Element not present");
			return false;
		}
		return result;

	}

	public static boolean checkElementPresent() {
		return false;

	}
	/**
	 * Read the test data from excel file
	 *
	 * @param data
	 *            The TestData data object
	 */

}
