package tc154;

import tc154.ValidSpecialitySearch;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 ValidSpecialitySearch VSS = new ValidSpecialitySearch();
		 VSS.openURL();
		 VSS.Valid_Speciality_Search(usernameS, passwordS);
}
}