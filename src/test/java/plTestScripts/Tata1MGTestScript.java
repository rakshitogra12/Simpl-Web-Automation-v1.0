package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.Tata1MGEndtoEndFlow;

public class Tata1MGTestScript extends BaseClass {

	@Test(priority = 1)
	public void Tata1mgTestMethodForSuccessTransactionScenario() throws Exception {

		Tata1MGEndtoEndFlow tataobj = new Tata1MGEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = tataobj.Tata1MGSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Tata 1mg");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
