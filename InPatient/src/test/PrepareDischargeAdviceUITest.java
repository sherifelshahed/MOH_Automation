package test;

import java.awt.AWTException;

import reference.PrepareDischargeAdviceUI;

public class PrepareDischargeAdviceUITest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		PrepareDischargeAdviceUI PDA = new PrepareDischargeAdviceUI();
		PDA.openurl();
		PDA.Login();
		PDA.OpenPrepareDischargeAdvicePage();
		PDA.CheckFieldsPDA();
		
		PDA.CloseDriver();
		
	}

}
