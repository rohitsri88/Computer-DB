package comm.computerDB.pagelib;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computerDB.util.CommonFunctions;

public class EditComputerPage {
	
	@FindBy(how=How.ID, using ="name")
	 private WebElement cmputerName;
	
	@FindBy(how=How.ID, using ="introduced")
	 private WebElement introducedDate ;
	
	@FindBy(how=How.ID, using ="discontinued")
	 private WebElement DiscontinuedDate ;
	
	@FindBy(how=How.ID, using ="company")
	 private WebElement companyName ;
	
	@FindBy(how=How.XPATH, using ="//input[@value='Save this computer']")
	 private WebElement saveThisComputer ;
	
	public void editDetails(HashMap<String, String> data, WebDriver driver){
		String compName = data.get("EDIT_ComputeName").toString();
		String intriducedDateVariable = data.get("EDIT_Introduced").toString();
		String discontinuedDateVariable = data.get("EDIT_Discontinued").toString();
		String companyNameVariable = data.get("EDIT_Company").toString();
		CommonFunctions.fillData(cmputerName, driver, compName, "Name of Computer");
		CommonFunctions.fillData(introducedDate, driver, intriducedDateVariable, "Introduction Date Control");
		CommonFunctions.fillData(DiscontinuedDate, driver, discontinuedDateVariable, "Disconnection Control");
		CommonFunctions.selectData(companyName, driver, companyNameVariable, "Company Dropdown");
		LoggingClass.getLogger().info("Details Filled Succesfully");
	}
	public HomePage navigateToNextPage(HashMap<String, String>data,WebDriver driver){
		CommonFunctions.clickElement(saveThisComputer, driver, "Click on Home Page");	
		HomePage ob =new HomePage();
		LoggingClass.getLogger().info("Page Loaded");
		return ob;
		}
}
