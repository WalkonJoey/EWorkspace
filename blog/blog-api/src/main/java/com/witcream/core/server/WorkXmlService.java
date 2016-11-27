package com.witcream.core.server;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;

import com.witcream.core.Assert;
import com.witcream.core.WorkEncrypt;
import com.witcream.core.WorkStAX;
import com.witcream.core.WorkXml;
import com.witcream.util.DateUtil;
import com.witcream.util.LogUtil;
import com.witcream.util.StringUtil;

public class WorkXmlService extends AbstractWorkService<WorkXml> {
	private static final Logger logger = LogUtil.slfLogger();
	private static final String BEANS_XML_NAME = "/beans.xml";
	private static final String REQ_HEAD_KEY = "req.head.key";
	private static final String KEY;
	private static final Map<String, WorkXml> ATTRS = new HashMap<String, WorkXml>();
	private WorkXml reqXml;
	private final String cmd;

	static {
		InputStream inXml = null;
		inXml = WorkXmlService.class.getResourceAsStream(BEANS_XML_NAME);
		Assert.notNull(inXml, "not found file beans.xml");
		WorkXml beans = WorkStAX.parse(inXml);
		
		Assert.notNull(beans, "beans.xml must be not empty");
		
		List<WorkXml> beansList = beans.allChildNode("bean");
		for (WorkXml bean : beansList) {
			String id = (String) bean.getAttrs().get("id");
			Assert.isNotBlank(id, "bean.id must not empty");
			ATTRS.put(id, bean);
		}
		KEY = (String) beans.getAttrs().get("key");
		if (inXml != null) {
			try {
				inXml.close();
			} catch (Exception localException1) {
			}
		}
	}

	public WorkXmlService(String content) {
		this.reqXml = WorkStAX.parse(new ByteArrayInputStream(content.getBytes()));
		this.cmd = this.reqXml.getXpathNode("req.head.cmd").getTextValue();
	}

	public WorkXml service() {
		if (!check()) {
			return warnXml();
		}
		return sucXml();
	}

	private boolean check() {
		if (StringUtil.isBlank(this.cmd)) {
			return false;
		}
		String key = this.reqXml.getXpathNode(REQ_HEAD_KEY).getTextValue();
		this.reqXml.removeXpath(REQ_HEAD_KEY);
		String vKey = "";
		if (StringUtil.isNotBlank(KEY)) {
			vKey = WorkEncrypt.encryptMd5(WorkEncrypt.encryptMd5(this.reqXml.toString()) + KEY);
			if (logger.isDebugEnabled()) {
				logger.debug("<== check keys: {}, {}, {}",
						new Object[] { Boolean.valueOf(key.equals(vKey)), key, vKey });
			}
		}
		return vKey.equals(key);
	}

	private WorkXml warnXml() {
		WorkXml head = new WorkXml("head").addTextChildNode("cmd", this.cmd)
				.addTextChildNode("seq", DateUtil.formatCurDate("yyyyMMddHHmmssSSS")).addTextChildNode("code", "503")
				.addTextChildNode("msg", "Permission denied");

		WorkXml warnXml = new WorkXml("resp").addChildNode(head);
		if (StringUtil.isNotBlank(KEY)) {
			String vKey = WorkEncrypt.encryptMd5(WorkEncrypt.encryptMd5(warnXml.toString()) + KEY);
			head.addTextChildNode("key", vKey);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("==> WARN Respond: {}", warnXml.toString());
		}
		return warnXml;
	}

	private WorkXml sucXml() {
		WorkXml head = new WorkXml("head").addTextChildNode("cmd", this.cmd).addTextChildNode("seq",
				DateUtil.formatCurDate("yyyyMMddHHmmssSSS"));

		WorkXml sucXml = new WorkXml("resp");

		WorkXml beanXml = (WorkXml) ATTRS.get(this.cmd);
		if (beanXml == null) {
			return nonXml();
		}
		String clzName = (String) beanXml.getAttrs().get("class");
		try {
			@SuppressWarnings("unchecked")
			Class<AbstractWorkFunc> clazz = (Class<AbstractWorkFunc>) Class.forName(clzName);
			AbstractWorkFunc func = (AbstractWorkFunc) clazz.newInstance();

			PropertyDescriptor pd = new PropertyDescriptor("reqXml", clazz);

			Method writeMethod = pd.getWriteMethod();
			writeMethod.invoke(func, new Object[] { this.reqXml });
			if (func.processor() != 0) {
				if (StringUtil.isBlank(func.getCode())) {
					func.setCodeMsg("999", "Server Busy");
				}
			} else if (StringUtil.isBlank(func.getCode())) {
				func.setCodeMsg("200", "Success");
			}
			head.addTextChildNode("code", func.getCode()).addTextChildNode("msg", func.getMsg());
			sucXml.addChildNode(head);
			if (Objects.nonNull(func.getRespBody())) {
				sucXml.addChildNode(func.getRespBody());
			}
			if (StringUtil.isNotBlank(KEY)) {
				String vKey = WorkEncrypt.encryptMd5(WorkEncrypt.encryptMd5(sucXml.toString()) + KEY);
				head.addTextChildNode("key", vKey);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("SUCC Respond : {}", sucXml.toString());
			}
			return sucXml;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return errXml();
	}

	private WorkXml errXml() {
		WorkXml errXml = new WorkXml("resp").addChildNode(new WorkXml("head").addTextChildNode("cmd", this.cmd)
				.addTextChildNode("seq", DateUtil.formatCurDate("yyyyMMddHHmmssSSS")).addTextChildNode("code", "500")
				.addTextChildNode("msg", "Error"));
		if (logger.isDebugEnabled()) {
			logger.debug("EXEC Respond : {}", errXml.toString());
		}
		return errXml;
	}

	private WorkXml nonXml() {
		WorkXml nonXml = new WorkXml("resp").addChildNode(new WorkXml("head").addTextChildNode("cmd", this.cmd)
				.addTextChildNode("seq", DateUtil.formatCurDate("yyyyMMddHHmmssSSS")).addTextChildNode("code", "501")
				.addTextChildNode("msg", "None Command"));
		if (logger.isDebugEnabled()) {
			logger.debug("EXEC Respond : {}", nonXml.toString());
		}
		return nonXml;
	}
}
