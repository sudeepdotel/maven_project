package excelOperation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RemoveLastRow {

    public static void main(String[] args) {
        File file = new File("/Users/sudeep-macmini/IdeaProjects/mavenProject/src/main/resources/testEmployee.xlsx");
        removeLastRow(file);
    }

    public static void removeLastRow(File file) {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
             XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

            XSSFSheet sheet = xssfWorkbook.getSheetAt(0); // first sheet

            // Check if the last header column is "Employee Monthly Salary"
            String headerValue = getHeaderValue(sheet.getRow(0), sheet.getRow(0).getLastCellNum() - 1);
            if (headerValue != null && headerValue.equals("Employee Monthly Salary")) {

                // Delete the last row using .removeRow method
                int lastRowNum = sheet.getLastRowNum();
                if (lastRowNum >= 0) {
                    Row lastRow = sheet.getRow(lastRowNum);
                    sheet.removeRow(lastRow);
                }

                // Save the changes back to the Excel file
                try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                    xssfWorkbook.write(fileOutputStream);
                }

                System.out.println("Last row removed successfully!");
            } else {
                System.out.println("Last column header is not 'Employee Monthly Salary'. Skipping removal of the last row.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getHeaderValue(Row headerRow, int columnIndex) {
        if (headerRow != null && columnIndex >= 0 && columnIndex < headerRow.getLastCellNum()) {
            Cell headerCell = headerRow.getCell(columnIndex);

            if (headerCell != null) {
                if (headerCell.getCellType() == CellType.STRING) {
                    return headerCell.getStringCellValue();
                } else if (headerCell.getCellType() == CellType.NUMERIC) {
                    return String.valueOf(headerCell.getNumericCellValue());
                }
            }
        }
        return null;
    }
}
