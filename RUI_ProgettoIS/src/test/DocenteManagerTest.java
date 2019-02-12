package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Model.GestioneAutenticazione.Docente;
import Model.GestioneAutenticazione.DocenteManager;
import Model.GestioneAutenticazione.Studente;
import Model.GestioneAutenticazione.StudenteManager;



public class DocenteManagerTest {

	@Test
	public void testDoRetrieveByUser() {
		System.out.println("*testDoRetriveByUser*");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		assertEquals("Result",true, DocenteManager.doRetrieveByUser(docente));
		System.out.println("docente trovato");
		DocenteManager.eliminaDocente(docente.getMatricola());
		System.out.println("docente eliminato");
		assertEquals("Result",false, DocenteManager.doRetrieveByUser(docente));
		System.out.println("docente non trovato");
	}

	@Test
	public void testRegisterUser() {
		System.out.println("testRegisterUser");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola123");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		Docente docente2 = new Docente();
		docente2.setMatricola("0555566666");
		docente2.setEmail("isaoilbello@1.unisa.it");
		docente2.setCognome("silente");
		docente2.setNome("albus");
		docente2.setPassword("albus12345678");
		docente.setInsegnamento1("artiMagiche");
		
		Studente studente = new Studente();
		studente.setCognome("rana");
		studente.setEmail("pastabuona@8.unisa.it");
		studente.setMatricola("0505050505");
		studente.setNome("giovanni");
		studente.setPassword("12345678");
		
		Studente studente2 = new Studente();
		studente2.setCognome("rana");
		studente2.setEmail("isaoilbello@1.unisa.it");
		studente2.setMatricola("0512155555");
		studente2.setNome("giovanni");
		studente2.setPassword("12345678");
		
		assertEquals("Result",true, DocenteManager.registerUser(docente));
		System.out.println("docente registrato");
		assertEquals("Result",false, DocenteManager.registerUser(docente));
		assertEquals("Result",false, DocenteManager.registerUser(docente2));
		System.out.println("docente esistente.");
		DocenteManager.eliminaDocente(docente.getMatricola());
		System.out.println("docente eliminato");
		
		StudenteManager.registerUser(studente);
		assertEquals("Result",false, DocenteManager.registerUser(docente));
		StudenteManager.eliminaStudente(studente.getMatricola());
		
		StudenteManager.registerUser(studente2);
		assertEquals("Result",false, DocenteManager.registerUser(docente));
		StudenteManager.eliminaStudente(studente2.getMatricola());
		
	}

	@Test
	public void testModifyUser() {
		System.out.println("testModifyUser");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		assertEquals("Result",true, DocenteManager.modifyUser(docente));
		System.out.println("modifica riuscita");
		DocenteManager.eliminaDocente(docente.getMatricola());
		
	}

	@Test
	public void testModifyRicevimento() {
		System.out.println("testModifyRicevimento");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		docente.setGiornoRicevimento1("Giovedi");
		docente.setGiornoRicevimento2("Domenica");
		assertEquals("Result",true, DocenteManager.modifyRicevimento(docente));
		System.out.println("ricevimento modificato");
		DocenteManager.eliminaDocente(docente.getMatricola());
	}

	@Test
	public void testDoRetrieveAll() {
		System.out.println("testDoRetriveAll");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		ArrayList<Docente> list = new ArrayList<Docente>();
		list = DocenteManager.doRetrieveAll();
		assertNotNull(list);
		for(Docente doc:list) {
			System.out.println("docente: "+doc.getNome()+"-"+doc.getMatricola());
		}
		DocenteManager.eliminaDocente(docente.getMatricola());
		System.out.println("docente eliminato");
		
	}

	@Test
	public void testDoRetrieveByMatricola() {
		System.out.println("testDoRetriveByMatricola");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		assertEquals("Result",true, DocenteManager.doRetrieveByMatricola(docente));
		System.out.println("matricola trovata");
		DocenteManager.eliminaDocente(docente.getMatricola());
		System.out.println("docente eliminato");
	}

	@Test
	public void testModifyImage() {
		System.out.println("testModifyImage");
		
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		
		assertEquals("Result",true, DocenteManager.modifyImage(docente));
		System.out.println("immagine inserita");
		
	}

	@Test
	public void testEliminaDocente() {
		System.out.println("testEliminaDocente");
		
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		assertEquals("Result",true, DocenteManager.eliminaDocente(docente.getMatricola()));
		System.out.println("docente eliminato");
		
	}
	@Test
	public void doRetriveByEmail() {
		System.out.println("doRetriveByEmail");
		Docente docente = new Docente();
		docente.setCognome("takahata");
		docente.setNome("Isao");
		docente.setEmail("isaoilbello@1.unisa.it");
		docente.setMatricola("0505050505");
		docente.setGiornoRicevimento1("lunedi");
		docente.setGiornoRicevimento2("venerdi");
		docente.setInsegnamento1("programmazione");
		docente.setInsegnamento2("ingegneria");
		docente.setPassword("lucciola12345678");
		docente.setUfficio("ufficio oggetti smarriti");
		docente.setOraRicevimento1(14.00);
		docente.setOraRicevimento2(15.00);
		docente.setOraRicevimento3(15.00);
		docente.setOraRicevimento4(16.00);
		docente.setImagePath("stringaImg");
		
		DocenteManager.registerUser(docente);
		assertEquals("Result",true,DocenteManager.doRetrieveByEmail(docente));
		System.out.println("docente by email trovato");
		DocenteManager.eliminaDocente(docente.getMatricola());
		
	}

}
