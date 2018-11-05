package comm.computerDB.pagelib;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computerDB.util.CommonFunctions;

public class AddComputerPage extends BaseTestClass {
	@FindBy(how=How.ID, using ="name")
	 private WebElement cmputerName;
	
	@FindBy(how=How.ID, using ="introduced")
	 private WebElement introducedDate ;
	
	@FindBy(how=How.ID, using ="discontinued")
	 private WebElement DiscontinuedDate ;
	
	@FindBy(how=How.ID, using ="company")
	 private WebElement companyName ;
	
	@FindBy(how=How.XPATH, using ="//*[@value='Create this computer']")
	 private WebElement createCompBtn ;

	
	@FindBy(how=How.XPATH, using ="//*[@value='Create this computer']")
	 private WebElement computrtCount;
	
	@FindBy(how=How.XPATH, using ="//input[@value='Create this computer']")
	 private WebElement createThisComputer;
	
	
	
	public void fillDetails(HashMap<String, String> data, WebDriver driver){
		String compName = data.get("ComputeName").toString();
		String intriducedDateVariable = data.get("Introduced").toString();
		String discontinuedDateVariable = data.get("Discontinued").toString();
		String companyNameVariable = data.get("Company").toString();
		CommonFunctions.fillData(cmputerName, driver, compName, "Name of Computer");
		CommonFunctions.fillData(introducedDate, driver, intriducedDateVariable, "Introduction Date Control");
		CommonFunctions.fillData(DiscontinuedDate, driver, discontinuedDateVariable, "Disconnection Control");
		CommonFunctions.selectData(companyName, driver, companyNameVariable, "Company Dropdown");
	}
	public HomePage navigateToNextPage(HashMap<String, String>data,WebDriver driver){
	CommonFunctions.clickElement(createThisComputer, driver, "Click on Home Page");	
	HomePage ob =new HomePage();
	return ob;
	}
}
