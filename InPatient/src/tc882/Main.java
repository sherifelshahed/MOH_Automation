package tc882;

import tc882.CancelDischargePatient;
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 String encounterId = "10003318";
		 CancelDischargePatient CDP = new CancelDischargePatient();
		 CDP.openURL();
		 CDP.Cancel_Discharge_patient(usernameS, passwordS, encounterId);
}
}