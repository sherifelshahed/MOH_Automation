package tc611;

import tc611.BlockBedNoFromDate;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 BlockBedNoFromDate BBNFD = new BlockBedNoFromDate();
		 BBNFD.openURL();
		 BBNFD.Block_bed_No_From_Date(usernameS, passwordS);
}
}
