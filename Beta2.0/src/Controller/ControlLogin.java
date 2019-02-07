package Controller;

import Model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletLogin")
public class ControlLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControlLogin() {
        super();
	}

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}