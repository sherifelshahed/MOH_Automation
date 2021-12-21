package test;
import java.awt.AWTException;

import reference.CMOLogin;
public class LoginTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		CMOLogin CL = new CMOLogin();
		CL.openurl();
		CL.Login();
		CL.CloseDriver();

	}

}
