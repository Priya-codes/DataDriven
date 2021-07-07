package com.selenium.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.selenium.testbase.TestBase;



public class TestUtility extends TestBase{

	public static String  screenshotpath;
	public static String screenshotName;
	

	
	 public static void capatureScreenShots () throws IOException
	 {
		
		 TakesScreenshot screenshot= (TakesScreenshot)driver;
		 Date d= new Date();
		 screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		 File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
		 File destFile = new File(System.getProperty(("user dir")+"\\target\\surefire-reports\\html\\" +screenshotName));
	     FileUtils.copyFile(srcFile, destFile);
	     System.out.println(screenshotName);
	 }
	 




	
}
