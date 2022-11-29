package testScripts;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.DunzoEndtoEndFlow;

public class DunzoTestScript extends BaseClass {

	@Test(priority = 1)
	public void DunzoTestMethodForSuccessTestScenario() throws Exception {

		DunzoEndtoEndFlow dzobj1 = new DunzoEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = dzobj1.DunzoSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Dunzo");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
