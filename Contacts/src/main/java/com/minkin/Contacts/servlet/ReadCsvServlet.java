package com.minkin.Contacts.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minkin.Contacts.DAO.DAOSaveContacts;
import com.minkin.Contacts.model.Contact;

@WebServlet("/ReadCsvServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class ReadCsvServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5203414934321280160L;

	public ReadCsvServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		processRequest(request, response);

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		DAOSaveContacts daoSaveContacts = new DAOSaveContacts();

		List<Contact> contactsList = new ArrayList<>();
		synchronized (daoSaveContacts) {

			Contact contact;
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";

			try {
				br = request.getReader();
				while ((line = br.readLine()) != null) {

					String[] data = line.split(cvsSplitBy);

					int i = 5; // количество аргументов в строке CSV файла

					if (data != null && data.length == i) {
						contact = new Contact(data);
						contactsList.add(contact);

					}
					System.out.println(contactsList);

				}
				daoSaveContacts.executeSave(contactsList);

				request.setAttribute("message", "Upload has been done successfully!");

				getServletContext().getRequestDispatcher("/cancel.jsp").forward(request, response);

			} catch (ServletException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
