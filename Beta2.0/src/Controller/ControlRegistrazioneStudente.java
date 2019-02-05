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
 * Servlet implementation class ControlRegistrazioneStudente
 */
@WebServlet("/ControlRegistrazioneStudente")
public class ControlRegistrazioneStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlRegistrazioneStudente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String matricolaStudente = request.getParameter("matricolaStudente");
		String email = request.getParameter("email");

		Studente bean = new Studente();
		bean.setNome(nome);
		bean.setCognome(cognome);
		bean.setPassword(password);
		bean.setMatricola(matricolaStudente);
		bean.setEmail(email);

		if (StudenteManager.registerUser(bean)) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("ERROR", "true");
			request.getRequestDispatcher("RegistrazioneStudente.jsp").forward(request, response);
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
