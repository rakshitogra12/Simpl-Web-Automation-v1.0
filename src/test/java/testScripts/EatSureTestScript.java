package testScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.EatSureEndtoEndFlow;

public class EatSureTestScript extends BaseClass {

	@Test(priority = 1)
	public void EatSureTestMethodForSuccessfullScenario() throws Exception {

		EatSureEndtoEndFlow bbobj1 = new EatSureEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = bbobj1.EatSureSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Eatsure");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
