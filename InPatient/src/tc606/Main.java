package tc606;

import tc606.BlockBed;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		BlockBed BB = new BlockBed();
		BB.openURL();
		BB.Block_bed(usernameS, passwordS);
}
}