package testScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.Tata1MGEndtoEndFlow;

public class Tata1MGTestScript extends BaseClass {

	@Test(priority = 1)
	public void tata1mgTestMethodForSuccessefulTransactionScenario() throws Exception {

		Tata1MGEndtoEndFlow bbobj1 = new Tata1MGEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.tata1MGSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();
			
			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Tata 1mg");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}
	
//	@Test(priority = 2)
//	public void tata1mgTestMethodForLinkingandFirstTransactScenario() throws InterruptedException, IOException {
//
//		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();
//
//		Map<Integer, String> pl_data = bbobj1.bigBasket();
//
//		for (Map.Entry<Integer, String> entry : pl_data.entrySet()) {
//
//			ReadandWriteExcel excelobj = new ReadandWriteExcel();
//
//			excelobj.ReadExcelLoginMethod(entry.getKey(), entry.getValue(), "BigBasket");
//		}
//
//		// Write method if we want to proceed for the Successful tranasction. temporary
//		// lines
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 3)
//	public void tata1mgTestMethodForInsufficientCreditcenario() throws InterruptedException, IOException {
//
//		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();
//
//		Map<Integer, String> pl_data = bbobj1.bigBasket();
//
//		for (Map.Entry<Integer, String> entry : pl_data.entrySet()) {
//
//			ReadandWriteExcel excelobj = new ReadandWriteExcel();
//
//			excelobj.ReadExcelLoginMethod(entry.getKey(), entry.getValue(), "BigBasket");
//		}
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 4)
//	public void tata1mgTestMethodForUnabletoProcessScenario() throws InterruptedException, IOException {
//
//		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();
//
//		Map<Integer, String> pl_data = bbobj1.bigBasket();
//
//		for (Map.Entry<Integer, String> entry : pl_data.entrySet()) {
//
//			ReadandWriteExcel excelobj = new ReadandWriteExcel();
//
//			excelobj.ReadExcelLoginMethod(entry.getKey(), entry.getValue(), "BigBasket");
//		}
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 5)
//	public void tata1mgTestMethodForPendingBillScenario() throws InterruptedException, IOException {
//
//		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();
//
//		Map<Integer, String> pl_data = bbobj1.bigBasket();
//
//		for (Map.Entry<Integer, String> entry : pl_data.entrySet()) {
//
//			ReadandWriteExcel excelobj = new ReadandWriteExcel();
//
//			excelobj.ReadExcelLoginMethod(entry.getKey(), entry.getValue(), "BigBasket");
//		}
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//	
//	@Test(priority = 6)
//	public void tata1mgTestMethodForOtherScenarios() throws InterruptedException, IOException {
//
//		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();
//
//		Map<Integer, String> pl_data = bbobj1.bigBasket();
//
//		for (Map.Entry<Integer, String> entry : pl_data.entrySet()) {
//
//			ReadandWriteExcel excelobj = new ReadandWriteExcel();
//
//			excelobj.ReadExcelLoginMethod(entry.getKey(), entry.getValue(), "BigBasket");
//		}
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
	
	
}
