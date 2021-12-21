package tc612;
import tc612.BlockBedNoUntilDate;
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 BlockBedNoUntilDate BBNUD = new BlockBedNoUntilDate() ;
		 BBNUD.openURL();
		 BBNUD.Block_bed_No_Until_Date(usernameS, passwordS);
}
}