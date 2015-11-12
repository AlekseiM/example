package com.minkin.Contacts.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minkin.Contacts.DAO.DAOSaveContacts;

import com.minkin.Contacts.model.ModelView;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8172398644117889990L;
	private ModelView modelView = new ModelView();

	public ViewServlet() {

	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionView = request.getParameter("View");
		if ((actionView != null) && (actionView.equals("view"))) {
			modelView.executeRequest(request, response);
		}

		String actionRead = request.getParameter("readCSV");
		if (actionRead != null) {

			request.getRequestDispatcher("/csvread.jsp").forward(request, response);
		}

		String actionPage = request.getParameter("page");
		if ((actionPage != null) && (actionPage.equals("next"))) {
			modelView.executeRequestPageNext(request, response);
		}

		if ((actionPage != null) && (actionPage.equals("previous"))) {
			modelView.executeRequestPagePrevious(request, response);
		}

		String actionOrder = request.getParameter("order");
		if (actionOrder != null) {
			modelView.executeRequest(request, response);
		}

		String actionCreate = request.getParameter("create");
		if (actionCreate != null) {
			createTable(request, response);
		}

	}

	private void createTable(HttpServletRequest request, HttpServletResponse response) {
		DAOSaveContacts daoSaveContacts = new DAOSaveContacts();
		synchronized (daoSaveContacts) {

			daoSaveContacts.executeCreateTable();

			request.setAttribute("message", "A new table is created!");

			try {
				request.getRequestDispatcher("/cancel.jsp").forward(request, response);

			} catch (ServletException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
