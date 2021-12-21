package test;

import java.awt.AWTException;

import reference.TransferPatientOut;

public class TransferPatientOutTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		TransferPatientOut TPOU = new TransferPatientOut();
		
		TPOU.openurl();
		TPOU.Login();
		TPOU.OpenTransferPatientPage();
		TPOU.TransferPatient();
		
		
		
		TPOU.CloseDriver();

	}

}
