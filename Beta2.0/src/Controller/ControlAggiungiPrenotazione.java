package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

/**
 * Servlet implementation class ControlAggiungiPrenotazione
 */
@WebServlet("/ControlAggiungiPrenotazione")
public class ControlAggiungiPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlAggiungiPrenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		// The core Logic of the Registration application is present here. We are going
		// to insert user data in to the database.
		String userRegistered = pren.agPrenotazione(bean);

		if (userRegistered.equals("SUCCESS")) // On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/ControlRicercaDocente").forward(request, response);
		} else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/exception.jsp").forward(request, response);
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
