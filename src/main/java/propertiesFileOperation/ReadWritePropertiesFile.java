package propertiesFileOperation;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class ReadWritePropertiesFile {

    public static void main(String[] args) {
        try{

            // Reading the .properties file
            FileReader fileReader = new FileReader("src/main/resources/application.properties");

            // Creating the Properties obj and loading the file content
            Properties properties = new Properties();
            properties.load(fileReader);

            // Reading/getting the content of .properties file
            String username = properties.getProperty("username");
            System.out.println("username is : "+username);
            String password = properties.getProperty("password");
            System.out.println("password is : "+password);

            // Writing to the properties file
            FileWriter fileWriter = new FileWriter("src/main/resources/application.properties");
            properties.setProperty("url", "www.me.com");
            properties.setProperty("database", "mysql");

            // now storing  above properties to the file
            properties.store(fileWriter, "");
        }
        catch ( Exception e){
            System.err.println("error message : "+ e.getMessage());

        }
    }

}
