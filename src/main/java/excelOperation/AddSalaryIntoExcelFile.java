package excelOperation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class AddSalaryIntoExcelFile {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/sudeep-macmini/IdeaProjects/mavenProject/src/main/resources/employee.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            int numberOfSheet = xssfWorkbook.getNumberOfSheets();
            System.out.println(numberOfSheet);

            XSSFSheet sheet = xssfWorkbook.getSheetAt(0); // first sheet

            // Adding new column "Employee Monthly Salary"
            Row rowForHeader = sheet.getRow(0);
            Cell colForHeader = rowForHeader.createCell(rowForHeader.getLastCellNum());
            colForHeader.setCellValue("Employee Monthly Salary");


            // Iterate through each row starting from the second row (skipping header)
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                // getting employee experience column value
                int experience = (int) row.getCell(4).getNumericCellValue();

                // Calculate salary based on experience
                double salary = calculateSalary(experience);

                System.out.println(salary);

                // Add the calculated salary to the new column
                Cell salaryCell = row.createCell(row.getLastCellNum());
                salaryCell.setCellValue(salary);


            }

            // Save the changes back to the Excel file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            xssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();

            System.out.println("Successfully saved data into excel!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double calculateSalary(int experience) {
        // Calculate salary based on experience
        if (experience < 5) {
            return 1000 * 5;
        } else if (experience < 10) {
            return 2500 * 5;
        } else if (experience < 20) {
            return 5000 * 5;
        } else {
            return 8000 * 5;
        }
    }
}
