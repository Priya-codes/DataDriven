package com.selenium.rough;

import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(" Screenshot"+d.toString().replace(":", " ").replace("_", " ")+".jpg");
	}

}
