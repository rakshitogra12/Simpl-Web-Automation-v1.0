package testScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.NetMedsEndtoEndFlow;

public class NetMedsTestScript extends BaseClass {

	@Test(priority = 1)
	public void NetMedsTestMethodForSuccessefulTransactionScenario() throws Exception {

		NetMedsEndtoEndFlow netmedsobj1 = new NetMedsEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = netmedsobj1.NetMedsSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Netmeds");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

//	@Test(priority = 2)
//	public void NetMedsTestMethodForLinkingandFirstTransactScenario() throws InterruptedException, IOException {
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
//	public void NetMedsTestMethodForInsufficientCreditcenario() throws InterruptedException, IOException {
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
//	public void NetMedsTestMethodForUnabletoProcessScenario() throws InterruptedException, IOException {
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
//	public void NetMedsTestMethodForPendingBillScenario() throws InterruptedException, IOException {
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
//	public void NetMedsTestMethodForOtherScenarios() throws InterruptedException, IOException {
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
