package test;

import java.awt.AWTException;

import reference.AssignBed_ValidRoomNumber;

public class AssignBed_ValidRoomNumberTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AssignBed_ValidRoomNumber ABVB = new AssignBed_ValidRoomNumber();
		ABVB.openurl();
		ABVB.Login();
		ABVB.AccessAsignBed();
		ABVB.CheckRoomNumber("I700000008","Khaled Ali elZend","OHCROOM");
		
		ABVB.CloseDriver();

	}

}
