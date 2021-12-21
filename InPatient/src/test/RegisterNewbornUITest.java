package test;

import java.awt.AWTException;

import reference.RegisterNewbornUI;

public class RegisterNewbornUITest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		RegisterNewbornUI RNU = new RegisterNewbornUI();
		RNU.openurl();
		RNU.Login();
		RNU.OpenRegisterNewbornPage();
		RNU.CheckFieldsPDA();

		RNU.CloseDriver();
	}

}
