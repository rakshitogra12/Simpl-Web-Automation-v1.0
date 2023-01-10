package commonMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write_Excel_Tachyon {

	public void ReadExcelLoginMethod(Integer plposition, ArrayList<String> dataValues, String merchantName)
			throws IOException {

		FileInputStream fis = new FileInputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Daily Merchant Report - Tachyon _ DD-MM-YYYY.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int rowvalue = 0;

		XSSFSheet sheet = wb.getSheet("Tachyon Reporting");

		for (int i = 1; i < sheet.getLastRowNum(); i++) {

			if (sheet.getRow(i).getCell(0).getStringCellValue().contains(merchantName)) {

				rowvalue = i;

			}
		}

		XSSFRow row = sheet.getRow(rowvalue);

		XSSFCell cell = row.createCell(2);

		if (dataValues.get(0).contains("simpl option is present on the payment page")) {

			cell.setCellValue("Y");

		} else {
			cell.setCellValue("N");

		}

		XSSFCell cell1 = row.createCell(10);

		if (dataValues.get(0).contains("simpl option is present on the payment page")) {

			cell1.setCellValue("Y");

		} else {
			cell1.setCellValue("N");

		}

		XSSFCell cell2 = row.createCell(6);

		if (dataValues.get(0).contains("simpl option is present on the payment page")) {

			cell2.setCellValue("Y");

		} else {
			cell2.setCellValue("N");

		}
		
		FileOutputStream fos = new FileOutputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Daily Merchant Report - Tachyon _ DD-MM-YYYY.xlsx");

		wb.write(fos);

		fos.close();

	}
	
	
}
