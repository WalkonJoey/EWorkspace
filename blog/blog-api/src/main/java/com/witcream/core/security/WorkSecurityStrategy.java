package com.witcream.core.security;

import com.witcream.core.WorkEncrypt;
import com.witcream.core.WorkXml;
import com.witcream.util.StringUtil;

public class WorkSecurityStrategy {
	private static final String DEFAULT_ENCRYPT = "MD5";
	private final String key;
	private final String encrypt;

	public String getKey() {
		return this.key;
	}

	public String getEncrypt() {
		return StringUtil.isBlank(this.encrypt) ? "MD5" : this.encrypt;
	}

	public WorkSecurityStrategy(String key) {
		this(key, "MD5");
	}

	public WorkSecurityStrategy(String key, String encrypt) {
		this.key = key;
		this.encrypt = encrypt;
	}

	public AbstractSecurityStrategy defaultWorkSecurityStrategy() {
		return new DefaultWorkSecurityStrategy();
	}

	private static class DefaultWorkSecurityStrategy extends AbstractSecurityStrategy {
		public WorkXml createSecurityStrategy(String key, String rule, WorkXml reqXml) {
			WorkXml encryptKey = new WorkXml("key");
			if ((StringUtil.isNotBlank(rule)) && ("MD5".equalsIgnoreCase(rule))) {
				encryptKey.setTextValue(WorkEncrypt.encryptMd5(WorkEncrypt.encryptMd5(reqXml.toString()) + key));
			}
			return encryptKey;
		}
	}
}
