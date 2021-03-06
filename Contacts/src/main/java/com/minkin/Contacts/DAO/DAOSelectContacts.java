package com.minkin.Contacts.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.minkin.Contacts.model.Contact;

public class DAOSelectContacts {

	CachedRowSet crs;

	public DAOSelectContacts() {

	}

	public List<Contact> executeSelect(String order) throws IOException {
		List<Contact> contactsList = new ArrayList<>();

		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			crs = factory.createCachedRowSet();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

			{

				crs.setUrl("jdbc:mysql://localhost:3306/MyDB3");
				crs.setUsername("root");
				crs.setPassword("********");
				String command = "SELECT * FROM Contacts ORDER BY " + order;
				crs.setCommand(command);
				// crs.setCommand("SELECT * FROM Contacts ORDER BY ?");
				// crs.setString(1, order);

				crs.setPageSize(7);

				crs.execute();

				while (crs.next()) {
					Contact contact = new Contact();

					contact.setName(crs.getString(1));
					contact.setSurName(crs.getString(2));
					contact.setLogin(crs.getString(3));
					contact.setEmail(crs.getString(4));
					contact.setPhoneNumber(crs.getString(5));

					contactsList.add(contact);

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return contactsList;

	}

	public List<Contact> executePageNext() {
		List<Contact> contactsList = new ArrayList<>();
		try {

			if (crs.nextPage()) {
				while (crs.next()) {
					Contact contact = new Contact();

					contact.setName(crs.getString(1));
					contact.setSurName(crs.getString(2));
					contact.setLogin(crs.getString(3));
					contact.setEmail(crs.getString(4));
					contact.setPhoneNumber(crs.getString(5));

					contactsList.add(contact);

				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return contactsList;
	}

	public List<Contact> executePagePrevious() {
		List<Contact> contactsList = new ArrayList<>();
		try {

			if (crs.previousPage()) {
				while (crs.next()) {
					Contact contact = new Contact();

					contact.setName(crs.getString(1));
					contact.setSurName(crs.getString(2));
					contact.setLogin(crs.getString(3));
					contact.setEmail(crs.getString(4));
					contact.setPhoneNumber(crs.getString(5));

					contactsList.add(contact);

				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return contactsList;
	}

}
