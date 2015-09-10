package servlettestjsp;

import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelTest {

	private static SortedSet<Person> persons;
	private static int allVisit;

	public ModelTest() {
		persons = new TreeSet<>();
		allVisit = 0;
	}

	public void executeRequest(HttpServletRequest request) throws ServletException, IOException {

		allVisit++;
		String nameJsp = request.getParameter("name");
		if (nameJsp.isEmpty())
			return;
		if (nameJsp.trim().length() == 0)
			return;
		String emailJsp = request.getParameter("email");

		persons.add(new Person(nameJsp, emailJsp));
	}

	public void executeResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("allVisit", allVisit);
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
