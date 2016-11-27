package com.witcream.core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class WorkStAX {
	public static WorkXml parse(InputStream in) {
		XMLStreamReader reader = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			factory.setProperty("javax.xml.stream.isCoalescing", Boolean.TRUE);
			reader = factory.createXMLStreamReader(in);

			return reader(reader);
		} catch (XMLStreamException | FactoryConfigurationError e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
		}
	}

	private static WorkXml reader(XMLStreamReader reader) throws XMLStreamException {
		List<WorkXml> nodes = new ArrayList<WorkXml>();
		while (reader.hasNext()) {
			if (reader.isStartElement()) {
				WorkXml node = new WorkXml(reader.getLocalName());
				for (int i = 0; i < reader.getAttributeCount(); i++) {
					node.addAttr(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
				}
				if (reader.hasNext()) {
					reader.next();
				}
				if (reader.isCharacters()) {
					node.setTextValue(reader.getText());
				}
				nodes.add(node);
			} else if (reader.isEndElement()) {
				int len = nodes.size();
				if (len > 1) {
					((WorkXml) nodes.get(len - 2)).addChildNode((WorkXml) nodes.get(len - 1));
					nodes.remove(len - 1);
				}
				if (reader.hasNext()) {
					reader.next();
				}
			} else if (reader.hasNext()) {
				reader.next();
			}
		}
		return nodes.isEmpty() ? null : (WorkXml) nodes.get(0);
	}
}
