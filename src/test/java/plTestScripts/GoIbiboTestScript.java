package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.GoIbiboEndtoEndFlow;

public class GoIbiboTestScript extends BaseClass {

	@Test(priority = 1)
	public void GoIbiboTestMethodForSuccessTransactionScenario() throws Exception {

		GoIbiboEndtoEndFlow goibiboobj = new GoIbiboEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = goibiboobj.GoIbiboSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "GoIbibo");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}