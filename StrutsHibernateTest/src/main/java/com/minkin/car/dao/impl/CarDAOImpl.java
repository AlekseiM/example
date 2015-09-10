package com.minkin.car.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.minkin.car.dao.CarDAO;
import com.minkin.car.model.Car;

public class CarDAOImpl implements CarDAO {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	public void saveOrUpdateCar(Car car) {

		session.saveOrUpdate(car);

	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCar() {

		return session.createQuery("FROM Car").list();

	}

	public Car getCar(Long carId) {
		Car car = (Car) session.get(Car.class, carId);
		return car;

	}

	public void delete(Long carId) {
		Car car = (Car) session.get(Car.class, carId);
		session.delete(car);

	}

}
