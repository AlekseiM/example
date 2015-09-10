package com.minkin.action;

import java.util.Map;

import com.minkin.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// проверяем регистрацию пользователя
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if (user == null)
			return Action.LOGIN;
		else {
			@SuppressWarnings("unused")
			Action action = (Action) actionInvocation.getAction();
			return actionInvocation.invoke();
		}
	}

}
