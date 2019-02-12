package Model.GestioneAutenticazione;

/**
 * The Class Studente.
 */
public class Studente extends Utente {

    /**
     * Instantiates a new studente.
     */
    public Studente() {
    }

    /**
     * Instantiates a new studente.
     *
     * @param email the email
     */
    public Studente(String email) {
        super(email);
    }

    /**
     * Instantiates a new studente.
     *
     * @param email the email
     * @param password the password
     */
    public Studente(String email, String password) {
        super(email, password);
    }

}
