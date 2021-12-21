package test;
import java.awt.AWTException;

import reference.TransferPatientOutUI;
public class TransferPatientOutUITest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		TransferPatientOutUI TPO = new TransferPatientOutUI();
		TPO.openurl();
		TPO.Login();
		TPO.OpenTransferPatientPage();
		TPO.CheckFieldsTPO();
		TPO.CloseDriver();
	}

}
