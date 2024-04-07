package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.Constants;
import managers.LogManager;

public class ConfigReader {

	private static Properties properties;
	private final static String propertiesFilePath = Constants.ConfigConstants.PROPERTIES_FILE_PATH;

	public static Properties getConfigReader() throws IOException {
		properties = new Properties();
		FileReader fr = new FileReader(propertiesFilePath);
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
