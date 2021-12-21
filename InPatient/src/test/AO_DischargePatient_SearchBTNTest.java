package test;

import java.awt.AWTException;

import reference.AO_DischargePatient_SearchBTN;

public class AO_DischargePatient_SearchBTNTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		AO_DischargePatient_SearchBTN ADSB = new AO_DischargePatient_SearchBTN();
		
		ADSB.openurl();
		ADSB.Login();
		ADSB.OpenPatientDischargePage();
		ADSB.SearchForPatient("A200000498");
		
		ADSB.CloseDriver();
		
	}

}
