package com.BMS.uhia;

import utility.Family_Registration;

public class Testing {
//My Test comment 1234
	public static void main(String[] args) {
		// Test Commit 
		Family_Registration fr = new Family_Registration();
		fr.InvokeBrowser();
		fr.Login_to_BMS("digital1","digital1@staging");
		//fr.Search_for_Beneficiary_by_NID("20000000000032");
		/*
		fr.Add_new_Family("5000", "1000000002", "testmahmoud@yahoos.com", "Nasr city,Cairo,Egypty");
		fr.teardown();
		*/
	}
	
}
