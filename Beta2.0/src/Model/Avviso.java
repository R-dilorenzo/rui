package Model;

import java.util.ArrayList;

import javafx.scene.chart.PieChart.Data;

public class Avviso {

	private int id;
	private String nomeAvviso;
	private String descrizione;
	private double oraAvviso;
	private String data;
	private String matricolaDocente;

	public Avviso() {

	}

	public Avviso(String nomeAvviso, String descrizione, double oraAvviso, String data,
			String matricolaDocente) {
		this.nomeAvviso = nomeAvviso;
		this.descrizione = descrizione;
		this.oraAvviso = oraAvviso;
		this.data = data;
		this.matricolaDocente = matricolaDocente;
	}

	public String getNomeAvviso() {
		return nomeAvviso;
	}

	public void setNomeAvviso(String nomeAvviso) {
		this.nomeAvviso = nomeAvviso;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getOraAvviso() {
		return oraAvviso;
	}

	public void setOraAvviso(double oraAvviso) {
		this.oraAvviso = oraAvviso;
	}

	public String getData() {
		return data;
	}

	public void setData(String data2) {
		this.data = data2;
	}

	public String getMatricolaDocente() {
		return matricolaDocente;
	}

	public void setMatricolaDocente(String matricolaDocente) {
		this.matricolaDocente = matricolaDocente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
