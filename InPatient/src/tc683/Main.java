package tc683;

import tc683.SalesReturn;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 SalesReturn SR = new SalesReturn();
		SR.openURL();
		SR.Sales_Return(usernameS, passwordS);
	}
}
