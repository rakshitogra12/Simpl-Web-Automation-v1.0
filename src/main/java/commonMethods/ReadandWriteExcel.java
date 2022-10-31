package commonMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadandWriteExcel {

	public void ReadExcelLoginMethod(Integer plposition, ArrayList<String> dataValues, String merchantName)
			throws IOException {

		FileInputStream fis = new FileInputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Daily Report(Automated)_ApprovalCall&Position_ SimplVisibility_Sheet.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Daily Report(Automated)");

		XSSFRow row = sheet.getRow(10);

		XSSFCell cell = row.createCell(7);

		if (dataValues.get(0).contains("simpl option is present on the payment page")) {

			cell.setCellValue("Y");

		} else {
			cell.setCellValue("N");

		}

		XSSFCell cell1 = row.createCell(10);

		if (plposition == 1) {

			cell1.setCellValue(plposition + "st");

		}
		if (plposition == 2) {

			cell1.setCellValue(plposition + "nd");
		}
		if (plposition == 3) {

			cell1.setCellValue(plposition + "3rd");
		}

		else {

			cell1.setCellValue(plposition + "th");
		}

		XSSFCell cell2 = row.createCell(6);

		cell2.setCellValue(dataValues.get(1));

		FileOutputStream fos = new FileOutputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Daily Report(Automated)_ApprovalCall&Position_ SimplVisibility_Sheet.xlsx");

		wb.write(fos);

		fos.close();

	}

}
