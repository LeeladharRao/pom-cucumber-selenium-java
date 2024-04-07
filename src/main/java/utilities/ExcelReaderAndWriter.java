package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.Scenario;

public class ExcelReaderAndWriter {

	static Map<String, String> testDataMaster;
	static Map<String, String> testData;

	public static Map<String, String> ExcelTestDataMasterReader(Scenario scenario) {

		testDataMaster = new HashMap<String, String>();

		String testDataFilePath = System.getProperty("user.dir") + ConfigReader.getProperty("testDataPath");

		try (FileInputStream fis = new FileInputStream(testDataFilePath)) {
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Master");

			// get Feature name header and iterate through to find feature name
			int featureNameRowIndex = 0;
			int featureNameColumnIndex = 0;

			for (Cell cell : sheet.getRow(0)) {
				if (cell.getStringCellValue().equalsIgnoreCase("Tags")) {
					featureNameColumnIndex = cell.getColumnIndex();
				}
			}

			for (Row row : sheet) {
				Cell cell = row.getCell(featureNameColumnIndex);
				if (scenario.getSourceTagNames().toString().contains(cell.getStringCellValue())) {
					featureNameRowIndex = row.getRowNum();
					break;
				}
			}

			// get all cells and save to testdata collection
			Row HeaderRow = sheet.getRow(0);
			Row featureRow = sheet.getRow(featureNameRowIndex);
			for (int i = 1; i < sheet.getRow(featureNameRowIndex).getLastCellNum(); i++) {
				testDataMaster.put(HeaderRow.getCell(i).toString(), featureRow.getCell(i).toString());
			}

			workbook.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return testDataMaster;
	}

	public static Map<String, String> ExcelTestDataFunctionReader(Scenario scenario) {

		testData = new HashMap<String, String>();

		String testDataFilePath = System.getProperty("user.dir") + ConfigReader.getProperty("testDataPath");

		try (FileInputStream fis = new FileInputStream(testDataFilePath)) {
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(testDataMaster.get("Core Function"));

			// get Feature name header and iterate through to find feature name
			int featureNameRowIndex = 0;
			int featureNameColumnIndex = 0;

			for (Cell cell : sheet.getRow(0)) {
				if (cell.getStringCellValue().equalsIgnoreCase("Scenario Name")) {
					featureNameColumnIndex = cell.getColumnIndex();
				}
			}

			for (Row row : sheet) {
				Cell cell = row.getCell(featureNameColumnIndex);
				if (scenario.getName().toString().equalsIgnoreCase(cell.getStringCellValue())) {
					featureNameRowIndex = row.getRowNum();
					break;
				}
			}

			// get all cells and save to testdata collection
			Row HeaderRow = sheet.getRow(0);
			Row featureRow = sheet.getRow(featureNameRowIndex);
			for (int i = 1; i < sheet.getRow(featureNameRowIndex).getLastCellNum(); i++) {
				testData.put(HeaderRow.getCell(i).toString(), featureRow.getCell(i).toString());
			}

			workbook.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return testData;

	}

}
