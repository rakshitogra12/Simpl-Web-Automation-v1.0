package testScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import testEndtoEndFlows.MakeMyTripendtoendflow;

public class MakeMyTripTestScript extends BaseClass {

	@Test(priority = 1)
	public void MakemytripTestMethodSuccessTransactionScenario() throws Exception {

		MakeMyTripendtoendflow mmtobj1 = new MakeMyTripendtoendflow();

		Map<Integer, ArrayList<String>> pl_data = mmtobj1.MakemytripSuccessfulScenarioCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "MakeMyTrip");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
