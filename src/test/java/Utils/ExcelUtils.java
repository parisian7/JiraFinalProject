package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    /*
    OpenExcel(String fileName, String sheetNumber);
    getValue(int rowNum, int cellNum); ->will return value as String
    setValue(String value, int rowNum, int cellNum); -> no return
    getNumberOfRows(); ->return int as a number of rows

     */

    private static String filePath;
    private static Workbook workbook;
    private static Sheet sheet;
    private static Row  row;
    private static Cell cell;

    /**
     * This method will open Excel file with provided excel file name and sheet name.
     * @param fileName
     * @param sheetName
     */
    public static void openExcel(String fileName, String sheetName){
    filePath = "src/test/resources/data/"+fileName+".xlsx";

    try {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        workbook=new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    }

    /**
     * This method will provide the value on specified row number and cell number.
     * @param rowNum
     * @param cellNum
     * @return
     */
    public static String getValue(int rowNum, int cellNum){
        return sheet.getRow(rowNum).getCell(cellNum).toString();
    }
    public static void setValue(String value, int rowNum, int cellNum) throws IOException {

        try {
            row=sheet.getRow(rowNum);
            cell = row.getCell(cellNum);
            cell.setCellValue(value);
        }catch (NullPointerException e){
            cell =sheet.createRow(rowNum).createCell(cellNum);
            cell.setCellValue(value);
        }
        FileOutputStream outputStream= new FileOutputStream(new File(filePath));
        workbook.write(outputStream);
        outputStream.close();

    }

    /**
     * It will return number of cells on specified row.
     * @return
     */
    public static int getNumberOfCells(int rowNum){
        try {
            return sheet.getRow(rowNum).getPhysicalNumberOfCells();
        }catch (NullPointerException e ){
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
