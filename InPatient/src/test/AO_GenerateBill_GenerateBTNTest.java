package test;

import java.awt.AWTException;

import reference.AO_GenerateBill_GenerateBTN;

public class AO_GenerateBill_GenerateBTNTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		AO_GenerateBill_GenerateBTN AGGB = new AO_GenerateBill_GenerateBTN();
		AGGB.openurl();
		AGGB.Login();
		AGGB.OpenBillGenerationPage();
		AGGB.SearchPatient("T200000003");
		AGGB.GenerateBill();
		
		
		AGGB.CloseDriver();

	}

}
