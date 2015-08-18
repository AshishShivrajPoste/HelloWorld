package com.triplepoint.carworkshop.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.triplepoint.carworkshop.constants.WorkShopConstants;

/***
* PropertyReader class is a Singelton class used to read properties 
* from configuration file config.properties.
* in descending order.
* @author : Ashish S Poste
* @since  : 
*/
public class PropertyReader {

	private Properties propertyReader;
	private static PropertyReader propertyReaderInstance;
	private InputStream input; 
	private PropertyReader(){
		propertyReader = new Properties();
		try {
////			input = new FileInputStream(WorkShopConstants.CONFIGURATION_FILE_PATH);
//			input = new FileInputStream(getClass().getResourceAsStream(WorkShopConstants.CONFIGURATION_FILE_PATH));
//			input  = new FileInputStream(new F)
//			
//			
//			getClass().getResourceAsStream("/database.properties");
			
			Properties props = new Properties();
			try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(WorkShopConstants.CONFIGURATION_FILE_PATH)) {
				propertyReader.load(resourceStream);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Returns the Singelton instance of PropertyReader class.
	 * @return : instance of PropertyReader
	 */
	public static PropertyReader getInstance(){
		if(propertyReaderInstance == null){
			synchronized (PropertyReader.class) {
				if(propertyReaderInstance == null){
					propertyReaderInstance = new PropertyReader();
				}
			}
		}
		return propertyReaderInstance;
	}
	/***
	 * Return the property Value for the property Name provided
	 * @param propertyName : String property value from config.properties file
	 * @return
	 */
	public String getPropertyString(String propertyName){
		return propertyReader.getProperty(propertyName);
	}
	/***
	 * Return the property Value for the property Name provided
	 * @param propertyName : Int property value from config.properties file
	 * @return
	 */
	public int getPropertyInt(String propertyName){
		return Integer.parseInt(propertyReader.getProperty(propertyName));
	}
}
