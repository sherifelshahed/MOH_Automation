package tc172;

import tc172.ConfirmCancelationButton;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 String encounterId = "10000167";
		 ConfirmCancelationButton CCB = new ConfirmCancelationButton();
		 CCB.openURL();
		 CCB.Confirm_Cancelation_BTN(usernameS, passwordS, encounterId);
}
}