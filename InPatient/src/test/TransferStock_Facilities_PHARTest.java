package test;

import java.awt.AWTException;

import reference.TransferStock_Facilities_PHAR;

public class TransferStock_Facilities_PHARTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		TransferStock_Facilities_PHAR TSFP = new TransferStock_Facilities_PHAR();
		TSFP.openurl();
		TSFP.LoginMan();
		TSFP.OpenSTtransaction();
		TSFP.TransferStock();
		TSFP.Transfer_Item();
		
		TSFP.CloseDriver();
	}

}
