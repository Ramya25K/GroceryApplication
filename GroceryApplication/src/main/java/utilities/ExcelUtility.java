package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook wb;// wb Object to access the entire Excel workbook
	public static XSSFSheet sh;// sh Object to access a specific sheet in the workbook
	public static FileInputStream f;// f Object to open and read the file input stream ( Reads the actual Excel file
									// from the file system.)

	public static String getStringData(int i, int j, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\LoginData.xlsx");// +is concatenate to get files from our path
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int i, int j, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\LoginData.xlsx");// +is concatenate to get files from our path
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
	}

	public static ArrayList<String> getString(String sheet, int rowno) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\LoginData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		ArrayList<String> excelRows = new ArrayList<String>();
		Row r = sh.getRow(rowno);
		int cellcount = r.getLastCellNum();
		for (int j = 0; j < cellcount; j++) {
			excelRows.add(r.getCell(j).getStringCellValue());
		}
		return excelRows;
	}

}
