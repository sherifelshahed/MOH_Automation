package tc173;

import tc173.AbortCancelationAdmission;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 String encounterId = "10000804";
		 AbortCancelationAdmission ACA = new AbortCancelationAdmission();
		 ACA.openURL();
		 ACA.Abort_Cancelation_admission(usernameS, passwordS, encounterId);
}
}