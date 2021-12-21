package test;

import java.awt.AWTException;

import reference.NewBornRegisterationFormUI;

public class NewBornRegisterationFormUITest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		String Patient_ID = "A400023347";
		NewBornRegisterationFormUI NBRF = new NewBornRegisterationFormUI();
		
		NBRF.openurl();
		NBRF.Login();
		NBRF.OpenRegisterNewbornPage();
		NBRF.OpenMotherBabyLink(Patient_ID);
		NBRF.RegisterBaby(Patient_ID);
		
		NBRF.CloseDriver();

	}

}
