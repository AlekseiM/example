package com.minkin.level;

import java.util.HashSet;
import java.util.Set;

//класс уровня логирования Error
public class ErrorLevel implements Level {

	private Set<String> setLevel = new HashSet<String>();

	public ErrorLevel() {

		setLevel.add("DEBUG");
		setLevel.add("INFO");
		setLevel.add("ERROR");

	}

	// проверяем заданный уровень логирования
	@Override
	public boolean checkLevel(String string) {
		String strLevel = string;
		return (setLevel.contains(strLevel));
	}

}
