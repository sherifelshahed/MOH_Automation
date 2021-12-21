package test;

import java.awt.AWTException;

import reference.NewBornRegisterationFormUI;

public class RegisterNewBornToAdmittedMotherTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		String PatientID = "A400023347";
		NewBornRegisterationFormUI RNBA = new NewBornRegisterationFormUI();

		RNBA.openurl();
		RNBA.Login();
		RNBA.OpenRegisterNewbornPage();
		RNBA.OpenMotherBabyLink(PatientID);
		RNBA.RegisterBaby(PatientID);

		RNBA.CloseDriver();

	}

}
