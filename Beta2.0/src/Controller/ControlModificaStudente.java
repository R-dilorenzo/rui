package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;

/**
 * Servlet implementation class ControlModificaStudente
 */
@WebServlet("/ControlModificaStudente")
public class ControlModificaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaStudente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dato = request.getParameter("dato");
		String action = request.getParameter("action");
		Studente usr = (Studente) request.getSession().getAttribute("Studente");

		if (dato != null && action != null) {

			switch (action) {
			case "email":
				usr.setEmail(dato);
				break;
			case "password":
				usr.setPassword(dato);
				break;
			}

			StudenteManager.modifyUser(usr);
			request.getSession().setAttribute("Studente", usr);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaStudente.jsp");
			requestDispatcher.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
