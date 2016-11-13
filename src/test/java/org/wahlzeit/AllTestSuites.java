package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;




@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlersTestSuite.class, ModelTestSuite.class, ServicesTestSuite.class, 
	UtilsTestSuite.class,
})

public class AllTestSuites {

	private final LocalServiceTestHelper helper =
			new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig()
			    .setDefaultHighRepJobPolicyUnappliedJobPercentage(100));
}
