package com.witcream.core.message;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.witcream.core.WorkXml;
import com.witcream.core.security.WorkSecurityStrategy;
import com.witcream.util.DateUtil;
import com.witcream.util.StringUtil;

public class WorkMsg {
	private final String id;
	private final WorkXml message;

	public WorkMsg(String id) {
		this(id, (WorkXml) null);
	}

	public WorkMsg(String id, WorkXml body) {
		this(id, body, (WorkSecurityStrategy) null);
	}

	public WorkMsg(String id, WorkXml body, WorkSecurityStrategy securityStrategy) {
		this.id = id;
		this.message = new WorkXml("req");
		this.message.addChildNode(builderHeaderNode());
		this.message.addChildNode(body);
		if (Objects.nonNull(securityStrategy)) {
			WorkXml encryptKey = securityStrategy.defaultWorkSecurityStrategy()
					.createSecurityStrategy(securityStrategy.getKey(), securityStrategy.getEncrypt(), this.message);
			this.message.getXpathNode("req.head").addChildNode(encryptKey);
		}
	}

	public WorkMsg(String id, Map<String, Object> params) {
		this(id, params, defaultWorkMsgStrategy());
	}

	public WorkMsg(String id, Map<String, Object> params, AbstractMsgStrategy strategy) {
		this(id, params, strategy, (WorkSecurityStrategy) null);
	}

	public WorkMsg(String id, Map<String, Object> params, WorkSecurityStrategy securityStrategy) {
		this(id, params, defaultWorkMsgStrategy(), securityStrategy);
	}

	public WorkMsg(String id, Map<String, Object> params, AbstractMsgStrategy msgStrategy,
			WorkSecurityStrategy securityStrategy) {
		this.id = id;
		this.message = new WorkXml("req");
		this.message.addChildNode(builderHeaderNode()).addChildNode(msgStrategy.createMsgBody(params));
		if (Objects.nonNull(securityStrategy)) {
			WorkXml encryptKey = securityStrategy.defaultWorkSecurityStrategy()
					.createSecurityStrategy(securityStrategy.getKey(), securityStrategy.getEncrypt(), this.message);
			this.message.getXpathNode("req.head").addChildNode(encryptKey);
		}
	}

	public WorkMsg(String id, List<Map<String, Object>> params) {
		this(id, params, defaultWorkMsgStrategy(), (WorkSecurityStrategy) null);
	}

	public WorkMsg(String id, List<Map<String, Object>> params, WorkSecurityStrategy securityStrategy) {
		this(id, params, defaultWorkMsgStrategy(), securityStrategy);
	}

	public WorkMsg(String id, List<Map<String, Object>> params, AbstractMsgStrategy strategy) {
		this(id, params, strategy, (WorkSecurityStrategy) null);
	}

	public WorkMsg(String id, List<Map<String, Object>> params, AbstractMsgStrategy msgStrategy,
			WorkSecurityStrategy securityStrategy) {
		this.id = id;
		this.message = new WorkXml("req");
		this.message.addChildNode(builderHeaderNode());
		this.message.addChildNode(msgStrategy.createItemsBody(params));
		if (Objects.nonNull(securityStrategy)) {
			WorkXml encryptKey = securityStrategy.defaultWorkSecurityStrategy()
					.createSecurityStrategy(securityStrategy.getKey(), securityStrategy.getEncrypt(), this.message);
			this.message.getXpathNode("req.head").addChildNode(encryptKey);
		}
	}

	private WorkXml builderHeaderNode() {
		return new WorkXml("head").addTextChildNode("cmd", this.id).addTextChildNode("seq",
				DateUtil.formatCurDate("yyyyMMddHHmmssSSS"));
	}

	public static AbstractMsgStrategy defaultWorkMsgStrategy() {
		return new DefaultWorkMsgStrategy();
	}

	private static class DefaultWorkMsgStrategy extends AbstractMsgStrategy {
		protected WorkXml createMsgBody(Map<String, Object> params) {
			if ((Objects.isNull(params)) || (params.isEmpty())) {
				return null;
			}
			WorkXml bodyNode = new WorkXml("body");
			Set<Map.Entry<String, Object>> set = params.entrySet();
			for (Map.Entry<String, Object> entry : set) {
				Object value = entry.getValue();
				if ((Objects.nonNull(value)) && (StringUtil.isNotBlank(String.valueOf(value)))) {
					bodyNode.addChildNode(
							new WorkXml(((String) entry.getKey()).trim()).setTextValue(String.valueOf(value)));
				}
			}
			return bodyNode;
		}
	}

	public String getId() {
		return this.id;
	}

	public WorkXml getMessage() {
		return this.message;
	}
}
