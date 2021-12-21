package tc610;

import tc610.BlockBedNoRemark;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 BlockBedNoRemark BBNR = new BlockBedNoRemark();
		 BBNR.openURL();
		 BBNR.Block_bed_No_Remark(usernameS, passwordS);
}
}