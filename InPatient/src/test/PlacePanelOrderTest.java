package test;

import java.awt.AWTException;

import reference.PlacePanelOrder;

public class PlacePanelOrderTest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		PlacePanelOrder PPO = new PlacePanelOrder();
		PPO.openurl();
		PPO.Login();
		PPO.OpenManagePatientOrderPage();
		PPO.SearchPatient("A200000401");
		PPO.RecordPanel();
		
		PPO.CloseDriver();

	}

}
