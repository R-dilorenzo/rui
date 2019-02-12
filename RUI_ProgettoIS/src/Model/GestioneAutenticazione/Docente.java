package Model.GestioneAutenticazione;

/**
 * The Class Docente.
 */
public class Docente extends Utente {

    /** The giorno ricevimento 1. */
    private String giornoRicevimento1;
    
    /** The giorno ricevimento 2. */
    private String giornoRicevimento2;
    
    /** The ora ricevimento 1. */
    private Double oraRicevimento1;
    
    /** The ora ricevimento 2. */
    private Double oraRicevimento2;
    
    /** The ora ricevimento 3. */
    private Double oraRicevimento3;
    
    /** The ora ricevimento 4. */
    private Double oraRicevimento4;
    
    /** The insegnamento 1. */
    private String insegnamento1;
    
    /** The insegnamento 2. */
    private String insegnamento2;
    
    /** The image path. */
    private String imagePath;
    
    /** The ufficio. */
    private String ufficio;

    /**
     * Instantiates a new docente.
     */
    public Docente() {
    }

    /**
     * Instantiates a new docente.
     *
     * @param email the email
     */
    public Docente(String email) {
		super(email);
	}

    /**
     * Instantiates a new docente.
     *
     * @param email the email
     * @param password the password
     */
    public Docente(String email, String password) {
		super(email, password);
	}

	/**
	 * Gets the giorno ricevimento 1.
	 *
	 * @return the giorno ricevimento 1
	 */
	public String getGiornoRicevimento1() {
		return giornoRicevimento1;
	}

	/**
	 * Sets the giorno ricevimento 1.
	 *
	 * @param giornoRicevimento1 the new giorno ricevimento 1
	 */
	public void setGiornoRicevimento1(String giornoRicevimento1) {
		this.giornoRicevimento1 = giornoRicevimento1;
	}

	/**
	 * Gets the giorno ricevimento 2.
	 *
	 * @return the giorno ricevimento 2
	 */
	public String getGiornoRicevimento2() {
		return giornoRicevimento2;
	}

	/**
	 * Sets the giorno ricevimento 2.
	 *
	 * @param giornoRicevimento2 the new giorno ricevimento 2
	 */
	public void setGiornoRicevimento2(String giornoRicevimento2) {
		this.giornoRicevimento2 = giornoRicevimento2;
	}

	/**
	 * Gets the ora ricevimento 1.
	 *
	 * @return the ora ricevimento 1
	 */
	public Double getOraRicevimento1() {
		return oraRicevimento1;
	}

	/**
	 * Sets the ora ricevimento 1.
	 *
	 * @param oraRicevimento1 the new ora ricevimento 1
	 */
	public void setOraRicevimento1(Double oraRicevimento1) {
		this.oraRicevimento1 = oraRicevimento1;
	}

	/**
	 * Gets the ora ricevimento 2.
	 *
	 * @return the ora ricevimento 2
	 */
	public Double getOraRicevimento2() {
		return oraRicevimento2;
	}

	/**
	 * Sets the ora ricevimento 2.
	 *
	 * @param oraRicevimento2 the new ora ricevimento 2
	 */
	public void setOraRicevimento2(Double oraRicevimento2) {
		this.oraRicevimento2 = oraRicevimento2;
	}

	/**
	 * Gets the ora ricevimento 3.
	 *
	 * @return the ora ricevimento 3
	 */
	public Double getOraRicevimento3() {
		return oraRicevimento3;
	}

	/**
	 * Sets the ora ricevimento 3.
	 *
	 * @param oraRicevimento3 the new ora ricevimento 3
	 */
	public void setOraRicevimento3(Double oraRicevimento3) {
		this.oraRicevimento3 = oraRicevimento3;
	}

	/**
	 * Gets the insegnamento 1.
	 *
	 * @return the insegnamento 1
	 */
	public String getInsegnamento1() {
		return insegnamento1;
	}

	/**
	 * Sets the insegnamento 1.
	 *
	 * @param insegnamento1 the new insegnamento 1
	 */
	public void setInsegnamento1(String insegnamento1) {
		this.insegnamento1 = insegnamento1;
	}

	/**
	 * Gets the insegnamento 2.
	 *
	 * @return the insegnamento 2
	 */
	public String getInsegnamento2() {
		return insegnamento2;
	}

	/**
	 * Sets the insegnamento 2.
	 *
	 * @param insegnamento2 the new insegnamento 2
	 */
	public void setInsegnamento2(String insegnamento2) {
		this.insegnamento2 = insegnamento2;
	}

	/**
	 * Gets the ora ricevimento 4.
	 *
	 * @return the ora ricevimento 4
	 */
	public Double getOraRicevimento4() {
		return oraRicevimento4;
	}

	/**
	 * Sets the ora ricevimento 4.
	 *
	 * @param oraRicevimento4 the new ora ricevimento 4
	 */
	public void setOraRicevimento4(Double oraRicevimento4) {
		this.oraRicevimento4 = oraRicevimento4;
	}

	/**
	 * Gets the image path.
	 *
	 * @return the image path
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Sets the image path.
	 *
	 * @param imagePath the new image path
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * Gets the ufficio.
	 *
	 * @return the ufficio
	 */
	public String getUfficio() {
		return ufficio;
	}

	/**
	 * Sets the ufficio.
	 *
	 * @param ufficio the new ufficio
	 */
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

}
