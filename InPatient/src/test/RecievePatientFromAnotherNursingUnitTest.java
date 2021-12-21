package test;

import java.awt.AWTException;

import reference.RecievePatientFromAnotherNursingUnit;

public class RecievePatientFromAnotherNursingUnitTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		RecievePatientFromAnotherNursingUnit RPAN = new RecievePatientFromAnotherNursingUnit();
		RPAN.openurl();
		RPAN.Login();
		RPAN.OpenTransferPatientInPage();
		RPAN.SearchForPatient();
		RPAN.OpenTransferForm();
		RPAN.TransferPatient();
		
		
		//RPAN.CloseDriver();
		
	}

}
