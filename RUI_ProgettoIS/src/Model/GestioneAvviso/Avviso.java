package Model.GestioneAvviso;

/**
 * The Class Avviso.
 */
public class Avviso {

	/** The id. */
	private int id;
	
	/** The nome avviso. */
	private String nomeAvviso;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The ora avviso. */
	private double oraAvviso;
	
	/** The data. */
	private String data;
	
	/** The matricola docente. */
	private String matricolaDocente;

	/**
	 * Instantiates a new avviso.
	 */
	public Avviso() {

	}

	/**
	 * Instantiates a new avviso.
	 *
	 * @param nomeAvviso the nome avviso
	 * @param descrizione the descrizione
	 * @param oraAvviso the ora avviso
	 * @param data the data
	 * @param matricolaDocente the matricola docente
	 */
	public Avviso(String nomeAvviso, String descrizione, double oraAvviso, String data,
			String matricolaDocente) {
		this.nomeAvviso = nomeAvviso;
		this.descrizione = descrizione;
		this.oraAvviso = oraAvviso;
		this.data = data;
		this.matricolaDocente = matricolaDocente;
	}

	/**
	 * Gets the nome avviso.
	 *
	 * @return the nome avviso
	 */
	public String getNomeAvviso() {
		return nomeAvviso;
	}

	/**
	 * Sets the nome avviso.
	 *
	 * @param nomeAvviso the new nome avviso
	 */
	public void setNomeAvviso(String nomeAvviso) {
		this.nomeAvviso = nomeAvviso;
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
	 * Gets the ora avviso.
	 *
	 * @return the ora avviso
	 */
	public double getOraAvviso() {
		return oraAvviso;
	}

	/**
	 * Sets the ora avviso.
	 *
	 * @param oraAvviso the new ora avviso
	 */
	public void setOraAvviso(double oraAvviso) {
		this.oraAvviso = oraAvviso;
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
	 * @param data2 the new data
	 */
	public void setData(String data2) {
		this.data = data2;
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

}
