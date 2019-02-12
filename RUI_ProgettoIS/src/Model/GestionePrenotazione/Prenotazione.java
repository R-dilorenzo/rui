package Model.GestionePrenotazione;

/**
 * The Class Prenotazione.
 */
public class Prenotazione {

	/** The id. */
	private int id;
	
	/** The matricola docente. */
	private String matricolaDocente;
	
	/** The matricola studente. */
	private String matricolaStudente;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The data. */
	private String data;
	
	/** The ora. */
	private double ora;
	
	/** The nome docente. */
	private String nomeDocente;
	
	/** The cognome docente. */
	private String cognomeDocente;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the matricola docente.
	 *
	 * @return the matricola docente
	 */
	public String getMatricolaDocente() {
		return matricolaDocente;
	}

	/**
	 * Sets the matricola docente.
	 *
	 * @param matricolaDocente the new matricola docente
	 */
	public void setMatricolaDocente(String matricolaDocente) {
		this.matricolaDocente = matricolaDocente;
	}

	/**
	 * Gets the matricola studente.
	 *
	 * @return the matricola studente
	 */
	public String getMatricolaStudente() {
		return matricolaStudente;
	}

	/**
	 * Sets the matricola studente.
	 *
	 * @param matricolaStudente the new matricola studente
	 */
	public void setMatricolaStudente(String matricolaStudente) {
		this.matricolaStudente = matricolaStudente;
	}

	/**
	 * Gets the descrizione.
	 *
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Sets the descrizione.
	 *
	 * @param descrizione the new descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Gets the ora.
	 *
	 * @return the ora
	 */
	public double getOra() {
		return ora;
	}

	/**
	 * Sets the ora.
	 *
	 * @param ora the new ora
	 */
	public void setOra(double ora) {
		this.ora = ora;
	}

	/**
	 * Instantiates a new prenotazione.
	 */
	public Prenotazione() {
	}

	/**
	 * Instantiates a new prenotazione.
	 *
	 * @param id the id
	 * @param matricolaDocente the matricola docente
	 * @param matricolaStudente the matricola studente
	 * @param descrizione the descrizione
	 * @param data the data
	 * @param ora the ora
	 */
	public Prenotazione(int id, String matricolaDocente, String matricolaStudente, String descrizione, String data,
			double ora) {
		super();
		this.id = id;
		this.matricolaDocente = matricolaDocente;
		this.matricolaStudente = matricolaStudente;
		this.descrizione = descrizione;
		this.data = data;
		this.ora = ora;
	}

	/**
	 * Gets the nome docente.
	 *
	 * @return the nome docente
	 */
	public String getNomeDocente() {
		return nomeDocente;
	}

	/**
	 * Sets the nome docente.
	 *
	 * @param nomeDocente the new nome docente
	 */
	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	/**
	 * Gets the cognome docente.
	 *
	 * @return the cognome docente
	 */
	public String getCognomeDocente() {
		return cognomeDocente;
	}

	/**
	 * Sets the cognome docente.
	 *
	 * @param cognomeDocente the new cognome docente
	 */
	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}

}
