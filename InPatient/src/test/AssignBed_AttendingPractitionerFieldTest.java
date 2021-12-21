package test;

import java.awt.AWTException;

import reference.AssignBed_AttendingPractitionerField;

public class AssignBed_AttendingPractitionerFieldTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		AssignBed_AttendingPractitionerField AAPF = new AssignBed_AttendingPractitionerField();
		
		AAPF.openurl();
		AAPF.Login();
		AAPF.AccessAsignBed();
		AAPF.SearchForPatient("I700000008","Khaled Ali elZend");
		
		AAPF.CloseDriver();
	}

}
