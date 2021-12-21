package tc680;

import tc680.DispenseMedicationUI;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 DispenseMedicationUI DMUI = new DispenseMedicationUI();
		DMUI.openURL();
		DMUI.Dispense_Medication(usernameS, passwordS);
	}
}
