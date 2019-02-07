package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Docente extends Utente {

    private String giornoRicevimento1;
    private String giornoRicevimento2;
    private Double oraRicevimento1;
    private Double oraRicevimento2;
    private Double oraRicevimento3;
    private Double oraRicevimento4;
    private String insegnamento1;
    private String insegnamento2;
    private String imagePath;
    private String ufficio;

    public Docente() {
    }

    public Docente(String email) {
		super(email);
	}

    public Docente(String email, String password) {
		super(email, password);
	}

	public String getGiornoRicevimento1() {
		return giornoRicevimento1;
	}

	public void setGiornoRicevimento1(String giornoRicevimento1) {
		this.giornoRicevimento1 = giornoRicevimento1;
	}

	public String getGiornoRicevimento2() {
		return giornoRicevimento2;
	}

	public void setGiornoRicevimento2(String giornoRicevimento2) {
		this.giornoRicevimento2 = giornoRicevimento2;
	}

	public Double getOraRicevimento1() {
		return oraRicevimento1;
	}

	public void setOraRicevimento1(Double oraRicevimento1) {
		this.oraRicevimento1 = oraRicevimento1;
	}

	public Double getOraRicevimento2() {
		return oraRicevimento2;
	}

	public void setOraRicevimento2(Double oraRicevimento2) {
		this.oraRicevimento2 = oraRicevimento2;
	}

	public Double getOraRicevimento3() {
		return oraRicevimento3;
	}

	public void setOraRicevimento3(Double oraRicevimento3) {
		this.oraRicevimento3 = oraRicevimento3;
	}

	public String getInsegnamento1() {
		return insegnamento1;
	}

	public void setInsegnamento1(String insegnamento1) {
		this.insegnamento1 = insegnamento1;
	}

	public String getInsegnamento2() {
		return insegnamento2;
	}

	public void setInsegnamento2(String insegnamento2) {
		this.insegnamento2 = insegnamento2;
	}

	public Double getOraRicevimento4() {
		return oraRicevimento4;
	}

	public void setOraRicevimento4(Double oraRicevimento4) {
		this.oraRicevimento4 = oraRicevimento4;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

}
