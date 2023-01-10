package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.AbhiBusEndtoEndflow;

public class AbhiBusTestScript extends BaseClass {

	@Test(priority = 1)
	public void AbhiBusTestMethodForSuccessTransactionScenario() throws Exception {

		AbhiBusEndtoEndflow abbusobj1 = new AbhiBusEndtoEndflow();

		Map<Integer, ArrayList<String>> pl_data = abbusobj1.AbhiBusSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Abhibus-Ixigo");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
