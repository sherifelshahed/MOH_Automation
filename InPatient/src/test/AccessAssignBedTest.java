package test;
import java.awt.AWTException;

import reference.AccessAssignBedPage;
public class AccessAssignBedTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AccessAssignBedPage AAB = new AccessAssignBedPage();
		
		AAB.openurl();
		AAB.Login();
		AAB.AccessAsignBed();
		AAB.SearchWithSpeciality();
		AAB.CloseDriver();
	}

}
