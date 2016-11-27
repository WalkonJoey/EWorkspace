package com.witcream.core;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import com.witcream.util.StringUtil;

public class WorkXml {
	public static final String TAG_ITEM = "item";
	private final Map<String, String> attrs = new TreeMap<String, String>();
	private final List<WorkXml> childNodes = new ArrayList<WorkXml>();
	private String tagName;
	private String textValue;
	private boolean isCdataNode = false;

	public WorkXml() {
		this("item");
	}

	public WorkXml(String tagName) {
		this.tagName = (StringUtil.isNotBlank(tagName) ? tagName.trim() : "item");
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = (StringUtil.isNotBlank(tagName) ? tagName.trim() : "item");
	}

	public boolean hasChildNodes() {
		return !this.childNodes.isEmpty();
	}

	public boolean hasTextValue() {
		return StringUtil.isNotBlank(this.textValue);
	}

	public boolean hasAttrs() {
		return !this.attrs.isEmpty();
	}

	public boolean isTextNode() {
		return !hasChildNodes();
	}

	public Map<String, String> getAttrs() {
		return this.attrs;
	}

	public List<WorkXml> getChildNodes() {
		return this.childNodes;
	}

	public String getTextValue() {
		return StringUtil.isNotBlank(this.textValue) ? this.textValue : "";
	}

