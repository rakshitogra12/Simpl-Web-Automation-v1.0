package plTestScripts;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadandWriteExcel;
import plTestEndtoEndFlows.NetMedsEndtoEndFlow;

public class NetMedsTestScript extends BaseClass {

	@Test(priority = 1)
	public void NetMedsTestMethodForSuccessTransactionScenario() throws Exception {

		NetMedsEndtoEndFlow netmedsobj1 = new NetMedsEndtoEndFlow();

		Map<Integer, ArrayList<String>> pl_data = netmedsobj1.NetMedsSuccessTestCode();

		for (Entry<Integer, ArrayList<String>> entry : pl_data.entrySet()) {

			ReadandWriteExcel excelobj = new ReadandWriteExcel();

			ArrayList<String> dataValues = entry.getValue();

			excelobj.ReadExcelLoginMethod(entry.getKey(), dataValues, "Netmeds");
		}

		System.out.println("End of Execution Successfully");

		driver.quit();

	}

}
