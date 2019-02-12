package Controller.GestionePrenotazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestionePrenotazione.PrenotazioneManager;

/**
 * Servlet implementation class ControlModificaPrenotazione.
 */
@WebServlet("/ControlModificaPrenotazione")
public class ControlModificaPrenotazione extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new control modifica prenotazione.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaPrenotazione() {
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
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
