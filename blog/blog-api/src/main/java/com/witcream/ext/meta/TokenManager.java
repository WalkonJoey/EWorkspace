package com.witcream.ext.meta;

import java.util.Map;

public interface TokenManager {
	public abstract String builder(Map<String, Object> paramMap);

	public abstract boolean verify(String paramString);

	public abstract void remove(String paramString);

	public abstract String update(String paramString);
}
