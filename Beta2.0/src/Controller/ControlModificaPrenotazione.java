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
 * Servlet implementation class ControlModificaPrenotazione
 */
@WebServlet("/ControlModificaPrenotazione")
public class ControlModificaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaPrenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String dato = null;
		String dato = request.getParameter("dato");
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));

		if (dato != null && action != null && id != 0) {
			try {
				boolean flag = PrenotazioneManager.modificaPrenotazione(id, dato, action);
				if (flag) {
					response.setStatus(HttpServletResponse.SC_ACCEPTED);
					// request.getSession().removeAttribute("docente");

				} else {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
				// HttpSession session = request.getSession();
				// session.setAttribute("docente", model.ModificaUtente(matricolaDocente, dato,
				// action));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaStudente.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
