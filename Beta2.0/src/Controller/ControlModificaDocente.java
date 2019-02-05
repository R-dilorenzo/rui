package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

/**
 * Servlet implementation class ControlModificaDocente
 */
@WebServlet("/ControlModificaDocente")
public class ControlModificaDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaDocente() {
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
		Docente usr = (Docente) request.getSession().getAttribute("Docente");

		if (dato != null && action != null) {

			switch (action) {
			case "email":
				usr.setEmail(dato);
				break;
			case "insegnamento1":
				usr.setInsegnamento1(dato);
				break;
			case "insegnamento2":
				usr.setInsegnamento2(dato);
				break;
			case "password":
				usr.setPassword(dato);
				break;
			case "oraRicevimento1":
				usr.setOraRicevimento1(Double.parseDouble(dato));
				break;
			case "oraRicevimento2":
				usr.setOraRicevimento2(Double.parseDouble(dato));
				break;
			case "oraRicevimento3":
				usr.setOraRicevimento3(Double.parseDouble(dato));
				break;
			case "oraRicevimento4":
				usr.setOraRicevimento4(Double.parseDouble(dato));
				break;
			case "giornoRicevimento1":
				usr.setGiornoRicevimento1(dato);
				break;
			case "giornoRicevimento2":
				usr.setGiornoRicevimento2(dato);
				break;
			case "ufficio":
				usr.setUfficio(dato);
				break;
			}

			DocenteManager.modifyUser(usr);
			DocenteManager.modifyRicevimento(usr);
			request.getSession().setAttribute("Docente", usr);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaDocente.jsp");
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
