package tc155;

import tc155.InvalidSpecialitySearch;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 InvalidSpecialitySearch IVSS = new InvalidSpecialitySearch();
		 IVSS.openURL();
		 IVSS.INValid_Speciality_Search(usernameS, passwordS);
}
}