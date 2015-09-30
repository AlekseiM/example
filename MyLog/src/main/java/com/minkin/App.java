package com.minkin;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

public class App {

	private static Log log;

	public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException,
			XMLStreamException, InstantiationException {
		// подключаем логгер
		log = new Log();

		System.out.println("Hello World!");
		// логируем
		log.info("Информация...");
		addString();

	}

	public static void addString() throws IOException, XMLStreamException {
		System.out.println("Hello World!");
		// логируем
		log.error("Внимание Ошибка...");
		log.debug("Проверка DEBUG...");

	}

}
