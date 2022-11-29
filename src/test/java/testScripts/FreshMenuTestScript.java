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

		Map<Integer, ArrayList<String>> pl_data = bbobj1.FreshMenuSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "FreshMenu");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
