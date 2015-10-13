package com.minkin.FileSocket;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class FileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Scanner inSyst = new Scanner(System.in);
		System.out.println("type the full path and file name to save");
		String pathFile = inSyst.nextLine();

		try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8071))) {

			Scanner in = new Scanner(channel);
			OutputStream outStream = Channels.newOutputStream(channel);
			PrintWriter out = new PrintWriter(outStream, true);

			boolean done = false;

			while (!done && in.hasNextLine()) {
				// обрабатываем список каталога

				boolean doneList = false;

				while (!doneList && in.hasNextLine()) {

					String string = in.nextLine();
					System.out.println(string);

					if (string.equals("ok"))
						doneList = true;

				}

				// вводим и отправляем файл или каталог
				String path = inSyst.nextLine();
				out.println(path);

				// получаем запрос на подтверждение
				String flag = in.nextLine();
				System.out.println(flag);

				// отправляем ответ
				String response = inSyst.nextLine();
				out.println(response);

				// выходим из цикла
				if (response.equals("ok"))
					done = true;

			}

			// создаем файл для записи
			File file = new File(pathFile);
			if (!file.exists())
				file.createNewFile();

			// читаем с сервера и записываем в файл
			try (FileChannel outFile = new FileOutputStream(file).getChannel()) {

				ByteBuffer buffer = ByteBuffer.allocate(1024);
				Byte[] data;

				while (channel.read(buffer) != -1) {
					buffer.flip();
					outFile.write(buffer);
					buffer.clear();
				}
				System.out.println("the file is loaded");

			}

		}
	}

}
