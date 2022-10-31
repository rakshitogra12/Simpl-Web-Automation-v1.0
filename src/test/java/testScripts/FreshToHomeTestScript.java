package testScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.FreshtoHomeEndtoEndFlow;

public class FreshToHomeTestScript extends BaseClass {

	@Test(priority = 1)
	public void freshToHomeTestMethodForSuccessfullScenario() throws Exception {

		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.freshtoHomeSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "FreshToHome");

		}

		System.out.println("End of Execution Successfully");

//		driver.quit();

	}
//
//	@Test(priority = 2)
//	public void freshtoHomeTestMethodForUnApprovedUserScenario() throws Exception {
//
//		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();
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
//	public void freshtoHomeTestMethodForInsufficientCreditScenario() throws Exception {
//
//		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();
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
//	public void freshtoHomeTestMethodForUnabletoProcessScenario() throws Exception {
//
//		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();
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
//	public void freshtoHomeTestMethodForPendingBillScenario() throws Exception {
//
//		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();
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
//	public void freshtoHomeTestMethodForOtherScenario() throws Exception {
//
//		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();
//
//		bbobj1.bigBasketOtherScenarioCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}

}
