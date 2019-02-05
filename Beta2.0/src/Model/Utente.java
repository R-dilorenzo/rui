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

	public void setEmail(String email) {
		// Create the Pattern using the regex
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		// Match the given string with the pattern
		Matcher m = p.matcher(email);

		if (m.matches()) {
			this.email = email;
		}
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		if (matricola.length() == 10)
		this.matricola = matricola;
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
