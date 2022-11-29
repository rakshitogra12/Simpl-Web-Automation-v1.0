package testScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.TenderCutsEndtoEndFlow;

public class TenderCutsTestScript extends BaseClass {

	@Test(priority = 1)
	public void TenderCutsTestMethodForSuccessTransactionScenario() throws Exception {

		TenderCutsEndtoEndFlow abbusobj1 = new TenderCutsEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = abbusobj1.TenderCutsSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Tendercuts");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
