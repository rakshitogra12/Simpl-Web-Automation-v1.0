package testScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.NykkaEndtoEndFlow;

public class NykaaTestScript extends BaseClass {

	@Test(priority = 1)
	public void NykaaTestMethodForSuccessTransactionScenario() throws Exception {

		NykkaEndtoEndFlow nykkobj1 = new NykkaEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = nykkobj1.NykkaSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Nykaa");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
