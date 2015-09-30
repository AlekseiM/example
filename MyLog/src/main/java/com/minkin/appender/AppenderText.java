package com.minkin.appender;

import java.io.IOException;

import com.minkin.Message;
import com.minkin.WriterMessage;

//класс вывода информации в тектовый файл
public class AppenderText implements Appender {

	private boolean rotationFile;
	private int fileSize;
	private int amountFileRotetion;
	private WriterMessage writerMessage;

	public AppenderText() {

	}

	// выводим в тектовый файл
	public void makeWritten(Message message) {
		writerMessage = new WriterMessage(rotationFile, fileSize, amountFileRotetion);
		try {
			writerMessage.writeText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean isRotationFile() {
		return rotationFile;
	}

	public int getFileSize() {
		return fileSize;
	}

	public int getAmountFileRotetion() {
		return amountFileRotetion;
	}

	public void setRotationFile(boolean rotationFile) {
		this.rotationFile = rotationFile;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public void setAmountFileRotetion(int amountFileRotetion) {
		this.amountFileRotetion = amountFileRotetion;
	}

}
