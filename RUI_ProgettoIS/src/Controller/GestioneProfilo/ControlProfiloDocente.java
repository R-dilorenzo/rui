package Controller.GestioneProfilo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.GestioneAutenticazione.Docente;
import Model.GestioneAvviso.AvvisoManager;
import Model.GestionePrenotazione.PrenotazioneManager;

/**
 * Servlet implementation class Redirect.
 */
@WebServlet("/ControlProfiloDocente")
public class ControlProfiloDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlProfiloDocente() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Docente doc = (Docente) request.getSession().getAttribute("Docente");

		try {
			request.setAttribute("RicAvv", AvvisoManager.getAvvisibyDocente(doc.getMatricola()));
			request.setAttribute("RicPren", PrenotazioneManager.returnPrenotazionebyDocente(doc.getMatricola()));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaDocente.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
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
