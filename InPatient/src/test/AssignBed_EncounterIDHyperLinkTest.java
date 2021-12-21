package test;

import java.awt.AWTException;

import reference.AssignBed_EncounterIDHyperLink;

public class AssignBed_EncounterIDHyperLinkTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		AssignBed_EncounterIDHyperLink ABEH = new AssignBed_EncounterIDHyperLink();
		
		ABEH.openurl();
		ABEH.Login();
		ABEH.AccessAsignBed();
		ABEH.CheckHyperLink();
		
		
		ABEH.CloseDriver();

	}

}
