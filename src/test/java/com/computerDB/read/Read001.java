package com.computerDB.read;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computerDB.util.ReadXlsx;

import comm.computerDB.pagelib.AddComputerPage;
import comm.computerDB.pagelib.BaseTestClass;
import comm.computerDB.pagelib.HomePage;
import comm.computerDB.pagelib.LoggingClass;

public class Read001 extends BaseTestClass {
	HomePage homePage;
	AddComputerPage addComputerPage;

	@Test
	public void readPositiveTestCase() {
		LoggingClass.getLogger().info("* * Started Test Case : " + this.getClass().getName() + " * *");
		try {
			HashMap<String, String> testData = ReadXlsx
					.GetCellData(ReadXlsx.rowNumberForTest("Read001", testDataFilePath, "Create"));
			homePage = verifyPageLoad();
			homePage.fillDetails(driver, testData);
			homePage.NavigateToReadPage(driver, testData);
			Assert.assertTrue(!homePage.verifyMessage(driver).contains("No computers found"), "Required Comuter not found!!");
			Assert.assertTrue(homePage.verifyMessage(driver).contains(testData.get("ComputeName").toString()),
					"Required computer name not found!!");
			Assert.assertTrue(homePage.verifyMessage(driver).contains(testData.get("Introduced").toString()),
					"Required Introduced date not found!!");
			Assert.assertTrue(homePage.verifyMessage(driver).contains(testData.get("Discontinued").toString()),
					"Required Discontinued date not found!!");
			Assert.assertTrue(homePage.verifyMessage(driver).contains(testData.get("Company").toString()),
					"Required Company not found!!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
