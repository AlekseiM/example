package com.minkin.Contacts.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minkin.Contacts.DAO.DAOSelectContacts;

public class ModelView {
	private DAOSelectContacts daoSelectContacts = new DAOSelectContacts();

	public ModelView() {

	}

	public void executeRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		List<Contact> contactsList = new ArrayList<>();

		String order = "";

		order = request.getParameter("order");

		try {

			contactsList = daoSelectContacts.executeSelect(order);
			for (Contact contact : contactsList)
				System.out.println(contact);

			request.setAttribute("contactsList", contactsList);
			request.getRequestDispatcher("/view.jsp").forward(request, response);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void executeRequestPageNext(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		List<Contact> contactsList = new ArrayList<>();
		try {
			contactsList = daoSelectContacts.executePageNext();

			for (Contact contact : contactsList)
				System.out.println(contact);

			request.setAttribute("contactsList", contactsList);
			request.getRequestDispatcher("/view.jsp").forward(request, response);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void executeRequestPagePrevious(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		List<Contact> contactsList = new ArrayList<>();
		try {
			contactsList = daoSelectContacts.executePagePrevious();

			for (Contact contact : contactsList)
				System.out.println(contact);

			request.setAttribute("contactsList", contactsList);
			request.getRequestDispatcher("/view.jsp").forward(request, response);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
