package com.minkin.AreaShape;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.minkin.AreaShape.model.Shape;

public class ParserShapes {
	
	private static int id = 1;
	
	private FileInputStream in = null;
	private Set<String> shapesSet = new HashSet<String>();

	public ParserShapes() {

	}

	public void perform(String fileName) {
		
		initialShapesSet();

		try {

			in = new FileInputStream(new File(fileName));
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(in);
			
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					String name = reader.getLocalName();
					if (shapesSet.contains(name)) {

						Runnable r = buildShape(reader, name);
						Thread t = new Thread(r);
						t.start();
						// без многопоточности
						// Shape shape = buildShape(reader, name);
						// shape.printArea();
					}

				}

			}

		} catch (

		XMLStreamException e)

		{
			e.printStackTrace();
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initialShapesSet() {

		shapesSet.add("triangle");
		shapesSet.add("circle");
		shapesSet.add("square");
		shapesSet.add("rectangle");

	}

	private Shape buildShape(XMLStreamReader reader, String aName) throws XMLStreamException {
		// меняем первый символ на заглавный
		String strName = aName.substring(0, 1).toUpperCase() + aName.substring(1);

		String nameClass = "com.minkin.AreaShape.model." + strName;
		Shape shape = null;
		try {
			shape = (Shape) Class.forName(nameClass).newInstance();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		shape.setId(id);

		id++;
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (name) {

				case "color":
					shape.setColor(getXMLText(reader));
					break;
				case "side":
					name = getXMLText(reader);
					shape.addSide(Float.parseFloat(name));
					break;
				case "diameter":
					name = getXMLText(reader);
					shape.setDiameter(Float.parseFloat(name));
					break;

				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();

				if (shapesSet.contains(name)) {

					return shape;

				}
				break;
			}

		}
		throw new XMLStreamException("Unknow element in tag Shape");

	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

}
