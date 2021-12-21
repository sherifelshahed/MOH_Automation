package test;

import java.awt.AWTException;

import reference.TransferPatientOut_Search_Speciality;

public class TransferPatientOut_Search_SpecialityTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		TransferPatientOut_Search_Speciality TPSS = new TransferPatientOut_Search_Speciality();
		
		TPSS.openurl();
		TPSS.Login();
		TPSS.OpenTransferPatientPage();
		TPSS.SearchWithSpeciality();
		
		TPSS.CloseDriver();
		
	}

}
