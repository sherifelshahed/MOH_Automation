package test;

import java.awt.AWTException;

import reference.AssingBed_RecordBTN;

public class AssingBed_RecordBTNTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AssingBed_RecordBTN ARB = new AssingBed_RecordBTN();
		
		ARB.openurl();
		ARB.Login();
		ARB.AccessAsignBed();
		ARB.SearchForPatient("I700000008", "Khaled Ali elZend");
		ARB.CloseDriver();

	}

}
