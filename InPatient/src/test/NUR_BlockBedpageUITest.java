package test;
import java.awt.AWTException;

import reference.NUR_BlockBedpageUICheck;
public class NUR_BlockBedpageUITest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		NUR_BlockBedpageUICheck NBDC = new NUR_BlockBedpageUICheck();
		NBDC.openurl();
		NBDC.Login();
		NBDC.OpenBlockBedPage();
		NBDC.CheckFields();
		NBDC.CloseDriver();
	}

}
