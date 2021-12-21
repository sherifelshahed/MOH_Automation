package tc141;

import tc141.CancelAdmission;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 String encounterId = "10000472";
		 CancelAdmission CA = new CancelAdmission();
		CA.openURL();
		CA.Cancel_admission(usernameS, passwordS, encounterId);
	}
}
