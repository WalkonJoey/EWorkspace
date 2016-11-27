package com.witcream.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.witcream.util.StringUtil;

class WorkParser {
	public static WorkXml parse(File fileXml) {
		return parse(getRootNode(fileXml));
	}

	public static WorkXml parse(String strXml) {
		return parse(getRootNode(strXml));
	}

	public static WorkXml parse(InputStream inXml) {
		return parse(getRootNode(inXml));
	}

	public static Document getDocument(File fileXml) {
		Document doc = null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(fileXml);
		} catch (Exception e) {
			throw new WorkException(e);
		}
		return doc;
	}

	public static Document getDocument(String strXml) {
		return getDocument(strXml, Consts.UTF_8);
	}

	public static Document getDocument(String strXml, Charset charset) {
		Document doc = null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(strXml.getBytes(charset)));
		} catch (Exception e) {
			throw new WorkException(e);
		}
		return doc;
	}

	public static Document getDocument(InputStream inXml) {
		Document doc = null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(inXml);
		} catch (Exception e) {
			throw new WorkException(e);
		}
		return doc;
	}

	static Node getRootNode(File fileXml) {
		Document doc = getDocument(fileXml);
		return doc.getDocumentElement();
	}

	static Node getRootNode(String strXml) {
		Document doc = getDocument(strXml);
		return doc.getDocumentElement();
	}

	static Node getRootNode(InputStream inXml) {
		Document doc = getDocument(inXml);
		return doc.getDocumentElement();
	}

	static Map<String, String> getAttrs(Node node) {
		Map<String, String> attrs = new TreeMap<String, String>();
		if (!node.hasAttributes()) {
			return attrs;
		}
		NamedNodeMap attrNodes = node.getAttributes();
		int len = attrNodes.getLength();
		for (int i = 0; i < len; i++) {
			Node attrNode = attrNodes.item(i);
			attrs.put(attrNode.getNodeName(), attrNode.getNodeValue());
		}
		return attrs;
	}

	static WorkXml parse(Node node) {
		WorkXml nodeXml = new WorkXml(node.getNodeName());
		nodeXml.addAttrs(getAttrs(node));
		if (node.hasChildNodes()) {
			NodeList nodeList = node.getChildNodes();
			int len = nodeList.getLength();
			for (int i = 0; i < len; i++) {
				Node childNode = nodeList.item(i);
				int nodeType = childNode.getNodeType();
				switch (nodeType) {
				case 1:
					nodeXml.addChildNode(parse(childNode));
					break;
				case 4:
					nodeXml.addCdataSection(true);
					nodeXml.setTextValue(StringUtil.isBlank(node.getTextContent()) ? "" : node.getTextContent().trim());
					break;
				case 3:
					String textValue = node.getTextContent();
					nodeXml.setTextValue(StringUtil.isBlank(textValue) ? "" : textValue.trim());
				}
			}
		}
		return nodeXml;
	}
}
