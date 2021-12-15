package webTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class DataProvider {
    public String configFilePath() {
        String userWorkingDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        return userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" +
                pathSeparator + "java" + pathSeparator + "webTable" + pathSeparator + "config.properties";
    }

    public Properties getPropertiesObject() {
        Properties property = new Properties();
        try {
            FileInputStream file = new FileInputStream(configFilePath());
            property.load(file);
        } catch (FileNotFoundException exception) {
            System.out.println("The specified file is not present in the given path.");
        } catch (IOException exception) {
            System.out.println("Check the file in the specified path.");
        }
        return property;
    }

    public String getStructureName() {
        return getPropertiesObject().getProperty("structureName");
    }

    public int getExpectedColumnCountInSixthRow() {
        return Integer.parseInt(getPropertiesObject().getProperty("expectedColumnCountInSixthRow"));
    }
}
