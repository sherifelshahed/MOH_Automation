package tc151;

import tc151.SearchAdmissionAfterNU;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 SearchAdmissionAfterNU SANU = new SearchAdmissionAfterNU();
		 SANU.openURL();
		 SANU.Search_admission(usernameS, passwordS);
}
}