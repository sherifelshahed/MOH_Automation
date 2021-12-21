package test;

import java.awt.AWTException;

import reference.ACC_AddSeparateService;

public class ACC_AddSeparateServiceTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ACC_AddSeparateService AASS = new ACC_AddSeparateService();
		AASS.openurl();
		AASS.Login();
		AASS.OpenManagePatientOrderPage();
		AASS.SearchPatient("H700000007");
		AASS.RecordOrder();
		
		AASS.CloseDriver();
		
	}

}
