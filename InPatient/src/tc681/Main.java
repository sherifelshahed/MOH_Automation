package tc681;

import tc681.DispenseMedication;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 DispenseMedication DM = new DispenseMedication();
		DM.openURL();
		DM.Dispense_Medication(usernameS, passwordS);
	}
}
