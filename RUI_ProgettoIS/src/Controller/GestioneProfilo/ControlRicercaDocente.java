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
import Model.GestioneAutenticazione.DocenteManager;
import Model.GestioneAvviso.AvvisoManager;
import Model.GestionePrenotazione.PrenotazioneManager;

/**
 * Servlet implementation class ControlRicercaDocente.
 */
@WebServlet("/ControlRicercaDocente")
public class ControlRicercaDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlRicercaDocente() {
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

		Docente doc = new Docente();
		
		doc.setMatricola(request.getParameter("matricolaDocente"));
		System.out.println(doc.getMatricola());

		try {

			DocenteManager.doRetrieveByMatricola(doc);

			request.setAttribute("RicAvv", AvvisoManager.getAvvisibyDocente(doc.getMatricola()));
			request.setAttribute("RicPren", PrenotazioneManager.returnPrenotazionebyDocente(doc.getMatricola()));

			request.setAttribute("Docente", doc);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProfiloDocente.jsp");
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
