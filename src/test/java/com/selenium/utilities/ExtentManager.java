package com.selenium.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if (extent==null)
		{
			//displayed order displauy
		extent =new ExtentReports(System.getProperty(("user.dir")+"\\target\\surefire-reports\\html\\extent.html"));
		extent.loadConfig(new File(System.getProperty(("user.dir")+"\\resources\\extentconfig\\ReportsConfig.xml")));
		}
		return extent;
	}
    
}
