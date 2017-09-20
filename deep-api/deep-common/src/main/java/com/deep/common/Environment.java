package com.deep.common;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2015/1/24.
 */
public final class Environment {
	
	
	private static final ResourceBundle propertyResource;
	
	static {
		propertyResource = PropertyResourceBundle.getBundle("environment");
	}

	public static String get(String key) {
		return propertyResource.getString(key);
	}

	public static Integer getInteger(String key) {
		return Integer.valueOf(propertyResource.getString(key));
	}
}
