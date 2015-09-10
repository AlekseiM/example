package com.minkin.car.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.minkin.car.dao.CarDAO;
import com.minkin.car.dao.impl.CarDAOImpl;
import com.minkin.car.model.Car;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CarAction extends ActionSupport implements ModelDriven<Car> {

	private static final long serialVersionUID = 3236820659579706600L;

	private Car car = new Car();
	private List<Car> carList = new ArrayList<Car>();
	private CarDAO carDAO = new CarDAOImpl();

	public String execute() throws Exception {
		return SUCCESS;
	}

	public Car getModel() {
		return car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public String saveOrUpdateCar() throws Exception {

		car.setCreatedDate(new Date());
		carDAO.saveOrUpdateCar(car);

		carList = carDAO.getAllCar();

		return SUCCESS;

	}

	public String getAllCar() throws Exception {

		carList = carDAO.getAllCar();

		return SUCCESS;

	}

	public String edit() throws Exception {

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		car = carDAO.getCar(Long.parseLong(request.getParameter("carId")));

		carList = carDAO.getAllCar();
		return SUCCESS;

	}

	public String delete() throws Exception {

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		carDAO.delete(Long.parseLong(request.getParameter("carId")));

		carList = carDAO.getAllCar();
		return SUCCESS;

	}

}
