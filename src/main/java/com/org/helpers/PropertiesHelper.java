package com.org.helpers;

import com.org.utils.LogManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static final String relPropertiesFilePathDefault = "src/test/resources/config/config.properties";

    public static Properties loadAllProps() {
        LinkedList<String> files = new LinkedList<>();
        files.add("src/test/resources/config/config.properties");

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProps = new Properties();
                linkFile = SystemHelpers.getCurrentDir() + f;
                fis = new FileInputStream(linkFile);
                tempProps.load(fis);
                properties.putAll(tempProps);
            }
            fis.close();
            LogManager.info("Loaded all properties.");
            LogManager.info(properties);
            return new Properties();
        } catch (IOException e) {
            LogManager.warn("Cannot Load all properties");
            return new Properties();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
            fis = new FileInputStream(linkFile);
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            LogManager.warn("Cannot set default properties file");
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = "";
        try {
            if (fis == null && properties == null) {
                setDefaultFile();
            }
            value = properties.getProperty(key);
            return value;
        } catch (Exception e) {
            LogManager.warn(e.getMessage());
            return value;
        }
    }

}
