package com.aries.line.util;

import com.aries.extension.util.PropertyUtil;
import com.aries.line.entity.LineProp;


/**
 * Load adapter configuration
 */
public class ConfUtil {

	private static final LineProp lineProperties = new LineProp();


	/**
	 * The adapter ID
	 */
	private static final String ADAPTER_ID = "line";
	
	/**
	 * Get a configuration value using the provided key
	 * @param key configuration key. Set this key value in the adapter configuration menu in JENNIFER client.
	 * @param defaultValue Optional default configuration value
	 * @return String configuration value
	 */
	public static String getValue(String key, String defaultValue){
		return PropertyUtil.getValue(ADAPTER_ID, key, defaultValue);
	}

	/**
	 * Get the slack properties
	 * @return SlackProp slack properties
	 */
	public static LineProp getProperties() {
		lineProperties.setLineToken(getValue("line_token", null));
		lineProperties.setStickerPackageId(getValue("stickerPackageId", ""));
		lineProperties.setStickerId(getValue("stickerId", ""));
		lineProperties.setNotificationDisabled(getValue("notificationDisabled", "false"));
		lineProperties.setEventLevel(getValue("eventLevel", "NORMAL"));
	
		return  lineProperties;
	}

	public static LineProp _getProperties() {
		lineProperties.setLineToken(getValue("line_token", "Jn37oXACTmDY7WwXvMrOlruHjOrfVMc5QXRJ809pptt"));
		lineProperties.setStickerPackageId(getValue("stickerPackageId", ""));
		lineProperties.setStickerId(getValue("stickerId", ""));
		lineProperties.setNotificationDisabled(getValue("notificationDisabled", "false"));
		lineProperties.setEventLevel("FATAL");
	
		return  lineProperties;
	}
}

