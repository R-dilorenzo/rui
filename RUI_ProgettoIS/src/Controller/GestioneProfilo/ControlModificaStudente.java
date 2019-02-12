package Controller.GestioneProfilo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestioneAutenticazione.Studente;
import Model.GestioneAutenticazione.StudenteManager;


/**
 * Servlet implementation class ControlModificaStudente.
 */
@WebServlet("/ControlModificaStudente")
public class ControlModificaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaStudente() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			default:
				break;
			}

			StudenteManager.modifyUser(usr);
			request.getSession().setAttribute("Studente", usr);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaStudente.jsp");
			requestDispatcher.forward(request, response);

		}
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
