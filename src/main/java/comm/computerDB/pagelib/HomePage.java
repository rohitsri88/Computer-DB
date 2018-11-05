package comm.computerDB.pagelib;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.computerDB.util.CommonFunctions;

public class HomePage {
	AddComputerPage addComputerPage;

	@FindBy(how=How.ID, using ="add")
	 private WebElement addComputer;
	
	
	@FindBy(how=How.XPATH, using ="//input[@id='searchsubmit']")
	 private WebElement filterByName;
	
	
	@FindBy(how=How.XPATH, using ="//div[@class='alert-message warning']")
	 private WebElement successMsg;
	
	public void verifyPage(WebDriver driver){
		
		
		Assert.assertTrue(CommonFunctions.checkElement(filterByName, driver));
		
		
	}
	public String getMessage(){
		return successMsg.getText();
	}
public void ValidateCountComputer(WebDriver driver){
		
		
		//Assert.assertTrue(driver.get(filterByName, driver));
		
		
	}
	public AddComputerPage NavigateToAddCompterPage(WebDriver driver,HashMap<String, String> testdata){
		CommonFunctions.clickElement(addComputer, driver, "Add New Computer Button");
		addComputerPage = PageFactory.initElements(driver, AddComputerPage.class);
		return addComputerPage;
		
	}
	
}
