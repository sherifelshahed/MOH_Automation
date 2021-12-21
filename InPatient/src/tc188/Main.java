package tc188;

import tc188.AssignBedAccess;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 AssignBedAccess G = new AssignBedAccess();
		 G.openURL();
		 G.Assign_Bed_Access(usernameS, passwordS);
		 
	
		
	}
}
