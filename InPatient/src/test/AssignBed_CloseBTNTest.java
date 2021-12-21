package test;

import java.awt.AWTException;

import reference.AssignBed_CloseBTN;

public class AssignBed_CloseBTNTest {
	public static void main(String[] args) throws InterruptedException, AWTException {
		AssignBed_CloseBTN ABCBX= new AssignBed_CloseBTN();

		ABCBX.openurl();
		ABCBX.Login();
		ABCBX.AccessAsignBed();
		ABCBX.CheckCloseBTN("I700000008","Khaled Ali elZend");
		
		ABCBX.CloseDriver();
	}
}
