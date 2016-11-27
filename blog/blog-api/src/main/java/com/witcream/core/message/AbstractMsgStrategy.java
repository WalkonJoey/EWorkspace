package com.witcream.core.message;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.witcream.core.WorkXml;

public abstract class AbstractMsgStrategy {
	protected abstract WorkXml createMsgBody(Map<String, Object> paramMap);

	protected WorkXml createItemsBody(List<Map<String, Object>> params) {
		if ((Objects.isNull(params)) || (params.isEmpty())) {
			return null;
		}
		WorkXml body = new WorkXml("body");
		for (Map<String, Object> map : params) {
			WorkXml item = new WorkXml("item");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (Objects.nonNull(entry.getValue())) {
					item.addTextChildNode((String) entry.getKey(), String.valueOf(entry.getValue()));
				}
			}
			body.addChildNode(item);
		}
		return body;
	}
}
