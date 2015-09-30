package com.minkin.level;

// класс уровня логирования Debug
public class DebugLevel implements Level {

	public DebugLevel() {

	}

	// проверям уровень заданного логирования
	@Override
	public boolean checkLevel(String string) {
		String strLevel = string;
		return (strLevel.equals("DEBUG"));

	}

}
