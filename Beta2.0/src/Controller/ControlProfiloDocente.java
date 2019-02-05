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
import Model.*;

/**
 * Servlet implementation class Redirect
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

	AvvisoManager model = new AvvisoManager();
	PrenotazioneManager model1 = new PrenotazioneManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Docente doc = (Docente) request.getSession().getAttribute("Docente");

		try {
			request.setAttribute("RicAvv", model.getAvvisibyDocente(doc.getMatricola()));
			request.setAttribute("RicPren", model1.returnPrenotazionebyDocente(doc.getMatricola()));

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaDocente.jsp");
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
