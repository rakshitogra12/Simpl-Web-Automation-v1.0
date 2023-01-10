package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.MyJioEndToEndFlow;

public class MyJioTestScript extends BaseClass {

	@Test(priority = 1)
	public void MyJioTestMethodForSuccessTransactionScenario() throws Exception {

		MyJioEndToEndFlow jioobj1 = new MyJioEndToEndFlow();

		Map<Integer, ArrayList<String>> pl_data = jioobj1.MyJioSuccessTestCode();

		for (Map.Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "MyJio");

		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
