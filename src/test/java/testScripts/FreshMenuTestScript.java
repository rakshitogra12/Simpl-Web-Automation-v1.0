package testScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.FreshMenuEndtoEndFlow;

public class FreshMenuTestScript extends BaseClass {

	@Test(priority = 1)
	public void FreshMenuTestMethodForSuccessfullScenario() throws Exception {

		FreshMenuEndtoEndFlow bbobj1 = new FreshMenuEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.freshMenuSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "FreshMenu");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

//	@Test(priority = 2)
//	public void bigBasketTestMethodForUnApprovedUserScenario() throws Exception {
//
//
//		IxigoEndtoEndFlow bbobj1 = new IxigoEndtoEndFlow();
//
//		bbobj1.bigBasketBlockedTestCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//
//	@Test(priority = 3)
//	public void bigBasketTestMethodForInsufficientCreditScenario() throws Exception {
//
//		IxigoEndtoEndFlow bbobj1 = new IxigoEndtoEndFlow();
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
//	public void bigBasketTestMethodForUnabletoProcessScenario() throws Exception {
//
//		IxigoEndtoEndFlow bbobj1 = new IxigoEndtoEndFlow();
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
//		IxigoEndtoEndFlow bbobj1 = new IxigoEndtoEndFlow();
//
//		bbobj1.bigBasketpendingBillTestCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	
//	@Test(priority = 6)
//	public void bigBasketTestMethodForOtherScenario() throws Exception {
//
//		IxigoEndtoEndFlow bbobj1 = new IxigoEndtoEndFlow();
//
//		bbobj1.bigBasketOtherScenarioCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//	
//}

}
