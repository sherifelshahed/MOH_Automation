package test;

import java.awt.AWTException;

import reference.ACC_RecordPanel;

public class ACC_RecordPanelTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ACC_RecordPanel ACRP = new ACC_RecordPanel();
		
		ACRP.openurl();
		ACRP.Login();
		ACRP.OpenManagePatientOrderPage();
		ACRP.SearchPatient("A100049381");
		ACRP.RecordPanel();
		
		ACRP.CloseDriver();

	}

}
