package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {
        //1. Read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        //2. Create the object of Properties Class
        Properties prop = new Properties();

        //3. Load the prop object with file object
        prop.load(fis);

        //4. read the value of the key using prop object & getProperty() method
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("usernumber"));
        System.out.println(prop.getProperty("password"));

    }
}
