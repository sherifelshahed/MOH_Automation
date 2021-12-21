package test;

import java.awt.AWTException;

import reference.PrepareDischargeAdvice;

public class PrepareDischargeAdviceTest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		PrepareDischargeAdvice PDAE = new PrepareDischargeAdvice();
		PDAE.openurl();
		PDAE.Login();
		PDAE.OpenPrepareDischargeAdvicePage();
		PDAE.SearchForPatient();
		PDAE.OpenPatientDiscargeAdvice();
		PDAE.PrepareAdvice();
		
		PDAE.CloseDriver();
		
	}

}
