package Controller.GestionePrenotazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestionePrenotazione.PrenotazioneManager;

/**
 * Servlet implementation class ControlCalendario.
 */
@WebServlet("/ControlCalendario")
public class ControlCalendario extends HttpServlet {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Instantiates a new control calendario.
     *
     * @see HttpServlet#HttpServlet()
     */
    public ControlCalendario() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
            request.setAttribute("RicPren", PrenotazioneManager.returnPrenotazionebyDocente(request.getParameter("matricolaDocente")));

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Calendario.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
		}

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
