package com.minkin.Contacts.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.minkin.Contacts.model.Contact;
import com.mysql.jdbc.PreparedStatement;

public class DAOSaveContacts {

	public DAOSaveContacts() {

	}

	public void executeSave(List<Contact> contacts) {
		try (Connection conn = getConnection()) {

			for (Contact contactModel : contacts) {
				String contactInsert = "INSERT INTO Contacts VALUES (?,?,?,?,?)";
				PreparedStatement stat = (PreparedStatement) conn.prepareStatement(contactInsert);
				stat.setString(1, contactModel.getName());
				stat.setString(2, contactModel.getSurName());
				stat.setString(3, contactModel.getLogin());
				stat.setString(4, contactModel.getEmail());
				stat.setString(5, contactModel.getPhoneNumber());
				stat.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void executeCreateTable() {
		try (Connection conn = getConnection()) {
			String commandDelete = "DROP TABLE IF EXISTS Contacts";
			String commandCreate = "CREATE TABLE Contacts(name varchar(30)," + "surName varchar(30),"
					+ "login varchar(30)," + "email varchar(30)," + "phoneNumber varchar(30))";
			PreparedStatement stat = (PreparedStatement) conn.prepareStatement(commandDelete);
			stat.executeUpdate();
			stat = (PreparedStatement) conn.prepareStatement(commandCreate);
			stat.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException, IOException {

		String url = "jdbc:mysql://localhost:3306/MyDB3";
		String username = "root";
		String password = "*********";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return DriverManager.getConnection(url, username, password);
	}

}
