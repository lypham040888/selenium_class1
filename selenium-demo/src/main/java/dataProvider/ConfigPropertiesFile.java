package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.google.common.io.Files;

public class ConfigPropertiesFile {
	private static Properties properties = new Properties();
	static String projectPath = System.getProperty("user.dir");
	private final static String propertyFilePath = projectPath + "//Configs//TestData.properties";

	public ConfigPropertiesFile() {
		// TODO Auto-generated constructor stub
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		// load properties file
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot load data for Configuration.properties at " + propertyFilePath);
		}
	}

	// Get Properties value by key
	public String getProperties(String key) {
		String value = properties.getProperty(key);
		if (value != null) {
			return value;
		} else {
			throw new RuntimeException(key + " is not specified in the Configuration.properties file.");
		}
	}

}
