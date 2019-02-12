package Controller.GestionePrenotazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestioneAutenticazione.Studente;
import Model.GestionePrenotazione.Prenotazione;
import Model.GestionePrenotazione.PrenotazioneManager;

/**
 * Servlet implementation class ControlAggiungiPrenotazione.
 */
@WebServlet("/ControlAggiungiPrenotazione")
public class ControlAggiungiPrenotazione extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Instantiates a new control aggiungi prenotazione.
	 */
	public ControlAggiungiPrenotazione() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studente stu = (Studente) request.getSession().getAttribute("Studente");
		double ora = Double.parseDouble(request.getParameter("ora"));
		String data = request.getParameter("data");
		String descrizione = request.getParameter("descrizione");
		String matricolaDocente = request.getParameter("matricolaDocente");

		Prenotazione bean = new Prenotazione();

		bean.setDescrizione(descrizione);
		bean.setMatricolaStudente(stu.getMatricola());
		bean.setData(data);
		bean.setOra(ora);
		bean.setMatricolaDocente(matricolaDocente);

		PrenotazioneManager pren = new PrenotazioneManager();

		String userRegistered = null;
		try {
			userRegistered = pren.agPrenotazione(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (userRegistered.equals("SUCCESS")) {
			request.getRequestDispatcher("/ControlRicercaDocente").forward(request, response);
		} else {
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/exception.jsp").forward(request, response);
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
