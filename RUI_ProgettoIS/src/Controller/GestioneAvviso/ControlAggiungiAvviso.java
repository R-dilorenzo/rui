package Controller.GestioneAvviso;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GestioneAvviso.Avviso;
import Model.GestioneAvviso.AvvisoManager;

/**
 * Servlet implementation class ControlAggiungiAvviso.
 */
@WebServlet("/ControlAggiungiAvviso")
public class ControlAggiungiAvviso extends HttpServlet {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new control aggiungi avviso.
	 */
    public ControlAggiungiAvviso() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeAvviso = request.getParameter("nomeAvviso");
        double oraAvviso = Double.parseDouble(request.getParameter("oraAvviso"));
		String data = request.getParameter("data");
		String descrizione = request.getParameter("descrizione");
		String matricolaDocente = request.getParameter("matricolaDocente");

		Avviso bean = new Avviso();

		bean.setDescrizione(descrizione);
		bean.setNomeAvviso(nomeAvviso);
		bean.setData(data);
		bean.setOraAvviso(oraAvviso);
		bean.setMatricolaDocente(matricolaDocente);


		String userRegistered = null;
		try {
			userRegistered = AvvisoManager.agAvviso(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userRegistered.equals("SUCCESS")) {
            request.getRequestDispatcher("ModificaDocente.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/exception.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
