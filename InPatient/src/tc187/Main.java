package tc187;

import tc187.ReasonForCancelationbutton;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 String encounterId = "10000804";
		 ReasonForCancelationbutton RFCB = new ReasonForCancelationbutton();
		 RFCB.openURL();
		 RFCB.Reason_For_Cancelation_btn(usernameS, passwordS, encounterId);
}}
