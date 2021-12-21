package test;

import java.awt.AWTException;

import reference.ViewMarChart;

public class ViewMarChartTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ViewMarChart VMC = new ViewMarChart();
		
		VMC.openurl();
		VMC.Login();
		VMC.OpenMedicationAdministrationPage();
		VMC.SearchForPatient();
		VMC.ViewChart();
		
		VMC.CloseDriver();

	}

}
