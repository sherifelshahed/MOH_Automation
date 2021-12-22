package test;

import java.awt.AWTException;

import reference.PharmacistLogin;

public class PharmacistLoginTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		PharmacistLogin PL = new PharmacistLogin();
		PL.openurl();
		PL.Login();
		PL.DispenseMedicationPage();
		
		PL.CloseDriver();
		
	}

}
