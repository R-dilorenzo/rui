package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AvvisoManagerTest.class, DocenteManagerTest.class, PrenotazioneManagerTest.class,
		StudenteManagerTest.class })
public class AllTests {

}
