package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties getLoadedPropertiesObject() throws IOException {
        //1. Read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        //2. Create the object of Properties Class
        Properties prop = new Properties();

        //3. Load the prop object with file object
        prop.load(fis);

        return prop;
    }

    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }
    public static String getUsernumber() throws IOException {
        return getLoadedPropertiesObject().getProperty("usernumber");
    }
    public static String getPassword() throws IOException {
        return getLoadedPropertiesObject().getProperty("password");
    }

    public static String getNewOnboardingAssociateId() throws IOException {
        return getLoadedPropertiesObject().getProperty("NewOnboardingAssociateId");
    }
    public static String getOldOnboardingAssociateId() throws IOException {
        return getLoadedPropertiesObject().getProperty("OldOnboardingAssociateId");
    }
    public static String getGovtIdMissmatchAssociateId() throws IOException {
        return getLoadedPropertiesObject().getProperty("GovtIdMissmatchAssociateId");
    }
    public static String getRedFlagAssociateId() throws IOException {
        return getLoadedPropertiesObject().getProperty("RedFlagAssociateId");
    }
    public static String getDeleteFingerprintAssociateId() throws IOException {
        return getLoadedPropertiesObject().getProperty("DeleteFingerprintAssociateId");
    }
    public static String getmanualFingerprintAssociateId() throws IOException {
        return getLoadedPropertiesObject().getProperty("manualFingerprintAssociateId");
    }


}

