package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.Constants;
import managers.LogManager;

public class ConfigReader {


	public static Properties getConfigReader() throws IOException {
		Properties properties = new Properties();
		FileReader fr = new FileReader(Constants.ConfigConstants.PROPERTIES_FILE_PATH);
		properties.load(fr);

		return properties;
	}

	public static String getProperty(String prop) {
		String propValue = null;
		try {
			if (ConfigReader.getConfigReader().getProperty(prop) != null) {
				propValue = ConfigReader.getConfigReader().getProperty(prop);
			} else {
				// assert
			}
		} catch (IOException e) {
			LogManager.logErrorMessage(e);
		}

		return propValue;
	}

}
