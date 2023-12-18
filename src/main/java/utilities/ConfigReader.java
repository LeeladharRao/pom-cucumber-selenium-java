package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;
	private final String propertiesFilePath = "configs//configuration.properties";

	
	public Properties getConfigReader() throws IOException {
		properties = new Properties();
		FileReader fr = new FileReader(propertiesFilePath);
		properties.load(fr);
		
		return properties;
	}

}
