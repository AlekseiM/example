package com.minkin;

//класс создает объект содержащий информацию из места события

public class Message {

	private String level;
	private String userMessage;

	private String stringDate;
	private String threadName;
	private String className;
	private String methodName;
	private int lineNumber;

	public Message() {

	}

	public Message(String stringDate, String threadName, String className, String methodName, int lineNumber) {

		this.stringDate = stringDate;
		this.threadName = threadName;
		this.className = className;
		this.methodName = methodName;
		this.lineNumber = lineNumber;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = " " + userMessage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public String toString() {

		return level + userMessage + ", threadName=" + threadName + ", className=" + className + ", methodName="
				+ methodName + ", lineNumber=" + lineNumber + ", stampDate=" + stringDate;
	}

	public String lineNumberToString() {
		return "" + lineNumber;

	}
}
