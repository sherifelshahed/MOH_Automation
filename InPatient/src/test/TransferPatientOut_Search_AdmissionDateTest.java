package test;

import java.awt.AWTException;

import reference.TransferPatientOut_Search_AdmissionDate;

public class TransferPatientOut_Search_AdmissionDateTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		TransferPatientOut_Search_AdmissionDate TPSA = new TransferPatientOut_Search_AdmissionDate();
		
		TPSA.openurl();
		TPSA.Login();
		TPSA.OpenTransferPatientPage();
		TPSA.SearchWithAdmissionDate();
		
		
		TPSA.CloseDriver();
	}

}
