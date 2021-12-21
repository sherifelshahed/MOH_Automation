package test;
import java.awt.AWTException;

import reference.AccessAdmissionPage;
public class AccessAdmissionPageTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AccessAdmissionPage AAP = new AccessAdmissionPage();
		AAP.openurl();
		AAP.Login();
		AAP.AccessAdmitPage();
		AAP.CloseDriver(); 
	}

}
