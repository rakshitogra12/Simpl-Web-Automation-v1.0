package commonMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write_Excel_Tachyon {

	public void ReadExcelLoginMethodStatusCheck(ArrayList<String> statusValues, String merchantName)
			throws IOException {

		FileInputStream fis = new FileInputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Tachyon Reports/Daily Report(Tachyon)|20-01-2023_Internal.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int rowvalue = 0;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDateTime now = LocalDateTime.now();

		String dateInFormat = dtf.format(now).toString();

		XSSFSheet sheet = wb.getSheet("Tachyon Reporting");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			if (sheet.getRow(i).getCell(0).getStringCellValue().contains(merchantName)) {

				rowvalue = i;

			}
		}

		XSSFRow row = sheet.getRow(rowvalue);

		XSSFCell cell1 = row.createCell(3);

		if (statusValues.get(0).contains("PASS")) {

			cell1.setCellValue("YES");

		} else if (statusValues.get(0).contains("N/A")) {

			cell1.setCellValue("N/A");

		} else if (statusValues.get(0).contains("FAIL")) {

			cell1.setCellValue("NO");

		}

		XSSFCell cell2 = row.createCell(4);

		if (statusValues.get(1).contains("PASS")) {

			cell2.setCellValue("YES");

		} else if (statusValues.get(1).contains("N/A")) {

			cell2.setCellValue("N/A");

		} else if (statusValues.get(1).contains("FAIL")) {
			cell2.setCellValue("NO");

		}

		XSSFCell cell3 = row.createCell(5);

		if (statusValues.get(2).contains("PASS")) {

			cell3.setCellValue("YES");

		} else if (statusValues.get(2).contains("N/A")) {

			cell3.setCellValue("N/A");

		} else if (statusValues.get(2).contains("FAIL")) {
			cell3.setCellValue("NO");

		}

		XSSFCell cell4 = row.createCell(2);

		if (cell1.getStringCellValue().equals("YES") || cell2.getStringCellValue().equals("YES")
				|| cell3.getStringCellValue().equals("YES")) {

			cell4.setCellValue("LIVE");

		} else {

			cell4.setCellValue("DISABLED");
		}

		FileOutputStream fos = new FileOutputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Tachyon Reports/Daily Report(Tachyon)|20-01-2023_Internal.xlsx");

		wb.write(fos);

		fos.close();

		System.out.println("Tachyon CTA Button Enabled/Disabled report has been generated");

	}

	public void ReadExcelLoginMethodTextCapturing(ArrayList<String> textList, String merchantName) throws IOException {

		FileInputStream fis = new FileInputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Tachyon Reports/Daily Report(Tachyon)|12-01-2023.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int rowvalue = 0;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDateTime now = LocalDateTime.now();

		String dateInFormat = dtf.format(now).toString();

		XSSFSheet sheet = wb.getSheet("Tachyon Reporting");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			if (sheet.getRow(i).getCell(0).getStringCellValue().contains(merchantName)) {

				rowvalue = i;

			}
		}

		XSSFRow row = sheet.getRow(rowvalue);

		XSSFCell cell1 = row.createCell(2);

		cell1.setCellValue(textList.get(0));

		XSSFCell cell2 = row.createCell(3);

		cell2.setCellValue(textList.get(1));

		XSSFCell cell3 = row.createCell(4);

		cell3.setCellValue(textList.get(2));

		FileOutputStream fos = new FileOutputStream(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Tachyon Reports/Daily Report(Tachyon)|"
						+ dateInFormat + ".xlsx");

		wb.write(fos);

		fos.close();

	}

}
