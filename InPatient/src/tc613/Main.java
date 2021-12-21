package tc613;

import tc613.BlockBedInvalidDate;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 BlockBedInvalidDate BBID = new BlockBedInvalidDate() ;
		 BBID.openURL();
		 BBID.Block_bed_Invalid_Date(usernameS, passwordS);
}
}