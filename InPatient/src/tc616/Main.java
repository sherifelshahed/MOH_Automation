package tc616;


import tc616.ReleaseBlockedBed;
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		 String usernameS = "NURIPD01";
		 String passwordS = "egy123";
		 
		 ReleaseBlockedBed RB = new ReleaseBlockedBed();
		RB.openURL();
		RB.Release_Bed(usernameS, passwordS);
}
}
