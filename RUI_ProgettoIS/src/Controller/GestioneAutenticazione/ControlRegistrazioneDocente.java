package Controller.GestioneAutenticazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestioneAutenticazione.Docente;
import Model.GestioneAutenticazione.DocenteManager;

/**
 * Servlet implementation class ControlRegistrazioneDocente.
 */
@WebServlet("/ControlRegistrazioneDocente")
public class ControlRegistrazioneDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlRegistrazioneDocente() {
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

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String matricolaDocente = request.getParameter("matricolaDocente");
		String email = request.getParameter("email");
		String insegnamento1 = request.getParameter("insegnamento1");
		String insegnamento2 = request.getParameter("insegnamento2");

		Docente bean = new Docente();
		bean.setNome(nome);
		bean.setCognome(cognome);
		bean.setPassword(password);
		bean.setMatricola(matricolaDocente);
		bean.setEmail(email);
		bean.setInsegnamento1(insegnamento1);
		bean.setInsegnamento2(insegnamento2);

		if (DocenteManager.registerUser(bean)) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			request.setAttribute("ERROR", "true");
			request.getRequestDispatcher("RegistrazioneDocente.jsp").forward(request, response);
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
