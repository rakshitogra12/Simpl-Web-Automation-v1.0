package testScripts;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.DunzoEndtoEndFlow;

public class DunzoTestScript extends BaseClass {

	@Test(priority = 1)
	public void dunzoTestMethodForSuccessTestScenario() throws Exception {

		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = dzobj1.dunzoCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Dunzo");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

//	@Test(priority = 2)
//	public void dunzoTestMethodForBlockedUserScenario() throws Exception {
//
//		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();
//
//		dzobj1.dunzoBlockedUserCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 3)
//	public void dunzoTestMethodForInsufficientCreditcenario() throws Exception {
//
//		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();
//
//		dzobj1.dunzoInsufficientCreditsCode();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 4)
//	public void dunzoTestMethodForUnabletoProcessScenario() throws Exception {
//
//		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();
//
//		dzobj1.dunzoUnabletoProcessScenario();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 5)
//	public void dunzoTestMethodForPendingBillScenario() throws Exception {
//
//		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();
//
//		dzobj1.dunzopendingBillScenario();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}
//
//	@Test(priority = 6)
//	public void dunzoTestMethodForOtherScenarios() throws Exception {
//
//		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();
//
//		dzobj1.dunzoOtherScenario();
//
//		System.out.println("End of Execution Successfully");
//
//		driver.quit();
//
//	}

}
