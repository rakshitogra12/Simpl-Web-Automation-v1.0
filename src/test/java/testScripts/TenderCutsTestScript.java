package testScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.TenderCutsEndtoEndFlow;

public class TenderCutsTestScript extends BaseClass {

	@Test(priority = 1)
	public void TenderCutsTestMethodForSuccessefulTransactionScenario() throws Exception {

		TenderCutsEndtoEndFlow abbusobj1 = new TenderCutsEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = abbusobj1.TenderCutsSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Tendercuts");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

//	@Test(priority = 2)
//	public void AbhiBusTestMethodForLinkingandFirstTransactScenario() throws InterruptedException, IOException {
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
//	public void AbhiBusTestMethodForInsufficientCreditcenario() throws InterruptedException, IOException {
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
//	public void AbhiBusTestMethodForUnabletoProcessScenario() throws InterruptedException, IOException {
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
//	public void AbhiBusTestMethodForPendingBillScenario() throws InterruptedException, IOException {
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
//	public void AbhiBusTestMethodForOtherScenarios() throws InterruptedException, IOException {
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
