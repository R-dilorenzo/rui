package Controller.GestioneAutenticazione;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.GestioneAutenticazione.Docente;
import Model.GestioneAutenticazione.DocenteManager;
import Model.GestioneAutenticazione.Studente;
import Model.GestioneAutenticazione.StudenteManager;

/**
 * The Class ControlLogin.
 */
@WebServlet("/ServletLogin")
public class ControlLogin extends HttpServlet {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new control login.
     */
    public ControlLogin() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Studente studente = new Studente(request.getParameter("email"), request.getParameter("password"));
		Docente docente = new Docente(request.getParameter("email"), request.getParameter("password"));
		HttpSession session = request.getSession();

		if (StudenteManager.doRetrieveByUser(studente)) {
			session.setAttribute("Studente", studente);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
			requestDispatcher.forward(request, response);
		} else if (DocenteManager.doRetrieveByUser(docente)) {
			session.setAttribute("Docente", docente);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("loginError", "True");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
			requestDispatcher.forward(request, response);
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
