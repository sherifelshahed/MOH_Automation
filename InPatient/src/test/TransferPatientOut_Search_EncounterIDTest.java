package test;

import java.awt.AWTException;

import reference.TransferPatientOut_Search_EncounterID;

public class TransferPatientOut_Search_EncounterIDTest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		TransferPatientOut_Search_EncounterID TPSE = new TransferPatientOut_Search_EncounterID();
		
		TPSE.openurl();
		TPSE.Login();
		TPSE.OpenTransferPatientPage();
		TPSE.SearchWithEncounterID();
		
		
		TPSE.CloseDriver();

	}

}
