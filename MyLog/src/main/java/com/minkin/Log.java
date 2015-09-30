package com.minkin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import com.minkin.appender.Appender;
import com.minkin.appender.AppenderText;
import com.minkin.level.Level;

// класс создает объект логирования информации с возможностью вывода в файл и на консоль.

public class Log {

	private boolean rotationFile;
	private String formatDate;
	private int fileSize;
	private String levelLog;
	private List<Appender> appenderList;
	private int amountFileRotetion;

	private Level level;

	private Message message;

	// создаем объект, сетим поля из конфигурационного файла

	public Log() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		appenderList = new ArrayList<Appender>();
		readConfig();
		level = (Level) Class.forName(getLevelLog()).newInstance();

	}

	private void readConfig() {
		Properties props = new Properties();
		String str;

		// получаем информацию из файла properties и заполняем поля объекта Log
		File propertiesFile = new File("configuration.properties");
		if (propertiesFile.exists() && propertiesFile.isFile())
			try (FileInputStream in = new FileInputStream(propertiesFile)) {
				props.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		setRotationFile(Boolean.parseBoolean(props.getProperty("rotationFile")));
		setFormatDate(props.getProperty("formatDate"));
		setFileSize(Integer.parseInt(props.getProperty("fileSize")));
		setAmountFileRotetion(Integer.parseInt(props.getProperty("amountFileRotation")));
		setLevelLog(props.getProperty("level"));

		str = props.getProperty("AppenderConsol");
		addAppender(str);
		str = props.getProperty("AppenderText");
		addAppender(str);
	}

	// создаем класс аппендера и добавляем в List
	public void addAppender(String str) {

		Set<String> appenderSet = new HashSet<String>();
		appenderSet.add("com.minkin.appender.AppenderConsol");
		appenderSet.add("com.minkin.appender.AppenderText");

		if (appenderSet.contains(str))
			try {

				Appender appender = (Appender) (Class.forName(str).newInstance());

				// если аппендер будет выводить в файл, то задаем параметры
				// работы с файлом
				if (appender instanceof AppenderText) {
					((AppenderText) appender).setRotationFile(rotationFile);
					((AppenderText) appender).setAmountFileRotetion(amountFileRotetion);
					((AppenderText) appender).setFileSize(fileSize);
				}

				appenderList.add(appender);
			} catch (InstantiationException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

	}

	// метод вызова события логирования уровня DEBUG с сообщением от
	// пользователя
	public void debug(String userMessage) throws IOException, XMLStreamException {
		message = getStackTrace();
		message.setLevel("DEBUG");
		message.setUserMessage(userMessage);
		// проверяем установленный уровень логирования и передаем информацию
		// аппендерам
		if (level.checkLevel(message.getLevel())) {
			for (Appender appender : appenderList)
				appender.makeWritten(message);

		}
	}

	// метод вызова события логирования уровня INFO с сообщением от пользователя
	public void info(String userMessage) throws IOException, XMLStreamException {
		message = getStackTrace();
		message.setLevel("INFO");
		message.setUserMessage(userMessage);
		// проверяем установленный уровень логирования и передаем информацию
		// аппендерам
		if (level.checkLevel(message.getLevel())) {
			for (Appender appender : appenderList)
				appender.makeWritten(message);
		}
	}

	// метод вызова события логирования уровня ERROR c сообщением от
	// пользователя
	public void error(String userMessage) throws IOException, XMLStreamException {
		message = getStackTrace();
		message.setLevel("ERROR");
		message.setUserMessage(userMessage);
		// проверяем установленный уровень логирования и передаем информацию
		// аппендерам
		if (level.checkLevel(message.getLevel())) {
			for (Appender appender : appenderList)
				appender.makeWritten(message);
		}
	}

	// получаем информацию из места события
	public Message getStackTrace() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		message = null;

		StackTraceElement element = stackTraceElements[3];
		String className = element.getClassName();
		String methodName = element.getMethodName();
		int lineNumber = element.getLineNumber();
		String threadName = Thread.currentThread().getName();

		// создаем дату и время события
		DateFormat dateFormat = new SimpleDateFormat(formatDate);
		Date date = new Date();
		message = new Message(dateFormat.format(date), threadName, className, methodName, lineNumber);

		return message;
	}

	public void setRotationFile(boolean rotationFile) {
		this.rotationFile = rotationFile;

	}

	public boolean isRotationFile() {
		return rotationFile;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getLevelLog() {
		return levelLog;
	}

	public void setLevelLog(String levelLog) {
		this.levelLog = levelLog;
	}

	public List<Appender> getAppender() {
		return appenderList;
	}

	public int getAmountFileRotetion() {
		return amountFileRotetion;
	}

	public void setAmountFileRotetion(int amountFileRotetion) {
		this.amountFileRotetion = amountFileRotetion;
	}

}
