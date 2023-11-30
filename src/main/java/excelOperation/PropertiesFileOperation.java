package excelOperation;

import model.UserCredential;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Properties;

public class PropertiesFileOperation {
    public static void main(String[] args) {
        try {
            File excelFile = new File("/Users/sudeep-macmini/IdeaProjects/mavenProject/src/main/resources/user.xlsx");

            FileInputStream fileInputStream = new FileInputStream(excelFile);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

            UserCredential[] userCredentials = new UserCredential[3];

            userCredentials[0] = new UserCredential("user1", "password1", "user1@example.com");
            userCredentials[1] = new UserCredential("user2", "password2", "user2@example.com");
            userCredentials[2] = new UserCredential("user3", "password3", "user3@example.com");


            if (xssfSheet.getPhysicalNumberOfRows() == 0) {
                // Create header row
                Row headerRow = xssfSheet.createRow(0);
                headerRow.createCell(0).setCellValue("Username");
                headerRow.createCell(1).setCellValue("Password");
                headerRow.createCell(2).setCellValue("Email");
            }

            for (int i = 0; i < 3; i++) {
                Row row;
                if (xssfSheet.getLastRowNum() == 0) {
                    row = xssfSheet.createRow(i);
                } else {
                    row = xssfSheet.createRow(xssfSheet.getLastRowNum() + 1);
                }

                for (int j = 0; j < 3; j++) {
                    Cell cell = row.createCell(j);

                    switch (j) {
                        case 0:
                            cell.setCellValue(userCredentials[i].getUserName());
                            break;
                        case 1:
                            cell.setCellValue(userCredentials[i].getPassWord());
                            break;
                        case 2:
                            cell.setCellValue(userCredentials[i].getEmail());
                            break;



                    }
                }
                System.out.println();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(excelFile);
            xssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Successfully saved data into excel!!");

            // Reading the .properties file
            FileReader fileReader = new FileReader("src/main/resources/newapp.properties");
            Properties properties = new Properties();
            properties.load(fileReader);

            // Writing to the properties file
            FileWriter fileWriter = new FileWriter("src/main/resources/newapp.properties");

            // now storing the above properties to the file
            for (UserCredential user : userCredentials) {
                properties.setProperty("Username", user.getUserName());
                properties.setProperty("Password", user.getPassWord());

                properties.setProperty("Email", user.getEmail());

                properties.store(fileWriter, "");
            }
            fileWriter.close();

            System.out.println("successfully saved to properties file");



        } catch (Exception e) {
            System.err.println("Error message: " + e.getMessage());
        }
    }
}
