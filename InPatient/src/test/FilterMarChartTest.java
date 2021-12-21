package test;

import java.awt.AWTException;

import reference.FilterMarChart;

public class FilterMarChartTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		FilterMarChart FMC = new FilterMarChart();
		
		FMC.openurl();
		FMC.Login();
		FMC.OpenMedicationAdministrationPage();
		FMC.SearchForPatient();
		FMC.CheckResult();
		
		FMC.CloseDriver();

	}

}
