package tc156;

import tc156.SpecialtyButton;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "CMOIPD01";
		 String passwordS = "egy123";
		 
		 SpecialtyButton SB = new SpecialtyButton();
		 SB.openURL();
		 SB.SpecialityBtn(usernameS, passwordS);
}}
