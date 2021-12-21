package tc607;

import tc607.BlockBedNoNU;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 BlockBedNoNU NU = new BlockBedNoNU();
		 NU.openURL();
		 NU.Block_bed_No_NU(usernameS, passwordS);
		
}
}
