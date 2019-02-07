package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Utente {

	private String matricola;
	private String nome;
	private String cognome;
	private String password;
	private String email;

	public Utente() {
	}

	public Utente(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	public Utente(String email) {
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	/**
	 * Imposta l'email dell'utente
	 * @pre email diverso da null
	 * @param email parametro da impostare
	 */
	public void setEmail(String email) {
		Pattern p = Pattern.compile(".+@.+\\.unisa.it");

		Matcher m = p.matcher(email);

		if (m.matches()) {
			this.email = email;
		}
	}

	public String getMatricola() {
		return matricola;
	}

	/**
	 * Metodo che aggiorna la matricola dell'utente
	 * @pre matricola diverso da null
	 * @param matricola parametro da aggiornare
	 */
	public void setMatricola(String matricola) {
        if (matricola.length() == 10) {
			this.matricola = matricola;
        }
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
