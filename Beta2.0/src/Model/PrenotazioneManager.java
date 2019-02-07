package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

import Database.DriverManagerConnectionPool;

public class PrenotazioneManager {

	/**
	 * Questo metodi ritorna una lista di tutti i prodotti presenti nel database
	 */
	public static ArrayList<Prenotazione> doRetrieveAll() throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement1 = null;
		ArrayList<Prenotazione> lista = new ArrayList<Prenotazione>();

		String SQL1 = "select * from prenotazione";

		try {
			conn = DriverManagerConnectionPool.getConnection();
			preparedStatement1 = conn.prepareStatement(SQL1);

			ResultSet rs = preparedStatement1.executeQuery();
			while (rs.next()) {
				Prenotazione pr = new Prenotazione();
				pr.setData(rs.getString("data"));
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();                     
				String inActiveDate = null;
				inActiveDate = sdf.format(date);
				
				if (pr.getData().compareTo(inActiveDate) < 0) continue;
				
				pr.setOra(rs.getDouble("ora"));
				pr.setId(rs.getInt("id"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setMatricolaStudente(rs.getString("matricolaStudente"));
				pr.setMatricolaDocente(rs.getString("matricolaDocente"));
				lista.add(pr);
			}

		} finally {
			try {
				if (preparedStatement1 != null && preparedStatement1 != null) {
					preparedStatement1.close();
				}
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		return lista;
	}

	public static ArrayList<Prenotazione> returnPrenotazionebyDocente(String matricolaDocente) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement1 = null;

		String SQL1 = "select * from prenotazione where  matricolaDocente=?";
		ArrayList<Prenotazione> lista = new ArrayList<Prenotazione>();
		try {
			conn = DriverManagerConnectionPool.getConnection();
			preparedStatement1 = conn.prepareStatement(SQL1);
			preparedStatement1.setString(1, matricolaDocente);

			ResultSet rs = preparedStatement1.executeQuery();
			while (rs.next()) {
				Prenotazione pr = new Prenotazione();
				pr.setData(rs.getString("data"));
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();                     
				String inActiveDate = null;
				inActiveDate = sdf.format(date);
				
				if (pr.getData().compareTo(inActiveDate) < 0) continue;
				
				pr.setId(rs.getInt("id"));
				pr.setMatricolaStudente(rs.getString("matricolaStudente"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setMatricolaDocente(rs.getString("matricolaDocente"));
				pr.setOra(rs.getDouble("ora"));
				
				lista.add(pr);
			}

		} finally {
			try {
				if (preparedStatement1 != null && preparedStatement1 != null) {
					preparedStatement1.close();
				}
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		String tempStr;
		double tempOra;
		int tempId;
		int length = lista.size();

		for (int t = 0; t < length - 1; t++) {
			for (int i = 0; i < length - t - 1; i++) {
				if ((lista.get(i + 1).getData()).compareTo((lista.get(i)).getData()) < 0) {

					tempStr = lista.get(i).getData();
					lista.get(i).setData(lista.get(i + 1).getData());
					lista.get(i + 1).setData(tempStr);

					tempStr = lista.get(i).getMatricolaDocente();
					lista.get(i).setMatricolaDocente(lista.get(i + 1).getMatricolaDocente());
					lista.get(i + 1).setMatricolaDocente(tempStr);

					tempStr = lista.get(i).getMatricolaStudente();
					lista.get(i).setMatricolaStudente(lista.get(i + 1).getMatricolaStudente());
					lista.get(i + 1).setMatricolaStudente(tempStr);

					tempOra = lista.get(i).getOra();
					lista.get(i).setOra(lista.get(i + 1).getOra());
					lista.get(i + 1).setOra(tempOra);

					tempId = lista.get(i).getId();
					lista.get(i).setId(lista.get(i + 1).getId());
					lista.get(i + 1).setId(tempId);

					tempStr = lista.get(i).getDescrizione();
					lista.get(i).setDescrizione(lista.get(i + 1).getDescrizione());
					lista.get(i + 1).setDescrizione(tempStr);
				} else if ((lista.get(i + 1).getData()).compareTo((lista.get(i)).getData()) == 0) {

					if ((lista.get(i + 1).getOra()) > ((lista.get(i)).getOra())) {

						tempStr = lista.get(i).getDescrizione();
						lista.get(i).setDescrizione(lista.get(i + 1).getDescrizione());
						lista.get(i + 1).setDescrizione(tempStr);

						tempStr = lista.get(i).getMatricolaDocente();
						lista.get(i).setMatricolaDocente(lista.get(i + 1).getMatricolaDocente());
						lista.get(i + 1).setMatricolaDocente(tempStr);

						tempOra = lista.get(i).getOra();
						lista.get(i).setOra(lista.get(i + 1).getOra());
						lista.get(i + 1).setOra(tempOra);

						tempStr = lista.get(i).getData();
						lista.get(i).setData(lista.get(i + 1).getData());
						lista.get(i + 1).setData(tempStr);
					}
				}

			}
		}

		return lista;
	}

	public static ArrayList<Prenotazione> returnPrenotazionebyStudente(String matricolaStudente) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement1 = null;

		String SQL1 = "SELECT * FROM prenotazione JOIN docente ON prenotazione.matricolaDocente = docente.matricola where prenotazione.matricolaStudente = ?";
		ArrayList<Prenotazione> lista = new ArrayList<Prenotazione>();
		try {
			conn = DriverManagerConnectionPool.getConnection();
			preparedStatement1 = conn.prepareStatement(SQL1);
			preparedStatement1.setString(1, matricolaStudente);

			ResultSet rs = preparedStatement1.executeQuery();
			while (rs.next()) {
				Prenotazione pr = new Prenotazione();
				pr.setData(rs.getString("data"));
			
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();                     
				String inActiveDate = null;
				inActiveDate = sdf.format(date);
				
				if (pr.getData().compareTo(inActiveDate) < 0) continue;
				
				pr.setId(rs.getInt("id"));
				pr.setMatricolaStudente(rs.getString("matricolaStudente"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setMatricolaDocente(rs.getString("matricolaDocente"));
				pr.setOra(rs.getDouble("ora"));
				
				pr.setCognomeDocente(rs.getString("cognome"));
				pr.setNomeDocente(rs.getString("nome"));
				lista.add(pr);
			}

		} finally {
			try {
				if (preparedStatement1 != null && preparedStatement1 != null) {
					preparedStatement1.close();
				}
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		return lista;
	}

	/*
	 * insermento di oggetto prenotazione nel database con incremento automatico
	 * dell' id
	 */
	public static String agPrenotazione(Prenotazione pre) {
		String matricolaStudente = pre.getMatricolaStudente();
		double ora = pre.getOra();
		String data = pre.getData();
		String descrizione = pre.getDescrizione();
		String matricolaDocente = pre.getMatricolaDocente();

		Connection con = null;
		PreparedStatement preparedStatement = null, ps1 = null;

		try {
			con = DriverManagerConnectionPool.getConnection();
			// con = driverManagerConnectionPool.getConnection();
			int auto = 0;
			ps1 = con.prepareStatement("select max(id) from prenotazione");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				auto = rs.getInt(1);
				auto++;
			}
			String query = "insert into prenotazione (id,data,ora,descrizione,matricolaStudente,matricolaDocente)values (?,?,?,?,?,?)"; // Insert
																																		// user
																																		// details
																																		// into
																																		// the
																																		// table
			preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
																// of data
			preparedStatement.setInt(1, auto);
			preparedStatement.setString(2, data);
			preparedStatement.setDouble(3, ora);
			preparedStatement.setString(4, descrizione);
			preparedStatement.setString(5, matricolaStudente);
			preparedStatement.setString(6, matricolaDocente);

			int i = preparedStatement.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the database
				return "SUCCESS";
			// driverManagerConnectionPool.releaseConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManagerConnectionPool.releaseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.

	}

	/**
	 * Questo metodo permette di rimuovere una prenotazione dal database. Ha come
	 * parametro l'id della prenotazione da rimuovere
	 */
	public static boolean eliminaPrenotazione(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement1 = null, ps2 = null;
		String SQLprova = "SELECT * FROM prenotazione WHERE id = ?";
		String selectSQL = "DELETE FROM prenotazione WHERE id = ?";
		try {
			conn = DriverManagerConnectionPool.getConnection();
			// con = driverManagerConnectionPool.getConnection();
			ps2 = conn.prepareStatement(SQLprova);
			ps2.setInt(1, id);
			ResultSet rs = ps2.executeQuery();
			if (!rs.next()) {

				return false;
			}
			preparedStatement1 = conn.prepareStatement(selectSQL);
			preparedStatement1.setInt(1, id);
			preparedStatement1.executeUpdate();
		} finally {
			try {
				if (preparedStatement1 != null) {
					preparedStatement1.close();
				}
			} finally {
				if (conn != null)
					conn.close();
			}
		}
		return true;
	}

	public static Prenotazione doRetrieveByKey(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Prenotazione bean = null;

		String selectSQL = "SELECT * FROM prenotazione JOIN docente ON prenotazione.matricolaDocente = docente.matricola WHERE id = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bean = new Prenotazione();
				bean.setId(rs.getInt("id"));
				bean.setMatricolaStudente(rs.getString("matricolaStudente"));
				bean.setOra(rs.getDouble("ora"));
				bean.setData(rs.getString("data"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMatricolaDocente(rs.getString("matricolaDocente"));
				bean.setNomeDocente(rs.getString("nome"));
				bean.setCognomeDocente(rs.getString("cognome"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

	public static boolean modificaPrenotazione(int id, String dato, String action) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement5 = null;
		if (dato == null)
			return false;
		if (action.equals("ora")) {

			if (dato.length() > 30)
				return false;

			String SQL = " UPDATE prenotazione SET ora = ? WHERE id = ?";
			try {
				conn = DriverManagerConnectionPool.getConnection();
				preparedStatement5 = conn.prepareStatement(SQL);
				preparedStatement5.setString(1, dato);
				preparedStatement5.setInt(2, id);
				preparedStatement5.execute();
				return true;
			} finally {
				try {
					if (preparedStatement5 != null) {
						preparedStatement5.close();
					}
				} finally {
					if (conn != null)
						conn.close();

				}
			}

		}
		if (action.equals("data")) {

			if (dato.length() > 30)
				return false;

			String SQL = " UPDATE prenotazione SET data = ? WHERE id = ?";
			try {

				conn = DriverManagerConnectionPool.getConnection();
				preparedStatement5 = conn.prepareStatement(SQL);
				preparedStatement5.setString(1, dato);
				preparedStatement5.setInt(2, id);
				preparedStatement5.execute();
				return true;
			} finally {
				try {
					if (preparedStatement5 != null) {
						preparedStatement5.close();
					}
				} finally {
					if (conn != null)
						conn.close();

				}
			}

		}
		if (action.equals("descrizione")) {
			if (dato.length() > 3000)
				return false;

			String SQL = " UPDATE prenotazione SET descrizione = ? WHERE id = ?";
			try {
				conn = DriverManagerConnectionPool.getConnection();
				preparedStatement5 = conn.prepareStatement(SQL);
				preparedStatement5.setString(1, dato);
				preparedStatement5.setInt(2, id);
				preparedStatement5.execute();
				return true;
			} finally {
				try {
					if (preparedStatement5 != null) {
						preparedStatement5.close();
					}
				} finally {
					if (conn != null)
						conn.close();

				}
			}

		}
		return false;

	}

}// fine classe
