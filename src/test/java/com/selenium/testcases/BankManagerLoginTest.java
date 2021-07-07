package com.selenium.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.testbase.TestBase;



public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void bankManagerLogin() throws InterruptedException
	{
		log.debug("Login Bank Manager accoint");
		driver.findElement(By.cssSelector(OR.getProperty("bmbtn"))).click();
		log.debug("Login Bank Manager accoint successful");
		//Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("bmbtn"))), "no element found");
		log.debug("button present");	
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("bmbtn"))));
	   
	}

	

	
}
