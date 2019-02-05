package Model;

public class Prenotazione {

	private int id;
	private String matricolaDocente;
	private String matricolaStudente;
	private String descrizione;
	private String data;
	private double ora;
	private String nomeDocente;
	private String cognomeDocente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricolaDocente() {
		return matricolaDocente;
	}

	public void setMatricolaDocente(String matricolaDocente) {
		this.matricolaDocente = matricolaDocente;
	}

	public String getMatricolaStudente() {
		return matricolaStudente;
	}

	public void setMatricolaStudente(String matricolaStudente) {
		this.matricolaStudente = matricolaStudente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getOra() {
		return ora;
	}

	public void setOra(double ora) {
		this.ora = ora;
	}

	public Prenotazione() {
	}

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

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public String getCognomeDocente() {
		return cognomeDocente;
	}

	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}

}
