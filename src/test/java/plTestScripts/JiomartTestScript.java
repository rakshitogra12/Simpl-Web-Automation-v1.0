package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.JioMartEndtoEndFlow;

public class JiomartTestScript extends BaseClass {

	@Test(priority = 1)
	public void JiomartTestMethodSuccessfullScenario() throws Exception {

		JioMartEndtoEndFlow jmobj1 = new JioMartEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = jmobj1.JioMartSuccessfulScenarioCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "JioMart");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}