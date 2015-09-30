package com.minkin.level;

import java.util.HashSet;
import java.util.Set;

//класс уровня логирования Info
public class InfoLevel implements Level {

	private Set<String> setLevel = new HashSet<String>();

	public InfoLevel() {

		setLevel.add("DEBUG");
		setLevel.add("INFO");

	}

	// проверяем заданный уровень логирования
	@Override
	public boolean checkLevel(String string) {
		String strLevel = string;
		return (setLevel.contains(strLevel));
	}

}
