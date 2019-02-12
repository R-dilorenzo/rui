package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.GestioneAutenticazione.Docente;
import Model.GestioneAutenticazione.DocenteManager;
import Model.GestioneAutenticazione.Studente;
import Model.GestioneAutenticazione.StudenteManager;


public class StudenteManagerTest {
	

	
	@Test
	public void testDoRetrieveByUser() {

		Studente studente = new Studente();
		studente.setCognome("rana");
		studente.setEmail("pastabuona@p.unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("giovanni");
		studente.setPassword("pesto12345678");

			System.out.println("*testdoRetriveByUser*");
			
			StudenteManager.registerUser(studente);
			assertEquals("Result", true, StudenteManager.doRetrieveByUser(studente));
			System.out.println("user trovato");
			StudenteManager.eliminaStudente(studente.getMatricola());
			assertEquals("Result",false,StudenteManager.doRetrieveByUser(studente));
			System.out.println("user non trovato");
			
			
		
			

	}

	@Test
	public void testRegisterUser() {

		Studente studente = new Studente();
		studente.setCognome("rana");
		studente.setEmail("pastabuona@p.unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("giovanni");
		studente.setPassword("pesto12345678");
		
		Studente studente2 = new Studente();
		studente2.setCognome("amadori");
		studente2.setEmail("pastabuona@p.unisa.it");
		studente2.setMatricola("0101010101");
		studente2.setNome("giovanni");
		studente2.setPassword("pesto12345678");
		
		Studente studente3 = new Studente();
		studente3.setCognome("amadori");
		studente3.setEmail("pastabuona@p.unisa.it");
		
		studente3.setNome("giovanni");
		studente3.setPassword("pesto12345678");
		
		System.out.println("*testRegisterUser*");
		Docente docente = new Docente();
		docente.setMatricola("0555566666");
		docente.setEmail("albus@a.unisa.it");
		docente.setCognome("silente");
		docente.setNome("albus");
		docente.setPassword("albus12345678");
		docente.setInsegnamento1("artiMagiche");
		
		Docente docente2 = new Docente();
		docente2.setMatricola("0512111111");
		docente2.setEmail("pastabuona@p.unisa.it");
		docente2.setCognome("silente");
		docente2.setNome("persival");
		docente2.setPassword("persival12345678");
		docente2.setInsegnamento1("artiMagiche");

		
		assertEquals("Result", true, StudenteManager.registerUser(studente));
		System.out.println("registrazione riuscita");
		assertEquals("Result", false, StudenteManager.registerUser(studente));
		assertEquals("Result", false, StudenteManager.registerUser(studente2));
		System.out.println("registrazione non riuscita");
		StudenteManager.eliminaStudente(studente.getMatricola());
		
		
			
		
		
		
		
		
		/* esiste un docente con la matricola inserita dallo studente */
		DocenteManager.registerUser(docente);
		assertEquals("Result",false, StudenteManager.registerUser(studente));
		System.out.println("registrazione non riuscita2");
		DocenteManager.eliminaDocente(docente.getMatricola());
		
		/* esiste docente con l'email inserita dallo studente*/
		DocenteManager.registerUser(docente2);
		assertEquals("Result",false, StudenteManager.registerUser(studente));
		System.out.println("registrazione non riuscita3");
		DocenteManager.eliminaDocente(docente2.getMatricola());
		

	}

	@Test
	public void testModifyUser() {

		Studente studente = new Studente();
		studente.setCognome("ana");
		studente.setEmail("overwatch@o.unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("hano");
		studente.setPassword("12345678");
		
		Studente studente1 = new Studente();
		studente.setCognome("alla");
		studente.setEmail("watch@w.unisa.it");
		studente.setMatricola("0512166666");
		studente.setNome("mano");
		studente.setPassword("123456789");
		
		
		System.out.println("*testModifyUser*");
		StudenteManager.registerUser(studente);
		studente.setCognome("cognome");
		assertEquals("Result", true, StudenteManager.modifyUser(studente));
		System.out.println("modifica: "+studente.getCognome());
		StudenteManager.eliminaStudente(studente.getMatricola());
		
		
	
		
		

	}

	@Test
	public void testDoRetrieveByMatricola() {

		Studente studente = new Studente();
		studente.setCognome("rana");
		studente.setEmail("pastabuona@p.unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("giovanni");
		studente.setPassword("pesto12345678");
		
		System.out.println("*testDoRetriveByMatricola*");

		StudenteManager.registerUser(studente);
		assertEquals("Result", true, StudenteManager.doRetrieveByMatricola(studente));
		StudenteManager.eliminaStudente(studente.getMatricola());
		System.out.println("matricola trovata");

	}

	@Test
	public void testEliminaStudente() {
		Studente studente = new Studente();
		studente.setCognome("aceGamer");
		studente.setEmail("ehvolevi@e.unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("zeb89");
		studente.setPassword("lezzo12345678");
		
		System.out.println("*testElimanStudente*");
		
		StudenteManager.registerUser(studente);
		assertEquals("Result",true,StudenteManager.eliminaStudente(studente.getMatricola()));
		System.out.println("eliminazione riuscita");

	}
	@Test
	public void testDoRetriveByEmail() {
		System.out.println("testDoRetriveByEmail");
		Studente studente = new Studente();
		studente.setCognome("aceGamer");
		studente.setEmail("ehvolevi@e.unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("zeb89");
		studente.setPassword("lezzo12345678");
		
		StudenteManager.registerUser(studente);
		assertEquals("Result",true, StudenteManager.doRetrieveByEmail(studente));
		System.out.println("studente by email trovato");
		StudenteManager.eliminaStudente(studente.getMatricola());
	}

}
