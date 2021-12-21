package test;

import java.awt.AWTException;
import reference.AssignBed_InValidRoomNumber;



public class AssignBed_InValidRoomNumberTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		AssignBed_InValidRoomNumber ABIVB = new AssignBed_InValidRoomNumber();
		ABIVB.openurl();
		ABIVB.Login();
		ABIVB.AccessAsignBed();
		ABIVB.CheckRoomNumber("I700000008","Khaled Ali elZend","123");
		
		ABIVB.CloseDriver();


	}

}
