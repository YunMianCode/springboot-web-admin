package com.springboot.admin.common.exception;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ExceptionBundle {

	private static Map<String, ResourceBundle> resMap = new HashMap();

	private static final ResourceBundle NULL_BUNDLE = new ResourceBundle() {
		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

		@Override
		protected Object handleGetObject(String key) {
			return null;
		}

		@Override
		public String toString() {
			return "NULL_BUNDLE";
		}
	};

	private static ResourceBundle getBundle(String resourceName) {
		ResourceBundle rb = resMap.get(resourceName);
		if (rb == null) {
			try {
				rb = ResourceBundle.getBundle(resourceName, Locale.getDefault());
				if (rb == null) {
					rb = NULL_BUNDLE;
				}
				resMap.put(resourceName, rb);
			} catch (MissingResourceException mre) {
				log.error("No resource property file in the classpath or in the res folder.", mre);
			}
		}
		return rb;
	}

	public static String getString(String key) {
		return getResString("resource", key, null);
	}

	public static String getMessage(String key) {
		return getResString("resource", key, null);
	}

	public static String getString(String key, String defaultValue) {
		return getResString("resource", key, defaultValue);
	}

	public static String getMessage(String key, String defaultValue) {
		return getResString("resource", key, defaultValue);
	}

	public static String getResString(String resourceName, String key) {
		return getResString(resourceName, key, null);
	}

	public static String getResString(String resourceName, String key, String defaultValue) {
		try {
			String value = getBundle(resourceName).getString(key);
			return StrUtil.isBlank(value) ? defaultValue : value.trim();
		} catch (MissingResourceException e) {
			return StrUtil.isBlank(defaultValue) ? key : defaultValue;
		}
	}

}
