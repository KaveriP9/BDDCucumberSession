package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//alt+shift+j

/**
 * @author Kaveri
 * This method is return the object of properties class
 */
public class ReadProperties {
	public static Properties loadProperties() {
		// Open the File
		File objfile = new File("AppConfig/config.properties");
		// Read the File

		FileInputStream objfis = null;
		try {
			objfis = new FileInputStream(objfile);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}

		Properties objprop = new Properties();
		try {
			objprop.load(objfis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return objprop;

	}
	/**
	 * @return This method will Read implicit wait time from config file
	 */
	public static long implicitWaitTime() {

		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));
	}

	/**
	 * @return This method will Read return userName from config File
	 */
	public static String getAppUserName() {
		return loadProperties().getProperty("userName");
	}
	/**
	 * @return
	 * @throws IOException
	 *             This method will read app url form config file
	 */
	public static String getappURL()  {

		return loadProperties().getProperty("appURL");
	}

	/**
	 * @return This method will read password from config file
	 */
	public static String getAppPassword() {
		return loadProperties().getProperty("password");
	}

	/**
	 * @return This will return fluent wait time
	 */
	public static long getFluentWaitTime() {

		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));
	}

}
