package com.selenium.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.utilities.ExcelReaderUtil;
import com.selenium.utilities.ExtentManager;



public  class TestBase {
 
 
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReaderUtil excel= new ExcelReaderUtil(System.getProperty("user.dir")+"\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public  ExtentReports repo= ExtentManager.getInstance(); //return extent report
	public static ExtentTest test; //define all the logs for the test cases 
	public boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			return true;
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(" no such element present");
		}
		return false;
	}
	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {

			fis = new FileInputStream(("user.dir") + "resources\\properties\\Config.properties");
			config.load(fis);
		
			log.debug("Comfiguration file is loaded ");
			fis = new FileInputStream(("user.dir") + "\\resources\\properties\\OR.properties");
			OR.load(fis);
		log.debug("Object Repository file is loaded ");

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"G:\\Eclipse_Codes\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chome browser is opening ");

				driver.get(config.getProperty("testSite"));
				log.debug("opening the Site :" + config.getProperty("testSite"));

				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitly.wait")),
				TimeUnit.SECONDS); // implicit wait
				wait= new WebDriverWait(driver, 5);  //explicit wait

			}

		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
          log.debug("Test Run Successfully");

		}
	}

}