package com.minkin.Certificate;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.minkin.Certificate.DAO.AttributeDAO;
import com.minkin.Certificate.DAO.CertificateDAO;
import com.minkin.Certificate.model.CertificateRegistration;
import com.minkin.Certificate.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		// List<CertificateRegistration> certificateList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Scanner in = new Scanner(System.in);
		try {

			CertificateDAO certificateDAO = new CertificateDAO(session);
			AttributeDAO attributeDAO = new AttributeDAO(session);

			String str = "1";

			while (!str.equals("0")) {

				System.out.println(" to enter data press 1\n to edit press 2\n to exit 0");

				if (in.hasNext())
					str = in.nextLine();

				if (str.equals("1")) {

					certificateDAO.setAttribute();
					certificateDAO.addCertificate();
				}
				if (str.equals("2")) {

					List<CertificateRegistration> certificateList = new ArrayList();

					certificateList = certificateDAO.getAllCertificate();
					for (CertificateRegistration cert : certificateList) {
						System.out.println(cert);
						System.out.println("--------------------");
					}
					attributeDAO.setParameters();
					attributeDAO.saveOrUpdateModel();
				}

			}

		} finally {
			System.out.println("exit");
			in.close();
			session.close();
		}

	}

}
