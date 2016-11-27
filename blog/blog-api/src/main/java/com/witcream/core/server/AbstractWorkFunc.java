package com.witcream.core.server;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.witcream.core.WorkXml;
import com.witcream.util.StringUtil;

public class AbstractWorkFunc {
	private WorkXml reqXml;
	private String code;
	private String msg;
	private WorkXml respBody;

	public void setXmlBody(WorkXml xmlBody) {
		this.respBody = xmlBody;
	}

	public void setMapBody(Map<String, Object> map) {
		if ((Objects.isNull(map)) || (map.isEmpty())) {
			return;
		}
		this.respBody = new WorkXml("body");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if ((Objects.nonNull(entry.getValue())) && (!String.valueOf(entry.getValue()).equals(""))) {
				this.respBody.addTextChildNode((String) entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
	}

	public void setListBody(List<Map<String, Object>> items) {
		if ((Objects.isNull(items)) || (items.isEmpty())) {
			return;
		}
		this.respBody = new WorkXml("body");
		for (Map<String, Object> item : items) {
			WorkXml itemXml = new WorkXml("item");
			for (Map.Entry<String, Object> entry : item.entrySet()) {
				if ((Objects.nonNull(entry.getValue())) && (!String.valueOf(entry.getValue()).equals(""))) {
					itemXml.addTextChildNode((String) entry.getKey(), String.valueOf(entry.getValue()));
				}
			}
			this.respBody.addChildNode(itemXml);
		}
	}

	public void setPagerBody(List<Map<String, Object>> items, Map<String, Object> total) {
		this.respBody = new WorkXml("body");
		if (items != null) {
			for (Map<String, Object> item : items) {
				WorkXml itemXml = new WorkXml();
				for (Map.Entry<String, Object> entry : item.entrySet()) {
					if ((Objects.nonNull(entry.getValue())) && (!String.valueOf(entry.getValue()).equals(""))) {
						itemXml.addTextChildNode((String) entry.getKey(), String.valueOf(entry.getValue()));
					}
				}
				this.respBody.addChildNode(itemXml);
			}
		}
		this.respBody.addTextChildNode("total_count", total.get("total_count").toString());
	}

	public void setStringBody(String body) {
		if (StringUtil.isBlank(body)) {
			return;
		}
		this.respBody = new WorkXml("body").setTextValue(body);
	}

	public WorkXml getRespBody() {
		return this.respBody;
	}

	public WorkXml getReqXml() {
		return this.reqXml;
	}

	public void setReqXml(WorkXml reqXml) {
		this.reqXml = reqXml;
	}

	public String getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setCodeMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int processor() {
		return 0;
	}
}
