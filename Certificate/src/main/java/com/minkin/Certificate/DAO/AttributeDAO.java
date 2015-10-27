package com.minkin.Certificate.DAO;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.minkin.Certificate.model.Model;

public class AttributeDAO {

	Session session;
	String stringInformation;
	int id;
	Class c;

	public AttributeDAO(Session session) {
		this.session = session;
	}

	public void setParameters() {
		Scanner in = new Scanner(System.in);
		String stringClass = null;
		String str = null;

		System.out.println("enter the name of the parameter");
		str = in.nextLine();
		stringClass = "com.minkin.Certificate.model." + str;

		try {
			c = Class.forName(stringClass);
		} catch (ClassNotFoundException e) {
			System.out.println("Error! incorrect parameter name");
			e.printStackTrace();
		}

		System.out.println("enter id");
		while (!in.hasNextInt())
			System.out.println("Error incorrect id");
		id = in.nextInt();
		in.nextLine();

		System.out.println("enter information");
		stringInformation = in.nextLine();

	}

	public void saveOrUpdateModel() {
		Transaction t = null;

		try {

			t = session.beginTransaction();
			Model model = (Model) session.get(c, id);
			model.setInformation(stringInformation);
			session.saveOrUpdate(model);
			t.commit();

			System.out.println(model);

		} catch (HibernateException e) {
			System.out.println("Error! incorrect parameter");
			e.printStackTrace();
		}

	}

}
