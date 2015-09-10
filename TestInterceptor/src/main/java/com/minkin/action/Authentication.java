package com.minkin.action;

import java.util.HashMap;
import java.util.Map;

import com.minkin.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class Authentication extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8911652766426809794L;

	private String login;
	private String password;
	private Map<String, User> session;

	// использую вместо базы данных
	private static Map<String, User> userStore = new HashMap<String, User>();

	public String execute() throws Exception {

		// для тестирования введу данные
		userStore.put("alexej", new User("alexej", "alexej", "123"));
		userStore.put("admin", new User("admin", "admin", "123"));

		User user = userStore.get(login);
		if ((user != null) && (user.getPassword().equals(password))) {

			session.put("user", user);
			return Action.SUCCESS;

		} else
			return Action.INPUT;
	}

	public static void addUser(User user) {
		userStore.put(user.getLogin(), user);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, User> getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	private boolean isEmptyString(String value) {
		return value.isEmpty() || "".equals(value.trim());
	}

	public void validate() {
		if (isEmptyString(login))
			addFieldError("login", "Не указан логин");
		if (isEmptyString(password))
			addFieldError("password", "Не указан пароль");
	}

}
