package com.witcream.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class JSONUtil {
	public static String fromObject(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (((obj instanceof Boolean)) || ((obj instanceof Integer)) || ((obj instanceof Float))
				|| ((obj instanceof Short)) || ((obj instanceof Double)) || ((obj instanceof Long))
				|| ((obj instanceof BigDecimal)) || ((obj instanceof BigInteger))) {
			json.append(obj);
		} else if (((obj instanceof String)) || ((obj instanceof Byte)) || ((obj instanceof Enum))) {
			json.append("\"").append(fromString(obj.toString())).append("\"");
		} else if ((obj instanceof Object[])) {
			json.append(fromArray((Object[]) obj));
		} else if ((obj instanceof List)) {
			json.append(fromList((List) obj));
		} else if ((obj instanceof Map)) {
			json.append(fromMap((Map) obj));
		} else if ((obj instanceof Set)) {
			json.append(fromSet((Set) obj));
		} else {
			json.append(fromBean(obj));
		}
		return json.toString();
	}

	public static String fromBean(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
		} catch (IntrospectionException localIntrospectionException) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = fromObject(props[i].getName());
					String value = fromObject(props[i].getReadMethod().invoke(bean, new Object[0]));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception localException) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String fromList(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if ((list != null) && (list.size() > 0)) {
			for (Object obj : list) {
				json.append(fromObject(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String fromArray(Object[] array) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if ((array != null) && (array.length > 0)) {
			for (Object obj : array) {
				json.append(fromObject(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String fromMap(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if ((map != null) && (map.size() > 0)) {
			for (Object key : map.keySet()) {
				json.append(fromObject(key));
				json.append(":");
				json.append(fromObject(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String fromSet(Set<?> set) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if ((set != null) && (set.size() > 0)) {
			for (Object obj : set) {
				json.append(fromObject(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String fromString(String s) {
		if (s == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				break;
			default:
				if ((ch >= 0) && (ch <= '\037')) {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
				break;
			}
		}
		return sb.toString();
	}

	private static ScriptEngine engine = null;

	static {
		ScriptEngineManager manager = new ScriptEngineManager();
		engine = manager.getEngineByName("nashorn");
	}

	public static Object parse(String text) throws Exception {
		ScriptObjectMirror mirror = (ScriptObjectMirror) engine.eval("(" + text + ")");
		if (mirror.isArray()) {
			return toArray(new ArrayList(), mirror);
		}
		if (mirror.isExtensible()) {
			return toMap(new HashMap(), mirror);
		}
		return null;
	}

	private static List<Object> toArray(List<Object> container, ScriptObjectMirror mirror) {
		Set<Map.Entry<String, Object>> entrys = mirror.entrySet();
		for (Map.Entry<String, Object> entry : entrys) {
			Object value = entry.getValue();
			if ((value instanceof ScriptObjectMirror)) {
				ScriptObjectMirror o = (ScriptObjectMirror) value;
				if (o.isArray()) {
					container.add(toArray(container, o));
				}
				if (o.isExtensible()) {
					container.add(toMap(new HashMap(), o));
				}
			} else {
				container.add(value);
			}
		}
		return container;
	}

	private static Map<String, Object> toMap(Map<String, Object> container, ScriptObjectMirror mirror) {
		Set<Map.Entry<String, Object>> entrys = mirror.entrySet();
		for (Map.Entry<String, Object> entry : entrys) {
			Object value = entry.getValue();
			if ((value instanceof ScriptObjectMirror)) {
				ScriptObjectMirror o = (ScriptObjectMirror) value;
				if (o.isExtensible()) {
					container.put(entry.getKey(), toMap(new HashMap(), o));
				}
				if (o.isArray()) {
					container.put(entry.getKey(), toArray(new ArrayList(), o));
				}
			} else {
				container.put(entry.getKey(), entry.getValue());
			}
		}
		return container;
	}

	public static void main(String[] args) throws Exception {
		String text = "{a:1}";
		text = "[{a:[1,2]}]";
		text = "{a: [{b:1, c:[2,{c:3}]}]}";
		System.out.println(parse(text));
	}
}
