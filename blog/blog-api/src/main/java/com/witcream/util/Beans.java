package com.witcream.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Beans {
	public static Map<String, Object> mapVal(Object bean) {
		Map<String, Object> map = new HashMap<String, Object> ();
		if (Objects.nonNull(bean)) {
			try {
				BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
				for (PropertyDescriptor property : propertyDescriptors) {
					String key = property.getName();
					Method getter = property.getReadMethod();
					Object value = getter.invoke(bean, new Object[0]);
					map.put(key, value);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	public static Map<String, Object> mapValUnderlineLowerCase(Object bean) {
		Map<String, Object> map = new HashMap<String, Object> ();
		if (Objects.nonNull(bean)) {
			try {
				BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
				for (PropertyDescriptor property : propertyDescriptors) {
					String key = property.getName().replaceAll("([A-Z$_]+)", "_$1").toLowerCase();
					Method getter = property.getReadMethod();
					Object value = getter.invoke(bean, new Object[0]);
					map.put(key, value);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return map;
	}
}
