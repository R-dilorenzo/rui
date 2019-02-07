package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DriverManagerConnectionPool;

public class StudenteManager {

	/** Medoto di login
	 * @pre user diverso da null
	 * @param user contiene email e password inseriti dallo studente
	 * @return true se l'operazione va a buon fine altrimenti false
	 */
	public static synchronized boolean doRetrieveByUser(Studente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM studente WHERE email = ? AND password = ?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ResultSet res = ps.executeQuery();

			if (!res.next())
				return false;
			else {
				user.setMatricola(res.getString("matricola"));
				user.setNome(res.getString("nome"));
				user.setCognome(res.getString("cognome"));

				return (true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Metodo che registra uno studente
	 * @pre user diverso da null
	 * @param user oggetto contenente i dati da inserire nel database
	 * @return true se l'operazione va a buon fine altrimenti false
	 */
	public static synchronized boolean registerUser(Studente user) {

		Docente doc = new Docente();
		doc.setMatricola(user.getMatricola());
		doc.setEmail(user.getEmail());
		
		if (DocenteManager.doRetrieveByMatricola(doc) || StudenteManager.doRetrieveByMatricola(user)
				|| DocenteManager.doRetrieveByEmail(doc) || StudenteManager.doRetrieveByEmail(user)) {
			return false;
		}

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("INSERT INTO studente (nome, cognome, password, email, matricola) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCognome());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getMatricola());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Metodo usato per aggiornare le informazioni dello studente
	 * @pre user diverso da null
	 * @param user parametro usato epr aggiornare lo studente
	 * @return true se l'operazione va a buon fine altrimenti false
	 */
	public static synchronized boolean modifyUser(Studente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("UPDATE studente SET password = ? WHERE matricola = ?");
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE studente SET nome = ? WHERE matricola = ?");
			ps.setString(1, user.getNome());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE studente SET email = ? WHERE matricola = ?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE studente SET cognome = ? WHERE matricola = ?");
			ps.setString(1, user.getCognome());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Restituisce uno studente in base alla matricola aggiornato con tutte le informazioni
	 * @pre user diverso da null
	 * @param user usato per riconoscere lo studente 
	 * @return true se l'operazione va a buon fine altrimenti false
	 */ 
	public static synchronized boolean doRetrieveByMatricola(Studente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM studente WHERE matricola = ?");
			ps.setString(1, user.getMatricola());

			ResultSet res = ps.executeQuery();

			if (!res.next())
				return false;
			else {
				user.setEmail(res.getString("email"));
				user.setNome(res.getString("nome"));
				user.setCognome(res.getString("cognome"));

				return (true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * Medoto di eliminazione di uno studente
	 * @pre matricola != null
	 * @param matricola dato secondo cui cancellare un studente 
	 * @return true se l'operazione va a buon fine altrimenti false
	 */
	public static synchronized boolean eliminaStudente(String matricola) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("DELETE FROM studente WHERE Matricola = ?");
			ps.setString(1, matricola);
			ps.executeUpdate();
			ps.close();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * Ritorna uno studente 
	 * @pre user diverso da null
	 * @param user usato per riconoscere un studente in base all'email
	 * @return true se l'operazione va a buon fine altrimenti false
	 */
	public static synchronized boolean doRetrieveByEmail(Studente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM studente WHERE email = ?");
			ps.setString(1, user.getEmail());

			ResultSet res = ps.executeQuery();

			if (!res.next())
				return false;
			else {
				user.setMatricola(res.getString("matricola"));
				user.setNome(res.getString("nome"));
				user.setCognome(res.getString("cognome"));

				return (true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
