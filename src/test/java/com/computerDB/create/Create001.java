package com.computerDB.create;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computerDB.util.ReadXlsx;

import comm.computerDB.pagelib.AddComputerPage;
import comm.computerDB.pagelib.BaseTestClass;
import comm.computerDB.pagelib.HomePage;
import comm.computerDB.pagelib.LoggingClass;

public class Create001 extends BaseTestClass {
 HomePage homePage;
 AddComputerPage addComputerPage;
	@Test
	public void createPositiveTestCase() {
		LoggingClass.getLogger().info("* * Started Test Case : " + this.getClass().getName() + " * *");
		try {
			HashMap<String, String> testData = ReadXlsx
					.GetCellData(ReadXlsx.rowNumberForTest("Create001", testDataFilePath, "Create"));
			homePage = verifyPageLoad();
			addComputerPage = homePage.NavigateToAddCompterPage(driver, testData);
			addComputerPage.fillDetails(testData, driver);
			homePage =  addComputerPage.navigateToNextPage(testData, driver);
			
			Assert.assertTrue(driver.getPageSource().contains("Done"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
