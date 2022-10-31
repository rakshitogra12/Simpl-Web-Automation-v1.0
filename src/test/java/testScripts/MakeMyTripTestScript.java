package testScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.makeMyTripendtoendflow;

public class MakeMyTripTestScript extends BaseClass {

	@Test(priority = 1)
	public void makemytripTestMethodSuccessfulUserScenario() throws Exception {

		makeMyTripendtoendflow mmtobj1 = new makeMyTripendtoendflow();

		Map<Integer, ArrayList<String>> pl_data = mmtobj1.makemytripSuccessfulScenarioCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "MakeMyTrip");
		}

		System.out.println("End of Execution Successfully");

//		driver.quit();

	}
//
//	@Test(priority = 2)
//	public void makemytripTestMethodForLinkingandFirstTransactScenario() throws InterruptedException, IOException {
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
//	public void makemytripTestMethodForInsufficientCreditcenario() throws InterruptedException, IOException {
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
//	public void makemytripTestMethodForUnabletoProcessScenario() throws InterruptedException, IOException {
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
//	public void bigBasketTestMethodForPendingBillScenario() throws InterruptedException, IOException {
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
//	public void bigBasketTestMethodForOtherScenarios() throws InterruptedException, IOException {
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

}
