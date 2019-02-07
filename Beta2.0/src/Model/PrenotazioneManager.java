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
	 * Ritorna una lista dei prodotti presenti nel database
	 * @pre true
	 * @return lista contenente tutte la prenotazioni
	 */
	public ArrayList<Prenotazione> doRetrieveAll() throws SQLException {
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

				if (pr.getData().compareTo(inActiveDate) < 0) {
					continue;
				}

				pr.setOra(rs.getDouble("ora"));
				pr.setId(rs.getInt("id"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setMatricolaStudente(rs.getString("matricolaStudente"));
				pr.setMatricolaDocente(rs.getString("matricolaDocente"));
				lista.add(pr);
			}

		} catch (SQLException e) {
			conn.close();
		} 

		return lista;
	}

	/**
	 * Ritorna tutte leprenotazioni effettuate su un certo docente
	 * @pre matricoladocente diverso da null
	 * @param matricolaDocente contiene la matricola del docente di cui prendere tutte le prenotazioni
	 * @return lista con tutte le prenotazuioni di quel dato docente
	 * @throws SQLException
	 */
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

				if (pr.getData().compareTo(inActiveDate) < 0) {
					continue;
				}

				pr.setId(rs.getInt("id"));
				pr.setMatricolaStudente(rs.getString("matricolaStudente"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setMatricolaDocente(rs.getString("matricolaDocente"));
				pr.setOra(rs.getDouble("ora"));

				lista.add(pr);
			}

		} catch (SQLException e) {
			conn.close();
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

	/**
	 * Ritora tutte le prenotazioni effettuate da uno studente
	 * @pre matricolastudente diverso da null 
	 * @param matricolaStudente contiene la matricola del docente
	 * @return lista con tutte le prenotazioni effettuate da un dato studente
	 * @throws SQLException
	 */
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

				if (pr.getData().compareTo(inActiveDate) < 0) {
					continue;
				}

				pr.setId(rs.getInt("id"));
				pr.setMatricolaStudente(rs.getString("matricolaStudente"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setMatricolaDocente(rs.getString("matricolaDocente"));
				pr.setOra(rs.getDouble("ora"));
				pr.setCognomeDocente(rs.getString("cognome"));
				pr.setNomeDocente(rs.getString("nome"));
				lista.add(pr);
			}

		} catch (SQLException e) {
			conn.close();
		} 

		return lista;
	}

	/**
	 * Aggiunge una prenotazione nel database
	 * @pre pre diverso da null
	 * @param pre contiene tutti i dati della prenotazione
	 * @return una stringa indicante il risultato dell'operazione
	 * @throws SQLException 
	 */
	public String agPrenotazione(Prenotazione pre) throws SQLException {
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
			String query = "insert into prenotazione (id,data,ora,descrizione,matricolaStudente,matricolaDocente)values (?,?,?,?,?,?)"; // table
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, auto);
			preparedStatement.setString(2, data);
			preparedStatement.setDouble(2 + 1, ora);
			preparedStatement.setString(2 + 2, descrizione);
			preparedStatement.setString(2 + 2 + 1, matricolaStudente);
			preparedStatement.setString(2 + 2 + 2, matricolaDocente);

			int i = preparedStatement.executeUpdate();

			return "SUCCESS";

		} catch (SQLException e) {
			con.close();
		} 
		return "Oops.. Something went wrong there..!";

	}

	/**
	 * Questo metodo permette di rimuovere una prenotazione dal database
	 * @pre id diverso da null
	 * @param id della prenotazione da rimuovere
	 * @return true se l'operazione va a buon fine altrimenti false
	 */
	public boolean eliminaPrenotazione(int id) throws SQLException {
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
		} catch (SQLException e) {
			conn.close();
		} 
		return true;
	}

	/**
	 * Restituisce una prenotazione
	 * @pre id diverso da null
	 * @param id usato per distinguere la prenotazione da restituire
	 * @return la prenotazione
	 * @throws SQLException
	 */
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

		} catch (SQLException e) {
			connection.close();
		} 
		return bean;
	}

	/**
	 * Modifica una prenotazione
	 * @param id usato per distinguere la prenotazione da modificare
	 * @param dato valore da aggiornare nella prenotazione
	 * @param action azione da eseguire sulla prenotazione
	 * @return true se l'operazione va a buon fine altrimenti false
	 * @throws SQLException
	 */
	public static boolean modificaPrenotazione(int id, String dato, String action) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement5 = null;
		if (dato == null) {
			return false;
		}
		if (action.equals("ora")) {

			if (dato.length() > 30) {
				return false;
			}

			String SQL = " UPDATE prenotazione SET ora = ? WHERE id = ?";
			try {
				conn = DriverManagerConnectionPool.getConnection();
				preparedStatement5 = conn.prepareStatement(SQL);
				preparedStatement5.setString(1, dato);
				preparedStatement5.setInt(2, id);
				preparedStatement5.execute();
				return true;
			} catch (SQLException e) {
				conn.close();
			} 

		}
		if (action.equals("data")) {

			if (dato.length() > 30) {
				return false;
			}

			String SQL = " UPDATE prenotazione SET data = ? WHERE id = ?";
			try {
				conn = DriverManagerConnectionPool.getConnection();
				preparedStatement5 = conn.prepareStatement(SQL);
				preparedStatement5.setString(1, dato);
				preparedStatement5.setInt(2, id);
				preparedStatement5.execute();
				return true;
			} catch (SQLException e) {
				conn.close();
			} 

		}
		if (action.equals("descrizione")) {
			if (dato.length() > 3000) {
				return false;
			}

			String SQL = " UPDATE prenotazione SET descrizione = ? WHERE id = ?";
			try {
				conn = DriverManagerConnectionPool.getConnection();
				preparedStatement5 = conn.prepareStatement(SQL);
				preparedStatement5.setString(1, dato);
				preparedStatement5.setInt(2, id);
				preparedStatement5.execute();
				return true;
			} catch (SQLException e) {
				conn.close();
			} 

		}
		return false;

	}

}
