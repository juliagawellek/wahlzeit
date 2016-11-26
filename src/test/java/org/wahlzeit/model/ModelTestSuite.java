package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccessRightsTest.class,SphericAndCartesianCoordinateTest.class, FlagReasonTest.class, GenderTest.class, GuestTest.class, LocationTest.class,
	PhotoFilterTest.class,TagsTest.class, UserStatusTest.class, ValueTest.class,
	BridgePhotoTest.class, BridgePhotoManagerTest.class, BridgePhotoFactoryTest.class, AbstractCoordinateTest.class
})

public class ModelTestSuite {

}
