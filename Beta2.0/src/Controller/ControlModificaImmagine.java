package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Docente;
import Model.DocenteManager;

/**
 * Servlet implementation class ControllAggiungiImmagine
 */
@WebServlet("/ControlModificaImmagine")
@MultipartConfig
public class ControlModificaImmagine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlModificaImmagine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Docente doc = (Docente) request.getSession().getAttribute("Docente");
		javax.servlet.http.Part filePart = request.getPart("immagine");
		InputStream fileContent = filePart.getInputStream();
		String fileName = filePart.getSubmittedFileName();

		String tomcatRoot = getServletContext().getRealPath("/");
		String imagePath = "immagini\\" + doc.getMatricola() + fileName;

		String filePath = tomcatRoot + imagePath;

		System.out.println(filePath);

		OutputStream os = null;
		System.out.println("prova");
		try {
			File file = new File(filePath);
			System.out.println("prova");
			file.createNewFile();
			System.out.println("prova");

			os = new FileOutputStream(file, false);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = fileContent.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			fileContent.close();
			os.close();
		}

		System.out.println("prova");
		doc.setImagePath("immagini/" + doc.getMatricola() + fileName);
		if (DocenteManager.modifyImage(doc)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaDocente.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
