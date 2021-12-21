package test;

import java.awt.AWTException;

import reference.AssignBed_AdmitingPractitioner;

public class AssignBed_AdmitingPractitionerTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		AssignBed_AdmitingPractitioner ABAP = new AssignBed_AdmitingPractitioner();
		
		ABAP.openurl();
		ABAP.Login();
		ABAP.AccessAsignBed();
		ABAP.CheckAdmittingPractitioner();
		
		
		ABAP.CloseDriver();

	}

}
