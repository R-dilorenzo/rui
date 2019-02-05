package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import Model.Prenotazione;
import Model.PrenotazioneManager;

public class PrenotazioneManagerTest {

	@Test
	public void testDoRetrieveAll() throws SQLException {
		System.out.println("testdoRetriveAll");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		assertNotNull(list);
		System.out.println("prenotazioni trovate ");
	}

	@Test
	public void testReturnPrenotazionebyDocente() throws SQLException {
		System.out.println("testReturnPrenotazioneByDocente");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre:list)
		{
			assertNotNull(PrenotazioneManager.returnPrenotazionebyStudente(pre.getMatricolaDocente()));
			System.out.println("prenotazione by docente trovate");
			PrenotazioneManager.eliminaPrenotazione(pre.getId());
		}
		
	}

	@Test
	public void testReturnPrenotazionebyStudente() throws SQLException {
		System.out.println("testReturnPrenotazioneByStudente");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre:list)
		{
			assertNotNull(PrenotazioneManager.returnPrenotazionebyStudente(pre.getMatricolaStudente()));
			System.out.println("prenotazione by studente trovate");
			PrenotazioneManager.eliminaPrenotazione(pre.getId());
		}
		
		
	}

	@Test
	public void testAgPrenotazione() throws SQLException {
		System.out.println("testAgPrenotazione");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		
		
		assertEquals("SUCCESS",PrenotazioneManager.agPrenotazione(prenotazione));
		System.out.println("prenotazione effettuata");
		ArrayList<Prenotazione> list = PrenotazioneManager.returnPrenotazionebyStudente(prenotazione.getMatricolaStudente());
		for(Prenotazione pre: list)
		{
			PrenotazioneManager.eliminaPrenotazione(pre.getId());
		}
		
	}

	@Test
	public void testEliminaPrenotazione() throws SQLException {
		System.out.println("testEliminaPrenotazione");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre:list)
		{
			assertEquals("Result",true, PrenotazioneManager.eliminaPrenotazione(pre.getId()));
			System.out.println("prenotazione eliminata");
			
		}
	}

	@Test
	public void testDoRetrieveByKey() throws SQLException {
		System.out.println("testDoRetriveByKey");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre: list)
		{
			assertNotNull(PrenotazioneManager.doRetrieveByKey(pre.getId()));
			System.out.println("prenotazione trovato tramite id");
			PrenotazioneManager.eliminaPrenotazione(pre.getId());
		}
	}

	@Test
	public void testModificaPrenotazione() throws SQLException {
		System.out.println("testModificaPrenotazione");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-02-04");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre: list)
		{
			assertEquals("Request",true,PrenotazioneManager.modificaPrenotazione(pre.getId(), "aonna", "descrizione"));
			System.out.println("modifica riuscita");
			PrenotazioneManager.eliminaPrenotazione(pre.getId());
		}
		
	}

}
