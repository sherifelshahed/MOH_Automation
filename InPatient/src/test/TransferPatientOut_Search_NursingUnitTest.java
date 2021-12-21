package test;

import java.awt.AWTException;

import reference.TransferPatientOut_Search_NursingUnit;

public class TransferPatientOut_Search_NursingUnitTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		TransferPatientOut_Search_NursingUnit TPOSN = new TransferPatientOut_Search_NursingUnit();
		
		TPOSN.openurl();
		TPOSN.Login();
		TPOSN.OpenTransferPatientPage();
		TPOSN.SearchWithNursingUnit();
		
		TPOSN.CloseDriver();

	}

}
