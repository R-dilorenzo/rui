package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import Model.Avviso;
import Model.AvvisoManager;

public class AvvisoManagerTest {

	@Test
	public void testDoRetrieveAll() throws SQLException {
		System.out.println("testDoRetriveAll");
		Avviso avviso = new Avviso();
		avviso.setData("2019-02-04");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("03366");

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
		avviso.setData("2019-02-04");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("03366");
		
		AvvisoManager.agAvviso(avviso);
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
		avviso.setData("2019-02-04");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("03366");

		assertEquals("SUCCESS", AvvisoManager.agAvviso(avviso));
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
		avviso.setData("2019-02-04");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("03366");

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
		avviso.setData("2019-02-04");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("03366");
		
		AvvisoManager.agAvviso(avviso);
		ArrayList<Avviso> list = AvvisoManager.doRetrieveAll();
		for(Avviso av: list)
		{
			assertEquals("Result",true, AvvisoManager.modificaAvviso(av.getId(), "nuovo avviso", "descrizione"));
			System.out.println("avviso modificato");
			AvvisoManager.eliminaAvviso(av.getId());
		}
		
	}

	@Test
	public void testDoRetrieveByKey() throws SQLException {
		System.out.println("testDoRetriveBykey");
		Avviso avviso = new Avviso();
		avviso.setData("2019-02-04");
		avviso.setDescrizione("tutti bocciati");
		avviso.setNomeAvviso("avviso per tutti");
		avviso.setOraAvviso(14.30);
		avviso.setMatricolaDocente("03366");

		AvvisoManager.agAvviso(avviso);
		ArrayList<Avviso> list = AvvisoManager.getAvvisibyDocente(avviso.getMatricolaDocente());
		for (Avviso av : list) {
			assertNotNull(AvvisoManager.doRetrieveByKey(av.getId()));
			System.out.println("avviso " + av.getId() + " trovato");
		}
	}

}
