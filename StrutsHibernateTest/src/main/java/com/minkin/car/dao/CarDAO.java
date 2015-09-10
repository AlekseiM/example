package com.minkin.car.dao;

import java.util.List;

import com.minkin.car.model.Car;

public interface CarDAO {

	void saveOrUpdateCar(Car car);

	List<Car> getAllCar();

	Car getCar(Long carId);

	void delete(Long carId);

}
