package test;

import java.awt.AWTException;

import reference.UnBlockBedPageUI;

public class UnBlockBedPageUITest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		UnBlockBedPageUI UBP = new UnBlockBedPageUI();
		UBP.openurl();
		UBP.Login();
		UBP.OpenReleaseBlockBedPage();
		UBP.CheckFieldsUBP();
		UBP.CloseDriver();

	}

}
