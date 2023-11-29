package textFileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWriteTextFile {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/input.txt");
            //to read data from file
            FileInputStream fileInputStream = new FileInputStream(file);
            int c;
            String inputData = "";
            //reading data from text file
            while ((c = fileInputStream.read()) != -1) {
                //System.out.println(c);
                inputData = inputData + (char)c;
            }
            System.out.println("Received Data : "+ inputData);
            inputData = inputData.trim() + " -- Ok Fine.."; //.trim() helps to remove extra space at the end of a string
            System.out.println("Updated Data :" +inputData);

            //write back data to file
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(inputData.getBytes()); //convert back from string to bytes (set of Ascii value)
            System.out.println("Write back to file successfully!!");
            outputStream.close();

            FileOutputStream outputStream1 = new FileOutputStream("src/main/resources/input.txt");
            outputStream1.write(inputData.getBytes()); //convert back from string to bytes (set of Ascii value)
            System.out.println("Write back to file successfully!!");
            outputStream1.close();
        } catch(Exception e) {
            System.err.println("Error Details ::" +e.getMessage());
        }
    }
}
