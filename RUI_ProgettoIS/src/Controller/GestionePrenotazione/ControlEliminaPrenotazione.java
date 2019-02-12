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
 * Servlet implementation class ControlEliminaPrenotazione.
 */
@WebServlet("/ControlEliminaPrenotazione")
public class ControlEliminaPrenotazione extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new control elimina prenotazione.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlEliminaPrenotazione() {
		super();
		// TODO Auto-generated constructor stub
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
		int id = Integer.parseInt(request.getParameter("id"));
		PrenotazioneManager model = new PrenotazioneManager();
		try {
			model.eliminaPrenotazione(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.removeAttribute("id");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModificaStudente.jsp");
		dispatcher.forward(request, response);
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
