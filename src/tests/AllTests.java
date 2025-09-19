package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OpenTest.class, OpenTest.class , SaveTest.class,
				TestReplayManager.class
})

public class AllTests {

}
