package tc152;

import tc152.InvalidNuSearchAdmission;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 InvalidNuSearchAdmission INSA = new InvalidNuSearchAdmission();
		 INSA.openURL();
		 INSA.Invalid_search_Nu_Admission(usernameS, passwordS);
}
}