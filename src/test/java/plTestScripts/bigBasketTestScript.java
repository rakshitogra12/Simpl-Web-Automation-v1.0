package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.BigBasketEndtoEndFlow;

public class bigBasketTestScript extends BaseClass {

	@Test(priority = 1)
	public void bigBasketTestMethodForSuccessTransactionScenario() throws Exception {

		BigBasketEndtoEndFlow bbobj1 = new BigBasketEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.BigBasketSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "BigBasket");

		}

		System.out.println("End of Execution Successfully");

	}
//
//	@Test(priority = 2)
//	public void bigBasketTestMethodForUnapprovedUserScenario() throws Exception {
//
//		BigBasketEndtoEndFlow bbobj1 = new BigBasketEndtoEndFlow();
//
//		bbobj1.bigBasketBlockedTestCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 3)
//	public void bigBasketTestMethodForInsufficientCreditScenario() throws Exception {
//
//		BigBasketEndtoEndFlow bbobj1 = new BigBasketEndtoEndFlow();
//
//		bbobj1.bigBasketInsufficentCreditTestCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 4)
//	public void bigBasketTestMethodForUnabletoprocessScenario() throws Exception {
//
//		BigBasketEndtoEndFlow bbobj1 = new BigBasketEndtoEndFlow();
//
//		bbobj1.bigBasketUnableToProcessTestCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 5)
//	public void bigBasketTestMethodForPendingBillScenario() throws Exception {
//
//		BigBasketEndtoEndFlow bbobj1 = new BigBasketEndtoEndFlow();
//
//		bbobj1.bigBasketpendingBillTestCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 6)
//	public void bigBasketTestMethodForOtherScenario() throws Exception {
//
//		BigBasketEndtoEndFlow bbobj1 = new BigBasketEndtoEndFlow();
//
//		bbobj1.bigBasketOtherScenarioCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}

}