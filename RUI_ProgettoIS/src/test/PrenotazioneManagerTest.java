package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import Model.GestionePrenotazione.Prenotazione;
import Model.GestionePrenotazione.PrenotazioneManager;



public class PrenotazioneManagerTest {

	@Test
	public void testDoRetrieveAll() throws SQLException {
		System.out.println("testdoRetriveAll");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-12-12");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		Prenotazione prenotazione1 = new Prenotazione();
		prenotazione1.setCognomeDocente("severus");
		prenotazione1.setNomeDocente("piton");
		prenotazione1.setDescrizione("potreiVomitare");
		prenotazione1.setData("2019-01-01");
		prenotazione1.setMatricolaDocente("0512103366");
		prenotazione1.setMatricolaStudente("0512104455");
		prenotazione1.setOra(14.00);
		
		PrenotazioneManager.agPrenotazione(prenotazione1);
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
		prenotazione.setData("2019-01-01");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		Prenotazione prenotazione1 = new Prenotazione();
		prenotazione1.setCognomeDocente("severus");
		prenotazione1.setNomeDocente("piton");
		prenotazione1.setDescrizione("potreiVomitare");
		prenotazione1.setData("2019-11-11");
		prenotazione1.setMatricolaDocente("0512103366");
		prenotazione1.setMatricolaStudente("0512104455");
		prenotazione1.setOra(15.00);
		
		Prenotazione prenotazione2 = new Prenotazione();
		prenotazione2.setCognomeDocente("severus");
		prenotazione2.setNomeDocente("piton");
		prenotazione2.setDescrizione("potreiVomitare");
		prenotazione2.setData("2019-12-12");
		prenotazione2.setMatricolaDocente("0512103366");
		prenotazione2.setMatricolaStudente("0512104455");
		prenotazione2.setOra(14.30);
		
		Prenotazione prenotazione3 = new Prenotazione();
		prenotazione3.setCognomeDocente("severus");
		prenotazione3.setNomeDocente("piton");
		prenotazione3.setDescrizione("potreiVomitare");
		prenotazione3.setData("2019-12-12");
		prenotazione3.setMatricolaDocente("0512103366");
		prenotazione3.setMatricolaStudente("0512104455");
		prenotazione3.setOra(14.00);
	
		PrenotazioneManager.agPrenotazione(prenotazione);
		PrenotazioneManager.agPrenotazione(prenotazione1);
		PrenotazioneManager.agPrenotazione(prenotazione2);
		PrenotazioneManager.agPrenotazione(prenotazione3);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre:list)
		{
			assertNotNull(PrenotazioneManager.returnPrenotazionebyDocente(pre.getMatricolaDocente()));
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
		prenotazione.setData("2019-12-12");
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
		prenotazione.setData("2019-12-12");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		Prenotazione prenotazione1 = new Prenotazione();
		prenotazione1.setCognomeDocente("severus");
		prenotazione1.setNomeDocente("piton");
		prenotazione1.setDescrizione("potreiVomitare");
		prenotazione1.setData("2019-12-12");
		//prenotazione1.setMatricolaDocente("0512103366");
		prenotazione1.setMatricolaStudente("0512104455");
		prenotazione1.setOra(14.00);
		
		
		
		assertEquals("SUCCESS",PrenotazioneManager.agPrenotazione(prenotazione));
		assertEquals("Oops.. Something went wrong there..!",PrenotazioneManager.agPrenotazione(prenotazione1));
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
		prenotazione.setData("2019-12-12");
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
		assertEquals("Result",false, PrenotazioneManager.eliminaPrenotazione(10000000));
	}

	@Test
	public void testDoRetrieveByKey() throws SQLException {
		System.out.println("testDoRetriveByKey");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-12-12");
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
		assertNull(PrenotazioneManager.doRetrieveByKey(1000000));
	}

	@Test
	public void testModificaPrenotazione() throws SQLException {
		System.out.println("testModificaPrenotazione");
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCognomeDocente("severus");
		prenotazione.setNomeDocente("piton");
		prenotazione.setDescrizione("potreiVomitare");
		prenotazione.setData("2019-12-12");
		prenotazione.setMatricolaDocente("0512103366");
		prenotazione.setMatricolaStudente("0512104455");
		prenotazione.setOra(14.00);
		
		String str = "............................................................";
		
		
		PrenotazioneManager.agPrenotazione(prenotazione);
		ArrayList<Prenotazione> list = PrenotazioneManager.doRetrieveAll();
		for(Prenotazione pre: list)
		{
			assertEquals("Request",false,PrenotazioneManager.modificaPrenotazione(pre.getId(), null, "descrizione"));
			assertEquals("Request",false,PrenotazioneManager.modificaPrenotazione(pre.getId(), TremilaCaratteri.getString3k(), "descrizione"));
			assertEquals("Request",false,PrenotazioneManager.modificaPrenotazione(pre.getId(), "aonna", "descrione"));
			assertEquals("Request",true,PrenotazioneManager.modificaPrenotazione(pre.getId(), "aonna", "descrizione"));
			assertEquals("Request",true,PrenotazioneManager.modificaPrenotazione(pre.getId(), "16.00", "ora"));
			assertEquals("Request",false,PrenotazioneManager.modificaPrenotazione(pre.getId(), str, "ora"));
			assertEquals("Request",true,PrenotazioneManager.modificaPrenotazione(pre.getId(), "2019-12-13", "data"));
			assertEquals("Request",false,PrenotazioneManager.modificaPrenotazione(pre.getId(), str, "data"));
			System.out.println("modifica riuscita");
			PrenotazioneManager.eliminaPrenotazione(pre.getId());
		}
		
	}

}
