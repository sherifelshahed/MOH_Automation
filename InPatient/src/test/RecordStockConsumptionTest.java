package test;

import java.awt.AWTException;

import reference.RecordStockConsumption;

public class RecordStockConsumptionTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		RecordStockConsumption RSC = new RecordStockConsumption();
		
		RSC.openurl();
		RSC.Login();
		RSC.OpenStockItemConsumptionPage();
		RSC.CreateDOC();
		RSC.CloseDriver();
		
		
	}

}
