package com.minkin.Certificate.DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.minkin.Certificate.model.CertificateRegistration;
import com.minkin.Certificate.model.DateIssue;
import com.minkin.Certificate.model.FirstName;
import com.minkin.Certificate.model.LastName;
import com.minkin.Certificate.model.MiddleName;
import com.minkin.Certificate.model.ModelPassport;
import com.minkin.Certificate.model.Number;
import com.minkin.Certificate.model.OrganizationRegistration;
import com.minkin.Certificate.model.Passport;
import com.minkin.Certificate.model.RegistrationDate;
import com.minkin.Certificate.model.Series;

public class CertificateDAO {
	private Session session;

	CertificateRegistration certificate = new CertificateRegistration();
	RegistrationDate registrationDate = new RegistrationDate();
	OrganizationRegistration organization = new OrganizationRegistration();
	Passport passport = new Passport();
	Passport passport2 = new Passport();

	LastName lastName = new LastName();
	FirstName firstName = new FirstName();
	MiddleName middleName = new MiddleName();
	Number number = new Number();
	Series series = new Series();
	DateIssue dateIssue = new DateIssue();

	LastName lastName2 = new LastName();
	FirstName firstName2 = new FirstName();
	MiddleName middleName2 = new MiddleName();
	Number number2 = new Number();
	Series series2 = new Series();
	DateIssue dateIssue2 = new DateIssue();

	List<ModelPassport> modelPassportList = new ArrayList<ModelPassport>();
	List<ModelPassport> modelPassportList2 = new ArrayList<ModelPassport>();

	public CertificateDAO(Session session) {
		this.session = session;
	}

	public void setAttribute() {
		Scanner in = new Scanner(System.in);

		System.out.println("enter the details of the certificate of registration");
		System.out.println("enter the date of registration");
		String str = in.nextLine();
		registrationDate.setInformation(str);

		System.out.println("enter the organization");
		str = in.nextLine();
		organization.setInformation(str);

		registrationDate.setCertificateRegistration(certificate);
		organization.setCertificateRegistration(certificate);

		passport.setCertificateRegistration(certificate);
		passport2.setCertificateRegistration(certificate);

		System.out.println("enter the passport details of husband");
		System.out.println("enter last name");
		str = in.nextLine();
		lastName.setInformation(str);
		modelPassportList.add(lastName);

		System.out.println("enter first name");
		str = in.nextLine();
		firstName.setInformation(str);
		modelPassportList.add(firstName);

		System.out.println("enter middle name");
		str = in.nextLine();
		middleName.setInformation(str);
		modelPassportList.add(middleName);

		System.out.println("enter number passport");
		str = in.nextLine();
		number.setInformation(str);
		modelPassportList.add(number);

		System.out.println("enter series passport");
		str = in.nextLine();
		series.setInformation(str);
		modelPassportList.add(series);

		System.out.println("enter date issue");
		str = in.nextLine();
		dateIssue.setInformation(str);
		modelPassportList.add(dateIssue);

		System.out.println("enter the passport details of spouse");
		System.out.println("enter last name");
		str = in.nextLine();
		lastName2.setInformation(str);
		modelPassportList2.add(lastName2);

		System.out.println("enter first name");
		str = in.nextLine();
		firstName2.setInformation(str);
		modelPassportList2.add(firstName2);

		System.out.println("enter middle name");
		str = in.nextLine();
		middleName2.setInformation(str);
		modelPassportList2.add(middleName2);

		System.out.println("enter number passport");
		str = in.nextLine();
		number2.setInformation(str);
		modelPassportList2.add(number2);

		System.out.println("enter series passport");
		str = in.nextLine();
		series2.setInformation(str);
		modelPassportList2.add(series2);

		System.out.println("enter date issue");
		str = in.nextLine();
		dateIssue2.setInformation(str);
		modelPassportList2.add(dateIssue2);

		for (ModelPassport modelPassport : modelPassportList)
			modelPassport.setPassport(passport);

		for (ModelPassport modelPassport : modelPassportList2)
			modelPassport.setPassport(passport2);

	}

	public void addCertificate() {
		Transaction t = null;

		try {

			t = session.beginTransaction();

			session.save(certificate);
			session.save(registrationDate);
			session.save(organization);
			session.save(passport);
			session.save(passport2);

			for (ModelPassport modelPassport : modelPassportList) {
				session.save(modelPassport);
			}

			for (ModelPassport modelPassport : modelPassportList2) {
				session.save(modelPassport);
			}

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}

	}

	@SuppressWarnings("unchecked")
	public List<CertificateRegistration> getAllCertificate() {
		List<CertificateRegistration> certificateList = new ArrayList<CertificateRegistration>();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			certificateList = (List<CertificateRegistration>) session.createQuery("FROM CertificateRegistration")
					.list();

			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return certificateList;

	}

}
