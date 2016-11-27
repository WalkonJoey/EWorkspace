package com.witcream.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionUtil {
	public static boolean isEmpty(Collection<?> c) {
		return (c == null) || (c.isEmpty());
	}

	public static boolean isNotEmpty(Collection<?> c) {
		return !isEmpty(c);
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null) || (map.isEmpty());
	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}

	public static <T> T[] toArray(Collection<T> collection, T[] array) {
		if (isEmpty(collection)) {
			return array;
		}
		return collection.toArray(array);
	}

	public static <K, V> Map<K, V> wrap(Set<Map.Entry<K, V>> entrys) {
		Map<K, V> wrap = new HashMap<K, V>();
		wrap.entrySet().addAll(entrys);
		return wrap;
	}
}
