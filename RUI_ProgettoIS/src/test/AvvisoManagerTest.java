package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import Model.GestioneAvviso.Avviso;
import Model.GestioneAvviso.AvvisoManager;




public class AvvisoManagerTest {

	

	@Test
	public void testDoRetrieveAll() throws SQLException {
		System.out.println("testDoRetriveAll");
		Avviso avviso = new Avviso();
		avviso.setData("2019-10-10");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("0512103366");

		AvvisoManager.agAvviso(avviso);
		ArrayList<Avviso> list = AvvisoManager.doRetrieveAll();
		assertNotNull(list);
		System.out.println("avvisi trovati");
		for (Avviso av : list) {
			AvvisoManager.eliminaAvviso(av.getId());
		}
	}

	@Test
	public void testGetAvvisibyDocente() throws SQLException {
		System.out.println("testGetAvvisiByDocente");
		Avviso avviso = new Avviso();
		avviso.setData("2019-10-10");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("0512103366");
		
		Avviso avviso1 = new Avviso();
		avviso1.setData("2019-01-01");
		avviso1.setDescrizione("tutti bocciati");
		avviso1.setNomeAvviso("avviso per tutti");
		avviso1.setOraAvviso(14.30);
		avviso1.setMatricolaDocente("0512103366");
		
		Avviso avviso2 = new Avviso();
		avviso2.setData("2019-11-11");
		avviso2.setDescrizione("tutti bocciati");
		avviso2.setNomeAvviso("avviso per me");
		avviso2.setOraAvviso(14.30);
		avviso2.setMatricolaDocente("0512103366");
		
		Avviso avviso3 = new Avviso();
		avviso3.setData("2019-11-11");
		avviso3.setDescrizione("tutti a casa");
		avviso3.setNomeAvviso("avviso per tutti");
		avviso3.setOraAvviso(15.00);
		avviso3.setMatricolaDocente("0512103366");
		
		Avviso avviso4 = new Avviso();
		avviso4.setData("2019-10-10");
		avviso4.setDescrizione("tutti a casa");
		avviso4.setNomeAvviso("avviso per tutti");
		avviso4.setOraAvviso(15.00);
		avviso4.setMatricolaDocente("0512103366");
		
		
		
		AvvisoManager.agAvviso(avviso);
		AvvisoManager.agAvviso(avviso1);
		AvvisoManager.agAvviso(avviso2);
		AvvisoManager.agAvviso(avviso3);
		AvvisoManager.agAvviso(avviso4);
		ArrayList<Avviso> list = AvvisoManager.getAvvisibyDocente(avviso.getMatricolaDocente());
		assertNotNull(list);
		System.out.println("avvisi by docente trovati");
		for (Avviso av : list) {
			AvvisoManager.eliminaAvviso(av.getId());
		}
	}

	@Test
	public void testAgAvviso() throws SQLException {
		System.out.println("testAgAvviso");
		Avviso avviso = new Avviso();
		avviso.setData("2019-10-10");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("0512103366");
		
		Avviso avviso1 = new Avviso();
		avviso1.setData("2019-10-10");
		avviso1.setDescrizione("tutti bocciati");
		avviso1.setNomeAvviso("avviso per tutti");
		avviso1.setOraAvviso(14.30);
		

		assertEquals("SUCCESS", AvvisoManager.agAvviso(avviso));
		assertEquals("Oops.. Something went wrong there..!",AvvisoManager.agAvviso(avviso1));
		ArrayList<Avviso> list = AvvisoManager.getAvvisibyDocente(avviso.getMatricolaDocente());
		for (Avviso av : list) {
			AvvisoManager.eliminaAvviso(av.getId());
			System.out.println("avviso :" + av.getId() + " eliminato");
		}
		
	}

	@Test
	public void testEliminaAvviso() throws SQLException {
		System.out.println("testEliminaAvviso");
		Avviso avviso = new Avviso();
		avviso.setData("2019-10-10");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("0512103366");

		AvvisoManager.agAvviso(avviso);
		ArrayList<Avviso> list = AvvisoManager.getAvvisibyDocente(avviso.getMatricolaDocente());
		for (Avviso av : list) {
			assertEquals("Result", true, AvvisoManager.eliminaAvviso(av.getId()));
			System.out.println("avviso :" + av.getId() + " eliminato");
		}

	}

	@Test
	public void testModificaAvviso() throws SQLException {
		System.out.println("testModifyAvviso");
		Avviso avviso = new Avviso();
		avviso.setData("2019-10-10");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("0512103366");
		
		String str = "..................................................................................";
		
		
		
		AvvisoManager.agAvviso(avviso);
		ArrayList<Avviso> list = AvvisoManager.doRetrieveAll();
		for(Avviso av: list)
		{	
			assertEquals("Result",false, AvvisoManager.modificaAvviso(av.getId(), "bello", "descrizioe"));
			assertEquals("Result",false, AvvisoManager.modificaAvviso(av.getId(), null, "descrizione"));
			assertEquals("Result",false, AvvisoManager.modificaAvviso(av.getId(), TremilaCaratteri.getString3k(), "descrizione"));
			assertEquals("Result",true, AvvisoManager.modificaAvviso(av.getId(), "nuovo avviso", "descrizione"));
			assertEquals("Result",false, AvvisoManager.modificaAvviso(av.getId(), str, "oraAvviso"));
			assertEquals("Result",true, AvvisoManager.modificaAvviso(av.getId(), "12.00", "oraAvviso"));
			assertEquals("Result",false, AvvisoManager.modificaAvviso(av.getId(), str, "nomeAvviso"));
			assertEquals("Result",false, AvvisoManager.modificaAvviso(av.getId(), "123", "nomeAvviso"));
			assertEquals("Result",true, AvvisoManager.modificaAvviso(av.getId(), "nuovo nome", "nomeAvviso"));
			System.out.println("avviso modificato");
			AvvisoManager.eliminaAvviso(av.getId());
		}
		
	}

	@Test
	public void testDoRetrieveByKey() throws SQLException {
		System.out.println("testDoRetriveBykey");
		Avviso avviso = new Avviso();
		avviso.setData("2019-10-10");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("0512103366");

		AvvisoManager.agAvviso(avviso);
		ArrayList<Avviso> list = AvvisoManager.getAvvisibyDocente(avviso.getMatricolaDocente());
		for (Avviso av : list) {
			assertNotNull(AvvisoManager.doRetrieveByKey(av.getId()));
			System.out.println("avviso " + av.getId() + " trovato");
		}
		assertEquals("Result",null, AvvisoManager.doRetrieveByKey(1000000));
		
	}

}
