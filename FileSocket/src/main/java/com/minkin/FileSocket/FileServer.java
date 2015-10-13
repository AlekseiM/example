package com.minkin.FileSocket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*Сделать клиент-сервер, который позволяет получать большие файлы с сервера.
Клиент: выбираем место и файл на сервере.
Сервер: список файлов.
Действие: передаем большой файл по кусочкам. Сервер должен уметь обслуживать одновременно
 несколько клиентов. Интерфейс пользователя произвольный: консольный или GUI. 
Предусмотреть в проекте автоматизацию сборки и запуска (либо проект IntelliJ IDEA + 
Run Configurations для запуска клиента и сервера, либо скрипты ant с таргетами сборки, 
запуска клиента и запуска сервера).
Язык: Использовать Java SE и стандартную библиотеку Java.
*/

public class FileServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8071);
			System.out.println("initialized");
			while (true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress().getHostName() + " connected");
				Runnable r = new ServerThread(socket);
				Thread t = new Thread(r);
				t.start();
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerThread implements Runnable {

	private Socket incoming;
	private File file;

	public ServerThread(Socket s) {
		incoming = s;
	}

	public void run() {

		try {
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true);

				Path workPath = Paths.get(System.getProperty("user.home"));

				Boolean done = false;

				while (!done) {
					// отправляем клиенту список доступных файлов и каталогов
					out.println("select the path and file...");
					if (workPath.toFile().exists() && workPath.toFile().isDirectory()) {

						try (DirectoryStream<Path> entries = Files.newDirectoryStream(workPath)) {
							for (Path entry : entries)
								out.println(entry);

						}
					} else
						out.println("the ERROR is not directory !!!");

					out.println("----------------------------------");
					out.println("write the full path and file name:");
					out.println("ok");
					// принимаем путь к файлу или каталогу
					String pathString = in.nextLine();

					workPath = Paths.get(pathString);

					out.println("if the selected file send - ok, continue select - ENTER");

					String flag = in.nextLine();
					// выходим из цикла
					if (flag.equals("ok")) {
						done = true;
					}

				}
				// отправляем выбранный файл
				file = new File(workPath.toString());
				if (file.exists() & file.isFile()) {

					try (FileChannel fileChannel = new FileInputStream(file).getChannel()) {

						ByteBuffer buffer = ByteBuffer.allocate(1024);
						while (fileChannel.read(buffer) != -1) {
							buffer.flip();
							outStream.write(buffer.array());

							buffer.clear();

						}
					}
				}

			} finally {
				System.out.println(incoming.getInetAddress().getHostName() + " Disconnected ");
				incoming.close();

			}

		} catch (

		IOException e)

		{
			e.printStackTrace();
		}
	}

}
