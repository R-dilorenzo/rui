package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Studente;
import Model.StudenteManager;
import Model.Utente;

public class StudenteManagerTest {
	

	@Test
	public void testDoRetrieveByUser() {

		Studente studente = new Studente();
		studente.setCognome("rana");
		studente.setEmail("pastabuona@unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("giovanni");
		studente.setPassword("pesto123");

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
		studente.setEmail("pastabuona@unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("giovanni");
		studente.setPassword("pesto123");
		
		System.out.println("*testRegisterUser*");


		assertEquals("Result", true, StudenteManager.registerUser(studente));
		System.out.println("registrazione riuscita");
		assertEquals("Result", false, StudenteManager.registerUser(studente));
		System.out.println("registrazione non riuscita");
		StudenteManager.eliminaStudente(studente.getMatricola());
		System.out.println("eliminazione riuscita");
		

	}

	@Test
	public void testModifyUser() {

		Studente studente = new Studente();
		studente.setCognome("ana");
		studente.setEmail("overwatch@unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("hano");
		studente.setPassword("1234");
		
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
		studente.setEmail("pastabuona@unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("giovanni");
		studente.setPassword("pesto123");
		
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
		studente.setEmail("ehvolevi@unisa.it");
		studente.setMatricola("0555566666");
		studente.setNome("zeb89");
		studente.setPassword("lezzo123");
		
		System.out.println("*testElimanStudente*");
		
		StudenteManager.registerUser(studente);
		assertEquals("Result",true,StudenteManager.eliminaStudente(studente.getMatricola()));
		System.out.println("eliminazione riuscita");

	}

}
