package ru.sib.exam.framework.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class ExcelUtils {

    private XSSFSheet excelWSheet;
    private XSSFWorkbook excelWBook;
    private XSSFCell cell;
    private XSSFRow row;


    public Object[][] getTableArray(String filePath, String sheetName) {

        String[][] tabArray = null;

        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);

            int startRow = 0;
            int startCol = 0;

            int ci, cj;

            int totalRow = excelWSheet.getLastRowNum() + 1;
            int totalCols = 6;

            tabArray = new String[totalRow][totalCols];
            ci = 0;
            for (int i = startRow; i < totalRow; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                }
            }
            excelWBook.close();
            excelFile.close();

        } catch (Exception e) {

        }
        return tabArray;
    }

    public String getCellData(int RowNum, int ColNum) {

        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            String cellData;
            if (cell.getCellType() == 0) {
                cellData = String.valueOf(cell.getNumericCellValue());
                cellData = cellData.substring(0, cellData.length() - 2);
            } else {
                cellData = cell.getStringCellValue();
            }
            return cellData;
        } catch (Exception e) {

        }
        return null;
    }


}
