package testScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.bigBasketEndtoEndFlow;

public class bigBasketTestScript extends BaseClass {

	@Test(priority = 1)
	public void bigBasketTestMethodForSuccessfullScenario() throws Exception {

		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.bigBasketSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "BigBasket");

		}

		// Write method if we want to proceed for the Successful tranasction. temporary
		// lines

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

	@Test(priority = 2)
	public void bigBasketTestMethodForUnApprovedUserScenario() throws Exception {

		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();

		bbobj1.bigBasketBlockedTestCode();

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

	@Test(priority = 3)
	public void bigBasketTestMethodForInsufficientCreditScenario() throws Exception {

		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();

		bbobj1.bigBasketInsufficentCreditTestCode();

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

	@Test(priority = 4)
	public void bigBasketTestMethodForUnabletoProcessScenario() throws Exception {

		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();

		bbobj1.bigBasketUnableToProcessTestCode();

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

	@Test(priority = 5)
	public void bigBasketTestMethodForPendingBillScenario() throws Exception {

		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();

		bbobj1.bigBasketpendingBillTestCode();

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

	@Test(priority = 6)
	public void bigBasketTestMethodForOtherScenario() throws Exception {

		bigBasketEndtoEndFlow bbobj1 = new bigBasketEndtoEndFlow();

		bbobj1.bigBasketOtherScenarioCode();

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}