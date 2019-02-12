package Controller.GestioneProfilo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestioneAutenticazione.DocenteManager;
import Model.GestioneAutenticazione.Studente;
import Model.GestionePrenotazione.PrenotazioneManager;


/**
 * Servlet implementation class Redirect1.
 */
@WebServlet("/ControlProfiloStudente")
public class ControlProfiloStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlProfiloStudente() {
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
		Studente stu = (Studente) request.getSession().getAttribute("Studente");
		try {
			request.setAttribute("LH", DocenteManager.doRetrieveAll());
			request.setAttribute("RicPren", PrenotazioneManager.returnPrenotazionebyStudente(stu.getMatricola()));
			System.out.println("uscente");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaStudente.jsp");
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
