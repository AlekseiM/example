package com.minkin.appender;

import com.minkin.Message;

// класс вывода информации на консоль
public class AppenderConsol implements Appender {

	public AppenderConsol() {

	}

	// выводим в консоль
	public void makeWritten(Message message) {
		System.out.println(message);

	}

}
