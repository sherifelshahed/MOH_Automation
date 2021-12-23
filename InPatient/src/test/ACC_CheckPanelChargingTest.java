package test;

import java.awt.AWTException;

import reference.ACC_CheckPanelCharging;

public class ACC_CheckPanelChargingTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ACC_CheckPanelCharging ACPC = new ACC_CheckPanelCharging();
		ACPC.openurl();
		ACPC.Login();
		ACPC.OpenManagePatientOrderPage();
		ACPC.SearchPatientNe("A200000401");
		ACPC.RecordPanel();
		ACPC.CloseDriver();
		ACPC.openurl();
		ACPC.LoginCMO();
		ACPC.OpenBillGenerationPage();
		ACPC.SearchPatientCMO("A200000401");
		ACPC.GenerateBill();
		ACPC.CloseDriver();
		
	}

}
