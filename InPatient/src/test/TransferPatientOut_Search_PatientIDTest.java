package test;

import java.awt.AWTException;

import reference.TransferPatientOut_Search_PatientID;

public class TransferPatientOut_Search_PatientIDTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		TransferPatientOut_Search_PatientID TPSP = new TransferPatientOut_Search_PatientID();
		
		TPSP.openurl();
		TPSP.Login();
		TPSP.OpenTransferPatientPage();
		TPSP.SearchWithPatientID();
		
		
		TPSP.CloseDriver();

	}

}
