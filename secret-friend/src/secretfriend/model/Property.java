package secretfriend.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author andre.almeida
 */
public class Property {

	/**  */
	private static final String DEVELOPER_MODE_ON = "developermodeon";
	/**  */
	private static final String DEVELOPER_MAIL = "developermail";
	/**  */
	private static final String MIN_VALUE = "minvalue";
	/**  */
	private static final String MAX_VALUE = "maxvalue";
	/**  */
	private static final String DATE = "date";
	/**  */
	private static final String SUBJECT = "subject";

	/** Instância única */
	private static Property instance;
	
	/**  */
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * @return
	 */
	private static Property instance() {
		if (instance == null) {
			instance = new Property();
		}
		return instance;
	}

	private Properties properties;
	
	/**
	 * @return
	 */
	public static Boolean isDeveloperModeOn() {
		return Boolean.valueOf(instance().getProperty(DEVELOPER_MODE_ON));
	}
	
	/**
	 * @return
	 */
	public static String getDeveloperEmail() {
		return instance().getProperty(DEVELOPER_MAIL);
	}
	
	/**
	 * @return
	 */
	public static Double getMinValue() {
		return Double.valueOf(instance().getProperty(MIN_VALUE));
	}
	
	/**
	 * @return
	 */
	public static Double getMaxValue() {
		return Double.valueOf(instance().getProperty(MAX_VALUE));
	}
	
	/**
	 * @return
	 */
	public static Date getDate() {
		try {
			return FORMAT.parse(instance().getProperty(DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return
	 */
	public static String getSubject() {
		return instance().getProperty(SUBJECT);
	}
	
	/**
	 * 
	 */
	private Property() {
		loadProperties();
	}
	
	/**
	 * 
	 */
	private void loadProperties() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream("preferences.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param key
	 * @return
	 */
	private String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
