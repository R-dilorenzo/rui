package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AvvisoManager;
import Model.Docente;
import Model.DocenteManager;
import Model.PrenotazioneManager;

/**
 * Servlet implementation class ControlRicercaDocente
 */
@WebServlet("/ControlRicercaDocente")
public class ControlRicercaDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlRicercaDocente() {
		super();
		// TODO Auto-generated constructor stub
	}

	AvvisoManager model = new AvvisoManager();
	PrenotazioneManager model1 = new PrenotazioneManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Docente doc = new Docente();
		
		doc.setMatricola(request.getParameter("matricolaDocente"));
		System.out.println(doc.getMatricola());

		try {

			DocenteManager.doRetrieveByMatricola(doc);

			request.setAttribute("RicAvv", model.getAvvisibyDocente(doc.getMatricola()));
			request.setAttribute("RicPren", model1.returnPrenotazionebyDocente(doc.getMatricola()));

			request.setAttribute("Docente", doc);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProfiloDocente.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
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
