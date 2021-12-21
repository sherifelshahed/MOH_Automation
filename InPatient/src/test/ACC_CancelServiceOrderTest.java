package test;

import java.awt.AWTException;

import reference.ACC_CancelServiceOrder;

public class ACC_CancelServiceOrderTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ACC_CancelServiceOrder ACSO = new ACC_CancelServiceOrder();
		
		ACSO.openurl();
		ACSO.Login();
		ACSO.OpenManagePatientOrderPage();
		ACSO.SearchPatient("T200000003");
		ACSO.CancelOrder();
		
		
		ACSO.CloseDriver();
			

	}

}
