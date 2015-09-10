package com.minkin;

import org.hibernate.Session;

import com.minkin.address.Address;
import com.minkin.address.Resident;
import com.minkin.util.HibernateUtil;


public class Main {

    public static void main( String[] args ){
    	Session session = HibernateUtil.getSessionFactory().openSession();

    	session.beginTransaction();
      
    	Address address = new Address();
    	    address.setCity("Moscow");
            address.setStreet("Lva Tolstogo");
            address.setHouse("16");
            
            session.save(address);
            
            
            Resident  resident = new Resident("Ivan", "Pak", 20, address);
            address.getResidents().add(resident);
            session.save(resident);
            
            Resident  resident2 = new Resident("Serg", "Petrov", 22, address);
            address.getResidents().add(resident2);
            session.save(resident2);
            
            
    	session.getTransaction().commit();
    	System.out.println(address);
    	System.out.println("Done");
    	}
  

}