	public WorkXml setTextValue(String textValue) {
		this.textValue = (StringUtil.isNotBlank(textValue) ? textValue.trim() : "");
		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(1024);
		Set<Map.Entry<String, String>> set;
		if (hasChildNodes()) {
			StringBuilder tc = new StringBuilder();
			for (WorkXml child : getChildNodes()) {
				tc.append(child.toString());
			}
			if (hasAttrs()) {
				StringBuilder tmp = new StringBuilder(128);
				set = this.attrs.entrySet();
				for (Map.Entry<String, String> entry : set) {
					tmp.append(String.format(" %s=\"%s\"", new Object[] { entry.getKey(), entry.getValue() }));
				}
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), tc.toString(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), tc.toString(), getTagName() }));
			}
			return sb.toString();
		}
		if (hasAttrs()) {
			StringBuilder tmp = new StringBuilder(128);
			set = this.attrs.entrySet();
			for (Entry<String, String> entry :  set) {
				tmp.append(String.format(" %s=\"%s\"",
						new Object[] { entry.getKey(), entry.getValue() }));
			}
			if ((isTextNode()) && (hasTextValue())) {
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), getTextValue(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s%s />", new Object[] { getTagName(), tmp.toString() }));
			}
			return sb.toString();
		}
		if ((isTextNode()) && (hasTextValue())) {
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), getTextValue(), getTagName() }));
			}
			return sb.toString();
		}
		if (StringUtil.isNotBlank(getTagName())) {
			sb.append(String.format("<%s />", new Object[] { getTagName() }));
		}
		return sb.toString();
	}

	public String toString(boolean cdataSection) {
		if (!cdataSection) {
			return toString();
		}
		StringBuilder sb = new StringBuilder(1024);
		Set<Map.Entry<String, String>> set;
		if (hasChildNodes()) {
			StringBuilder tc = new StringBuilder();
			for (WorkXml child : getChildNodes()) {
				tc.append(child.toString(cdataSection));
			}
			if (hasAttrs()) {
				StringBuilder tmp = new StringBuilder(128);
				set = this.attrs.entrySet();
				for (Map.Entry<String, String> entry : set) {
					tmp.append(String.format(" %s=\"%s\"", new Object[] { entry.getKey(), entry.getValue() }));
				}
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), tc.toString(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), tc.toString(), getTagName() }));
			}
			return sb.toString();
		}
		if (hasAttrs()) {
			StringBuilder tmp = new StringBuilder(128);
			set = this.attrs.entrySet();
			for (Entry<String,String> entry : set) {
				tmp.append(String.format(" %s=\"%s\"",
						new Object[] {entry.getKey(), entry.getValue() }));
			}
			if ((isTextNode()) && (hasTextValue())) {
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s><!CDATA[%s]]></%s>",
							new Object[] { getTagName(), tmp.toString(), getTextValue(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s%s />", new Object[] { getTagName(), tmp.toString() }));
			}
			return sb.toString();
		}
		if ((isTextNode()) && (hasTextValue())) {
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s><!CDATA[%s]]></%s>",
						new Object[] { getTagName(), getTextValue(), getTagName() }));
			}
			return sb.toString();
		}
		if (StringUtil.isNotBlank(getTagName())) {
			sb.append(String.format("<%s />", new Object[] { getTagName() }));
		}
		return sb.toString();
	}

	public String toStandardString() {
		StringBuilder sb = new StringBuilder(1024);
		Set<Map.Entry<String, String>> set;
		if (hasChildNodes()) {
			StringBuilder tc = new StringBuilder();
			for (WorkXml child : getChildNodes()) {
				tc.append(child.toStandardString());
			}
			if (hasAttrs()) {
				StringBuilder tmp = new StringBuilder(128);
				set = this.attrs.entrySet();
				for (Map.Entry<String, String> entry : set) {
					tmp.append(String.format(" %s=\"%s\"", new Object[] { entry.getKey(), entry.getValue() }));
				}
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), tc.toString(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), tc.toString(), getTagName() }));
			}
			return sb.toString();
		}
		if (hasAttrs()) {
			StringBuilder tmp = new StringBuilder(128);
			set = this.attrs.entrySet();
			for (Entry<String, String> entry : set) {
				tmp.append(String.format(" %s=\"%s\"",
						new Object[] { entry.getKey(), entry.getValue() }));
			}
			if ((isTextNode()) && (hasTextValue())) {
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), getTextValue(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s%s></%s>", new Object[] { getTagName(), tmp.toString(), getTagName() }));
			}
			return sb.toString();
		}
		if ((isTextNode()) && (hasTextValue())) {
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), getTextValue(), getTagName() }));
			}
			return sb.toString();
		}
		if (StringUtil.isNotBlank(getTagName())) {
			sb.append(String.format("<%s></%s>", new Object[] { getTagName(), getTagName() }));
		}
		return sb.toString();
	}

	public String toCompactString() {
		StringBuilder sb = new StringBuilder(1024);
		Set<Map.Entry<String, String>> set;
		if (hasChildNodes()) {
			StringBuilder tc = new StringBuilder();
			for (WorkXml child : getChildNodes()) {
				tc.append(child.toCompactString());
			}
			if (hasAttrs()) {
				StringBuilder tmp = new StringBuilder(128);
				set = this.attrs.entrySet();
				for (Map.Entry<String, String> entry : set) {
					tmp.append(String.format(" %s=\"%s\"", new Object[] { entry.getKey(), entry.getValue() }));
				}
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), tc.toString(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), tc.toString(), getTagName() }));
			}
			return sb.toString();
		}
		if (hasAttrs()) {
			StringBuilder tmp = new StringBuilder(128);
			set = this.attrs.entrySet();
			for (Entry<String, String> entry : set) {
				tmp.append(String.format(" %s=\"%s\"",
						new Object[] {entry.getKey(), entry.getValue() }));
			}
			if ((isTextNode()) && (hasTextValue())) {
				if (StringUtil.isNotBlank(getTagName())) {
					sb.append(String.format("<%s%s>%s</%s>",
							new Object[] { getTagName(), tmp.toString(), getTextValue(), getTagName() }));
				}
				return sb.toString();
			}
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s%s/>", new Object[] { getTagName(), tmp.toString() }));
			}
			return sb.toString();
		}
		if ((isTextNode()) && (hasTextValue())) {
			if (StringUtil.isNotBlank(getTagName())) {
				sb.append(String.format("<%s>%s</%s>", new Object[] { getTagName(), getTextValue(), getTagName() }));
			}
			return sb.toString();
		}
		if (StringUtil.isNotBlank(getTagName())) {
			sb.append(String.format("<%s/>", new Object[] { getTagName() }));
		}
		return sb.toString();
	}

	public String toString(String version, String encoding) {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("<?xml version=\"").append(version).append("\" encoding=\"").append(encoding).append("\"?>")
				.append(toString());
		return sb.toString();
	}

	public String toUtfString() {
		return toString("1.0", "utf-8");
	}

	public WorkXml addAttrs(Map<String, String> attrs) {
		if ((attrs != null) && (!attrs.isEmpty())) {
			for (Map.Entry<String, String> entry : attrs.entrySet()) {
				addAttr((String) entry.getKey(), (String) entry.getValue());
			}
		}
		return this;
	}

	public WorkXml addAttr(String name, String value) {
		if (StringUtil.isNotBlank(name)) {
			this.attrs.put(name, StringUtil.isNotBlank(value) ? value.trim() : "");
		}
		return this;
	}

	public WorkXml addChildNode(WorkXml child) {
		if (Objects.nonNull(child)) {
			this.childNodes.add(child);
		}
		return this;
	}

	public WorkXml addChildNodes(List<WorkXml> childNodes) {
		if ((childNodes != null) && (!childNodes.isEmpty())) {
			this.childNodes.addAll(childNodes);
		}
		return this;
	}

	public WorkXml addTextChildNode(String tagName, String textValue) {
		if (StringUtil.isNotBlank(tagName)) {
			return addChildNode(new WorkXml(tagName.trim()).setTextValue(textValue));
		}
		return this;
	}

	public WorkXml putTextChildNode(String tagName, Object textValue) {
		if (StringUtil.isNotBlank(tagName)) {
			return addChildNode(
					new WorkXml(tagName.trim()).setTextValue(textValue != null ? String.valueOf(textValue) : ""));
		}
		return this;
	}

	public WorkXml addTextChildNodes(Map<String, String> textNodes) {
		if ((textNodes != null) && (!textNodes.isEmpty())) {
			for (Map.Entry<String, String> entry : textNodes.entrySet()) {
				addTextChildNode((String) entry.getKey(), (String) entry.getValue());
			}
		}
		return this;
	}

	public WorkXml putTextChildNodes(Map<String, Object> textNodes) {
		if ((textNodes != null) && (!textNodes.isEmpty())) {
			for (Map.Entry<String, Object> entry : textNodes.entrySet()) {
				addTextChildNode((String) entry.getKey(),
						entry.getValue() != null ? String.valueOf(entry.getValue()) : "");
			}
		}
		return this;
	}

	public WorkXml addTextChildNode(String tagName, String textValue, Map<String, String> attrs) {
		return addTextChildNode(tagName, textValue).addAttrs(attrs);
	}

	public void clear() {
		this.attrs.clear();
		this.childNodes.clear();
		this.textValue = "";
	}

	public WorkXml firstChildNode(String tagName) {
		if ((StringUtil.isBlank(tagName)) || (!hasChildNodes())) {
			return null;
		}
		for (WorkXml node : getChildNodes()) {
			if (tagName.equals(node.getTagName())) {
				return node;
			}
		}
		return null;
	}

	public List<WorkXml> allChildNode(String tagName) {
		List<WorkXml> nodes = new ArrayList<WorkXml>();
		if ((StringUtil.isBlank(tagName)) || (!hasChildNodes())) {
			return nodes;
		}
		for (WorkXml node : getChildNodes()) {
			if (tagName.equals(node.getTagName())) {
				nodes.add(node);
			}
		}
		return nodes;
	}

	public void removeChildNode(String tagName) {
		if ((StringUtil.isBlank(tagName)) || (!hasChildNodes())) {
			return;
		}
		List<WorkXml> nodes = getChildNodes();
		for (int i = nodes.size() - 1; i >= 0; i--) {
			if (tagName.equals(((WorkXml) nodes.get(i)).getTagName())) {
				nodes.remove(i);
			}
		}
	}

	@Skip
	public void removeChildNode(WorkXml node) {
		if ((node == null) || (!hasChildNodes())) {
			return;
		}
		getChildNodes().remove(node);
	}

	public boolean removeChildNodes(Collection<? extends WorkXml> c) {
		return getChildNodes().removeAll(c);
	}

	public void removeXpath(String xpath) {
		if ((StringUtil.isBlank(xpath)) || (!xpath.contains(".")) || (xpath.startsWith(".")) || (xpath.endsWith("."))) {
			return;
		}
		int point = xpath.lastIndexOf(".");
		List<WorkXml> nodes = getXpathNodes(xpath.substring(0, point));
		for (WorkXml node : nodes) {
			node.removeChildNode(xpath.substring(point + 1));
		}
	}

	public List<WorkXml> getXpathNodes(String xpath) {
		List<WorkXml> nodes = new ArrayList<WorkXml>();
		if ((StringUtil.isBlank(xpath)) || (xpath.trim().startsWith(".")) || (xpath.trim().endsWith("."))) {
			return nodes;
		}
		if (!xpath.contains(".")) {
			if (getTagName().equals(xpath.trim())) {
				nodes.add(this);
			}
			return nodes;
		}
		String[] paths = xpath.trim().split("\\.");
		int len = paths.length;
		if (!getTagName().equals(paths[0].trim())) {
			return nodes;
		}
		nodes.add(this);
		String[] dest = new String[len - 1];
		System.arraycopy(paths, 1, dest, 0, len - 1);
		return getXpathStepNodes(nodes, dest);
	}

	public List<WorkXml> getXpathStepNodes(List<WorkXml> nodes, String[] paths) {
		List<WorkXml> existNodes = new ArrayList<WorkXml>();
		if ((paths == null) || (paths.length == 0) || (StringUtil.isBlank(paths[0]))
				|| (StringUtil.isBlank(paths[0].trim()))) {
			return existNodes;
		}
		for (WorkXml node : nodes) {
			List<WorkXml> childNodes = node.getChildNodes();
			for (WorkXml childNode : childNodes) {
				if (childNode.getTagName().equals(paths[0].trim())) {
					existNodes.add(childNode);
				}
			}
		}
		if (existNodes.isEmpty()) {
			return existNodes;
		}
		if (paths.length == 1) {
			return existNodes;
		}
		String[] dest = new String[paths.length - 1];
		System.arraycopy(paths, 1, dest, 0, paths.length - 1);
		return getXpathStepNodes(existNodes, dest);
	}

	@Skip
	public WorkXml getXpathNode(String xpath) {
		List<WorkXml> nodes = getXpathNodes(xpath);
		return nodes.isEmpty() ? null : (WorkXml) nodes.get(0);
	}


	@Skip
	public Map<String, String> toMap(String xpath) {
		WorkXml node = getXpathNode(xpath);
		Map<String, String> textValues = new TreeMap<String, String>();
		if (node != null) {
			for (WorkXml childNode : node.getChildNodes()) {
				if (childNode.isTextNode()) {
					textValues.put(childNode.getTagName(), childNode.getTextValue());
				}
			}
		}
		return textValues;
	}

	@Skip
	public Map<String, String> toMap() {
		Map<String, String> keyVal = new TreeMap<String, String>();
		for (WorkXml node : getChildNodes()) {
			keyVal.put(node.getTagName(), node.getTextValue());
		}
		return keyVal;
	}

	@Skip
	public void display() {
		System.out.println(format(0));
	}

	private String format(int index) {
		StringBuilder sb = new StringBuilder(1024);
		String space = index == 0 ? "" : "   ";
		for (int i = 1; i < index; i++) {
			space = space + "   ";
		}
		WorkXml child;
		if (hasChildNodes()) {
			StringBuilder tc = new StringBuilder(128);
			for (Iterator<WorkXml> localIterator = getChildNodes().iterator(); localIterator.hasNext();) {
				child = (WorkXml) localIterator.next();
				tc.append(child.format(index + 1));
			}
			StringBuilder tmp = new StringBuilder(64);
			if (hasAttrs()) {
				for (Map.Entry<String, String> entry : getAttrs().entrySet()) {
					tmp.append(String.format(" %s=\"%s\"", new Object[] { entry.getKey(), entry.getValue() }));
				}
			}
			sb.append(String.format("%s<%s%s>\n%s%s</%s>\n",
					new Object[] { space, getTagName(), tmp.toString(), tc.toString(), space, getTagName() }));
		} else {
			StringBuilder tmp = new StringBuilder(128);
			if (hasAttrs()) {
				Set<Entry<String, String>> set = this.attrs.entrySet();
				for (Entry<String, String> entry : set) {
					tmp.append(String.format(" %s=\"%s\"", new Object[] { entry.getKey(), entry.getValue() }));
				}
			}
			if ((isTextNode()) && (hasTextValue())) {
				sb.append(String.format("%s<%s%s>%s</%s>\n",
						new Object[] { space, getTagName(), tmp.toString(), getTextValue(), getTagName() }));
			} else {
				sb.append(String.format("%s<%s%s />\n", new Object[] { space, getTagName(), tmp.toString() }));
			}
		}
		return sb.toString();
	}

	public static WorkXml asXml(String strXml) {
		return XmlParser.parse(strXml);
	}

	public static WorkXml asXml(File fileXml) {
		return XmlParser.parse(fileXml);
	}

	public static WorkXml asXml(InputStream inXml) {
		return XmlParser.parse(inXml);
	}

	public Map<String, Object> map() {
		return toJSON(new HashMap<String, Object>(), this);
	}

	private static Map<String, Object> toJSON(Map<String, Object> container, WorkXml inXml) {
		if (inXml.isTextNode()) {
			if (inXml.hasAttrs()) {
				Map<String, Object> json = new HashMap<String, Object>();
				json.put("TextVal", inXml.getTextValue());
				Map<String, Object> attrs = new HashMap<String, Object>();
				for (Map.Entry<String, String> entry : inXml.getAttrs().entrySet()) {
					attrs.put(entry.getKey(), entry.getValue());
				}
				json.put("Attrs", attrs);
				container.put(inXml.getTagName(), json);
			} else {
				container.put(inXml.getTagName(), inXml.getTextValue());
			}
		} else if (inXml.hasAttrs()) {
			Map<String, Object> json = new HashMap<String, Object>();
			Map<String, Object> attrs = new HashMap<String, Object>();
			for (Map.Entry<String, String> entry : inXml.getAttrs().entrySet()) {
				attrs.put(entry.getKey(), entry.getValue());
			}
			json.put("Attrs", attrs);
			container.put(inXml.getTagName(), toJSON(json, inXml.getChildNodes()));
		} else {
			Object o = container.get(inXml.getTagName());
			if (o != null) {
				if ((o instanceof Object[])) {
					Object[] src = (Object[]) o;
					Object[] dest = new Object[src.length + 1];
					System.arraycopy(src, 0, dest, 0, src.length);
					dest[(dest.length - 1)] = toJSON(new HashMap<String, Object>(), inXml.getChildNodes());
					container.put(inXml.getTagName(), dest);
				} else {
					Object[] dest = new Object[2];
					dest[0] = o;
					dest[1] = toJSON(new HashMap<String, Object>(), inXml.getChildNodes());
					container.put(inXml.getTagName(), dest);
				}
			} else {
				container.put(inXml.getTagName(), toJSON(new HashMap<String, Object>(), inXml.getChildNodes()));
			}
		}
		return container;
	}

	private static Map<String, Object> toJSON(Map<String, Object> json, List<WorkXml> childNodes) {
		for (WorkXml node : childNodes) {
			if (node.isTextNode()) {
				if (node.hasAttrs()) {
					Map<String, Object> tmp = new HashMap<String, Object>();
					Map<String, Object> attrs = new HashMap<String, Object>();
					for (Map.Entry<String, String> entry : node.getAttrs().entrySet()) {
						attrs.put(entry.getKey(), entry.getValue());
					}
					tmp.put("Attrs", attrs);
					tmp.put("TextVal", node.getTextValue());
					json.put(node.getTagName(), tmp);
				} else {
					Object o = json.get(node.getTagName());
					if (o != null) {
						if ((o instanceof Object[])) {
							Object[] src = (Object[]) o;
							Object[] dest = new Object[src.length + 1];
							System.arraycopy(src, 0, dest, 0, src.length);
							dest[(dest.length - 1)] = node.getTextValue();
							json.put(node.getTagName(), dest);
						} else {
							Object[] dest = new Object[2];
							dest[0] = o;
							dest[1] = node.getTextValue();
							json.put(node.getTagName(), dest);
						}
					} else {
						json.put(node.getTagName(), node.getTextValue());
					}
				}
			} else {
				toJSON(json, node);
			}
		}
		return json;
	}

	public void addCdataSection(boolean isCdataNode) {
		this.isCdataNode = isCdataNode;
	}

	public boolean isCdataNode() {
		return this.isCdataNode;
	}
}
