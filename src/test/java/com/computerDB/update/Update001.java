package com.computerDB.update;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computerDB.util.ReadXlsx;

import comm.computerDB.pagelib.AddComputerPage;
import comm.computerDB.pagelib.BaseTestClass;
import comm.computerDB.pagelib.EditComputerPage;
import comm.computerDB.pagelib.HomePage;
import comm.computerDB.pagelib.LoggingClass;

public class Update001 extends BaseTestClass {
	HomePage homePage;
	AddComputerPage addComputerPage;
	EditComputerPage editComputerPage;

	@Test
	public void readPositiveTestCase() {
		LoggingClass.getLogger().info("* * Started Test Case : " + this.getClass().getName() + " * *");
		try {
			HashMap<String, String> testData = ReadXlsx
					.GetCellData(ReadXlsx.rowNumberForTest("Update001", testDataFilePath, "Create"));
			homePage = verifyPageLoad();
			homePage.fillDetails(driver, testData);
			editComputerPage = homePage.NavigateToEditComputerPage(driver, testData);
			Assert.assertTrue(!homePage.verifyMessage(driver).contains("No computers found"),
					"Required Comuter not found!!");

			editComputerPage.editDetails(testData, driver);
			homePage = editComputerPage.navigateToNextPage(testData, driver);

			Assert.assertTrue(homePage.verifyMessage(driver).contains(testData.get("EDIT_ComputeName").toString()),
					"Updated computer not present!!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
