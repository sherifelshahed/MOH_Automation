package test;

import java.awt.AWTException;

import reference.TransferPatientOut_Search_Practitioner;

public class TransferPatientOut_Search_PractitionerTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		TransferPatientOut_Search_Practitioner TPOSP = new TransferPatientOut_Search_Practitioner();
		TPOSP.openurl();
		TPOSP.Login();
		TPOSP.OpenTransferPatientPage();
		TPOSP.SearchWithPractitioner();
		
		TPOSP.CloseDriver();
		
	}

}
