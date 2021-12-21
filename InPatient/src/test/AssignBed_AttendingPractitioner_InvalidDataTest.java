package test;

import java.awt.AWTException;

import reference.AssignBed_AttendingPractitioner_InvalidData;

public class AssignBed_AttendingPractitioner_InvalidDataTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AssignBed_AttendingPractitioner_InvalidData AAPI = new AssignBed_AttendingPractitioner_InvalidData();
		
		AAPI.openurl();
		AAPI.Login();
		AAPI.AccessAsignBed();
		AAPI.CheckAttendingPracFieldInvalid("I700000008","1233");
		
		
		AAPI.CloseDriver();
		
	}

}
