package test;

import java.awt.AWTException;

import reference.TransferBulkPractitioner;

public class TransferBulkPractitionerTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		TransferBulkPractitioner TBP = new TransferBulkPractitioner();
		
		TBP.openurl();
		TBP.Login();
		TBP.OpenBulkTransferPractitionerPage();
		TBP.SearchForPatients();
		TBP.SelectPatients();
		
		
		TBP.CloseDriver();

	}

}
