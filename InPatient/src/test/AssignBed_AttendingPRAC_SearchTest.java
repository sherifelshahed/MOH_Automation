package test;

import java.awt.AWTException;

import reference.AssignBed_AttendingPRAC_Search;

public class AssignBed_AttendingPRAC_SearchTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		AssignBed_AttendingPRAC_Search AAPS = new AssignBed_AttendingPRAC_Search();
		
		AAPS.openurl();
		AAPS.Login();
		AAPS.AccessAsignBed();
		AAPS.CheckAttendingPrac();
		
		AAPS.CloseDriver();
	}

}
