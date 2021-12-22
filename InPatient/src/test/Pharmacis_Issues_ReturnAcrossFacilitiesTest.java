package test;

import reference.Pharmacis_Issues_ReturnAcrossFacilities;

public class Pharmacis_Issues_ReturnAcrossFacilitiesTest {

	public static void main(String[] args) throws InterruptedException {
		Pharmacis_Issues_ReturnAcrossFacilities PIRF = new Pharmacis_Issues_ReturnAcrossFacilities();
		
		PIRF.openurl();
		PIRF.LoginMan();
		PIRF.OpenIssueReturn();
		PIRF.IssueReturn();
		
		
		
		PIRF.CloseDriver();

	}

}
