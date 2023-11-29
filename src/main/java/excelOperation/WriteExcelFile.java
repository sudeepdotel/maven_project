package excelOperation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

public class WriteExcelFile {
    public static void main(String[] args){
        try{
            File file = new File("/Users/sudeep-macmini/IdeaProjects/mavenProject/src/main/resources/test.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            System.out.println(xssfSheet.getLastRowNum());

            for (int i = 0; i < 2; i++) {
                Row row;
                if (xssfSheet.getLastRowNum() == 0) {
                    row = xssfSheet.createRow(i);
                } else {
                    row = xssfSheet.createRow(xssfSheet.getLastRowNum() + 1);
                }
                for(int j = 0; j < 3; j++) {
                    Cell cell = row.createCell(j);
                    switch (j) {
                        case 0:
                            if (i == 0) {
                                cell.setCellValue("Hi");
                            } else {
                                cell.setCellValue("Everyone");
                            }
                            break;
                        case 1:
                            if (i == 0) {
                                cell.setCellValue(431);
                            } else {
                                cell.setCellValue(456);
                            }
                            break;
                        case 2:
                            if (i == 0) {
                                cell.setCellValue(false);
                            } else {
                                cell.setCellValue(true);
                            }
                            break;
                    }
                }
            }

            //write back to excel
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            xssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Successfully Save data into excel!!");

        } catch ( Exception e){
            System.out.println(e.getMessage());
        }


    }
}
