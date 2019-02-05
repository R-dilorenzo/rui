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
 * Servlet implementation class ControlModificaAvviso
 */
@WebServlet("/ControlModificaAvviso")
public class ControlModificaAvviso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaAvviso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String dato = null;
		String dato = request.getParameter("dato");
		String action = request.getParameter("action");
		// ArrayList<Avviso> usr = (ArrayList<Avviso>)
		// request.getSession().getAttribute("lista");
		// String nomeAvviso=(String) request.getSession().getAttribute("nomeAvviso");
		int id = Integer.parseInt(request.getParameter("id"));

//request.removeAttribute("docente");

		if (dato != null && action != null) {
			try {
				boolean flag = AvvisoManager.modificaAvviso(id, dato, action);
				if (flag) {
					response.setStatus(HttpServletResponse.SC_ACCEPTED);
					// request.getSession().removeAttribute("docente");

				} else {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
				// HttpSession session = request.getSession();
				// session.setAttribute("docente", model.ModificaUtente(matricolaDocente, dato,
				// action));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaDocente.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
