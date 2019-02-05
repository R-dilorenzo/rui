package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DriverManagerConnectionPool;


public class DocenteManager {

	
	/* Medoto di login. Prende un oggetto docente con campi email e password settati. Gi altri campi del docente verranno settati 
	 * con una query se email e password coincidono. Ritorna true se è stato trovato un docente compatibile, false altrimenti*/
	public static synchronized boolean doRetrieveByUser(Docente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM docente WHERE email = ? AND password = ?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ResultSet res = ps.executeQuery();

			if (!res.next())
				return false;
			else {
				user.setMatricola(res.getString("matricola"));
				user.setInsegnamento1(res.getString("insegnamento1"));
				user.setInsegnamento2(res.getString("insegnamento2"));
				user.setGiornoRicevimento1(res.getString("giornoRicevimento1"));
				user.setGiornoRicevimento2(res.getString("giornoRicevimento2"));
				user.setOraRicevimento1(res.getDouble("oraRicevimento1"));
				user.setOraRicevimento2(res.getDouble("oraRicevimento2"));
				user.setOraRicevimento3(res.getDouble("oraRicevimento3"));
				user.setOraRicevimento4(res.getDouble("oraRicevimento4"));
				user.setCognome(res.getString("cognome"));
				user.setNome(res.getString("nome"));
				user.setImagePath(res.getString("Img"));
				user.setUfficio("ufficio");

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

	/* Medoto di registrazione. Prende un oggetto docente con tutti gli attributi obbligatori settati. Il docente verrà salvato 
	 * sul db se non esiste gia e ritorna true, false altrimenti*/
	public static synchronized boolean registerUser(Docente user) {

		/* Verifica che non esista un altro docente/studente con la stessa mail/matricola */
		Studente stu = new Studente();
		stu.setMatricola(user.getMatricola());
		stu.setEmail(user.getEmail());
		if (DocenteManager.doRetrieveByMatricola(user) || StudenteManager.doRetrieveByMatricola(stu) 
				|| DocenteManager.doRetrieveByEmail(user) || StudenteManager.doRetrieveByEmail(stu)) {
			return false;
		}

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement(
					"INSERT INTO docente (nome, password, email, matricola, insegnamento1, insegnamento2, cognome) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, user.getNome());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMatricola());
			ps.setString(5, user.getInsegnamento1());
			ps.setString(6, user.getInsegnamento2());
			ps.setString(7, user.getCognome());

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

	/* Medoto di aggiornamento. Prende un oggetto docente con tutti gli attributi settati e aggiorna il database*/
	public static synchronized boolean modifyUser(Docente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("UPDATE docente SET password = ? WHERE matricola = ?");
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET nome = ? WHERE matricola = ?");
			ps.setString(1, user.getNome());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET cognome = ? WHERE matricola = ?");
			ps.setString(1, user.getCognome());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET email = ? WHERE matricola = ?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET insegnamento1 = ? WHERE matricola = ?");
			ps.setString(1, user.getInsegnamento1());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET insegnamento2 = ? WHERE matricola = ?");
			ps.setString(1, user.getInsegnamento2());
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

	/* Secondo medoto di aggiornamento */
	public static synchronized boolean modifyRicevimento(Docente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("UPDATE docente SET giornoRicevimento1 = ? WHERE matricola = ?");
			ps.setString(1, user.getGiornoRicevimento1());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET giornoRicevimento2 = ? WHERE matricola = ?");
			ps.setString(1, user.getGiornoRicevimento2());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET oraRicevimento1 = ? WHERE matricola = ?");
			ps.setDouble(1, user.getOraRicevimento1());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET oraRicevimento2 = ? WHERE matricola = ?");
			ps.setDouble(1, user.getOraRicevimento2());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET oraRicevimento3 = ? WHERE matricola = ?");
			ps.setDouble(1, user.getOraRicevimento3());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET oraRicevimento4 = ? WHERE matricola = ?");
			ps.setDouble(1, user.getOraRicevimento4());
			ps.setString(2, user.getMatricola());
			ps.executeUpdate();
			ps.close();

			ps = conn.prepareStatement("UPDATE docente SET ufficio = ? WHERE matricola = ?");
			ps.setString(1, user.getUfficio());
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

	/* Ritorna tutti i docenti del db*/
	public static synchronized ArrayList<Docente> doRetrieveAll() {

		ArrayList<Docente> docenti = new ArrayList<Docente>();
		Connection conn = null;
		PreparedStatement ps = null;
		Docente user = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("SELECT * FROM docente");

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				user = new Docente();
				user.setEmail(res.getString("email"));
				user.setMatricola(res.getString("matricola"));
				user.setInsegnamento1(res.getString("insegnamento1"));
				user.setInsegnamento2(res.getString("insegnamento2"));
				user.setGiornoRicevimento1(res.getString("giornoRicevimento1"));
				user.setGiornoRicevimento2(res.getString("giornoRicevimento2"));
				user.setOraRicevimento1(res.getDouble("oraRicevimento1"));
				user.setOraRicevimento2(res.getDouble("oraRicevimento2"));
				user.setOraRicevimento3(res.getDouble("oraRicevimento3"));
				user.setOraRicevimento4(res.getDouble("oraRicevimento4"));
				user.setCognome(res.getString("cognome"));
				user.setNome(res.getString("nome"));
				user.setImagePath(res.getString("Img"));
				user.setUfficio(res.getString("ufficio"));
				docenti.add(user);
			}

			String tempStr;
			int length = docenti.size();

			for (int t = 0; t < length - 1; t++) {
				for (int i = 0; i < length - t - 1; i++) {
					if ((docenti.get(i + 1).getCognome()).compareTo((docenti.get(i)).getCognome()) < 0) {

						tempStr = docenti.get(i).getCognome();
						docenti.get(i).setCognome(docenti.get(i + 1).getCognome());
						docenti.get(i + 1).setCognome(tempStr);

						tempStr = docenti.get(i).getNome();
						docenti.get(i).setNome(docenti.get(i + 1).getNome());
						docenti.get(i + 1).setNome(tempStr);

						tempStr = docenti.get(i).getMatricola();
						docenti.get(i).setMatricola(docenti.get(i + 1).getMatricola());
						docenti.get(i + 1).setMatricola(tempStr);
					}
				}
			}
			return (docenti);

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
		return null;
	}

	/* Ritorna un docente in base alla matricola */
	public static synchronized boolean doRetrieveByMatricola(Docente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM docente WHERE matricola = ?");
			ps.setString(1, user.getMatricola());

			ResultSet res = ps.executeQuery();

			if (!res.next())
				return false;
			else {
				user.setEmail(res.getString("email"));
				user.setInsegnamento1(res.getString("insegnamento1"));
				user.setInsegnamento2(res.getString("insegnamento2"));
				user.setGiornoRicevimento1(res.getString("giornoRicevimento1"));
				user.setGiornoRicevimento2(res.getString("giornoRicevimento2"));
				user.setOraRicevimento1(res.getDouble("oraRicevimento1"));
				user.setOraRicevimento2(res.getDouble("oraRicevimento2"));
				user.setOraRicevimento3(res.getDouble("oraRicevimento3"));
				user.setOraRicevimento4(res.getDouble("oraRicevimento4"));
				user.setCognome(res.getString("cognome"));
				user.setNome(res.getString("nome"));
				user.setImagePath(res.getString("Img"));
				user.setUfficio(res.getString("ufficio"));

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

	/* Aggiorna l'immagine del docente */
	public static boolean modifyImage(Docente user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("UPDATE docente SET Img = ? WHERE matricola = ?");
			ps.setString(1, user.getImagePath());
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
	
	/*Medoto di eliminazione, usato per testing */
	public static synchronized boolean eliminaDocente(String matricola) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();

			ps = conn.prepareStatement("DELETE FROM docente WHERE Matricola = ?");
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
	
	/*Ritorna un docente in base alla matricola */
	public static synchronized boolean doRetrieveByEmail(Docente user) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM docente WHERE email = ?");
			ps.setString(1, user.getEmail());

			ResultSet res = ps.executeQuery();

			if (!res.next())
				return false;
			else {
				user.setMatricola(res.getString("matricola"));
				user.setInsegnamento1(res.getString("insegnamento1"));
				user.setInsegnamento2(res.getString("insegnamento2"));
				user.setGiornoRicevimento1(res.getString("giornoRicevimento1"));
				user.setGiornoRicevimento2(res.getString("giornoRicevimento2"));
				user.setOraRicevimento1(res.getDouble("oraRicevimento1"));
				user.setOraRicevimento2(res.getDouble("oraRicevimento2"));
				user.setOraRicevimento3(res.getDouble("oraRicevimento3"));
				user.setOraRicevimento4(res.getDouble("oraRicevimento4"));
				user.setCognome(res.getString("cognome"));
				user.setNome(res.getString("nome"));
				user.setImagePath(res.getString("Img"));
				user.setUfficio(res.getString("ufficio"));

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
