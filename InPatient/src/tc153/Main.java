package tc153;

import tc153.NursintUnitLookUpBtn;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 NursintUnitLookUpBtn NULU = new NursintUnitLookUpBtn();
		 NULU.openURL();
		 NULU.NU_LookUp(usernameS, passwordS);
}
}
