package com.minkin.action;

import com.minkin.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegistrUser extends ActionSupport implements ModelDriven<Object> {

	private User user = new User();
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {

		Authentication.addUser((User) getModel());
		return SUCCESS;
	}

	public Object getModel() {
		return user;
	}

}
