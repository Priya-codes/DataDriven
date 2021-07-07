package com.selenium.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.testbase.TestBase;





public class AddCustomerTest extends TestBase{

	
	@Test(dataProvider="getdata")
	public void addCustomer(String fname, String lname, String postcode, String alerttext) throws InterruptedException
	{
		
		driver.findElement(By.cssSelector(OR.getProperty("addcustbtn"))).click();
	
		log.debug("Add customer button");
		
        driver.findElement(By.cssSelector(OR.getProperty("fname"))).sendKeys(fname);;
		driver.findElement(By.cssSelector(OR.getProperty("lname"))).sendKeys(lname);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
	
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());

	Assert.assertTrue(alert.getText().contains(alerttext));
	Thread.sleep(5000);
	alert.accept();
	
	}
	@DataProvider
	public Object[][] getdata() {
		 String sheetname="AddCustomerTest";
		int rows=excel.getRowCount(sheetname);
		System.out.println(rows);
		int columns=excel.getColumnCount(sheetname);
		System.out.println(columns);
		Object[][] data=new Object[rows-1][columns];//data[1][3]
		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<columns; colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetname, colNum, rowNum);
			}

		}
  return data;
		
		
	}
}
