package newCore.properties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PlatformProperties {

	private Properties properties = null;
	private String dellHomePageURL;
	private String microsoftHomePageURL;


	private Map<String, String> platformProperties = new HashMap<String, String>();

	public PlatformProperties() throws IOException{
		readPlatformProperties();
	}

	private void readPlatformProperties() throws IOException{
		properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("PlatformInformation.properties"));

		setDellHomePageURL(properties.getProperty("dellHomePageURL"));
		setMicrosoftHomePageURL(properties.getProperty("microsoftHomePageURL"));

		Set<Object> keys = properties.keySet();
		for(Object obj : keys){
			String key = obj.toString();
			platformProperties.put(key, properties.getProperty(key));
		}
	}

	public void setValue(String key, String value){
		platformProperties.put(key, value);
	}

	public String getValue(String key){
		return platformProperties.get(key);
	}

	public String getDellHomePageURL(){
		return dellHomePageURL;
	}

	public void setDellHomePageURL(final String dellHomePageURL){
		this.dellHomePageURL = dellHomePageURL;
	}

	public String getMicrosoftHomePageURL() {
		return microsoftHomePageURL;
	}

	public void setMicrosoftHomePageURL(String microsoftHomePageURL) {
		this.microsoftHomePageURL = microsoftHomePageURL;
	}


}
