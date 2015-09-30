package com.minkin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

// класс для записи информации в текстовый файл
public class WriterMessage {

	private Message message;
	private File file;
	private File dir;
	private File[] files;
	private int fileSize;
	private int amountFileRotetion;
	private boolean rotationFile;

	// получаем параметры работы с файлом
	public WriterMessage(boolean rotationFile, int fileSize, int amountFileRotetion) {
		this.rotationFile = rotationFile;
		this.fileSize = fileSize;
		this.amountFileRotetion = amountFileRotetion;
	}

	// создаем каталог для записи
	// если файл для записи не существует, создаем его.
	// задаем количество файлов ротации

	public void writeText(Message message) throws IOException {
		this.message = message;
		dir = new File("dirLog");
		if (Files.notExists(dir.toPath()))
			Files.createDirectories(dir.toPath());

		for (int i = 1; i <= amountFileRotetion; i++) {
			file = new File("dirLog/log" + i);
			if (!file.exists())
				file.createNewFile();
		}
		files = dir.listFiles();

		writeInFile();
	}

	// записываем информацию в файл

	public void writeInFile() throws IOException {
		if (rotationFile)
			checkRotation();

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(files[0], true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(message);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
		}
	}

	// если необходимо, ротируем файлы
	public void checkRotation() throws IOException {

		if (files[0].length() > fileSize) {

			for (int i = files.length - 1; i >= 1; i--) {

				Files.deleteIfExists(files[i].toPath());

				Files.move(files[i - 1].toPath(), files[i].toPath());

			}

		}
	}

}
