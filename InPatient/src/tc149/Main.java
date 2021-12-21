package tc149;

import tc149.SearchAdmission;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 SearchAdmission SA = new SearchAdmission();
		 SA.openURL();
		 SA.Search_admission(usernameS, passwordS);
}
}