package test;

import java.awt.AWTException;

import reference.ACC_CancelPanelOrder;

public class ACC_CancelPanelOrderTest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		ACC_CancelPanelOrder ACPO = new ACC_CancelPanelOrder();
		ACPO.openurl();
		ACPO.Login();
		ACPO.OpenManagePatientOrderPage();
		ACPO.SearchPatient("A100049381");  
		ACPO.CancelPanel();

		ACPO.CloseDriver();

	}

}
