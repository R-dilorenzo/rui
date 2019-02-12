package Controller.GestioneAvviso;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestioneAvviso.AvvisoManager;

/**
 * Servlet implementation class ControlModificaAvviso.
 */
@WebServlet("/ControlModificaAvviso")
public class ControlModificaAvviso extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new control modifica avviso.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaAvviso() {
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
		
		String dato = request.getParameter("dato");
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));


		if (dato != null && action != null) {
			try {
				boolean flag = AvvisoManager.modificaAvviso(id, dato, action);
				if (flag) {
					response.setStatus(HttpServletResponse.SC_ACCEPTED);

				} else {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaDocente.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
