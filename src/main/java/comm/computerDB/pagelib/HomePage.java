package comm.computerDB.pagelib;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.computerDB.util.CommonFunctions;

public class HomePage  {
	AddComputerPage addComputerPage;

	@FindBy(how=How.ID, using ="add")
	 private WebElement addComputer;
	
	
	@FindBy(how=How.XPATH, using ="//input[@id='searchsubmit']")
	 private WebElement filterByName;
	
	@FindBy(how=How.ID, using ="searchbox")
	 private WebElement searchComputerName;
	
	
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
public void fillDetails(WebDriver driver, HashMap<String, String> data){
	String computerNameToSearch = data.get("ComputeName").toString();
	CommonFunctions.fillData(searchComputerName, driver, computerNameToSearch, "Srearch Text Box");
	LoggingClass.getLogger().info("Computer Name filled Successfuly!!");
	
}
	public AddComputerPage NavigateToAddCompterPage(WebDriver driver,HashMap<String, String> testdata){
		CommonFunctions.clickElement(addComputer, driver, "Add New Computer Button");
		addComputerPage = PageFactory.initElements(driver, AddComputerPage.class);
		LoggingClass.getLogger().info("Page Loaded");
		return addComputerPage;
		
	}
	public void NavigateToReadPage(WebDriver driver,HashMap<String, String> data){
		CommonFunctions.clickElement(filterByName, driver, "Filter Button");
		LoggingClass.getLogger().info("Page Loaded");
		//return new HomePage();
		
	}
	public boolean checkValue(WebDriver driver,HashMap<String, String> data ){
		
		try{
			driver.findElement(By.xpath(""));
			return false;
		}
		catch (NoSuchElementException e) {
			return false;
		}
		
	}
	public String verifyMessage(WebDriver driver){
		return driver.getPageSource();
	}

	
}
