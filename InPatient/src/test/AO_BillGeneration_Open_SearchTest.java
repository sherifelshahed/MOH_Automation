package test;

import java.awt.AWTException;

import reference.AO_BillGeneration_Open_Search;

public class AO_BillGeneration_Open_SearchTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AO_BillGeneration_Open_Search ABOS = new AO_BillGeneration_Open_Search();
		
		ABOS.openurl();
		ABOS.Login();
		ABOS.OpenBillGenerationPage();
		ABOS.SearchPatient("A200000516");
		
		
		ABOS.CloseDriver();

	}

}
