package comm.computerDB.pagelib;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {

	public WebDriverWait wait;
	public Logger logger = Logger.getLogger(BaseTestClass.class);
	public WebDriver driver;
	public HomePage homePage;
	public String testDataFilePath ;
	public BaseTestClass() {
		try {
			PropertyConfigurator.configure(
					new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator
							+ "java" + File.separator + "Resources" + File.separator + "log4j.properties");
			 testDataFilePath = new File(".").getCanonicalPath() + File.separator + "src" + File.separator
					+ "test" + File.separator + "java" + File.separator + "Resources" + File.separator + "DataSet.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HomePage verifyPageLoad() {
		LoggingClass.getLogger().info("Verifying Home page of computer DB application");
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.verifyPage(driver);
		LoggingClass.getLogger().info("Computer DB Home Page Succesfully loaded");
		return homePage;
	}
	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("FireFox") String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("Chrome")){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		}
		else if(browser.equalsIgnoreCase("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		else{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.get("http://computer-database.herokuapp.com/computers");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDownTest() {
		driver.quit();

	}

}
