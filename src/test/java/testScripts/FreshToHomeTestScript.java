package testScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.FreshtoHomeEndtoEndFlow;

public class FreshToHomeTestScript extends BaseClass {

	@Test(priority = 1)
	public void FreshToHomeTestMethodForSuccessTransactionScenario() throws Exception {

		FreshtoHomeEndtoEndFlow bbobj1 = new FreshtoHomeEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.FreshtoHomeSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "FreshToHome");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
