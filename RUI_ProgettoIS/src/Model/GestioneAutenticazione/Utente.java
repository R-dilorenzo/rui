package Model.GestioneAutenticazione;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Utente.
 */
public abstract class Utente {

	/** The matricola. */
	private String matricola;
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;

	/**
	 * Instantiates a new utente.
	 */
	public Utente() {
	}

	/**
	 * Instantiates a new utente.
	 *
	 * @param email the email
	 * @param password the password
	 */
	public Utente(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	/**
	 * Instantiates a new utente.
	 *
	 * @param email the email
	 */
	public Utente(String email) {
		this.setEmail(email);
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Imposta l'email dell'utente.
	 *
	 * @param email parametro da impostare
	 * @pre email diverso da null
	 */
	public void setEmail(String email) {
		Pattern p = Pattern.compile(".+@.+\\.unisa.it");

		Matcher m = p.matcher(email);

		if (m.matches()) {
			this.email = email;
		}
	}

	/**
	 * Gets the matricola.
	 *
	 * @return the matricola
	 */
	public String getMatricola() {
		return matricola;
	}

	/**
	 * Metodo che aggiorna la matricola dell'utente.
	 *
	 * @param matricola parametro da aggiornare
	 * @pre matricola diverso da null
	 */
	public void setMatricola(String matricola) {
        if (matricola.length() == 10) {
			this.matricola = matricola;
        }
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
