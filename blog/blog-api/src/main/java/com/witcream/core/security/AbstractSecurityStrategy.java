package com.witcream.core.security;

import com.witcream.core.WorkXml;

public abstract class AbstractSecurityStrategy {
	public abstract WorkXml createSecurityStrategy(String paramString1, String paramString2, WorkXml paramWorkXml);
}