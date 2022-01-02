package tc018;

import tc018.BedAvailablity;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 BedAvailablity BA = new BedAvailablity();
		BA.openURL();
		BA.Bed_Availabilty(usernameS, passwordS);
		// dummy comment for test 
	}
}
