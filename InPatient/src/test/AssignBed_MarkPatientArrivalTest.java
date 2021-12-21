package test;

import java.awt.AWTException;

import reference.AssignBed_MarkPatientArrival;

public class AssignBed_MarkPatientArrivalTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
	
		AssignBed_MarkPatientArrival ABMP = new AssignBed_MarkPatientArrival();
		
		ABMP.openurl();
		ABMP.Login();
		ABMP.AccessAsignBed();
		ABMP.SearchForPatient("I700000008", "Khaled Ali elZend");
		
		
		ABMP.CloseDriver();

	}

}
