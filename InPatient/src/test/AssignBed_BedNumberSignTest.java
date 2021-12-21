package test;

import java.awt.AWTException;

import reference.AssignBed_BedNumberSign;

public class AssignBed_BedNumberSignTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AssignBed_BedNumberSign ABBS = new AssignBed_BedNumberSign();
		
		ABBS.openurl();
		ABBS.Login();
		ABBS.AccessAsignBed();
		ABBS.CheckBedNumberSign();
		
		ABBS.CloseDriver();

	}

}
